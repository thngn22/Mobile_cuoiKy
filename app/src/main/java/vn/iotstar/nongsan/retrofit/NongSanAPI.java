package vn.iotstar.nongsan.retrofit;

import java.util.List;
import vn.iotstar.nongsan.constant.Constant;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import vn.iotstar.nongsan.models.CategoryModel;
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
            @Field("email") String email,
            @Field("password") String password,
            @Field("phone") String phone

    );

//    @Headers({
//            "Accept: application/json",
//            "User-Agent: Your-App-Name",
//            "Cache-Control: max-age=640000"
//    })
    @POST("mealdetail.php")
    @FormUrlEncoded
    Call<ProductDetailModel> getProductDetailModel(
            @Field("id")
            int id
    );
    @POST("search.php")
    @FormUrlEncoded
    Call<ProductModel> getProductDetailModelBySearch(
            @Field("searchName")
            String searchName
    );
}
