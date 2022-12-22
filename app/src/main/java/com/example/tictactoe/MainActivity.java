package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tictactoe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final List<int[]> combinationsList = new ArrayList<>();
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int playerTurn = 1;
    private int totalSelectedBoxes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        combinationsList.add(new int[] {0,1,2});
        combinationsList.add(new int[] {3,4,5});
        combinationsList.add(new int[] {6,7,8});
        combinationsList.add(new int[] {0,3,6});
        combinationsList.add(new int[] {1,4,7});
        combinationsList.add(new int[] {2,5,8});
        combinationsList.add(new int[] {2,4,6});
        combinationsList.add(new int[] {0,4,8});

        String getPlayerOneName = getIntent().getStringExtra("playerone");
        String getPlayerTwoName = getIntent().getStringExtra("playertwo");

        binding.playeronename.setText(getPlayerOneName);
        binding.layertwoname.setText(getPlayerTwoName);

        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(0)) {
                    performAction((ImageView) view, 0);
                }
            }
        });

        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(1)) {
                    performAction((ImageView) view, 1);
                }
            }
        });
        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(2)) {
                    performAction((ImageView) view, 2);
                }
            }
        });
        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(3)) {
                    performAction((ImageView) view, 3);
                }
            }
        });
        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(4)) {
                    performAction((ImageView) view, 4);
                }
            }
        });
        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(5)) {
                    performAction((ImageView) view, 5);
                }
            }
        });
        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(6)) {
                    performAction((ImageView) view, 6);
                }
            }
        });
        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(7)) {
                    performAction((ImageView) view, 7);
                }
            }
        });
        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(8)) {
                    performAction((ImageView) view, 8);
                }
            }
        });
    }

    private void performAction(ImageView imageView, int selectedBoxPosition){
        boxPositions[selectedBoxPosition] = playerTurn;

        if(playerTurn == 1) {
            imageView.setImageResource(R.drawable.ximage);
            if(checkResult()) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, binding.playeronename.getText().toString()
                + " Won", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else if(totalSelectedBoxes == 9) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "Match Draw", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else{
                changePlayerTurn(2);
                totalSelectedBoxes++;

            }
        }else{
            imageView.setImageResource(R.drawable.oimage);
            if(checkResult()) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, binding.layertwoname.getText().toString()
                        + " Won", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else if(totalSelectedBoxes == 9) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "Match Draw", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else{
                changePlayerTurn(1);
                totalSelectedBoxes++;

            }
        }
    }
    private void changePlayerTurn (int currentPlayerTurn) {
        playerTurn = currentPlayerTurn;
        if(playerTurn == 1) {
            binding.playeronelyt.setBackgroundResource(R.drawable.black_border);
            binding.playertwolyt.setBackgroundResource(R.drawable.white_box);
        }else {
            binding.playertwolyt.setBackgroundResource(R.drawable.black_border);
            binding.playeronelyt.setBackgroundResource(R.drawable.white_box);
        }
    }

    private boolean checkResult(){
        boolean response = false;
        for (int i = 0; i < combinationsList.size(); i++) {
            final int [] combination = combinationsList.get(i);

            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn && boxPositions[combination[2]] == playerTurn) {
               response = true;
            }
        }
        return response;
    }
    private boolean isBoxSelected(int boxPosition) {
        boolean response = false;
        if (boxPositions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }
    public void restartMatch()  {
        boxPositions = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
        playerTurn= 1;
        totalSelectedBoxes = 1;

        binding.image1.setImageResource(R.drawable.white_box);
        binding.image2.setImageResource(R.drawable.white_box);
        binding.image3.setImageResource(R.drawable.white_box);
        binding.image4.setImageResource(R.drawable.white_box);
        binding.image5.setImageResource(R.drawable.white_box);
        binding.image6.setImageResource(R.drawable.white_box);
        binding.image7.setImageResource(R.drawable.white_box);
        binding.image8.setImageResource(R.drawable.white_box);
        binding.image9.setImageResource(R.drawable.white_box);

    }
}