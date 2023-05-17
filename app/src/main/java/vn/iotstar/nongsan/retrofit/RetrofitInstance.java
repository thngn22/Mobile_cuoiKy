package vn.iotstar.nongsan.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.iotstar.nongsan.constant.Constant;

public class RetrofitInstance {
    private static Retrofit retrofit;
    public static Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.ROOT_URL) //192.168.1.3 https://foodapp.free.beeceptor.com/
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
