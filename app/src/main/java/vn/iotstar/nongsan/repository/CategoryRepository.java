package vn.iotstar.nongsan.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.iotstar.nongsan.models.CategoryModel;
import vn.iotstar.nongsan.retrofit.NongSanAPI;
import vn.iotstar.nongsan.retrofit.RetrofitInstance;

public class CategoryRepository {
    private final NongSanAPI nongSanAPI;

    public CategoryRepository() {
        nongSanAPI = RetrofitInstance.getRetrofit().create(NongSanAPI.class);
    }

    public MutableLiveData<CategoryModel> getCategoryModel() {
        MutableLiveData<CategoryModel> data = new MutableLiveData<>();
        nongSanAPI.getCategoryModel().enqueue(new Callback<CategoryModel>() {
            @Override
            public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                    Log.d("logg", "co du lieu category");
                } else {
                    Log.d("logg", "dell");
                }

            }

            @Override
            public void onFailure(Call<CategoryModel> call, Throwable t) {
                Log.d("logg", "Lỗi đọc ở đây nè, retrofit bị lỗi category");
                Log.d("logg", t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }
}
