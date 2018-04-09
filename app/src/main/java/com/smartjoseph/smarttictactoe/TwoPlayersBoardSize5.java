package com.smartjoseph.smarttictactoe;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class TwoPlayersBoardSize5 extends AppCompatActivity {

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
    Integer sum = 0;
    int playerOneScores = 0;
    int playerTwoScores = 0;

    //this grid refers to the game board and it is counted horizontally from left to right.
    ImageView gridOne, gridTwo, gridThree, gridFour, gridFive, gridSix, gridSeven, gridEight, gridNine, gridTen ;
    ImageView gridEleven, gridTwelve, gridThirteen, gridFourteen, gridFifteen, gridSixteen, gridSeventeen, gridEighteen;
    ImageView gridNineteen, gridTwenty, gridTwentyOne, gridTwentyTwo, gridTwentyThree, gridTwentyFour, gridTwentyFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_players_board_size5);

        // Get the Intent that started this activity and extract the string
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
        gridOne = (ImageView) findViewById(R.id.gridOne);
        gridTwo = (ImageView) findViewById(R.id.gridTwo);
        gridThree = (ImageView) findViewById(R.id.gridThree);
        gridFour = (ImageView) findViewById(R.id.gridFour);
        gridFive = (ImageView) findViewById(R.id.gridFive);
        gridSix = (ImageView) findViewById(R.id.gridSix);
        gridSeven = (ImageView) findViewById(R.id.gridSeven);
        gridEight = (ImageView) findViewById(R.id.gridEight);
        gridNine = (ImageView) findViewById(R.id.gridNine);
        gridTen = (ImageView) findViewById(R.id.gridTen);
        gridEleven = (ImageView) findViewById(R.id.gridEleven);
        gridTwelve = (ImageView) findViewById(R.id.gridTwelve);
        gridThirteen = (ImageView) findViewById(R.id.gridThirteen);
        gridFourteen = (ImageView) findViewById(R.id.gridFourteen);
        gridFifteen = (ImageView) findViewById(R.id.gridFifteen);
        gridSixteen = (ImageView) findViewById(R.id.gridSixteen);
        gridSeventeen = (ImageView) findViewById(R.id.gridSeventeen);
        gridEighteen = (ImageView) findViewById(R.id.gridEighteen);
        gridNineteen = (ImageView) findViewById(R.id.gridNineteen);
        gridTwenty = (ImageView) findViewById(R.id.gridTwenty);
        gridTwentyOne = (ImageView) findViewById(R.id.gridTwentyOne);
        gridTwentyTwo = (ImageView) findViewById(R.id.gridTwentyTwo);
        gridTwentyThree = (ImageView) findViewById(R.id.gridTwentyThree);
        gridTwentyFour = (ImageView) findViewById(R.id.gridTwentyFour);
        gridTwentyFive = (ImageView) findViewById(R.id.gridTwentyFive);


        final ImageView gridOnePlayerOneIcon = (ImageView) findViewById(R.id.gridOnePlayerOneIcon);
        final ImageView gridTwoPlayerOneIcon = (ImageView) findViewById(R.id.gridTwoPlayerOneIcon);
        final ImageView gridThreePlayerOneIcon = (ImageView) findViewById(R.id.gridThreePlayerOneIcon);
        final ImageView gridFourPlayerOneIcon = (ImageView) findViewById(R.id.gridFourPlayerOneIcon);
        final ImageView gridFivePlayerOneIcon = (ImageView) findViewById(R.id.gridFivePlayerOneIcon);
        final ImageView gridSixPlayerOneIcon = (ImageView) findViewById(R.id.gridSixPlayerOneIcon);
        final ImageView gridSevenPlayerOneIcon = (ImageView) findViewById(R.id.gridSevenPlayerOneIcon);
        final ImageView gridEightPlayerOneIcon = (ImageView) findViewById(R.id.gridEightPlayerOneIcon);
        final ImageView gridNinePlayerOneIcon = (ImageView) findViewById(R.id.gridNinePlayerOneIcon);
        final ImageView gridTenPlayerOneIcon = (ImageView) findViewById(R.id.gridTenPlayerOneIcon);
        final ImageView gridElevenPlayerOneIcon = (ImageView) findViewById(R.id.gridElevenPlayerOneIcon);
        final ImageView gridTwelvePlayerOneIcon = (ImageView) findViewById(R.id.gridTwelvePlayerOneIcon);
        final ImageView gridThirteenPlayerOneIcon = (ImageView) findViewById(R.id.gridThirteenPlayerOneIcon);
        final ImageView gridFourteenPlayerOneIcon = (ImageView) findViewById(R.id.gridFourteenPlayerOneIcon);
        final ImageView gridFifteenPlayerOneIcon = (ImageView) findViewById(R.id.gridFifteenPlayerOneIcon);
        final ImageView gridSixteenPlayerOneIcon = (ImageView) findViewById(R.id.gridSixteenPlayerOneIcon);
        final ImageView gridSeventeenPlayerOneIcon = (ImageView) findViewById(R.id.gridSeventeenPlayerOneIcon);
        final ImageView gridEighteenPlayerOneIcon = (ImageView) findViewById(R.id.gridEighteenPlayerOneIcon);
        final ImageView gridNineteenPlayerOneIcon = (ImageView) findViewById(R.id.gridNineteenPlayerOneIcon);
        final ImageView gridTwentyPlayerOneIcon = (ImageView) findViewById(R.id.gridTwentyPlayerOneIcon);
        final ImageView gridTwentyOnePlayerOneIcon = (ImageView) findViewById(R.id.gridTwentyOnePlayerOneIcon);
        final ImageView gridTwentyTwoPlayerOneIcon = (ImageView) findViewById(R.id.gridTwentyTwoPlayerOneIcon);
        final ImageView gridTwentyThreePlayerOneIcon = (ImageView) findViewById(R.id.gridTwentyThreePlayerOneIcon);
        final ImageView gridTwentyFourPlayerOneIcon = (ImageView) findViewById(R.id.gridTwentyFourPlayerOneIcon);
        final ImageView gridTwentyFivePlayerOneIcon = (ImageView) findViewById(R.id.gridTwentyFivePlayerOneIcon);

        final ImageView gridOnePlayerTwoIcon = (ImageView) findViewById(R.id.gridOnePlayerTwoIcon);
        final ImageView gridTwoPlayerTwoIcon = (ImageView) findViewById(R.id.gridTwoPlayerTwoIcon);
        final ImageView gridThreePlayerTwoIcon = (ImageView) findViewById(R.id.gridThreePlayerTwoIcon);
        final ImageView gridFourPlayerTwoIcon = (ImageView) findViewById(R.id.gridFourPlayerTwoIcon);
        final ImageView gridFivePlayerTwoIcon = (ImageView) findViewById(R.id.gridFivePlayerTwoIcon);
        final ImageView gridSixPlayerTwoIcon = (ImageView) findViewById(R.id.gridSixPlayerTwoIcon);
        final ImageView gridSevenPlayerTwoIcon = (ImageView) findViewById(R.id.gridSevenPlayerTwoIcon);
        final ImageView gridEightPlayerTwoIcon = (ImageView) findViewById(R.id.gridEightPlayerTwoIcon);
        final ImageView gridNinePlayerTwoIcon = (ImageView) findViewById(R.id.gridNinePlayerTwoIcon);
        final ImageView gridTenPlayerTwoIcon = (ImageView) findViewById(R.id.gridTenPlayerTwoIcon);
        final ImageView gridElevenPlayerTwoIcon = (ImageView) findViewById(R.id.gridElevenPlayerTwoIcon);
        final ImageView gridTwelvePlayerTwoIcon = (ImageView) findViewById(R.id.gridTwelvePlayerTwoIcon);
        final ImageView gridThirteenPlayerTwoIcon = (ImageView) findViewById(R.id.gridThirteenPlayerTwoIcon);
        final ImageView gridFourteenPlayerTwoIcon = (ImageView) findViewById(R.id.gridFourteenPlayerTwoIcon);
        final ImageView gridFifteenPlayerTwoIcon = (ImageView) findViewById(R.id.gridFifteenPlayerTwoIcon);
        final ImageView gridSixteenPlayerTwoIcon = (ImageView) findViewById(R.id.gridSixteenPlayerTwoIcon);
        final ImageView gridSeventeenPlayerTwoIcon = (ImageView) findViewById(R.id.gridSeventeenPlayerTwoIcon);
        final ImageView gridEighteenPlayerTwoIcon = (ImageView) findViewById(R.id.gridEighteenPlayerTwoIcon);
        final ImageView gridNineteenPlayerTwoIcon = (ImageView) findViewById(R.id.gridNineteenPlayerTwoIcon);
        final ImageView gridTwentyPlayerTwoIcon = (ImageView) findViewById(R.id.gridTwentyPlayerTwoIcon);
        final ImageView gridTwentyOnePlayerTwoIcon = (ImageView) findViewById(R.id.gridTwentyOnePlayerTwoIcon);
        final ImageView gridTwentyTwoPlayerTwoIcon = (ImageView) findViewById(R.id.gridTwentyTwoPlayerTwoIcon);
        final ImageView gridTwentyThreePlayerTwoIcon = (ImageView) findViewById(R.id.gridTwentyThreePlayerTwoIcon);
        final ImageView gridTwentyFourPlayerTwoIcon = (ImageView) findViewById(R.id.gridTwentyFourPlayerTwoIcon);
        final ImageView gridTwentyFivePlayerTwoIcon = (ImageView) findViewById(R.id.gridTwentyFivePlayerTwoIcon);



        final ImageView usersTurn = (ImageView) findViewById(R.id.usersTurn);
        final TextView usersTurnTitle = (TextView) findViewById(R.id.playerOneName);

        final ImageView computersTurn = (ImageView) findViewById(R.id.computersTurn);
        final TextView computersTurnTitle = (TextView) findViewById(R.id.opponentName);

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

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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


                    if ((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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

                        displayPlayerOneScore(playerOneScores);
                    }

                    if ((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                    if ((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridOnePlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridOne.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);

                    }
                    if ((gridOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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

                        displayPlayerTwoScore(playerTwoScores);

                    }
                    if ((gridOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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

                    }
                    displayPlayerTwoScore(playerTwoScores);
                }
            }
        });

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


                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridTwoPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridTwo.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

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


                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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


                    if ((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                    if ((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridThree.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }

                    if ((gridThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

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

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridFourPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridFour.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridNinePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

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

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                    if ((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridFive.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }

                    if ((gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

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

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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


                    if ((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridSixPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridSix.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridSixPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridEightPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTenPlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

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

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                    if ((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridSevenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridSeven.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }

                    if ((gridSixPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridEightPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTenPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

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

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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


                    if ((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridEightPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridEight.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridSixPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridEightPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTenPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

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

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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


                    if ((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridNinePlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridNine.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridNinePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridSixPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridEightPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTenPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridTenPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridTen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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


                    if ((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridTenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridTen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridSixPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridEightPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTenPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridEleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridElevenPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridEleven.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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


                    if ((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                    if ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridElevenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridEleven.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }

                    if ((gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridTwelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridTwelvePlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridTwelve.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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


                    if ((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridTwelvePlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridTwelve.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridThirteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridThirteenPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridThirteen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores =  playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridThirteenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridThirteen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridFourteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridFourteenPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridFourteen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridFourteenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridFourteen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridNinePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridFifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridFifteenPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridFifteen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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


                    if ((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)){

                        playerOneScores = playerOneScores + 1;

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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridFifteenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridFifteen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridSixteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridSixteenPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridSixteen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridSixteenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridSixteen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridSeventeen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridSeventeenPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridSeventeen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridSeventeenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridSeventeen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridEighteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridEighteenPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridEighteen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridEighteenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridEighteen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridNineteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridNineteenPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridNineteen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridNineteenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridNineteen.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridNinePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridTwenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridTwentyPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridTwenty.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
//                        displayUsersScore(usersScore);
                    }
                    if ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridTwentyPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridTwenty.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridTwentyOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridTwentyOnePlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridTwentyOne.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridTwentyOnePlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridTwentyOne.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridTwentyTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridTwentyTwoPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridTwentyTwo.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridTwentyTwoPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridTwentyTwo.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridTwentyThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;

                if (clicked_GridCounter == 1) {
                    gridTwentyThreePlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridTwentyThree.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }


                }else if (clicked_GridCounter == 2){
                    gridTwentyThreePlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridTwentyThree.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;

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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridTwentyFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridTwentyFourPlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridTwentyFour.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridTwentyFourPlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridTwentyFour.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridNinePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                }
            }
        });

        gridTwentyFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum++;
                if (clicked_GridCounter == 1) {
                    gridTwentyFivePlayerOneIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_winning_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    usersTurn.setImageResource(R.drawable.playerone_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));
                    gridTwentyFive.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter + 1;

                    if ((!((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEightPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNinePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            !((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                                    (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE))&&

                            ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE)||(gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridTenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridTenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridElevenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridElevenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwelvePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwelvePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFourteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridFourteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridFifteenPlayerOneIcon.getVisibility() == View.VISIBLE)||(gridFifteenPlayerTwoIcon.getVisibility() == View.VISIBLE))&&
                            ((gridSixteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSixteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridSeventeenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridSeventeenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridEighteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridEighteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE))&&
                            ((gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)||(gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)))){

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

                    if ((gridFivePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }
                    if ((gridTwentyOnePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerOneIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerOneIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerOneIcon.getVisibility()==View.VISIBLE)){
                        playerOneScores = playerOneScores + 1;
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
                        displayPlayerOneScore(playerOneScores);
                    }

                }else if (clicked_GridCounter == 2){
                    gridTwentyFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                    computersTurn.setImageResource(R.drawable.playertwo_symbol);
                    computersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

                    usersTurn.setImageResource(R.drawable.playerone_winning_symbol);
                    usersTurnTitle.setTextColor(getResources().getColor(R.color.colorYellow));

                    gridTwentyFive.setEnabled(false);
                    clicked_GridCounter = clicked_GridCounter - 1;

                    if ((gridFivePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridFifteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){

                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
                    }
                    if ((gridOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridSevenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridThirteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridNineteenPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerOneScore(playerTwoScores);
                    }
                    if ((gridTwentyOnePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyTwoPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyThreePlayerTwoIcon.getVisibility()==View.VISIBLE)&&(gridTwentyFourPlayerTwoIcon.getVisibility()==View.VISIBLE)&&
                            (gridTwentyFivePlayerTwoIcon.getVisibility()==View.VISIBLE)){
                        playerTwoScores = playerTwoScores + 1;
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
                        displayPlayerTwoScore(playerTwoScores);
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
                Intent i = new Intent(TwoPlayersBoardSize5.this, Menu.class);
                startActivity(i);
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
                Intent i = new Intent(TwoPlayersBoardSize5.this, Options.class);
                startActivity(i);
            }
        });

    }

    /**
     * Displays the given score for Player Two.
     */
    public void displayPlayerTwoScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.playerTwoScore);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Displays the given score for player One.
     */
    public void displayPlayerOneScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.playerOneScore);
        scoreView.setText(String.valueOf(score));
    }


    public void addListenerOnNewGameButton() {
        newGameBtn = (ImageButton) findViewById(R.id.newGame_btn);
        newGameBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                replayGame();
//                usersScore = 0;
//                displayUsersScore(usersScore);
//                computerScore = 0;
//                displayComputerScore(computerScore);

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
        findViewById(R.id.gridTenPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridElevenPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwelvePlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridThirteenPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridFourteenPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridFifteenPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridSixteenPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridSeventeenPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridEighteenPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridNineteenPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwentyPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwentyOnePlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwentyTwoPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwentyThreePlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwentyFourPlayerOneIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwentyFivePlayerOneIcon).setVisibility(View.INVISIBLE);

        findViewById(R.id.gridOnePlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwoPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridThreePlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridFourPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridFivePlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridSixPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridSevenPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridEightPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridNinePlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTenPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridElevenPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwelvePlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridThirteenPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridFourteenPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridFifteenPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridSixteenPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridSeventeenPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridEighteenPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridNineteenPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwentyPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwentyOnePlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwentyTwoPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwentyThreePlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwentyFourPlayerTwoIcon).setVisibility(View.INVISIBLE);
        findViewById(R.id.gridTwentyFivePlayerTwoIcon).setVisibility(View.INVISIBLE);


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
        gridTen.setEnabled(true);
        gridEleven.setEnabled(true);
        gridTwelve.setEnabled(true);
        gridThirteen.setEnabled(true);
        gridFourteen.setEnabled(true);
        gridFifteen.setEnabled(true);
        gridSixteen.setEnabled(true);
        gridSeventeen.setEnabled(true);
        gridEighteen.setEnabled(true);
        gridNineteen.setEnabled(true);
        gridTwenty.setEnabled(true);
        gridTwentyOne.setEnabled(true);
        gridTwentyTwo.setEnabled(true);
        gridTwentyThree.setEnabled(true);
        gridTwentyFour.setEnabled(true);
        gridTwentyFive.setEnabled(true);

    }

}