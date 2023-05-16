package vn.iotstar.nongsan.models;

import java.util.List;

public class SignupModel {
    private String message;
    int status;
    private List<Object> metadata;

    public SignupModel() {
    }

    public SignupModel(String message, int status, List<Object> metadata) {
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

    public List<Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Object> metadata) {
        this.metadata = metadata;
    }
}
