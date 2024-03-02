package com.example.barkulayan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class GameOverPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over_page);

        MediaPlayer mp = MediaPlayer.create(GameOverPage.this, R.raw.outro);
        mp.start();


        ImageView i2 = findViewById(R.id.gameoverpage);
        Glide.with(this)
                .load(R.drawable.gameover)
                .into(i2);


    }

    public void goToMainPage(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}