package com.example.whale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder>{
    ArrayList<ModelWeather> items;

    public WeatherAdapter(ArrayList<ModelWeather> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_weather, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelWeather item = items.get(position);
        holder.imgWeather.setImageResource(getRainImage(item.getRainType(), item.getSky()));
        holder.tvTime.setText(item.getFcstTime());
        holder.tvHumidity.setText(String.format("%s%%", item.getHumidity()));
        holder.tvTemp.setText(String.format("%s도", item.getTemp()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgWeather;
        public TextView tvTime;
        public TextView tvHumidity;
        public TextView tvTemp;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgWeather = itemView.findViewById(R.id.imgWeather);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvHumidity = itemView.findViewById(R.id.tvHumidity);
            tvTemp = itemView.findViewById(R.id.tvTemp);


        }
    }

    public String getTime(String factTime) {

        if(factTime != "지금") {
            int hourSystem = Integer.parseInt(factTime);
            String hourSystemString = "";

            if(hourSystem == 0) {
                return "오전 12시";
            }else if (hourSystem > 2100) {
                hourSystem -= 1200;
                hourSystemString = String.valueOf(hourSystem);
                return "오후 ${hourSystemString[0]}${hourSystemString[1]}시";
            }else if (hourSystem == 1200) {
                return "오후 12시";
            }else if (hourSystem > 1200) {
                hourSystem -= 1200;
                hourSystemString = String.valueOf(hourSystem);
                return "오후 ${hourSystemString[0]시";
            }else if (hourSystem >= 1000) {
                hourSystemString = String.valueOf(hourSystem);
                return "오전 ${hourSystemString[0]}${hourSystemString[1]}시";
            }else {
                hourSystemString = String.valueOf(hourSystem);
                return "오전 ${hourSystemString[0]시";
            }
        }else {
            return factTime;
        }

    }

    public int getRainImage(String rainType, String sky) {
        if(rainType.equals("0")) {
            return getWeatherImage(sky);
        }else if (rainType.equals("1")) {
            return R.drawable.rainy;
        }else if (rainType.equals("2")) {
            return R.drawable.haily;
        }else if (rainType.equals("3")) {
            return R.drawable.snowy;
        }else if (rainType.equals("4")) {
            return R.drawable.cloud;
        }else {
            return getWeatherImage(sky);
        }
    }

    public int getWeatherImage(String sky) {
        if (sky.equals("1")) {
            return R.drawable.sun;
        }else if (sky.equals("3")) {
            return R.drawable.cloud;
        }else if (sky.equals("4")) {
            return R.drawable.cloud;
        }else {
            return R.drawable.ic_launcher_foreground;
        }
    }
}
