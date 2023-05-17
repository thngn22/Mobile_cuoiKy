package vn.iotstar.nongsan.models;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.List;

import kotlin.jvm.internal.SerializedIr;

public class SignupModel {

    private String message;
    int status;
    @SerializedName("shop")
    private User metadata;

    public SignupModel() {
    }

    public SignupModel(String message, int status, User metadata) {
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

    public User getMetadata() {
        return metadata;
    }

    public void setMetadata(User metadata) {
        this.metadata = metadata;
    }
}
