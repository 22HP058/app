//package com.example.whale;
//
//import android.util.Log;
//
//import androidx.annotation.NonNull;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import java.util.Objects;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.converter.scalars.ScalarsConverterFactory;
//import retrofit2.Response;
//
//public class Network {
//
//    String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/";
//    String serviceKey = "AkzV6q46FMZBp89e3lCEWO8xnWcsHJWJ79lhamIkkrNNYGwyCeU/XyFBOTA80Bp2mq1Qt/jlKdYAHLhNr7VC/g==";
//    String nx = "60";	//위도
//    String ny = "125";	//경도
//    String baseDate = "20220929";	//조회하고싶은 날짜
//    String baseTime = "0500";	//조회하고싶은 시간
//    String type = "json";	//조회하고 싶은 type(json, xml 중 고름)
//    String w;
//
//    public String getWeather(Retrofit2Callback callback)  {
//
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .build();
//
//        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
//
//
//
//        retrofitService.getPosts(serviceKey, 10, 1, "JSON", "20220928", "1600", 60, 125).enqueue(new Callback<Wheather>() {
//            @Override
//            public void onResponse(@NonNull Call<Wheather> call, @NonNull Response<Wheather> response) {
//                Log.d("TAG", "onResponse: getPost" + Objects.requireNonNull(response.body()).getResponse().getBody().getItems().getItem().get(0).getObsrValue());
//
//                w = response.body().getResponse().getBody().getItems().getItem().get(0).getObsrValue();
//                if(null != callback) callback.returnResult(w);
//                }
//
//            @Override
//            public void onFailure(Call<Wheather> call, Throwable t) {
//                Log.d("TAG", "onFailure: " + t.toString());
//                Log.d("TAG", "onFailure: " + "response" + call.toString());
//            }
//        });
//
//        return w;
//    }
//}
