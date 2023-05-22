package vn.iotstar.nongsan.retrofit;

import androidx.annotation.RawRes;

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
import vn.iotstar.nongsan.models.CartModel;
import vn.iotstar.nongsan.models.CategoryModel;
import vn.iotstar.nongsan.models.LoginModel;
import vn.iotstar.nongsan.models.ProductDetail;
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

    @POST(Constant.URL_LOGIN)
    @FormUrlEncoded
    Call<LoginModel> getLoginModel(
            @Field("email") String email,
            @Field("password") String password
    );

    @POST(Constant.URL_PRODUCT_BY_CATEGORY + "{categoryId}/")
    Call<ProductModel>  getProductByCategoryModel(
            @Path("categoryId") String categoryId,
            @Header("Authorization") String accessToken,
            @Header("x-client-id") String clientId,
            @Header("x-rtoken-id") String refreshToken
    );

    @GET(Constant.URL_PRODUCT_DETAIL + "{productId}/")
    Call<ProductDetailModel>  getProductDetail(
            @Path("productId") String productId

    );

    @POST(Constant.URL_SEARCH)
    @FormUrlEncoded
    Call<ProductModel> getProductDetailModelBySearch(
            @Field("search")
            String searchName
    );


    @POST(Constant.URL_LIST_CART)
    Call<CartModel> getListCart(
            @Header("Authorization") String accessToken,
            @Header("x-client-id") String clientId,
            @Header("x-rtoken-id") String refreshToken
    );

    @POST(Constant.URL_ADD_CART)
    @FormUrlEncoded
    Call<CartModel> getUpdateAddCart(
            @Header("Authorization") String accessToken,
            @Header("x-client-id") String clientId,
            @Header("x-rtoken-id") String refreshToken,
            @Field("id") String id,
            @Field("name") String name,
            @Field("thumb") String thumb,
            @Field("description") String description,
            @Field("quantity") int quantity,
            @Field("price") int price

            );
    @POST(Constant.URL_REMOVE_CART)
    @FormUrlEncoded
    Call<CartModel> getRemoveCart(
            @Field("id") String productId,
            @Field("name") String productName,
            @Field("thumb") String productThumb,
            @Field("description") String productDescription,
            @Field("quantity") int productQuantity,
            @Field("price") int productPrice
    );

}
