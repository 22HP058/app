package com.example.whale;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StreamingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StreamingFragment extends Fragment {
    WebView webView;
    WebSettings webSettings;


    public StreamingFragment() {
        // Required empty public constructor
    }

    public static StreamingFragment newInstance() {
        StreamingFragment fragment = new StreamingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // viewmodel 처리

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_streaming,container,false);
        webView = view.findViewById(R.id.webview);
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("http://192.168.238.168:8000/index.html");

        return view;
    }
}