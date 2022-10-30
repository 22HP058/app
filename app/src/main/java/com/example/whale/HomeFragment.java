package com.example.whale;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.whale.URLConnector;
import com.example.whale.ParsingJson;

public class HomeFragment extends Fragment {
    String baseUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/";
    String serviceKey = "AkzV6q46FMZBp89e3lCEWO8xnWcsHJWJ79lhamIkkrNNYGwyCeU/XyFBOTA80Bp2mq1Qt/jlKdYAHLhNr7VC/g==";
    RecyclerView recyclerView;
    WeatherAdapter recyclerViewAdapter;
    ArrayList<Data> dataList;


    //seb : plust database parsing variable
    TextView text_sensor_row_length;
    TextView text_sensor_column_length;
    TextView text_sensor_column;
    TextView text_sensor_result;




    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.weatherRecyclerView);


       setWeather(60, 150);


       //seb : plus database parsing
        text_sensor_row_length = view.findViewById(R.id.text_sensor_row_length);
        text_sensor_column_length = view.findViewById(R.id.text_sensor_column_length);
        text_sensor_column = view.findViewById(R.id.text_sensor_column);
        text_sensor_result = view.findViewById(R.id.text_sensor_result);



        //url connect
        URLConnector task = new URLConnector("sensor");       //"tram" , "sensor"
        task.start();
        try{
            task.join();
            System.out.println("waiting... for result");
        }
        catch(InterruptedException e){

        }
        //http response
        String Json_result = task.getResult();


        //json parsing
        ParsingJson sensorParsing;

        try {
            sensorParsing = new ParsingJson(Json_result);

            //행 개수 갖고오기
            int row_length = sensorParsing.getRowLength();
            //column 개수 갖고오기
            int column_length = sensorParsing.getColumnLength();
            //column 가져오기
            String[] column = sensorParsing.getColumn();

            text_sensor_row_length.setText(String.valueOf(row_length));
            text_sensor_column_length.setText(String.valueOf(column_length));
            text_sensor_column.setText(Arrays.toString(column));


            //database 값 parsing 결과 가져오기
            String[][] parsingResult = sensorParsing.getParsingResult();
            for(int i=0; i<parsingResult.length; i++){
                Log.i("check_parsing_value",String.valueOf(i)+ Arrays.toString(parsingResult[i]));
                text_sensor_result.append(Arrays.toString(parsingResult[i]));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }





    }

    private void setWeather(int nx, int ny) {
        Calendar cal = Calendar.getInstance();
//        baseDate = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(cal.getTime());
        String timeH = new SimpleDateFormat("HH", Locale.getDefault()).format(cal.getTime());
        String timeM = new SimpleDateFormat("mm", Locale.getDefault()).format(cal.getTime());

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //.addConverterFactory(ScalarsConverterFactory.create())

        RetrofitService wheatherInterface =  retrofit.create(RetrofitService.class);

//        wheatherInterface.getWeather(serviceKey, 74, 1,"JSON", "20221009", "1100", nx, ny)
//                .enqueue(new Callback<WEATHER>() {
//                    @Override
//                    public void onResponse(Call<WEATHER> call, Response<WEATHER> response) {
//                        if (response.isSuccessful()) {
//                            if (response.body() != null) {
//                                List<ITEM> it = response.body().getResponse().getBody().getItems().getItem();
//                                ArrayList<ModelWeather> weatherArr = getWeatherArr(it); // add to arraylist from json
//
//                                recyclerViewAdapter = new WeatherAdapter(weatherArr);
//                                for (ModelWeather i : weatherArr) {
//                                    Log.d("TAG", "onResponse: " + i.getFcstTime() + " " + i.getRainType());
//                                }
//
//                                recyclerView.setAdapter(recyclerViewAdapter);
//                            }
//
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<WEATHER> call, Throwable t) {
//                        Log.d("TAG", "onFailure: " + "불러오기 실패");
//                        Log.d("TAG", "onFailure: " + t.toString());
////                Log.d("TAG", "onFailure: " + call.toString());
//                    }
//                });
    }

    @NonNull
    private ArrayList<ModelWeather> getWeatherArr(List<ITEM> it) {
        ArrayList<ModelWeather> weatherArr = new ArrayList<ModelWeather>();
        int index = 0;
        ModelWeather model = new ModelWeather();

        for (ITEM i : it) {
            // 6개의 항목만 담는다.
            index %= 6;
//                            Log.d("TAG", "onResponse: " + i.getCategory() + " : " + i.getFcstValue() + " " + i.getFcstValue().getClass());

            switch (i.getCategory()) {
                case "TMP":
                    model.setTemp(i.getFcstValue());
                    break;
                case "UUU":
                    model.setUuu(i.getFcstValue());
                    break;
                case "VVV":
                    model.setVvv(i.getFcstValue());
                    break;
                case "VEC":
                    model.setVec(i.getFcstValue());
                    break;
                case "WSD":
                    model.setWsd(i.getFcstValue());
                    break;
                case "SKY":
                    model.setSky(i.getFcstValue());
                    break;
                case "PTY":
                    model.setRainType(i.getFcstValue());
                    break;
                case "POP":
                    model.setPop(i.getFcstValue());
                    break;
                case "WAV":
                    model.setWav(i.getFcstValue());
                    break;
                case "PCP":
                    model.setPcp(i.getFcstValue());
                    break;
                case "REH":
                    model.setHumidity(i.getFcstValue());

                    break;
                case "SNO":
                    model.setSno(i.getFcstValue());
                    model.setFcstTime(i.getFcstTime());
//                    Log.d("TAG", "추가되었나요?: " + model.getTemp() + " " + model.getFcstTime() + " " + model.getSky() + " " + model.getRainType() + " " + model.getHumidity());
                    weatherArr.add(new ModelWeather(model));
                    index++;
                    break;
                default:
                    continue;
            }


            if (index > 5)
                break;
        }
////                        weatherArr.get(0).setFcstTime("지금");
//        for (ModelWeather i : weatherArr) {
//            Log.d("TAG", "결과출력: " + i.getFcstTime() + " " + i.getHumidity() + " " + i.getRainType() + " " + i.getSky() + " " + i.getTemp());
//        }
        return weatherArr;
    }

}