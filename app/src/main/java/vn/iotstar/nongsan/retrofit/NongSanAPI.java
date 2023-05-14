package vn.iotstar.nongsan.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import vn.iotstar.nongsan.models.CategoryModel;
import vn.iotstar.nongsan.models.ProductDetailModel;
import vn.iotstar.nongsan.models.ProductModel;

public interface NongSanAPI {
    @GET("category.php")
    Call<CategoryModel> getCategoryModel();

    @POST("meals.php")
    @FormUrlEncoded
    Call<ProductModel> getProductModel(
            @Field("idCate")
            int idCate
    );

    @POST("mealdetail.php")
    @FormUrlEncoded
    Call<ProductDetailModel> getProductDetailModel(
            @Field("id")
            int id
    );
}
