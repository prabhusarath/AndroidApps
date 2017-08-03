package com.example.sarathkumar.tictactoe;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /* Elements used in the Application*/
    Button box1, box2, box3, box4, box5, box6, box7, box8, box9;
    Button dialog_ok;
    TextView dialog_info;
    Boolean turns;

    /* Game Results */
    String player1 = " Winner Player 1 ";
    String player2 = " Winner Player 2 ";
    String draws = " Draw Game !!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog_ok = (Button) findViewById(R.id.dialog_ok);
        gameInput();
    }

    /* Function to Show a new Layout with Game Result and Play Again Option.*/
    public void openDialog(String str) {
        final Dialog dialog = new Dialog(MainActivity.this); // Context, this, etc.
        dialog.setContentView(R.layout.dialog_demo);
        dialog.show();
        dialog_info = (TextView) dialog.findViewById(R.id.dialog_info);
        dialog_info.setText(str);
    }

    /* Function to Restart the Application for a New Game. */
    public void restartApp(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    /* Function to Record the input based on the Turns of the Players.*/
    public void gameInput(){

        /* All the Buttons to Record the Input */
        box1 = (Button) findViewById(R.id.box1);
        box2 = (Button) findViewById(R.id.box2);
        box3 = (Button) findViewById(R.id.box3);
        box4 = (Button) findViewById(R.id.box4);
        box5 = (Button) findViewById(R.id.box5);
        box6 = (Button) findViewById(R.id.box6);
        box7 = (Button) findViewById(R.id.box7);
        box8 = (Button) findViewById(R.id.box8);
        box9 = (Button) findViewById(R.id.box9);

        /* Variable to Check the Turn of players. */
        turns = true;

        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (box1.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box1.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box1.setText("O");
                    }
                }
                gameResults();
            }
        });

        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (box2.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box2.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box2.setText("O");
                    }
                }
                gameResults();
            }
        });

        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (box3.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box3.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box3.setText("O");
                    }
                }
                gameResults();
            }
        });

        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (box4.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box4.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box4.setText("O");
                    }
                }
                gameResults();
            }
        });
        box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (box5.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box5.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box5.setText("O");
                    }
                }
                gameResults();
            }
        });
        box6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (box6.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box6.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box6.setText("O");
                    }
                }
                gameResults();
            }
        });
        box7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (box7.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box7.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box7.setText("O");
                    }
                }
                gameResults();
            }
        });
        box8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (box8.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box8.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box8.setText("O");
                    }
                }
                gameResults();
            }
        });
        box9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (box9.getText().toString().equals("")) {
                    if (turns) {
                        turns = !turns;
                        box9.setText("X");
                    } else if (!turns) {
                        turns = !turns;
                        box9.setText("O");
                    }
                }
                gameResults();
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


    /* Function to Check the Wining Condition and the Player Symbol Associated with it.*/
    public <T> boolean gameRules(T a, T b, T c, T expected) {
        return a.equals(expected) && b.equals(expected) && c.equals(expected);
    }


    /* Results Function to Check the Results of the Game with All the 8 Wining Conditions.*/
    public void gameResults() {

        String bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;

        /* Variables to show the Result has been Found or Draw Condition has Occured */
        boolean result = false;
        boolean draw = true;

         /* Variables to show the Result  */
        bt1 = box1.getText().toString();
        bt2 = box2.getText().toString();
        bt3 = box3.getText().toString();
        bt4 = box4.getText().toString();
        bt5 = box5.getText().toString();
        bt6 = box6.getText().toString();
        bt7 = box7.getText().toString();
        bt8 = box8.getText().toString();
        bt9 = box9.getText().toString();

        if (gameRules(bt1, bt2, bt3, "X")) {
            result = true;
            draw = false;
            openDialog(player1);

        } else if (gameRules(bt1, bt2, bt3, "O")) {
            result = true;
            draw = false;
            openDialog(player2);

        }

        if (gameRules(bt4, bt5, bt6, "X")) {
            result = true;
            draw = false;
            openDialog(player1);

        } else if (gameRules(bt4, bt5, bt6, "O")) {
            result = true;
            draw = false;
            openDialog(player2);

        }

        if (gameRules(bt7, bt8, bt9, "X")) {
            result = true;
            draw = false;
            openDialog(player1);

        } else if (gameRules(bt7, bt8, bt9, "O")) {
            result = true;
            draw = false;
            openDialog(player2);

        }

        if (gameRules(bt1, bt4, bt7, "X")) {
            result = true;
            draw = false;
            openDialog(player1);

        } else if (gameRules(bt1, bt4, bt7, "O")) {
            result = true;
            draw = false;
            openDialog(player2);

        }

        if (gameRules(bt2, bt5, bt8, "X")) {
            result = true;
            draw = false;
            openDialog(player1);

        } else if (gameRules(bt2, bt5, bt8, "O")) {
            result = true;
            draw = false;
            openDialog(player2);

        }

        if (gameRules(bt6, bt9, bt3, "X")) {
            result = true;
            draw = false;
            openDialog(player1);

        } else if (gameRules(bt6, bt9, bt3, "O")) {
            result = true;
            draw = false;
            openDialog(player2);

        }

        if (gameRules(bt1, bt5, bt9, "X")) {
            result = true;
            draw = false;
            openDialog(player1);

        } else if (gameRules(bt1, bt5, bt9, "O")) {
            result = true;
            draw = false;
            openDialog(player2);

        }

        if (gameRules(bt7, bt5, bt3, "X")) {
            result = true;
            draw = false;
            openDialog(player1);

        } else if (gameRules(bt7, bt5, bt3, "O")) {
            result = true;
            draw = false;
            openDialog(player2);
        }

         /* All the Buttons will be disabled once Result is Obtained */
        if (result) {
            box1.setEnabled(!result);
            box2.setEnabled(!result);
            box3.setEnabled(!result);
            box4.setEnabled(!result);
            box5.setEnabled(!result);
            box6.setEnabled(!result);
            box7.setEnabled(!result);
            box8.setEnabled(!result);
            box9.setEnabled(!result);
        } else {

            if( draw && !bt1.isEmpty() && !bt2.isEmpty() && !bt3.isEmpty() && !bt4.isEmpty()
                    && !bt5.isEmpty() && !bt6.isEmpty() && !bt7.isEmpty() && !bt8.isEmpty() && !bt9.isEmpty())
            {
                openDialog(draws);
            }
        }

    }
}

