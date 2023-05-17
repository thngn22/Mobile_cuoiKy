package vn.iotstar.nongsan.preference;

import android.content.Context;
import android.content.SharedPreferences;

import vn.iotstar.nongsan.models.User;

public class SharedPreference {
    private static final String  SHARED_NAME = "0";
    private static final String  user_id = "0";
    private static final String  user_email = "0";
    private static final String  user_name = "0";
    private static final String  user_phone = "0";
    private static final String  user_image = "0";
    public static SharedPreference instance;
    public static Context context;
    private SharedPreference(Context context){
        this.context = context;
    }
    public static synchronized SharedPreference getInstance(Context context){
        if (instance == null){
            instance = new SharedPreference(context);
        }
        return instance;
    }
    public void userLogin(User user){
        SharedPreferences sharedPreference = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString(user_id, user.getId());
        editor.putString(user_email, user.getEmail());
        editor.putString(user_image, user.getImage());
        editor.putString(user_name, user.getName());
        editor.putString(user_phone, user.getPhone());
        editor.apply();

    }
    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(user_name, null) != null;
    }
    public User getUser(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        return new User(
            sharedPreferences.getString(user_id, "0"),
            sharedPreferences.getString(user_name, "0"),
            sharedPreferences.getString(user_email, "0"),
            sharedPreferences.getString(user_phone, "0"),
            sharedPreferences.getString(user_image, "0")
        );
    }
    public void logOut(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor =   sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}

