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

public interface NongSanAPI {

    @GET(Constant.URL_CATEGORY)
    Call<CategoryModel> getCategoryModel();

    @GET(Constant.URL_PRODUCT_PUBLISHED)
    Call<ProductModel> getProductModel();


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
