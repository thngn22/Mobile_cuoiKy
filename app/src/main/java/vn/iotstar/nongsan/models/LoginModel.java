package vn.iotstar.nongsan.models;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LoginModel {
    private String message;
    int status;
    //@SerializedName("user")
    private HashMap<String, HashMap<String, String>> metadata;

    public LoginModel() {
    }

    public LoginModel(String message, int status, HashMap<String,HashMap<String, String>> metadata) {
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

    public HashMap<String, HashMap<String, String>> getMetadata() {
        return metadata;
    }

    public void setMetadata(HashMap<String, HashMap<String, String>> metadata) {
        this.metadata = metadata;
    }
}
