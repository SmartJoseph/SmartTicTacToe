package com.smartjoseph.smarttictactoe;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class TwoPlayers extends AppCompatActivity {

    final Context context = this;
    ImageButton newGameBtn;
    ImageButton backBtn;
    ImageButton optionsBtn;
    ImageButton helpBtn;
    TextView playerOne;
    TextView playerTwo;

    /**
     * The variable clicked_GridCounter keeps track of the number
     * of times the grid has been clicked.
     * It's been set to '1' because i want player one to start the game by default.
     */
    Integer clicked_GridCounter = 1;
    Integer sum = 0, usersScore = 0, computerScore = 0;

    //this grid refers to the game board and it is counted horizontally from left to right.
    ImageView gridOne, gridTwo, gridThree, gridFour, gridFive, gridSix, gridSeven, gridEight, gridNine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_players);

        playerOne = (TextView) findViewById(R.id.playerOneName);
        Intent playerOneIntent = getIntent();
        final String playerOneNm = playerOneIntent.getStringExtra("playerOnesName");
        playerOne.setText(playerOneNm);

        playerTwo = (TextView) findViewById(R.id.opponentName);
        Intent playerTwoIntent = getIntent();
        final String playerTwoNm = playerTwoIntent.getStringExtra("opponentsName");
        playerTwo.setText(playerTwoNm);

        addListenerOnNewGameButton();
        addListenerOnBackButton();
        addListenerOnOptionsButton();
        addListenerOnHelpButton();

        //
        final ImageView gridOnePlayerOneIcon = (ImageView) findViewById(R.id.gridOnePlayerOneIcon);
        final ImageView gridTwoPlayerOneIcon = (ImageView) findViewById(R.id.gridTwoPlayerOneIcon);
        final ImageView gridThreePlayerOneIcon = (ImageView) findViewById(R.id.gridThreePlayerOneIcon);
        final ImageView gridFourPlayerOneIcon = (ImageView) findViewById(R.id.gridFourPlayerOneIcon);
        final ImageView gridFivePlayerOneIcon = (ImageView) findViewById(R.id.gridFivePlayerOneIcon);
        final ImageView gridSixPlayerOneIcon = (ImageView) findViewById(R.id.gridSixPlayerOneIcon);
        final ImageView gridSevenPlayerOneIcon = (ImageView) findViewById(R.id.gridSevenPlayerOneIcon);
        final ImageView gridEightPlayerOneIcon = (ImageView) findViewById(R.id.gridEightPlayerOneIcon);
        final ImageView gridNinePlayerOneIcon = (ImageView) findViewById(R.id.gridNinePlayerOneIcon);

        final ImageView gridOnePlayerTwoIcon = (ImageView) findViewById(R.id.gridOnePlayerTwoIcon);
        final ImageView gridTwoPlayerTwoIcon = (ImageView) findViewById(R.id.gridTwoPlayerTwoIcon);
        final ImageView gridThreePlayerTwoIcon = (ImageView) findViewById(R.id.gridThreePlayerTwoIcon);
        final ImageView gridFourPlayerTwoIcon = (ImageView) findViewById(R.id.gridFourPlayerTwoIcon);
        final ImageView gridFivePlayerTwoIcon = (ImageView) findViewById(R.id.gridFivePlayerTwoIcon);
        final ImageView gridSixPlayerTwoIcon = (ImageView) findViewById(R.id.gridSixPlayerTwoIcon);
        final ImageView gridSevenPlayerTwoIcon = (ImageView) findViewById(R.id.gridSevenPlayerTwoIcon);
        final ImageView gridEightPlayerTwoIcon = (ImageView) findViewById(R.id.gridEightPlayerTwoIcon);
        final ImageView gridNinePlayerTwoIcon = (ImageView) findViewById(R.id.gridNinePlayerTwoIcon);

        final ImageView gridOnePlayerOneWin = (ImageView) findViewById(R.id.gridOnePlayerOneWin);
        final ImageView gridTwoPlayerOneWin = (ImageView) findViewById(R.id.gridTwoPlayerOneWin);
        final ImageView gridThreePlayerOneWin = (ImageView) findViewById(R.id.gridThreePlayerOneWin);
        final ImageView gridFourPlayerOneWin = (ImageView) findViewById(R.id.gridFourPlayerOneWin);
        final ImageView gridFivePlayerOneWin = (ImageView) findViewById(R.id.gridFivePlayerOneWin);
        final ImageView gridSixPlayerOneWin = (ImageView) findViewById(R.id.gridSixPlayerOneWin);
        final ImageView gridSevenPlayerOneWin = (ImageView) findViewById(R.id.gridSevenPlayerOneWin);
        final ImageView gridEightPlayerOneWin = (ImageView) findViewById(R.id.gridEightPlayerOneWin);
        final ImageView gridNinePlayerOneWin = (ImageView) findViewById(R.id.gridNinePlayerOneWin);

        final ImageView gridOnePlayerTwoWin = (ImageView) findViewById(R.id.gridOnePlayerTwoWin);
        final ImageView gridTwoPlayerTwoWin = (ImageView) findViewById(R.id.gridTwoPlayerTwoWin);
        final ImageView gridThreePlayerTwoWin = (ImageView) findViewById(R.id.gridThreePlayerTwoWin);
        final ImageView gridFourPlayerTwoWin = (ImageView) findViewById(R.id.gridFourPlayerTwoWin);
        final ImageView gridFivePlayerTwoWin = (ImageView) findViewById(R.id.gridFivePlayerTwoWin);
        final ImageView gridSixPlayerTwoWin = (ImageView) findViewById(R.id.gridSixPlayerTwoWin);
        final ImageView gridSevenPlayerTwoWin = (ImageView) findViewById(R.id.gridSevenPlayerTwoWin);
        final ImageView gridEightPlayerTwoWin = (ImageView) findViewById(R.id.gridEightPlayerTwoWin);
        final ImageView gridNinePlayerTwoWin = (ImageView) findViewById(R.id.gridNinePlayerTwoWin);


        final ImageView usersTurn = (ImageView) findViewById(R.id.usersTurn);
        final TextView usersTurnTitle = (TextView) findViewById(R.id.playerOneName);

        final ImageView computersTurn = (ImageView) findViewById(R.id.computersTurn);
        final TextView computersTurnTitle = (TextView) findViewById(R.id.opponentName);



        gridOne = (ImageView) findViewById(R.id.gridOne);
        gridOne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridOnePlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridOne.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerOneWin.setVisibility(View.VISIBLE);
                        gridTwoPlayerOneWin.setVisibility(View.VISIBLE);
                        gridThreePlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                replayGame();
                                dialog.dismiss();


                            }
                        });

                        displayUsersScore(usersScore);
                    }

                    /**
                     * This is hte code that handles DRAW or TIE
                     */

                    if ((!((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridThreePlayerOneIcon.getVisibility() == View.VISIBLE))&&
                            !((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)) &&
                            !((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE))&&
                            !((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerOneIcon.getVisibility() == View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)))){

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.drawemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.draw);
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                    }
                    //


                    if ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerOneWin.setVisibility(View.VISIBLE);
                        gridFourPlayerOneWin.setVisibility(View.VISIBLE);
                        gridSevenPlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });


                        displayUsersScore(usersScore);
                    }

                    if ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerOneWin.setVisibility(View.VISIBLE);
                        gridFivePlayerOneWin.setVisibility(View.VISIBLE);
                        gridNinePlayerOneWin.setVisibility(View.VISIBLE);

                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                        displayUsersScore(usersScore);
                    }

                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                } else if (clicked_GridCounter == 2) {
                    gridOnePlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridOne.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridTwoPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }

                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridSevenPlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }

                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                }
            }
        });

        gridTwo = (ImageView) findViewById(R.id.gridTwo);
        gridTwo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridTwoPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    gridTwo.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;


                    /**
                     * This is hte code that handles DRAW or TIE
                     */

                    if ((!((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerOneIcon.getVisibility() == View.VISIBLE))&&

                            ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)))){
                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.drawemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.draw);
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                    }

                    if ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerOneWin.setVisibility(View.VISIBLE);
                        gridTwoPlayerOneWin.setVisibility(View.VISIBLE);
                        gridThreePlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayUsersScore(usersScore);
                    }

                    if ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridTwoPlayerOneWin.setVisibility(View.VISIBLE);
                        gridFivePlayerOneWin.setVisibility(View.VISIBLE);
                        gridEightPlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                        displayUsersScore(usersScore);
                    }


                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                } else if (clicked_GridCounter == 2) {
                    gridTwoPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridTwo.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridTwoPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }

                    if ((gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridTwoPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }
                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                }
            }
        });

        gridThree = (ImageView) findViewById(R.id.gridThree);
        gridThree.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridThreePlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    gridThree.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;


                    /**
                     * This is hte code that handles DRAW or TIE
                     */

                    if ((!((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridThreePlayerOneIcon.getVisibility() == View.VISIBLE))&&

                            ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)))){
                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.drawemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.draw);
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                    }


                    if ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerOneWin.setVisibility(View.VISIBLE);
                        gridTwoPlayerOneWin.setVisibility(View.VISIBLE);
                        gridThreePlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayUsersScore(usersScore);
                    }

                    if ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridThreePlayerOneWin.setVisibility(View.VISIBLE);
                        gridSixPlayerOneWin.setVisibility(View.VISIBLE);
                        gridNinePlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayUsersScore(usersScore);
                    }
                    if ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridThreePlayerOneWin.setVisibility(View.VISIBLE);
                        gridFivePlayerOneWin.setVisibility(View.VISIBLE);
                        gridSevenPlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayUsersScore(usersScore);
                    }

                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                } else if (clicked_GridCounter == 2) {
                    gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridThree.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridTwoPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }

                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridSevenPlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }

                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                }
            }

        });

        gridFour = (ImageView) findViewById(R.id.gridFour);
        gridFour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridFourPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    gridFour.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;


                    /**
                     * This is hte code that handles DRAW or TIE
                     */


                    if ((!((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerOneIcon.getVisibility() == View.VISIBLE))&&

                            ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)))){
                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.drawemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.draw);
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                    }



                    if ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridFourPlayerOneWin.setVisibility(View.VISIBLE);
                        gridFivePlayerOneWin.setVisibility(View.VISIBLE);
                        gridSixPlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayUsersScore(usersScore);
                    }

                    if ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerOneWin.setVisibility(View.VISIBLE);
                        gridFourPlayerOneWin.setVisibility(View.VISIBLE);
                        gridSevenPlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayUsersScore(usersScore);
                    }

                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                } else if (clicked_GridCounter == 2) {
                    gridFourPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridFour.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }

                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridSevenPlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }
                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                }
            }
        });

        gridFive = (ImageView) findViewById(R.id.gridFive);
        gridFive.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridFivePlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    gridFive.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    /**
                     * This is hte code that handles DRAW or TIE
                     */

                    if ((!((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridThreePlayerOneIcon.getVisibility() == View.VISIBLE))&&

                            ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)))){
                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.drawemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.draw);
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                    }

                    if ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridFourPlayerOneWin.setVisibility(View.VISIBLE);
                        gridFivePlayerOneWin.setVisibility(View.VISIBLE);
                        gridSixPlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                        displayUsersScore(usersScore);
                    }
                    if ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridTwoPlayerOneWin.setVisibility(View.VISIBLE);
                        gridFivePlayerOneWin.setVisibility(View.VISIBLE);
                        gridEightPlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                        displayUsersScore(usersScore);
                    }
                    if ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerOneWin.setVisibility(View.VISIBLE);
                        gridFivePlayerOneWin.setVisibility(View.VISIBLE);
                        gridNinePlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                        displayUsersScore(usersScore);
                    }
                    if ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridThreePlayerOneWin.setVisibility(View.VISIBLE);
                        gridFivePlayerOneWin.setVisibility(View.VISIBLE);
                        gridSevenPlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayUsersScore(usersScore);
                    }
                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                } else if (clicked_GridCounter == 2) {
                    gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridFive.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }

                    if ((gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridTwoPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridSevenPlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }
                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                }
            }
        });

        gridSix = (ImageView) findViewById(R.id.gridSix);
        gridSix.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridSixPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    gridSix.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    /**
                     * This is hte code that handles DRAW or TIE
                     */

                    if ((!((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerOneIcon.getVisibility() == View.VISIBLE))&&

                            ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)))){
                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.drawemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.draw);
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                    }


                    if ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridFourPlayerOneWin.setVisibility(View.VISIBLE);
                        gridFivePlayerOneWin.setVisibility(View.VISIBLE);
                        gridSixPlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                        displayUsersScore(usersScore);
                    }

                    if ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridThreePlayerOneWin.setVisibility(View.VISIBLE);
                        gridSixPlayerOneWin.setVisibility(View.VISIBLE);
                        gridNinePlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayUsersScore(usersScore);
                    }

                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                } else if (clicked_GridCounter == 2) {
                    gridSixPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridSix.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore++;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }

                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                }
            }
        });

        gridSeven = (ImageView) findViewById(R.id.gridSeven);
        gridSeven.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sum++;

                if (clicked_GridCounter == 1) {
                    gridSevenPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    gridSeven.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    /**
                     * This is hte code that handles DRAW or TIE
                     */

                    if ((!((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerOneIcon.getVisibility() == View.VISIBLE))&&

                            ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)))){
                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.drawemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.draw);
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                    }

                    if ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridSevenPlayerOneWin.setVisibility(View.VISIBLE);
                        gridEightPlayerOneWin.setVisibility(View.VISIBLE);
                        gridNinePlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                        displayUsersScore(usersScore);
                    }
                    if ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerOneWin.setVisibility(View.VISIBLE);
                        gridFourPlayerOneWin.setVisibility(View.VISIBLE);
                        gridSevenPlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayUsersScore(usersScore);
                    }
                    if ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridThreePlayerOneWin.setVisibility(View.VISIBLE);
                        gridFivePlayerOneWin.setVisibility(View.VISIBLE);
                        gridSevenPlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayUsersScore(usersScore);
                    }

                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                } else if (clicked_GridCounter == 2) {
                    gridSevenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridSeven.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridSevenPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridSevenPlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore++;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridSevenPlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }

                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                }
            }
        });

        gridEight = (ImageView) findViewById(R.id.gridEight);
        gridEight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridEightPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    gridEight.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    /**
                     * This is hte code that handles DRAW or TIE
                     */

                    if ((!((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerOneIcon.getVisibility() == View.VISIBLE))&&

                            ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)))){
                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.drawemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.draw);
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                    }


                    if ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridSevenPlayerOneWin.setVisibility(View.VISIBLE);
                        gridEightPlayerOneWin.setVisibility(View.VISIBLE);
                        gridNinePlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                        displayUsersScore(usersScore);
                    }
                    if ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridTwoPlayerOneWin.setVisibility(View.VISIBLE);
                        gridFivePlayerOneWin.setVisibility(View.VISIBLE);
                        gridEightPlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayUsersScore(usersScore);
                    }

                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                } else if (clicked_GridCounter == 2) {
                    gridEightPlayerTwoIcon.setVisibility(View.VISIBLE);
                    gridEight.setEnabled(false);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridSevenPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }
                    if ((gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridTwoPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }

                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                }
            }
        });

        gridNine = (ImageView) findViewById(R.id.gridNine);
        gridNine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridNinePlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    gridNine.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    /**
                     * This is hte code that handles DRAW or TIE
                     */

                    if ((!((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE))&&

                            ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE)))){
                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.drawemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.draw);
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                    }

                    if ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridSevenPlayerOneWin.setVisibility(View.VISIBLE);
                        gridEightPlayerOneWin.setVisibility(View.VISIBLE);
                        gridNinePlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                        displayUsersScore(usersScore);
                    }
                    if ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridThreePlayerOneWin.setVisibility(View.VISIBLE);
                        gridSixPlayerOneWin.setVisibility(View.VISIBLE);
                        gridNinePlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });
                        displayUsersScore(usersScore);
                    }
                    if ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerOneWin.setVisibility(View.VISIBLE);
                        gridFivePlayerOneWin.setVisibility(View.VISIBLE);
                        gridNinePlayerOneWin.setVisibility(View.VISIBLE);
                        usersScore = usersScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerOneNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayUsersScore(usersScore);
                    }

                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                } else if (clicked_GridCounter == 2) {
                    gridNinePlayerTwoIcon.setVisibility(View.VISIBLE);

                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridNine.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridSevenPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore++;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore++;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridOnePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        computerScore = computerScore + 1;

                        // alert dialog box that displays winner or loser
                        final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                        dialog.setTitle(R.string.gameOver);
                        dialog.setContentView(R.layout.activity_custom);

                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                        dialogWindow.setGravity(Gravity.CENTER);

                        lp.width = 500;
                        lp.height = 500;

                        dialogWindow.setAttributes(lp);

                        // set the custom dialog components - text , image and button
                        ImageView imageView = (ImageView) dialog.findViewById(R.id.congratsEmoji);
                        imageView.setImageResource(R.drawable.congratsemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(playerTwoNm +" Wins!");
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);

                        Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                        // if button is clicked, close the custom dialog and reset the game board

                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                replayGame();
                                dialog.dismiss();
                            }
                        });

                        displayComputerScore(computerScore);
                    }
                    if (sum == 9) {
                        clicked_GridCounter = 0;
                    }
                }

            }
        });


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

    public void addListenerOnHelpButton() {
        helpBtn = (ImageButton) findViewById(R.id.about_btn);
        helpBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // alert dialog box that displays winner or loser
                final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                dialog.setTitle(R.string.gameOver);
                dialog.setContentView(R.layout.activity_help);

                Window dialogWindow = dialog.getWindow();
                WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                dialogWindow.setGravity(Gravity.CENTER);

                lp.width = 500;
                lp.height = 600;

                dialogWindow.setAttributes(lp);

                // set the custom dialog components - text , image and button

                TextView aboutApp = (TextView) dialog.findViewById(R.id.helpView);
                aboutApp.setText(R.string.help_information);
                dialog.show();

                Button dialogButton = (Button) dialog.findViewById(R.id.buttonShowCustomDialog);

                // if button is clicked, close the custom dialog and reset the game board

                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });

    }

    public void addListenerOnOptionsButton() {
        optionsBtn = (ImageButton) findViewById(R.id.options_btn);
        optionsBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(TwoPlayers.this, Options.class);
                startActivity(i);
            }
        });

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayComputerScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.playerTwoScore);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Displays the given score for Team A.
     */
    public void displayUsersScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.playerOneScore);
        scoreView.setText(String.valueOf(score));
    }


    public void addListenerOnNewGameButton() {
        newGameBtn = (ImageButton) findViewById(R.id.newGame_btn);
        newGameBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                replayGame();

                usersScore = 0;
                displayUsersScore(usersScore);
                computerScore = 0;
                displayComputerScore(computerScore);

            }
        });

    }

    public void replayGame(){
        findViewById(R.id.gridOnePlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwoPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridThreePlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridFourPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridFivePlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridSixPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridSevenPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridEightPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridNinePlayerOneIcon).setVisibility(View.INVISIBLE);

        findViewById(R.id.gridOnePlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwoPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridThreePlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridFourPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridFivePlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridSixPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridSevenPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridEightPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridNinePlayerTwoIcon).setVisibility(View.INVISIBLE);


        findViewById(R.id.gridOnePlayerOneWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwoPlayerOneWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridThreePlayerOneWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridFourPlayerOneWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridFivePlayerOneWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridSixPlayerOneWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridSevenPlayerOneWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridEightPlayerOneWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridNinePlayerOneWin).setVisibility(View.INVISIBLE);

        findViewById(R.id.gridOnePlayerTwoWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwoPlayerTwoWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridThreePlayerTwoWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridFourPlayerTwoWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridFivePlayerTwoWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridSixPlayerTwoWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridSevenPlayerTwoWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridEightPlayerTwoWin).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridNinePlayerTwoWin).setVisibility(View.INVISIBLE);
        ImageView computersTurn = (ImageView) findViewById(R.id.computersTurn);
        computersTurn.setImageResource(R.drawable.playertwo_symbol);
        TextView computersTurnTitle = (TextView) findViewById(R.id.opponentName);
        computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

        ImageView usersTurn = (ImageView) findViewById(R.id.usersTurn);
        usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
        TextView usersTurnTitle = (TextView) findViewById(R.id.playerOneName);
        usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

        clicked_GridCounter = 1;
        sum = 0;

        gridOne.setEnabled(true);
        gridTwo.setEnabled(true);
        gridThree.setEnabled(true);
        gridFour.setEnabled(true);
        gridFive.setEnabled(true);
        gridSix.setEnabled(true);
        gridSeven.setEnabled(true);
        gridEight.setEnabled(true);
        gridNine.setEnabled(true);
    }


}
