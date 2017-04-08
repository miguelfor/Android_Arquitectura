package com.example.miguelforero.arquitectura;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.Build.ID;

public class MainActivity extends AppCompatActivity {

    int ID=1;
    private EditText nombre;
    private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre= (EditText)findViewById(R.id.nombre);
        pass= (EditText)findViewById(R.id.pass);
        Log.v("MSN MainActivity","onCreate");
    }
    public void notificar(View view){
        Snackbar snackbar= Snackbar.make(view,"Debes recuperar tu cuenta",Snackbar.LENGTH_LONG)
                .setAction("RECUPERAR", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "las instrucciones de recuperación de su cuenta se han enviado a su e-mail", Toast.LENGTH_SHORT).show();
                    }
                });
        snackbar.setActionTextColor(Color.WHITE);
        View snackBarView =snackbar.getView();
        snackBarView.setBackgroundColor(Color.BLACK);
        snackbar.show();
    }
    public void entrar (View view){

        if(nombre.getText().toString().equals("")){
            Toast.makeText(this, "Ingrese nombre" , Toast.LENGTH_SHORT).show();
        }else if(pass.getText().toString().equals("")){
            Toast.makeText(this, "Ingrese contraseña" , Toast.LENGTH_SHORT).show();
        }else{
        Intent intent= new Intent(this, Main2Activity.class);
        startActivity(intent);
        }
    }

    public  void notificacion(View view){

        NotificationManager noti =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification n = new NotificationCompat.Builder(this).setContentTitle("Esta es una notificacion").setContentText("Este es el contenido").setSubText("este es el subtexto")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();
        noti.notify(1,n);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MSN MainActivity","onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("MSN MainActivity","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.wtf("MSN MainActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("MSN MainActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MSN MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MSN MainActivity","onDestroy");
    }

    public void notificacion2(View view){
        Intent i= new Intent(MainActivity.this,Main2Activity.class);
        i.putExtra("NotificacionID", ID);

        PendingIntent pendingIntent= PendingIntent.getActivity(this, 0, i, 0);
        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Uri sonido= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification n = new NotificationCompat.Builder(this)
                .setContentIntent(pendingIntent)
                .setTicker("Click aqui")
                .setContentTitle("Notificacion nueva")
                .setContentText("Contenido de la notificacion")
                .setSubText("Subtexto")
                .setSmallIcon(R.mipmap.ic_launcher)
                .addAction(R.mipmap.ic_launcher,"Click aqui",pendingIntent)
                .addAction(android.R.drawable.ic_menu_share,"Compartir",pendingIntent)
                .setVibrate(new long[]{1000,500,1000,5000})
                .setPriority(Notification.PRIORITY_MAX)
                .setSound(sonido)
                .setLights(Color.BLUE,1,0)
                .build();
        nm.notify(ID,n);
    }
}
