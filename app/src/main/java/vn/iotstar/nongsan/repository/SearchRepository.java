package vn.iotstar.nongsan.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.iotstar.nongsan.models.ProductModel;
import vn.iotstar.nongsan.retrofit.NongSanAPI;
import vn.iotstar.nongsan.retrofit.RetrofitInstance;

public class SearchRepository {
    private final NongSanAPI nongSanAPI;

    public SearchRepository() {
        nongSanAPI = RetrofitInstance.getRetrofit().create(NongSanAPI.class);
    }

    public MutableLiveData<ProductModel> getSearchModel(String searchName) {
        MutableLiveData<ProductModel> data = new MutableLiveData<>();
        nongSanAPI.getProductDetailModelBySearch(searchName).enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                    Log.d("logg", "co du lieu search");
                } else {
                    Log.d("logg", "dell");
                }

            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {
                Log.d("logg", "Lỗi đọc ở đây nè, retrofit bị lỗi search");
                Log.d("logg", t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }
}
