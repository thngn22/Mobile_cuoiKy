package vn.iotstar.nongsan.models;

import java.util.List;

public class ProductDetailModel {
    private String message;
    private int status;
    private ProductDetail metadata;

    public ProductDetailModel() {
    }

    public ProductDetailModel(String message, int status, ProductDetail metadata) {
        this.message = message;
        this.status = status;
        this.metadata = metadata;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ProductDetail getMetadata() {
        return metadata;
    }

    public void setMetadata(ProductDetail metadata) {
        this.metadata = metadata;
    }
}
