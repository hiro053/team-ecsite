package jp.co.internous.sunflower.model.domain;

import java.sql.Timestamp;

import jp.co.internous.sunflower.model.form.CartForm;

/**
 * tbl_cartのドメイン
 * @author インターノウス
 *
 */
public class TblCart {

    // フィールド
    private int id;               // カート情報のID
    private int userId;           // ユーザーID
    private int productId;        // 商品ID
    private int productCount;     // 商品の個数
    private Timestamp createdAt;  // 作成日時
    private Timestamp updatedAt;  // 更新日時

    // コンストラクタ
    public TblCart() {}

    /**
     * コンストラクタ
     * @param f カートフォーム
     */
    public TblCart(CartForm f) {
        userId = f.getUserId();
        productId = f.getProductId();
        productCount = f.getProductCount();
    }

    // getterとsetter
    // カート情報のIDを取得
    public int getId() {
        return id;
    }
    // カート情報のIDを設定
    public void setId(int id) {
        this.id = id;
    }

    // ユーザーIDを取得
    public int getUserId() {
        return userId;
    }
    // ユーザーIDを設定
    public void setUserId(int userId) {
        this.userId = userId;
    }

    // 商品IDを取得
    public int getProductId() {
        return productId;
    }
    // 商品IDを設定
    public void setProductId(int productId) {
        this.productId = productId;
    }

    // 商品の個数を取得
    public int getProductCount() {
        return productCount;
    }
    // 商品の個数を設定
    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    // 作成日時を取得
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    // 作成日時を設定
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // 更新日時を取得
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    // 更新日時を設定
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
