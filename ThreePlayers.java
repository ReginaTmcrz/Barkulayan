package com.example.barkulayan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ThreePlayers extends AppCompatActivity {

    private EditText usernameEditText1, usernameEditText2, usernameEditText3 ;
    private ImageButton proceedButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_players);

        ImageView red = new ImageView(getApplicationContext());
        red.setImageResource(R.drawable.three);
        Toast toastRed = new Toast(getApplicationContext());
        toastRed.setDuration(Toast.LENGTH_LONG);
        toastRed.setView(red);
        toastRed.show();

        // Load the GIF using Glide
        Glide.with(this)
                .load(R.drawable.three)
                .into(red);

        usernameEditText1 = findViewById(R.id.username_edit_text1);
        usernameEditText2 = findViewById(R.id.username_edit_text2);
        usernameEditText3 = findViewById(R.id.username_edit_text3);

        proceedButton = findViewById(R.id.proceedBtn);

        usernameEditText1.addTextChangedListener(textWatcher);
        usernameEditText2.addTextChangedListener(textWatcher);
        usernameEditText3.addTextChangedListener(textWatcher);

        proceedButton.setEnabled(false);
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username1 = usernameEditText1.getText().toString();
                String username2 = usernameEditText2.getText().toString();
                String username3 = usernameEditText3.getText().toString();

                Intent intent = new Intent(ThreePlayers.this, ThreePlayersBoard.class);
                intent.putExtra("USERNAME1", username1);
                intent.putExtra("USERNAME2", username2);
                intent.putExtra("USERNAME3", username3);

                startActivity(intent);
            }
        });

    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            // Check if all text fields are non-empty
            boolean allFieldsFilled = !usernameEditText1.getText().toString().isEmpty() &&
                    !usernameEditText2.getText().toString().isEmpty() &&
                    !usernameEditText3.getText().toString().isEmpty();

            // Enable or disable the button based on the condition
            proceedButton.setEnabled(allFieldsFilled);
        }
    };

    public void goToPageSelectNumbersOfPlayersPage(View v) {
        Intent i = new Intent(this, selectNumbersOfPlayers.class);
        startActivity(i);
        finish();
    }
}