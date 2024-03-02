package com.example.barkulayan;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class selectNumbersOfPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_numbers_of_players);

    }

    public void goToSinglePlayerPage(View v) {

        Intent i = new Intent(this, SinglePlayer.class);
        startActivity(i);
        finish();
    }

    public void goToTwoPlayersPage(View v) {
        Intent i = new Intent(this, TwoPlayers.class);
        startActivity(i);
        finish();
    }

    public void goToThreePlayersPage(View v) {
        Intent i = new Intent(this, ThreePlayers.class);
        startActivity(i);
        finish();
    }

    public void goToFourPlayersPage(View v) {
        Intent i = new Intent(this, FourPlayers.class);
        startActivity(i);
        finish();
    }

    public void goToMainPage(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}