package vn.iotstar.nongsan.models;

import java.util.List;

public class CategoryModel {
    private String message;
    private int status;
    private List<Category> metadata;

    public CategoryModel() {
    }

    public CategoryModel(String message, int status, List<Category> metadata) {
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

    public List<Category> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Category> metadata) {
        this.metadata = metadata;
    }
}
