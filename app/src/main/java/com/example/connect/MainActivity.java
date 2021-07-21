package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activeplayer=0;
    //2 means untapped
    boolean game=true;
    int[] gamestate={2,2,2,2,2,2,2,2,2};

    int[][] winnigpositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropin(View view)
    {
        ImageView image=(ImageView) view;
        int tapped=Integer.parseInt(image.getTag().toString());
        if(gamestate[tapped]==2&&game==true)
        {
            gamestate[tapped]=activeplayer;
            image.setTranslationY(-1000f);
            if(activeplayer==0) {
                image.setImageResource(R.drawable.yellow);
                activeplayer=1;
            }
            else{
                image.setImageResource(R.drawable.red);
                activeplayer=0;
            }
            image.animate().translationYBy(1000f).setDuration(300);
            for (int[] winningposition : winnigpositions){
                if(gamestate[winningposition[0]]==gamestate[winningposition[1]]&&gamestate[winningposition[1]]==gamestate[winningposition[2]]&&gamestate[winningposition[0]]!=2)
                {
                    game=false;
                    Button a=(Button)findViewById(R.id.button2);
                    if(gamestate[winningposition[0]]==1)
                    {
                        a.setText("RED WON ( PLAY AGAIN )");
                    }
                    else
                    {
                        a.setText("YELLOW WON ( PLAY AGAIN )");
                    }
                    a.setAlpha(1);
                }
            }
            boolean flag = false;
            for(int i=0;i<9;i++)
            {
                if(gamestate[i]==2)
                {
                    flag = true;
                    break;
                }
            }
            if(flag==false)
            {
                game=false;
                Button a=(Button)findViewById(R.id.button2);
                a.setText("DRAW (PLAY AGAIN)");
                a.setAlpha(1);
            }
        }
    }
    public void playAgain(View view)
    {
        activeplayer=0;
        game=true;
        Button a=(Button)findViewById(R.id.button2);
        a.setAlpha(0);
        for(int i=0;i<gamestate.length;i++)
        {
            gamestate[i]=2;
        }
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView2);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView3);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView4);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView5);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView6);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView7);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView8);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView9);
        imageView.setImageResource(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
