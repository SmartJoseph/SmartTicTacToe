package com.smartjoseph.smarttictactoe;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Options extends AppCompatActivity {
    final Context context = this;
    ImageButton aboutBtn;
    ImageButton helpBtn;
    ImageButton shareBtn;
    ImageButton feedbackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        addListenerOnHelpButton();
        addListenerOnAboutButton();
        addListenerOnShareButton();
        addListenerOnFeedbackButton();
    }

    public void addListenerOnAboutButton() {
        aboutBtn = (ImageButton) findViewById(R.id.about_btn);
        aboutBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // alert dialog box that displays winner or loser
                final Dialog dialog = new Dialog(context, R.style.CustomDboxTitle);
                dialog.setTitle(R.string.gameOver);
                dialog.setContentView(R.layout.activity_about);

                Window dialogWindow = dialog.getWindow();
                WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                dialogWindow.setGravity(Gravity.CENTER);

                lp.width = 300;
                lp.height = 400;

                dialogWindow.setAttributes(lp);

                // set the custom dialog components - text , image and button
                ImageView imageView = (ImageView) dialog.findViewById(R.id.smartImage);
                imageView.setImageResource(R.drawable.smart);

                TextView designedBy = (TextView) dialog.findViewById(R.id.designedBy);
                designedBy.setText("Designed and Developed by");

                TextView smartJoseph = (TextView) dialog.findViewById(R.id.smartJoseph);
                smartJoseph.setText("Smart Joseph");

                TextView aboutApp = (TextView) dialog.findViewById(R.id.aboutApp);
                aboutApp.setText("for the Andela Learning Community Android Beginner: Take A Climb Challenge");
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

    public void addListenerOnHelpButton() {
        helpBtn = (ImageButton) findViewById(R.id.help_btn);
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

                lp.width = 300;
                lp.height = 400;

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

    public void addListenerOnShareButton() {
        shareBtn = (ImageButton) findViewById(R.id.share_btn);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, getResources().getText(R.string.share_text));
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.share_with)));
            }
        });

    }

    public void addListenerOnFeedbackButton() {
        feedbackBtn = (ImageButton) findViewById(R.id.feedback_btn);
        feedbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto: iamsmartjoseph@gmail.com")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT,
                        "SMART TIC TAC TOE GAME FEEDBACK");
                intent.putExtra(Intent.EXTRA_TEXT, " ");

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }
}
