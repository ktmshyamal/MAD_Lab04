package com.example.androidnotifications;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    public static final String CHANNEL_ID = "notification";

    Button sign;
    EditText value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign = findViewById(R.id.id_btn_sign);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get user input(Name) to String variable
                value = findViewById(R.id.id_name);
                String name = value.getText().toString();

                // Create an explicit intent for an Activity in your app
                Intent intent = new Intent(MainActivity.this,register.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

                //set user name (Hello << name >>! Welcome to the MAD team)
                //image
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Click on this to Register")
                        .setContentText("Hello " + name + " ! Welcome to the MAD team")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);

                notificationManager.notify(0, builder.build());
            }
        });
    }
}
