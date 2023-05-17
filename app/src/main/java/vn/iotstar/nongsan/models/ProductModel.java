package vn.iotstar.nongsan.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class ProductModel {
    private String message;
    private int status;
    private List<Product> metadata;

    public ProductModel() {
    }

    public ProductModel(String message, int status, List<Product> metadata) {
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

    public List<Product> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Product> metadata) {
        this.metadata = metadata;
    }
}
