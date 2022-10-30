package com.example.whale;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment extends Fragment {

    private TextView stateText;
    private TextView tramStateText;
    private ImageView map;
    private FrameLayout mapcontainer;
    private ImageView marker;

    public MapFragment() {
        // Required empty public constructor
    }



    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        stateText.setTextColor();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        stateText = view.findViewById(R.id.state);
        tramStateText = view.findViewById(R.id.tram_state);
        map = view.findViewById(R.id.map);
        mapcontainer = view.findViewById(R.id.container);
        marker = (ImageView)inflater.inflate(R.layout.marker, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        marker.setX(470);
        marker.setY(105);
        mapcontainer.addView(marker);
        setLocation("2");

    }
    public void setState(String msg, String key) {
        Log.d("TAG", "메인액티비티로의 브로드캐스트" + msg + " " +key);

        stateText.setText(key);
        tramStateText.setText(msg);

    }

    public void setLocation(String key) {

        if(key.equals("0")) {
            marker.setX(470);
            marker.setY(105);
        }else if(key.equals("1")) {
            marker.setX(835);
            marker.setY(280);
        }else if(key.equals("2")) {
            marker.setX(470);
            marker.setY(425);
        }else if(key.equals("3")) {
            marker.setX(60);
            marker.setY(280);
        }
        Log.d("TAG", "setLocation: " + key);


    }


}