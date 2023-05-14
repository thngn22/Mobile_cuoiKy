package vn.iotstar.nongsan.models;

import java.util.List;

public class ProductModel {
    private boolean success = false;
    private String message;

    private List<Product> result;

    public ProductModel(boolean success, String message, List<Product> result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public ProductModel() {
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

    public List<Product> getResult() {
        return result;
    }

    public void setResult(List<Product> result) {
        this.result = result;
    }
}
