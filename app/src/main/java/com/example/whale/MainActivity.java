package com.example.whale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private TextView textView1;
//    private TextView textView2;
    private String weather;
    private ImageView weatherView;

    MapFragment mapFragment;

    class AlarmBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("state")) {
                mapFragment.setState(intent.getStringExtra("msg"), intent.getStringExtra("key"));
            }else if (intent.getAction().equals("location")) {
                Log.d("TAG", "onReceive: " +"3");
                mapFragment.setLocation(intent.getStringExtra("msg"));
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView);
//        textView2 = findViewById(R.id.textView2);
        weatherView = findViewById(R.id.imageView);

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy년 MM월 dd일");
        String time1 = dateFormat1.format(date);

        textView1.setText(time1);


        // Service  등록
        AlarmBroadcastReceiver br = new AlarmBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("state");
        filter.addAction("location");
        registerReceiver(br, filter);

        Intent intent = new Intent(this, AlarmService.class);
        startService(intent);




        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction();
        Fragment newFragment = HomeFragment.newInstance();
        mapFragment = MapFragment.newInstance();
        Fragment streamingFragment = StreamingFragment.newInstance();




        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        fm.beginTransaction().replace(R.id.fragmentContainerView, newFragment).commit();
                        Log.d("TAG", "onNavigationItemSelected: home button");
                        break;
                    case R.id.map:
                        fm.beginTransaction().replace(R.id.fragmentContainerView, mapFragment).commit();



                        Log.d("TAG", "onNavigationItemSelected: map button");
                        break;
                    case R.id.streaming:
                        fm.beginTransaction().replace(R.id.fragmentContainerView, streamingFragment).commit();


                        Log.d("TAG", "onNavigationItemSelected: streaming button");
                        break;

                }

                return true;
            }
        });





        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // subscribe topic
        FirebaseMessaging.getInstance().subscribeToTopic("weather")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Subscribed";
                        if (!task.isSuccessful()) {
                            msg = "Subscribe failed";
                        }
                        Log.d("TAG", msg);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

        FirebaseMessaging.getInstance().subscribeToTopic("state")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Subscribed";
                        if (!task.isSuccessful()) {
                            msg = "Subscribe failed";
                        }
                        Log.d("TAG", msg);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

        FirebaseMessaging.getInstance().subscribeToTopic("location")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Subscribed";
                        if (!task.isSuccessful()) {
                            msg = "Subscribe failed";
                        }
                        Log.d("TAG", msg);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

        // DB
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("/");

//        myRef.setValue("Hello, World!");
//        myRef.child("time").setValue("20220929");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Alarm value = dataSnapshot.getValue(Alarm.class);
                if(value != null){
//                    mapFragment.setState(value.getDate(), value.getTime());
                    Log.d("TAG", "Value is: " + dataSnapshot.getValue());
                    HashMap<String, String> data = (HashMap<String, String>) dataSnapshot.getValue();
//                    data = (HashMap<String, String>) dataSnapshot.getValue();
                    Log.d("TAG", "onDataChange: " + String.valueOf(data.get("stationPlace")));
//                    try {
////                        JSONObject jsonObject = new JSONObject(String.valueOf(data.get("stationPlace")));
////                        Log.d("TAG", "onDataChange: " + jsonObject.getString("213124"));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }

                    // DB 튜플추가시 key는 string으로 맞추는게?
                }
//                mapFragment.setState(value.getDate(), value.getTime());
//                Log.d("TAG", "Value is: " + value.getDate() + value.getTime());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

//      token=  dkCHy8nrTlCQzfCI_PBbPO:APA91bG2BW1Njch3Yzj23eNKHmi0SuGuZfxGodCepAihGa18vM7AfQRgPSu-IzSDisgACsLCptuOD5UP1kvfnODujjXN74BHP_4LP1dn3dNWp06RC9NRrIZ5Yfr7srVMVaiW_d88P8Vr






//        Network network = new Network();
//        weather = network.getWeather(new Retrofit2Callback() {
//            @Override
//            public void returnResult(String result) {
//                weather = result;
//                Log.d("TAG", "returnResult: " + weather);
//                if (weather != null) {
//                    setWeather(result);
//                }
//            }
//        });
       // Log.d("TAG", "onCreate: " + ((Network) network).getWeather());
    }



//    private void setWeather(String result) {
//        if (result.equals("0")) {
//            // 맑음 그림 선택할 것.
//            weatherView.setImageResource(R.drawable.ic_sun);
//        }else if (result.equals("1")) {
//            weatherView.setImageResource(R.drawable.ic_rainy);
//        }else if (result.equals("2")) {
//            weatherView.setImageResource(R.drawable.ic_rainysnowy);
//        }else if (result.equals("3")) {
//            weatherView.setImageResource(R.drawable.ic_snowy);
//        }else if (result.equals("5")) {
//            weatherView.setImageResource(R.drawable.ic_rainy);
//        }else if (result.equals("6")) {
//            weatherView.setImageResource(R.drawable.ic_rainysnowy);
//        }else if (result.equals("7")) {
//            weatherView.setImageResource(R.drawable.ic_snowy);
//        }else
//            weatherView.setImageResource(R.drawable.ic_cloudy);
//    }

}

