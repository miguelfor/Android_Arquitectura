package com.example.miguelforero.arquitectura;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.v("MSN Main2Activity","onCreate");
        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(getIntent().getExtras().getInt("NotificacionID"));
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MSN Main2Activity","onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("MSN MainActivity","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("MSN Main2Activity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("MSN Main2Activity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MSN Main2Activity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MSN Main2Activity","onDestroy");
    }
}
