package vn.iotstar.nongsan.retrofit;

import java.util.List;

import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import vn.iotstar.nongsan.constant.Constant;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import vn.iotstar.nongsan.models.CategoryModel;
import vn.iotstar.nongsan.models.LoginModel;
import vn.iotstar.nongsan.models.ProductDetailModel;
import vn.iotstar.nongsan.models.ProductModel;
import vn.iotstar.nongsan.models.SignupModel;

public interface NongSanAPI {

    @GET(Constant.URL_CATEGORY)
    Call<CategoryModel> getCategoryModel();

    @GET(Constant.URL_PRODUCT_PUBLISHED)
    Call<ProductModel> getProductModel();

    @POST(Constant.URL_SIGNUP)
    @FormUrlEncoded
    Call<SignupModel> getSignupModel(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("phone") String phone
    );

    @POST("auth/login")
    @FormUrlEncoded
    Call<LoginModel> getLoginModel(
            @Field("email") String email,
            @Field("password") String password
    );

    @POST(Constant.URL_PRODUCT_BY_CATEGORY + ":{categoryId}/")
    Call<ProductModel>  getProductByCategoryModel(
            @Path("categoryId") String categoryId,
            @Header("Authorization") String accessToken,
            @Header("x-client-id") String clientId,
            @Header("x-rtoken-id") String refreshToken
    );

    @POST("search.php")
    @FormUrlEncoded
    Call<ProductModel> getProductDetailModelBySearch(
            @Field("searchName")
            String searchName
    );
}
