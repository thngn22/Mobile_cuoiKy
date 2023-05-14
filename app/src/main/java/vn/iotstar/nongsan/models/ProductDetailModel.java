package vn.iotstar.nongsan.models;

import java.util.List;

public class ProductDetailModel {
    private boolean success = false;
    private String message;
    private List<ProductDetail> result;

    public ProductDetailModel(boolean success, String message, List<ProductDetail> result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public ProductDetailModel() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ProductDetail> getResult() {
        return result;
    }

    public void setResult(List<ProductDetail> result) {
        this.result = result;
    }
}
