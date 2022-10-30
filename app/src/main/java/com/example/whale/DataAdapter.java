//package com.example.whale;
//
//import android.content.Context;
//import android.text.Layout;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class DataAdapter extends BaseAdapter {
//
//    Context context = null;
//    LayoutInflater layoutInflater = null;
//    ArrayList<Data> dataList;
//
//    public DataAdapter(Context context, ArrayList<Data> dataList) {
//        this.context = context;
//        this.layoutInflater = LayoutInflater.from(context);
//        this.dataList = dataList;
//    }
//
//    @Override
//    public int getCount() {
//        return dataList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return dataList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        View mview = layoutInflater.inflate(R.layout.data_row, null);
//
//        TextView textView5 = mview.findViewById(R.id.textView7);
//        TextView textView6 = mview.findViewById(R.id.textView8);
//        TextView textView7 = mview.findViewById(R.id.textView9);
//
//        textView5.setText(dataList.get(i).getTem());
//        textView6.setText(dataList.get(i).getHum());
//        textView7.setText(dataList.get(i).getDus());
//
//
//        return mview;
//    }
//}
