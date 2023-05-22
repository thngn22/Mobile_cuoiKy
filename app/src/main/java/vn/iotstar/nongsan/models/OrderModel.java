package vn.iotstar.nongsan.models;

import java.util.HashMap;
import java.util.List;

public class OrderModel {
    private String message;
    int status;
    private List<HashMap<String, Object>> metadata;

    public OrderModel(String message, int status, List<HashMap<String, Object>> metadata) {
        this.message = message;
        this.status = status;
        this.metadata = metadata;
    }

    public OrderModel() {
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

    public List<HashMap<String, Object>> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<HashMap<String, Object>> metadata) {
        this.metadata = metadata;
    }
}
