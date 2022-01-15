package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    //Player representation
    // 0-O
    // 1- X
    int actPlayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    //State meanings:
    // 0-O
    // 1-X
    // 2-NULL
    int[][] winPos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void btnClick(View view){
        TextView status = findViewById(R.id.status);
        ImageView img=(ImageView)view;
        int imgtag=Integer.parseInt(img.getTag().toString());
        if (!gameActive){
            reset(view);
        }
        if (gameState[imgtag]==2 && gameActive) {
            gameState[imgtag] = actPlayer;
            img.setTranslationY(-1000f);
            if (actPlayer == 0) {
                img.setImageResource(R.drawable.circle);
                actPlayer = 1;

                status.setText("X's turn...Tap to play");
            }
            else {
                img.setImageResource(R.drawable.cross);
                actPlayer = 0;

                status.setText("O's turn...Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for (int[] winposition: winPos){
            if (gameState[winposition[0]] == gameState[winposition[1]] && gameState[winposition[1]]==gameState[winposition[2]] && gameState[winposition[0]]!=2){
                String winner;
                gameActive=false;
                if (gameState[winposition[0]]==0){
                    winner="O has won";
                }
                else{
                    winner="X has won";
                }
                status.setText(winner);
            }
        }
        //Condition when the game is draw: put this after the for loop checking the winning condition
        boolean emptySquare = false;
        for (int squareState : gameState) {
            if (squareState == 2) {
                emptySquare = true;
                break;
            }
        }
        if (!emptySquare && gameActive) {
            // Game is a draw
            gameActive = false;
            String winnerStr;
            winnerStr = "No one won";

            status.setText(winnerStr);
        }
    }
    public void reset(View view){
        gameActive=true;
        actPlayer=0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Made by Chandravo",Toast.LENGTH_SHORT).show();
    }
}