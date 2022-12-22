package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        EditText playerone = findViewById(R.id.playerone);
        EditText playertwo = findViewById(R.id.playertwo);
        Button startgame = findViewById(R.id.startgame);

        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getPlayerOne = playerone.getText().toString();
                String getPlayerTwo = playertwo.getText().toString();

                if(getPlayerOne.isEmpty() || getPlayerTwo.isEmpty()){
                    Toast.makeText(AddPlayers.this, "Please Enter PLayer Name", Toast.LENGTH_SHORT).show();
            }else {

                    Intent intent = new Intent(AddPlayers.this, MainActivity.class);
                    intent.putExtra("playerone", getPlayerOne);
                    intent.putExtra("playertwo", getPlayerTwo);
                    startActivity(intent);
                }
            }
        });
    }
}