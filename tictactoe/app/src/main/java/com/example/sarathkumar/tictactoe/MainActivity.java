package com.example.sarathkumar.tictactoe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button box1,box2,box3,box4,box5,box6,box7,box8,box9;

    Boolean turns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        box1 = (Button) findViewById(R.id.box1);
        box2 = (Button) findViewById(R.id.box2);
        box3 = (Button) findViewById(R.id.box3);
        box4 = (Button) findViewById(R.id.box4);
        box5 = (Button) findViewById(R.id.box5);
        box6 = (Button) findViewById(R.id.box6);
        box7 = (Button) findViewById(R.id.box7);
        box8 = (Button) findViewById(R.id.box8);
        box9 = (Button) findViewById(R.id.box9);

        turns = true;

        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(box1.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box1.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box1.setText("O");
                    }
                }
                results();
            }
        });

        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(box2.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box2.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box2.setText("O");
                    }
                }
                results();
            }
        });

        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(box3.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box3.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box3.setText("O");
                    }
                }
                results();
            }
        });

        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(box4.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box4.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box4.setText("O");
                    }
                }
                results();
            }
        });
        box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(box5.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box5.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box5.setText("O");
                    }
                }
                results();
            }
        });
        box6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(box6.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box6.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box6.setText("O");
                    }
                }
                results();
            }
        });
        box7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(box7.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box7.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box7.setText("O");
                    }
                }
                results();
            }
        });
        box8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(box8.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box8.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box8.setText("O");
                    }
                }
                results();
            }
        });
        box9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(box9.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box9.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box9.setText("O");
                    }
                }
                results();
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


    public <T> boolean Rules(T a, T b,T c, T expected) {
        return a.equals(expected) && b.equals(expected) && c.equals(expected);
    }


    public void results(){

        String bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;

        boolean result = false;
        boolean draw = true;

        bt1 = box1.getText().toString();
        bt2 = box2.getText().toString();
        bt3 = box3.getText().toString();
        bt4 = box4.getText().toString();
        bt5 = box5.getText().toString();
        bt6 = box6.getText().toString();
        bt7 = box7.getText().toString();
        bt8 = box8.getText().toString();
        bt9 = box9.getText().toString();

        if ( Rules(bt1,bt2,bt3,"X")){
            Toast.makeText(MainActivity.this, " Winner Player 1",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        } else if(Rules(bt1,bt2,bt3,"O")){
            Toast.makeText(MainActivity.this, " Winner Player 2",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }

        if ( Rules(bt4,bt5,bt6,"X")){
            Toast.makeText(MainActivity.this, " Winner Player 1",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }else if(Rules(bt4,bt5,bt6,"O")){
            Toast.makeText(MainActivity.this, " Winner Player 2",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }

        if ( Rules(bt7,bt8,bt9,"X")){
            Toast.makeText(MainActivity.this, " Winner Player 1",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }else if(Rules(bt7,bt8,bt9,"O")){
            Toast.makeText(MainActivity.this, " Winner Player 2",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }

        if ( Rules(bt1,bt4,bt7,"X")){
            Toast.makeText(MainActivity.this, " Winner Player 1",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }else if(Rules(bt1,bt4,bt7,"O")){
            Toast.makeText(MainActivity.this, " Winner Player 2",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }

        if ( Rules(bt2,bt5,bt8,"X")){
            Toast.makeText(MainActivity.this, " Winner Player 1",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }else if(Rules(bt2,bt5,bt8,"O")){
            Toast.makeText(MainActivity.this, " Winner Player 2",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }

        if ( Rules(bt6,bt9,bt3,"X")){
            Toast.makeText(MainActivity.this, " Winner Player 1",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }else if(Rules(bt6,bt9,bt3,"O")){
            Toast.makeText(MainActivity.this, " Winner Player 2",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }

        if ( Rules(bt1,bt5,bt9,"X")){
            Toast.makeText(MainActivity.this, " Winner Player 1",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }else if(Rules(bt1,bt5,bt9,"O")){
            Toast.makeText(MainActivity.this, " Winner Player 2",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }

        if ( Rules(bt7,bt5,bt3,"X")){
            Toast.makeText(MainActivity.this, " Winner Player 1",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }else if(Rules(bt7,bt5,bt3,"O")){
            Toast.makeText(MainActivity.this, " Winner Player 2",Toast.LENGTH_LONG).show();
            result=true;
            draw = false;
        }

        if(result) {
            box1.setEnabled(!result);
            box2.setEnabled(!result);
            box3.setEnabled(!result);
            box4.setEnabled(!result);
            box5.setEnabled(!result);
            box6.setEnabled(!result);
            box7.setEnabled(!result);
            box8.setEnabled(!result);
            box9.setEnabled(!result);
        }

        if( draw && !result && !(box1.isEnabled()) && !(box2.isEnabled()) && !(box3.isEnabled()) && !(box4.isEnabled())
                && !(box5.isEnabled()) && !(box6.isEnabled()) && !(box7.isEnabled()) && !(box8.isEnabled()) && !(box9.isEnabled())){
            Log.d("aa","aaaaa");
            Toast.makeText(MainActivity.this, " Game Draw Finished.",Toast.LENGTH_LONG).show();
        }


    }
}
