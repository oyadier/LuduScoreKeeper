package com.example.luduscorekeeper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int playDice;
    int playerOneScores;
    int playerTwoScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     *  This blocks of codes contains the all the methods for the 1st Player
     * */
    public void displayRandomNumber1(int number) {
        TextView textView1 = (TextView) findViewById(R.id.randomNumber1);
        textView1.setText(number + " ");

    }

    // Displays 1st players result and declaring him winner if his scores reaches 50 early
    public void displayPlayerOneScores(int scores) {
        TextView textView1 = (TextView) findViewById(R.id.player1_scores);
        textView1.setText(scores + " ");
        WinnerDeclaration();
    }


    public void PlayerOneRotate(View view) {


        playDice = (int) (1 + Math.random() * 6);
        setPlayDiceSound(playDice);
        displayRandomNumber1(playDice);
        if (playDice < 6) {
            Toast.makeText(this, "2nd Player's Turn", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "1st Player's another Chance", Toast.LENGTH_LONG).show();
        }
    }

    public void PlusSixPoints(View view) {
        playerOneScores += 6;
        displayPlayerOneScores(playerOneScores);
    }


    public void PlusFivePoints(View view) {
        playerOneScores += 5;
        displayPlayerOneScores(playerOneScores);
    }

    public void PlusFourPoints(View view) {
        playerOneScores +=  4;
        displayPlayerOneScores(playerOneScores);
    }

    public void PlusThreePoints(View view) {
        playerOneScores +=  3;
        displayPlayerOneScores(playerOneScores);
    }

    public void PlusTwoPoints(View view) {
        playerOneScores +=2;
        displayPlayerOneScores(playerOneScores);

    }

    public void PlusOnePoints(View view) {
        playerOneScores += 1;
        displayPlayerOneScores(playerOneScores);


    }



    /*
     * The second player's block of codes
     * */

    public void PlayerTwoRotate(View view) {

        playDice = (int) (1 + Math.random() * 6);
        setPlayDiceSound(playDice);
        displayRandomNumber2(playDice);
        if (playDice < 6) {
            Toast.makeText(this, "1st Player's Turn", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "2nd Player's another Chance", Toast.LENGTH_LONG).show();
        }

    }


    public void displayRandomNumber2(int number) {
        TextView textView2 = (TextView) findViewById(R.id.randomNumber2);
        textView2.setText(number + " ");
    }

    // Displays 2nd players result and declaring him winner if his scores reaches 50 early

    public void displayPlayerTwoScores(int scores) {
        TextView textView1 = (TextView) findViewById(R.id.player2_scores);
        textView1.setText(scores + " ");
        WinnerDeclaration();
    }

    public void PlusSixPoints6(View view) {
        playerTwoScores  += 6;
        displayPlayerTwoScores(playerTwoScores);
    }


    public void PlusFivePoints5(View view) {
        playerTwoScores  += 5;
        displayPlayerTwoScores(playerTwoScores);
    }

    public void PlusFourPoints4(View view) {
        playerTwoScores  += 4;
        displayPlayerTwoScores(playerTwoScores);
    }

    public void PlusThreePoints3(View view) {
        playerTwoScores  += 3;
        displayPlayerTwoScores(playerTwoScores);
    }

    public void PlusTwoPoints2(View view) {
        playerTwoScores = playerTwoScores + 2;
        displayPlayerTwoScores(playerTwoScores);
    }

    public void PlusOnePoints1(View view) {
        playerTwoScores  += 1;
        displayPlayerTwoScores(playerTwoScores);
    }


    public void RestartScores(View view) {

        TextView restart = (TextView) findViewById(R.id.player1_scores);
        TextView restart2 = (TextView) findViewById(R.id.player2_scores);
        restart.setText((playerOneScores = 0) + " ");
        restart2.setText((playerTwoScores = 0) + " ");
        displayRandomNumber1(0);
        displayRandomNumber2(0);
    }

    /*This codes declares any of the players whose mark reaches the winning number 50 early and t
     and then reset the both the dice number and the players dashboard to 0;*/
    public void WinnerDeclaration() {
        int winner = 50;

        if (winner <= playerOneScores) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Player 1 Won");
            builder.setMessage("Press Ok to Restart the Ludo game");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    displayPlayerOneScores(playerOneScores = 0);
                    displayPlayerTwoScores(playerTwoScores = 0);
                    displayRandomNumber1(0);
                    displayRandomNumber2(0);
                }
            });
            builder.create().show();
        } else if (winner <= playerTwoScores) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Player 2 Won");
            builder.setMessage("Press Ok to Restart the Ludo game");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    displayPlayerOneScores(playerOneScores = 0);
                    displayPlayerTwoScores(playerTwoScores = 0);
                    displayRandomNumber1(0);
                    displayRandomNumber2(0);
                }
            });
            builder.create().show();
        }

    }

    public void setPlayDiceSound(int sounds) {
        if (sounds == 6) {

            final MediaPlayer suprice = MediaPlayer.create(this, R.raw.surprise);
            suprice.start();
            suprice.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    suprice.release();
                }
            });

        } else {
            final MediaPlayer diceSound = MediaPlayer.create(this, R.raw.dice);
            diceSound.start();
            diceSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    diceSound.release();
                }
            });
        }

    }

}
