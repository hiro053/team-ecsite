package jp.co.internous.sunflower.model.domain.dto;

import java.sql.Timestamp;

/**
 * カート画面に表示するためのDTO
 * @author インターノウス
 *
 */
public class CartDto {

    // フィールド
    private int id;               // カート情報のID
    private String imageFullPath; // 商品の画像のフルパス
    private String productName;   // 商品名
    private int price;            // 商品の価格
    private int productCount;     // 商品の個数
    private int subtotal;         // 小計
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // getterとsetter
    // カート情報のIDを取得
    public int getId() {
        return id;
    }
    // カート情報のIDを設定
    public void setId(int id) {
        this.id = id;
    }

    // 商品の画像のフルパスを取得
    public String getImageFullPath() {
        return imageFullPath;
    }
    // 商品の画像のフルパスを設定
    public void setImageFullPath(String imageFullPath) {
        this.imageFullPath = imageFullPath;
    }

    // 商品名を取得
    public String getProductName() {
        return productName;
    }
    // 商品名を設定
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // 商品の価格を取得
    public int getPrice() {
        return price;
    }
    // 商品の価格を設定
    public void setPrice(int price) {
        this.price = price;
    }

    // 商品の個数を取得
    public int getProductCount() {
        return productCount;
    }
    // 商品の個数を設定
    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    // 小計を取得
    public int getSubtotal() {
        return subtotal;
    }
    // 小計を設定
    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
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
