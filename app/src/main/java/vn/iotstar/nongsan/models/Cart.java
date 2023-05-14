package vn.iotstar.nongsan.models;

public class Cart {
    private ProductDetail productDetail;
    int amount;

    public Cart(ProductDetail productDetail, int amount) {
        this.productDetail = productDetail;
        this.amount = amount;
    }

    public Cart() {
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
