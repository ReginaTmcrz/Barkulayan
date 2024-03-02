package com.example.barkulayan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.intro);
        mp.start();


        ImageView i = new ImageView(getApplicationContext());
        i.setImageResource(R.drawable.elizarianslogo);

        Toast toastI = new Toast(getApplicationContext());
        toastI.setDuration(Toast.LENGTH_LONG);
        toastI.setView(i);
        toastI.show();

        // Load the GIF using Glide
        Glide.with(this)
                .load(R.drawable.elizarianslogo)
                .into(i);

        ImageView i2 = findViewById(R.id.homebg);
        Glide.with(this)
                .load(R.drawable.homepagebg)
                .into(i2);

    }

    public void gotoSelectNumofplayersPage(View v) {

        Intent i = new Intent(this, selectNumbersOfPlayers.class);
        startActivity(i);
        finish();
    }

    public void goToAboutPage(View v) {
        Intent i = new Intent(this, AboutPage.class);
        startActivity(i);
        finish();
    }





}
