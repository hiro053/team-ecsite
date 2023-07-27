package jp.co.internous.sunflower.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.sunflower.model.domain.TblCart;
import jp.co.internous.sunflower.model.domain.dto.CartDto;
import jp.co.internous.sunflower.model.form.CartForm;
import jp.co.internous.sunflower.model.mapper.TblCartMapper;
import jp.co.internous.sunflower.model.session.LoginSession;


/**
 * カート情報に関する処理のコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/sunflower/cart")
public class CartController {

    /*
     * フィールド定義
     */

    @Autowired
    private LoginSession loginSession;

    @Autowired
    private TblCartMapper cartMapper;

    private Gson gson = new Gson();


    /**
     * カート画面を初期表示する。
     * @param m 画面表示用オブジェクト
     * @return カート画面
     */
    @RequestMapping("/")
    public String index(Model m) {
        // ログインセッションからユーザーIDまたは仮ユーザーIDを取得
        int userId = loginSession.isLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();

        List<CartDto> carts = cartMapper.findByUserId(userId);

        // カート情報とログインセッションを画面に送る
        m.addAttribute("carts", carts);
        m.addAttribute("loginSession", loginSession);

        // カート画面に遷移する
        return "cart";
    }


    /**
     * カートに追加処理を行う
     * @param f カート情報のForm
     * @param m 画面表示用オブジェクト
     * @return カート画面
     */
    @RequestMapping("/add")
    public String addCart(CartForm f, Model m) {
        // ログインセッションからユーザーIDまたは仮ユーザーIDを取得
        int userId = loginSession.isLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();

        f.setUserId(userId);

        // カートテーブルに挿入/更新
        TblCart cart = new TblCart(f);

        // ユーザーIDと商品IDを条件に件数を取得する
        int findCountByUserIdAndProductId = cartMapper.findCountByUserIdAndProductId(userId, f.getProductId());

        // ユーザーIDと追加する商品IDと一致するデータが存在するかチェックする
        if (findCountByUserIdAndProductId > 0) {
            // ユーザーに紐づくカート情報に、追加する商品IDと一致するデータが存在する場合は、カート情報を更新する
            cartMapper.update(cart);
        } else {
            // ユーザーに紐づくカート情報に、追加する商品IDと一致するデータが存在しない場合は、カート情報を登録する
            cartMapper.insert(cart);
        }

        List<CartDto> carts = cartMapper.findByUserId(userId);

        m.addAttribute("carts", carts);
        m.addAttribute("loginSession", loginSession);

        // カート画面に遷移する
        return "cart";
    }


    /**
     * カート情報を削除する
     * @param checkedIdList 選択したカート情報のIDリスト
     * @return true:削除成功、false:削除失敗
     */
    @SuppressWarnings("unchecked")
    @PostMapping("/delete")
    @ResponseBody
    public boolean deleteCart(@RequestBody String checkedIdList) {
        // 選択したカート情報のIDリストを文字列として受け取る
        Map<String, List<Integer>> map = gson.fromJson(checkedIdList, Map.class);
        List<Integer> checkedIds = map.get("checkedIdList");

        // 選択したIDのカート情報を削除する
        int deleteById = cartMapper.deleteById(checkedIds);

        // 削除の結果を判定し、成功したかを返す
        return deleteById > 0;
    }

}
