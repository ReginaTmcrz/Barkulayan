package com.example.barkulayan;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SinglePlayerBoard extends AppCompatActivity {

    private ImageButton redButton, blueButton, yellowButton, greenButton, orangeButton, pinkButton;
    private ImageButton betButton;
    private int selectedCount = 0;
    private TextView selectedColorsTextView11;
    private ArrayList<String> selectedColors = new ArrayList<>();
    private ArrayList<ImageButton> colorButtons;
    private Random random = new Random();
    private int currentRound = 0;
    private TextView randomColorTextView, roundTextView;
    private TextView usernameTextView1;
    private List<TextView> usernameTextViews = new ArrayList<>();
    private List<TextView> selectedColorTextViews = new ArrayList<>();
    private ArrayList<ImageButton> selectedButtons = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_board);

        redButton = findViewById(R.id.redBtn);
        blueButton = findViewById(R.id.blueBtn);
        yellowButton = findViewById(R.id.yellowBtn);
        greenButton = findViewById(R.id.greenBtn);
        orangeButton = findViewById(R.id.orangeBtn);
        pinkButton = findViewById(R.id.pinkBtn);
        betButton = findViewById(R.id.betBtn);


        selectedColorsTextView11 = findViewById(R.id.selectedColorsTextView1);
        usernameTextView1 = findViewById(R.id.username_text_view1);

        randomColorTextView = findViewById(R.id.random_color_textview);
        roundTextView = findViewById(R.id.round_textview);


        usernameTextViews.add(usernameTextView1);

        selectedColorTextViews.add(selectedColorsTextView11);

        ImageButton redbutton = findViewById(R.id.redBtn);
        ImageButton bluebutton = findViewById(R.id.blueBtn);
        ImageButton yellowbutton = findViewById(R.id.yellowBtn);
        ImageButton greenbutton = findViewById(R.id.greenBtn);
        ImageButton orangebutton = findViewById(R.id.orangeBtn);
        ImageButton pinkbutton = findViewById(R.id.pinkBtn);

        redbutton.setImageResource(R.drawable.redmariobuttonsmall);
        bluebutton.setImageResource(R.drawable.blueghostbuttonsmall);
        yellowbutton.setImageResource(R.drawable.yellowstarbuttonsmall);
        greenbutton.setImageResource(R.drawable.greenluigibuttonsmall);
        orangebutton.setImageResource(R.drawable.orangemushroombuttonsmall);
        pinkbutton.setImageResource(R.drawable.pinkshellbuttonsmall);


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("USERNAME1")) {
            String username1 = intent.getStringExtra("USERNAME1");
            // Display username in the TextViews
            usernameTextView1.setText(username1);

        }

        colorButtons = new ArrayList<>(Arrays.asList(redButton, blueButton, yellowButton, greenButton, orangeButton, pinkButton));

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {handleButtonClick(redButton, "Red");

                ImageButton redbtn = findViewById(R.id.redBtn);
                redbtn.setImageResource(R.drawable.redmariobuttonclickedsmall);
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(blueButton, "Blue");
                ImageButton bluebtn = findViewById(R.id.blueBtn);
                bluebtn.setImageResource(R.drawable.blueghostbuttonclickedsmall);
            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(yellowButton, "Yellow");
                ImageButton yellowbtn = findViewById(R.id.yellowBtn);
                yellowbtn.setImageResource(R.drawable.yellowstarbuttonclickedsmall);
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(greenButton, "Green");
                ImageButton greenbtn = findViewById(R.id.greenBtn);
                greenbtn.setImageResource(R.drawable.greenluigibuttonclickedsmall);
            }
        });

        orangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(orangeButton, "Orange");
                ImageButton orangebtn = findViewById(R.id.orangeBtn);
                orangebtn.setImageResource(R.drawable.orangemushroombuttonclickedsmall);
            }
        });

        pinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(pinkButton, "Pink");
                ImageButton pinkbtn = findViewById(R.id.pinkBtn);
                pinkbtn.setImageResource(R.drawable.pinkshellbuttonclickedsmall);
            }
        });

        betButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView redBtn = findViewById(R.id.redBtn);
                ImageView blueBtn = findViewById(R.id.blueBtn);
                ImageView yellowBtn = findViewById(R.id.yellowBtn);
                ImageView greenBtn = findViewById(R.id.greenBtn);
                ImageView orangeBtn = findViewById(R.id.orangeBtn);
                ImageView pinkBtn = findViewById(R.id.pinkBtn);


                redBtn.setImageResource(R.drawable.redmariobuttonsmall);
                blueBtn.setImageResource(R.drawable.blueghostbuttonsmall);
                yellowBtn.setImageResource(R.drawable.yellowstarbuttonsmall);
                greenBtn.setImageResource(R.drawable.greenluigibuttonsmall);
                orangeBtn.setImageResource(R.drawable.orangemushroombuttonsmall);
                pinkBtn.setImageResource(R.drawable.pinkshellbuttonsmall);

                MediaPlayer mp = MediaPlayer.create(SinglePlayerBoard.this, R.raw.clicksound);
                mp.start();


                if (selectedCount == 1) {
                    startNextRound();

                }


            }

        });
    }

    private void startNextRound() {
        if (currentRound < 5) {
            ++currentRound;
            roundTextView.setText("" + currentRound);

            // Reset selected colors and buttons
            resetSelectedColorsAndButtons();

            // Randomly select a color and assign points
            int randomIndex = random.nextInt(colorButtons.size());
            ImageButton randomColorButton = colorButtons.get(randomIndex);

            String randomColor = randomColorButton.getContentDescription().toString();
            randomColorTextView.setText("" + randomColor);
            showToastForColor(randomColor);
        } else {
            GameOver();
        }
    }

    private void GameOver() {
        Intent i = new Intent(this, GameOverPage.class);
        startActivity(i);
        finish();
    }

    private void resetSelectedColorsAndButtons() {
        selectedCount = 0;
        selectedColors.clear();
        Collections.shuffle(colorButtons);
        for (ImageButton button : colorButtons) {
            button.setEnabled(true);
        }
        selectedColorsTextView11.setText("choose color");

    }

    private void handleButtonClick(ImageButton button, String color) {
        if (button.isEnabled()) {
            button.setEnabled(false);
            selectedColors.add(color);
            selectedCount++;
            updateSelectedColorTextViews();
            if (selectedCount == 1) {
                betButton.setEnabled(true);
                disableUnselectedButtons();
            }else {

            }
        }
    }


    private void disableUnselectedButtons() {
        for (ImageButton btn : new ImageButton[]{redButton, blueButton, yellowButton, greenButton, orangeButton, pinkButton}) {
            if (!selectedButtons.contains(btn)) {
                btn.setEnabled(false);
            }
        }
    }

    private void updateSelectedColorTextViews() {
        switch (selectedCount) {
            case 1:
                selectedColorsTextView11.setText(selectedColors.get(0));
                break;
        }
    }


    // Handle button clicks for each color// For simplicity, I'll add only one listener and determine the color based on the button's text
    public void onColorButtonClick(View view) {
        ImageButton button = (ImageButton) view;
        String color = button.getContentDescription().toString();
        handleButtonClick(button, color);
    }


    private void showToastForColor(String color) {
        switch (color) {
            case "Red":
                ImageView red = new ImageView(getApplicationContext());

                red.setImageResource(R.drawable.redtoast);
                Toast toastRed = new Toast(getApplicationContext());
                toastRed.setDuration(Toast.LENGTH_LONG);
                toastRed.setView(red);
                toastRed.show();

                // Load the GIF using Glide
                Glide.with(this)
                        .load(R.drawable.redtoast)
                        .into(red);

                MediaPlayer mpr = MediaPlayer.create(SinglePlayerBoard.this, R.raw.win);
                mpr.start();

                break;


            case "Blue":
                ImageView blue = new ImageView(getApplicationContext());
                blue.setImageResource(R.drawable.bluetoast);
                Toast toastBlue = new Toast(getApplicationContext());
                toastBlue.setDuration(Toast.LENGTH_LONG);
                toastBlue.setView(blue);
                toastBlue.show();

                // Load the GIF using Glide
                Glide.with(this)
                        .load(R.drawable.bluetoast)
                        .into(blue);

                MediaPlayer mpb = MediaPlayer.create(SinglePlayerBoard.this, R.raw.win);
                mpb.start();

                break;


            case "Yellow":
                ImageView yellow = new ImageView(getApplicationContext());
                yellow.setImageResource(R.drawable.yellowtoast);
                Toast toastYellow = new Toast(getApplicationContext());
                toastYellow.setDuration(Toast.LENGTH_LONG);
                toastYellow.setView(yellow);
                toastYellow.show();

                // Load the GIF using Glide
                Glide.with(this)
                        .load(R.drawable.yellowtoast)
                        .into(yellow);

                MediaPlayer mpy = MediaPlayer.create(SinglePlayerBoard.this, R.raw.win);
                mpy.start();

                break;

            case "Green":
                ImageView green = new ImageView(getApplicationContext());
                green.setImageResource(R.drawable.greentoast);
                Toast toastGreen = new Toast(getApplicationContext());
                toastGreen.setDuration(Toast.LENGTH_LONG);
                toastGreen.setView(green);
                toastGreen.show();

                // Load the GIF using Glide
                Glide.with(this)
                        .load(R.drawable.greentoast)
                        .into(green);

                MediaPlayer mpg = MediaPlayer.create(SinglePlayerBoard.this, R.raw.win);
                mpg.start();

                break;

            case "Orange":
                ImageView orange = new ImageView(getApplicationContext());
                orange.setImageResource(R.drawable.orangetoast);
                Toast toastOrange = new Toast(getApplicationContext());
                toastOrange.setDuration(Toast.LENGTH_LONG);
                toastOrange.setView(orange);
                toastOrange.show();

                // Load the GIF using Glide
                Glide.with(this)
                        .load(R.drawable.orangetoast)
                        .into(orange);

                MediaPlayer mpo = MediaPlayer.create(SinglePlayerBoard.this, R.raw.win);
                mpo.start();
                break;


            case "Pink":
                ImageView pink = new ImageView(getApplicationContext());
                pink.setImageResource(R.drawable.pinktoast);
                Toast toastPink = new Toast(getApplicationContext());
                toastPink.setDuration(Toast.LENGTH_LONG);
                toastPink.setView(pink);
                toastPink.show();

                // Load the GIF using Glide
                Glide.with(this)
                        .load(R.drawable.pinktoast)
                        .into(pink);

                MediaPlayer mpp = MediaPlayer.create(SinglePlayerBoard.this, R.raw.win);
                mpp.start();

                break;

        }
    }

    public void gotoHomePage(){
        Intent i = new Intent(this, selectNumbersOfPlayers.class);
        startActivity(i);
        finish();

    }
}