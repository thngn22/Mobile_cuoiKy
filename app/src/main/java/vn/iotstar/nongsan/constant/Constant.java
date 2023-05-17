package vn.iotstar.nongsan.constant;


import android.Manifest;

public class Constant {

    public static final String localhost = "192.168.1.11:4040";
    //ACCESS
    public static final String ROOT_URL = "http://" + localhost + "/v1/api/";
    public static final String URL_SIGNUP = ROOT_URL + "auth/signup/";
    public static final String URL_LOGIN = ROOT_URL + "auth/login/";
    public static final String URL_HANDLE_REFRESH_TOKEN = ROOT_URL + "auth/handleRefreshToken/";
    public static final String URL_LOGOUT = ROOT_URL + "auth/logout/";

    //CATEGORY
    public static final String URL_CATEGORY = ROOT_URL + "category/";

    //PRODUCT
    public static final String URL_PRODUCT_PUBLISHED = ROOT_URL + "product/published/";



    //    public static final String URL_CATEGORY= "http://app.iotstar.vn/appfoods/categories.php";
    private static final String URL_LAST_PRODUCT = "http://app.iotstar.vn/appfoods/lastproduct.php";
    public static String[] storage_permissions ={
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    public static String[] storage_permissions_33 = {
            Manifest.permission.READ_MEDIA_IMAGES,
            Manifest.permission.READ_MEDIA_AUDIO,
            Manifest.permission.READ_MEDIA_VIDEO
    };
    public static final String MY_IMAGES = "avatar";
    public static final String MY_ID = "id";
}

