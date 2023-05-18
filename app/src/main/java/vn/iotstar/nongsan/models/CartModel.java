package vn.iotstar.nongsan.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CartModel {
    private String message;
    int status;
    private List<Cart> metadata;

    public CartModel() {
    }

    public CartModel(String message, int status, List<Cart> metadata) {
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

    public List<Cart> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Cart> metadata) {
        this.metadata = metadata;
    }
}
