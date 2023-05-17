package vn.iotstar.nongsan.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.iotstar.nongsan.models.ProductModel;
import vn.iotstar.nongsan.retrofit.NongSanAPI;
import vn.iotstar.nongsan.retrofit.RetrofitInstance;
import vn.iotstar.nongsan.utils.UtilsTokens;
import vn.iotstar.nongsan.utils.UtilsUser;

public class ProductRepository {
    private NongSanAPI nongSanAPI;

    public ProductRepository() {
        nongSanAPI = RetrofitInstance.getRetrofit().create(NongSanAPI.class);
    }

    public MutableLiveData<ProductModel> getProductModel() {
        MutableLiveData<ProductModel> data = new MutableLiveData<>();
        nongSanAPI.getProductModel().enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                    Log.d("logg", "co du lieu product");
                } else {
                    Log.d("logg", "dell");
                }
            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {
                Log.d("logg", "Lỗi đọc ở đây nè, retrofit bị lỗi product");
                Log.d("logg", t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }


    public MutableLiveData<ProductModel> getProductByCategoryModel(String categoryId, String accessToken, String clientId, String refreshToken) {
        MutableLiveData<ProductModel> data = new MutableLiveData<>();
        nongSanAPI.getProductByCategoryModel(categoryId, accessToken, clientId, refreshToken).enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                    Log.d("logg", "co du lieu product");
                } else {
                    Log.d("logg", "dell");
                }
            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {
                Log.d("logg", "Lỗi đọc ở đây nè, retrofit bị lỗi product");
                Log.d("logg", t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }

    public MutableLiveData<ProductModel> getSearchModel(String searchName) {
        MutableLiveData<ProductModel> data = new MutableLiveData<>();
        nongSanAPI.getProductDetailModelBySearch(searchName).enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                    Log.d("logg", "co du lieu product");
                } else {
                    Log.d("logg", "dell");
                }
            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {
                Log.d("logg", "Lỗi đọc ở đây nè, retrofit bị lỗi product");
                Log.d("logg", t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }
}
