package com.example.sarathkumar.connectall;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int player = 0;

    int[] state = {2,2,2,2,2,2,2,2,2};

    int[][] pos = {{0,1,2} , {3,4,5} , {6,7,8} ,{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};

    public void Change(View view) {
        ImageView img = (ImageView) view;

        Integer count = Integer.parseInt(img.getTag().toString());

        if (state[count] == 2)

        {
            state[count] = player;

            img.setTranslationY(-1000f);

            if (player == 0) {
                img.setImageResource(R.drawable.yellow);
                player = 1;
            } else {
                img.setImageResource(R.drawable.sm);
                player = 0;
            }


            img.animate().translationYBy(1000f).rotation(360).setDuration(1000l);


            String Msg;

            //LinearLayout l = (LinearLayout) findViewById(R.id.b1);

            for (int[] poss : pos) {
                if (state[poss[0]] == state[poss[1]] && state[poss[1]] == state[poss[2]] && state[poss[0]] != 2)

                {
                    if (player == 0){
                        Msg = "Player 2";
                        Toast.makeText(getApplicationContext(), Msg + " Won !!", Toast.LENGTH_LONG).show();
                        findViewById(R.id.b1).setAlpha(1);
                    }
                     else {
                        Msg = "Player 1";
                        Toast.makeText(getApplicationContext(), Msg + " Won !!", Toast.LENGTH_LONG).show();
                        findViewById(R.id.b1).setAlpha(1);
                    }

                }

            }


        }
    }

    public void Reset(View view)
    {
        for(int i=0;i<9;i++)
        {
            state[i] = 2;
        }

        ImageView Rstimg = (ImageView) view;

    }

    /*
    public void Change1(View view)
    {
        ImageView img = (ImageView) view;

        img.setTranslationY(1000f);



        img.animate().translationYBy(-1000f).rotation(360).setDuration(1000l);

    } */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
