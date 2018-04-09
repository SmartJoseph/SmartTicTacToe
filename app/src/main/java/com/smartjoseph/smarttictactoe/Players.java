package com.smartjoseph.smarttictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Players extends AppCompatActivity {

    ImageButton backBtn;
    ImageButton startBtn;
    Button boardSizeThree;
    Button boardSizeFive;

    Integer selectedBoard = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        addListenerOnBackButton();
        addListenerOnStartButton();
        addListenerOnBoardSizeThreeButton();
        addListenerOnBoardSizeFiveButton();
    }

    public void addListenerOnBackButton() {
        backBtn = (ImageButton) findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void addListenerOnBoardSizeThreeButton() {
        boardSizeThree = (Button) findViewById(R.id.boardSize3);
        boardSizeThree.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boardSizeThree.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                boardSizeThree.setTextColor(getResources().getColor(R.color.colorWhite));
                boardSizeThree.setEnabled(false);
                selectedBoard = 3;

                boardSizeFive.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                boardSizeFive.setTextColor(getResources().getColor(R.color.colorBrown));
                boardSizeFive.setEnabled(true);
            }
        });
    }

    public void addListenerOnBoardSizeFiveButton() {
        boardSizeFive = (Button) findViewById(R.id.boardSize5);
        boardSizeFive.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boardSizeFive.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                boardSizeFive.setTextColor(getResources().getColor(R.color.colorWhite));
                boardSizeFive.setEnabled(false);
                selectedBoard = 5;

                boardSizeThree.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                boardSizeThree.setTextColor(getResources().getColor(R.color.colorBrown));
                boardSizeThree.setEnabled(true);
            }
        });

    }


    public void addListenerOnStartButton() {
        startBtn = (ImageButton) findViewById(R.id.start_btn);
        startBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Get Player One's name
                EditText playerOneName = (EditText) findViewById(R.id.playerOneNameEditTxt);

                // Get Player Opponent's name
                EditText opponentName = (EditText) findViewById(R.id.opponentNameEditTxt);

                if (playerOneName==null || opponentName==null && selectedBoard == 0) {
                    Toast.makeText(Players.this, "Please enter players' names and select board size", Toast.LENGTH_SHORT).show();

                } else {

                    if (playerOneName !=null && opponentName !=null && selectedBoard == 3) {
                        Intent startGame = new Intent(Players.this, TwoPlayers.class);
                        startGame.putExtra("playerOnesName", playerOneName.getText().toString());
                        startGame.putExtra("opponentsName", opponentName.getText().toString());
                        startActivity(startGame);
                    } else if (playerOneName !=null && opponentName !=null && selectedBoard == 5) {
                        Intent startGame = new Intent(Players.this, TwoPlayersBoardSize5.class);
                        startGame.putExtra("playerOnesName", playerOneName.getText().toString());
                        startGame.putExtra("opponentsName", opponentName.getText().toString());
                        startActivity(startGame);
                    }


                }
            }
        });

    }
}
