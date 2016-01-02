package com.example.sarathkumar.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button but;
    Random rand;
    ArrayList<Integer> ans = new ArrayList<Integer>();
    int corAns;
    TextView yh;
    TextView points;
    int score=0;
    int ques =0;
    Button option1;
    Button option2;
    Button option3;
    Button option4;
    Button p;

    TextView clock;

    public void playAgain(View view)
    {
        score=0;
        ques =0;

        yh.setText("30s");
        points.setText("0/0");

        new CountDownTimer(3100,100){
            @Override
            public void onFinish() {

                clock.setText("0");
                yh.setText("Your Score"+Integer.toString(score)+"/"+Integer.toString(ques));
                p.setVisibility(View.VISIBLE);

            }

            @Override
            public void onTick(long millisUntilFinished) {

                int s = (int)(millisUntilFinished)/1000 ;

                clock.setText(Integer.toString(s));

            }
        };


        generate();
    }

    public void generate()
    {

        int a = rand.nextInt(10);
        int b = rand.nextInt(10);
        TextView t1 = (TextView) findViewById(R.id.numb);
        points = (TextView) findViewById(R.id.cor);
        t1.setText(Integer.toString(a)+"+"+Integer.toString(b));
        corAns = rand.nextInt(4);
        int inC;

        ans.clear();

        for(int i=0;i<4;i++)
        {
            if ( i == corAns)
            {
                ans.add(a+b);
            }
            else {
                inC = rand.nextInt(30);
                while (inC == a + b) {
                    inC = rand.nextInt(40);
                }
                ans.add(inC);
            }
        }
        option1.setText(Integer.toString(ans.get(0)));
        option2.setText(Integer.toString(ans.get(1)));
        option3.setText(Integer.toString(ans.get(2)));
        option4.setText(Integer.toString(ans.get(3)));

    }
    public void choose(View view)
    {
        if((view.getTag()).toString().equals(Integer.toString(corAns)))
                {
                    yh.setText("Correct :) ");
                    score++;
                }
        else {
                    yh.setText("Wrong :( ");
                }
        ques++;

        points.setText(Integer.toString(score)+"/"+Integer.toString(ques));

        generate();
    }

    public void Init(View view)
    {
        but.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but = (Button) findViewById(R.id.b1);
        yh = (TextView) findViewById(R.id.textView4);
        rand = new Random();
        clock = (TextView) findViewById(R.id.sec);

        option1 = (Button) findViewById(R.id.button1);
        option2 = (Button) findViewById(R.id.button2);
        option3 = (Button) findViewById(R.id.button3);
        option4 = (Button) findViewById(R.id.button4);
        p = (Button) findViewById(R.id.play);

        generate();

        new CountDownTimer(3100,100){
            @Override
            public void onFinish() {

                clock.setText("0");
                yh.setText("Your Score"+Integer.toString(score)+"/"+Integer.toString(ques));
                p.setVisibility(View.VISIBLE);

            }

            @Override
            public void onTick(long millisUntilFinished) {

                int s = (int)(millisUntilFinished)/1000 ;

                clock.setText(Integer.toString(s));

            }
        };

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
