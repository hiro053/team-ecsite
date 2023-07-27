package jp.co.internous.sunflower.model.form;

import java.io.Serializable;

/**
 * カートフォーム
 * @author インターノウス
 *
 */
public class CartForm implements Serializable {
    private static final long serialVersionUID = 1L;

    // フィールド
    private int userId;           // ユーザーID
    private int productId;        // 商品ID
    private int productCount;     // 商品の個数

    // setter・getter
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
}
