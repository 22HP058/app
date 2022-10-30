package com.example.whale;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;
import java.util.Objects;

public class AlarmService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {


        if(!message.getData().isEmpty()) {
            Log.d("TAG", "onMessageReceived: " + message.getData());
            Map<String, String> data = message.getData();
            String msg = data.get("body");


            if (Objects.requireNonNull(message.getFrom()).equals("/topics/weather")) {

//                Bundle bundle = new Bundle();
//                bundle.putString("title", data.get("title"));
//                bundle.putString("body", data.get("body"));
//
//                Intent intent = new Intent(getApplicationContext(), AlartDialogActivity.class);
//                intent.putExtra("alarm", bundle);
//                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
//                try {
//                    pendingIntent.send();
//                }catch (Exception e) {
//                    e.printStackTrace();
//                }
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder = null;

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    String channelId = "one-channel";
                    String channelName = "My Channel One";
                    String channelDescription = "My Channel One Description";
                    NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
                    channel.setDescription(channelDescription);

                    manager.createNotificationChannel(channel);
                    builder = new NotificationCompat.Builder(this, channelId);
                } else {
                    builder = new NotificationCompat.Builder(this, "else");
                }

                builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
                        .setContentTitle(data.get("title"))
                        .setWhen(System.currentTimeMillis())
                        .setContentText(data.get("body"))
                        .setAutoCancel(true);

                manager.notify(222, builder.build());
            }else if (message.getFrom().trim().equals("/topics/state")) {
                sendMessage("state", message.getData().get("title"), message.getData().get("body"));
                Log.d("TAG", "프래그먼트로 이동 ");
            }else if (message.getFrom().trim().equals("/topics/location")) {
                Log.d("TAG", "onMessageReceived: " + "1");
                sendMessage("location", message.getData().get("title"), message.getData().get("body"));
            }

        }

    }

    @Override
    public void onNewToken(@NonNull String token) {
        Log.d("TAG", "onNewToken: " + token);
        super.onNewToken(token);
//        sendRegistrationToServer(token);
    }

    //    @Override
//    public void onTokenRefresh() {
//        // Get updated InstanceID token.
////        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
////        Log.d("TAG", "Refreshed token: " + refreshedToken);
//
//        // If you want to send messages to this application instance or
//        // manage this apps subscriptions on the server side, send the
//        // Instance ID token to your app server.
////        sendRegistrationToServer(refreshedToken);
//    }

    public void sendMessage(String action,String key, String msg) {
        Intent intent = new Intent();
        if(action.equals("state")){
            intent.setAction("state");
        }else if (action.equals("location")) {
            intent.setAction("location");
            Log.d("TAG", "sendMessage: " +"2");
        }
        intent.putExtra("key", key);
        intent.putExtra("msg", msg);
        sendBroadcast(intent);
    }


}
