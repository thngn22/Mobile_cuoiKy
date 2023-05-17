package vn.iotstar.nongsan.models;

import org.json.JSONObject;

public class UserModel {
    private JSONObject user, tokens;

    public UserModel() {
    }

    public UserModel(JSONObject user, JSONObject tokens) {
        this.user = user;
        this.tokens = tokens;
    }

    public JSONObject getUser() {
        return user;
    }

    public void setUser(JSONObject user) {
        this.user = user;
    }

    public JSONObject getTokens() {
        return tokens;
    }

    public void setTokens(JSONObject tokens) {
        this.tokens = tokens;
    }
}
