package com.smartjoseph.smarttictactoe;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.smartjoseph.smarttictactoe.R.id.computersTurn;
import static com.smartjoseph.smarttictactoe.R.id.gridEightPlayerOneIcon;
import static com.smartjoseph.smarttictactoe.R.id.gridFourPlayerOneIcon;
import static com.smartjoseph.smarttictactoe.R.id.gridFourPlayerTwoIcon;
import static com.smartjoseph.smarttictactoe.R.id.gridNinePlayerOneIcon;
import static com.smartjoseph.smarttictactoe.R.id.gridNinePlayerTwoIcon;
import static com.smartjoseph.smarttictactoe.R.id.gridOne;
import static com.smartjoseph.smarttictactoe.R.id.gridOnePlayerOneIcon;
import static com.smartjoseph.smarttictactoe.R.id.gridSevenPlayerOneIcon;
import static com.smartjoseph.smarttictactoe.R.id.gridThreePlayerOneIcon;
import static com.smartjoseph.smarttictactoe.R.id.gridThreePlayerTwoIcon;
import static com.smartjoseph.smarttictactoe.R.id.gridTwoPlayerOneIcon;
import static com.smartjoseph.smarttictactoe.R.id.usersTurn;

public class SinglePlayer extends AppCompatActivity {

    final Context context = this;
    ImageButton newGameBtn;
    ImageButton backBtn;
    ImageButton optionsBtn;
    ImageButton helpBtn;

    /**
     * The variable clicked_GridCounter keeps track of the number
     * of times the grid has been clicked.
     * It's been set to '1' because i want player one to start the game by default.
     */
    Integer clicked_GridCounter = 1, swap = 1;
    Integer sum = 0, usersScore = 0, computerScore = 0;

    //this grid refers to the game board and it is counted horizontally from left to right.
    ImageView gridOne, gridTwo, gridThree, gridFour, gridFive, gridSix, gridSeven, gridEight, gridNine;
    TextView playerOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        // Get the Intent that started this activity and extract the string
        playerOne = (TextView) findViewById(R.id.playerOneName);
        Intent playerOneIntent = getIntent();
        final String usersAnswer_playerOne = playerOneIntent.getStringExtra("playerOnesName");
        playerOne.setText(usersAnswer_playerOne);

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

