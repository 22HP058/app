package com.example.whale;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

//    @GET("getUltraSrtNcst")
//    Call<Wheather> getPosts(
//            @Query("Servicekey")String serviceKey,
//            @Query("numOfRows") int numOfRows,
//            @Query("pageNo") int pageNo,
//            @Query("dataType") String dataType,
//            @Query("base_date") String baseDate,
//            @Query("base_time") String baseTime,
//            @Query("nx") int nx,
//            @Query("ny") int ny);

    @GET("getVilageFcst")
    Call<WEATHER> getWeather(
            @Query("serviceKey") String serviceKey,
            @Query("numOfRows") int num_of_rows,
            @Query("pageNo") int page_no,
            @Query("dataType") String data_type,
            @Query("base_date") String base_date,
            @Query("base_time") String base_time,
            @Query("nx") int nx,
            @Query("ny") int ny
    );

}

//http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst
// ?ServiceKey=AkzV6q46FMZBp89e3lCEWO8xnWcsHJWJ79lhamIkkrNNYGwyCeU%2FXyFBOTA80Bp2mq1Qt%2FjlKdYAHLhNr7VC%2Fg%3D%3D
// &numOfRows=10
// &pageNo=1
// &dataType=json
// &base_date=20220918
// &base_time=1200
// &nx=60
// &ny=120