        gridOne = (ImageView) findViewById(R.id.gridOne);
        gridOne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gridOnePlayerOneIcon.setVisibility(View.VISIBLE);
                gridOne.setEnabled(false);
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
                    text.setText(R.string.you_win);
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
                } if ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE)) {
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
                    text.setText(R.string.you_win);
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
                    text.setText(R.string.you_win);
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
                 * This is the code that handles DRAW or TIE
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




                if ((findViewById(R.id.gridFivePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFivePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFive();

                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridNinePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridNinePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridNinePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridNine();

                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridSixPlayerTwoIcon.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridThreePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridThreePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridThree();

                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }else if ((findViewById(R.id.gridSevenPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSevenPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSevenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSeven();

                    if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridEightPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridEightPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridEightPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridEight();

                    if ((gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridFourPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFourPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFourPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFour();

                    if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridSixPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSixPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSixPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSix();

                    if ((gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridTwoPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridTwoPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridTwoPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridTwo();

                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }

            }
        });


        gridTwo = (ImageView) findViewById(R.id.gridTwo);
        gridTwo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gridTwoPlayerOneIcon.setVisibility(View.VISIBLE);
                gridTwo.setEnabled(false);

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
                    text.setText(R.string.you_win);
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
                    text.setText(R.string.you_win);
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
                }if (sum == 9) {
                    clicked_GridCounter = 0;
                }


                if ((findViewById(R.id.gridFivePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFivePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFive();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridNinePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridNinePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridNinePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridNine();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridThreePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridThreePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridThree();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }else if ((findViewById(R.id.gridSevenPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSevenPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSevenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSeven();
                    if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridEightPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridEightPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridEightPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridEight();
                    if ((gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridFourPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFourPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFourPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFour();
                    if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridSixPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSixPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSixPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSix();
                    if ((gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }

            }
        });



        gridThree = (ImageView) findViewById(R.id.gridThree);
        gridThree.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gridThreePlayerOneIcon.setVisibility(View.VISIBLE);
                gridThree.setEnabled(false);
                /**
                 * This is hte code that handles DRAW or TIE
                 */

                if ((!((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerOneIcon.getVisibility() == View.VISIBLE) && (gridThreePlayerOneIcon.getVisibility() == View.VISIBLE)) &&

                        ((gridOnePlayerOneIcon.getVisibility() == View.VISIBLE) || (gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE)) &&
                        ((gridTwoPlayerOneIcon.getVisibility() == View.VISIBLE) || (gridTwoPlayerTwoIcon.getVisibility() == View.VISIBLE)) &&
                        ((gridFourPlayerOneIcon.getVisibility() == View.VISIBLE) || (gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE)) &&
                        ((gridFivePlayerOneIcon.getVisibility() == View.VISIBLE) || (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE)) &&
                        ((gridSixPlayerOneIcon.getVisibility() == View.VISIBLE) || (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) &&
                        ((gridSevenPlayerOneIcon.getVisibility() == View.VISIBLE) || (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) &&
                        ((gridEightPlayerOneIcon.getVisibility() == View.VISIBLE) || (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE)) &&
                        ((gridNinePlayerOneIcon.getVisibility() == View.VISIBLE) || (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)))) {
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
                    text.setText(R.string.you_win);
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
                    text.setText(R.string.you_win);
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
                    text.setText(R.string.you_win);
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


                if ((findViewById(R.id.gridFivePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFivePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFive();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridNinePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridNinePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridNinePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridNine();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }else if ((findViewById(R.id.gridSevenPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSevenPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSevenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSeven();
                    if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridEightPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridEightPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridEightPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridEight();
                    if ((gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridFourPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFourPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFourPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFour();
                    if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridSixPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSixPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSixPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSix();
                    if ((gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridTwoPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridTwoPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridTwoPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridTwo();
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }

            }
        });

        gridFour = (ImageView) findViewById(R.id.gridFour);
        gridFour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gridFourPlayerOneIcon.setVisibility(View.VISIBLE);
                gridFour.setEnabled(false);


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
                    text.setText(R.string.you_win);
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
                    text.setText(R.string.you_win);
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


                if ((findViewById(R.id.gridFivePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFivePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFive();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridNinePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridNinePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridNinePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridNine();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridThreePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridThreePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridThree();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }else if ((findViewById(R.id.gridSevenPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSevenPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSevenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSeven();
                    if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridEightPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridEightPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridEightPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridEight();

                    if ((gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }else if ((findViewById(R.id.gridSixPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSixPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSixPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSix();
                    if ((gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridTwoPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridTwoPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridTwoPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridTwo();
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }

            }
        });

        gridFive = (ImageView) findViewById(R.id.gridFive);
        gridFive.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gridFivePlayerOneIcon.setVisibility(View.VISIBLE);
                gridFive.setEnabled(false);

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
                    text.setText(R.string.you_win);
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
                    text.setText(R.string.you_win);
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
                    text.setText(R.string.you_win);
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
                    text.setText(R.string.you_win);
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

                if ((findViewById(R.id.gridOnePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridOnePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridOnePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridOne();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridNinePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridNinePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridNinePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridNine();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }else if ((findViewById(R.id.gridThreePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridThreePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridThree();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }else if ((findViewById(R.id.gridSevenPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSevenPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSevenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSeven();
                    if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridEightPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridEightPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridEightPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridEight();
                    if ((gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridFourPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFourPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFourPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFour();
                    if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridSixPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSixPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSixPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSix();
                    if ((gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridTwoPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridTwoPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridTwoPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridTwo();
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }

            }
        });

        gridSix = (ImageView) findViewById(R.id.gridSix);
        gridSix.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gridSixPlayerOneIcon.setVisibility(View.VISIBLE);
                gridSix.setEnabled(false);

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
                    text.setText(R.string.you_win);
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
                    text.setText(R.string.you_win);
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

                if ((findViewById(R.id.gridOnePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridOnePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridOnePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridOne();

                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridNinePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridNinePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridNinePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridNine();

                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }else if ((findViewById(R.id.gridThreePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridThreePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridThree();

                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }else if ((findViewById(R.id.gridSevenPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSevenPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSevenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSeven();

                    if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridEightPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridEightPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridEightPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridEight();

                    if ((gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridFourPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFourPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFourPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFour();

                    if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridFivePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFivePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFive();

                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }else if ((findViewById(R.id.gridTwoPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridTwoPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridTwoPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridTwo();

                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }

            }
        });


        gridSeven = (ImageView) findViewById(R.id.gridSeven);
        gridSeven.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gridSevenPlayerOneIcon.setVisibility(View.VISIBLE);
                gridSeven.setEnabled(false);

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
                    text.setText(R.string.you_win);
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
                    text.setText(R.string.you_win);
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
                    text.setText(R.string.you_win);
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

                if ((findViewById(R.id.gridOnePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridOnePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridOnePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridOne();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridNinePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridNinePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridNinePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridNine();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }else if ((findViewById(R.id.gridThreePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridThreePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridThree();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }else if ((findViewById(R.id.gridFivePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFivePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFive();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridEightPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridEightPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridEightPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridEight();

                    if ((gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridFourPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFourPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFourPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFour();

                    if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridSixPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSixPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSixPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSix();

                    if ((gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridTwoPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridTwoPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridTwoPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridTwo();

                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }

            }
        });

        gridEight = (ImageView) findViewById(R.id.gridEight);
        gridEight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gridEightPlayerOneIcon.setVisibility(View.VISIBLE);
                gridEight.setEnabled(false);

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
                    text.setText(R.string.you_win);
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
                    text.setText(R.string.you_win);
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

                if ((findViewById(R.id.gridOnePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridOnePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridOnePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridOne();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridNinePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridNinePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridNinePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridNine();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridThreePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridThreePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridThree();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }else if ((findViewById(R.id.gridSevenPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSevenPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSevenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSeven();
                    if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridFivePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFivePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFive();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridFourPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFourPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFourPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFour();

                    if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridSixPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSixPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSixPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSix();
                    if ((gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridTwoPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridTwoPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridTwoPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridTwo();
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }

            }
        });

        gridNine = (ImageView) findViewById(R.id.gridNine);
        gridNine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gridNinePlayerOneIcon.setVisibility(View.VISIBLE);
                gridNine.setEnabled(false);

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
                    text.setText(R.string.you_win);
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
                    text.setText(R.string.you_win);
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
                    text.setText(R.string.you_win);
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

                if ((findViewById(R.id.gridOnePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridOnePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridOnePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridOne();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoIcon.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridFivePlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFivePlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFivePlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFive();
                    if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }else if ((findViewById(R.id.gridSevenPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSevenPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSevenPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSeven();
                    if ((gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                    }if ((gridThreePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridEightPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridEightPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridEightPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridEight();
                    if ((gridEightPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridNinePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSevenPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridEightPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridNinePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridFourPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridFourPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridFourPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridFour();
                    if ((gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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

                }else if ((findViewById(R.id.gridSixPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridSixPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridSixPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridSix();
                    if ((gridSixPlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFivePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridFourPlayerTwoIcon.getVisibility() == View.VISIBLE)) {
                        gridFivePlayerTwoWin.setVisibility(View.VISIBLE);
                        gridFourPlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        gridSixPlayerTwoWin.setVisibility(View.VISIBLE);
                        gridThreePlayerTwoWin.setVisibility(View.VISIBLE);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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


                }else if ((findViewById(R.id.gridTwoPlayerOneIcon).getVisibility() == View.INVISIBLE) &&
                        (findViewById(R.id.gridTwoPlayerTwoIcon).getVisibility() == View.INVISIBLE)) {
                    gridTwoPlayerTwoIcon.setVisibility(View.VISIBLE);
                    disableGridTwo();
                    if ((gridOnePlayerTwoIcon.getVisibility() == View.VISIBLE) && (gridTwoPlayerTwoWin.getVisibility() == View.VISIBLE) && (gridThreePlayerTwoWin.getVisibility() == View.VISIBLE)) {
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                        imageView.setImageResource(R.drawable.loseemoji);
                        TextView text = (TextView) dialog.findViewById(R.id.YouWin);
                        text.setText(R.string.you_lose);
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
                }
            }
        });
    }


    public void disableGridOne(){
        gridOne.setEnabled(false);
    }
    public void disableGridTwo(){
        gridTwo.setEnabled(false);
    }
    public void disableGridThree(){
        gridThree.setEnabled(false);
    }
    public void disableGridFour(){
        gridFour.setEnabled(false);
    }
    public void disableGridFive(){
        gridFive.setEnabled(false);
    }
    public void disableGridSix(){
        gridSix.setEnabled(false);
    }
    public void disableGridSeven(){
        gridSeven.setEnabled(false);
    }
    public void disableGridEight(){
        gridEight.setEnabled(false);
    }
    public void disableGridNine(){
        gridNine.setEnabled(false);
    }


    public void addListenerOnBackButton() {
        backBtn = (ImageButton) findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(SinglePlayer.this, Menu.class);
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
                Intent i = new Intent(SinglePlayer.this, Options.class);
                startActivity(i);
            }
        });

    }

    /**
     * Displays the bot's score.
     */
    public void displayComputerScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.computerScore);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Displays the user's score.
     */
    public void displayUsersScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.yourScore);
        scoreView.setText(String.valueOf(score));
    }


    public void addListenerOnNewGameButton() {
        newGameBtn = (ImageButton) findViewById(R.id.newGame_btn);
        newGameBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                findViewById(gridOnePlayerOneIcon).setVisibility(View.INVISIBLE);
                findViewById(gridTwoPlayerOneIcon).setVisibility(View.INVISIBLE);
                findViewById(gridThreePlayerOneIcon).setVisibility(View.INVISIBLE);
                findViewById(gridFourPlayerOneIcon).setVisibility(View.INVISIBLE);
                findViewById(R.id.gridFivePlayerOneIcon).setVisibility(View.INVISIBLE);
                findViewById(R.id.gridSixPlayerOneIcon).setVisibility(View.INVISIBLE);
                findViewById(gridSevenPlayerOneIcon).setVisibility(View.INVISIBLE);
                findViewById(gridEightPlayerOneIcon).setVisibility(View.INVISIBLE);
                findViewById(gridNinePlayerOneIcon).setVisibility(View.INVISIBLE);

                findViewById(R.id.gridOnePlayerTwoIcon).setVisibility(View.INVISIBLE);
                findViewById(R.id.gridTwoPlayerTwoIcon).setVisibility(View.INVISIBLE);
                findViewById(gridThreePlayerTwoIcon).setVisibility(View.INVISIBLE);
                findViewById(gridFourPlayerTwoIcon).setVisibility(View.INVISIBLE);
                findViewById(R.id.gridFivePlayerTwoIcon).setVisibility(View.INVISIBLE);
                findViewById(R.id.gridSixPlayerTwoIcon).setVisibility(View.INVISIBLE);
                findViewById(R.id.gridSevenPlayerTwoIcon).setVisibility(View.INVISIBLE);
                findViewById(R.id.gridEightPlayerTwoIcon).setVisibility(View.INVISIBLE);
                findViewById(gridNinePlayerTwoIcon).setVisibility(View.INVISIBLE);


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
                usersTurn.setImageResource(R.drawable.playerone_symbol);
                TextView usersTurnTitle = (TextView) findViewById(R.id.playerOneName);
                usersTurnTitle.setTextColor(getResources().getColor(R.color.colorWhite));

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