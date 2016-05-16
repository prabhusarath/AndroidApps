package com.example.sarathkumar.currencyconvertercomplete;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rand = new Random();
    Integer ir;

    public void convButton(View view)
    {
        EditText T1 = (EditText) findViewById(R.id.editText);

        String usDollars = T1.getText().toString();

        if (usDollars.length() > 0 )
        {
        Integer indianRupees = Integer.parseInt(usDollars);

        String Msg =" ";
        if (indianRupees > ir)
        {
            Msg = "High";

        }
        else if(indianRupees < ir)
        {
            Msg = "Low";
        }
        else {
            Msg = "Correct Equal";
            ir = rand.nextInt(21);

        }

        Toast.makeText(getApplicationContext(),Msg,Toast.LENGTH_LONG).show();}

        else {
            Toast.makeText(getApplicationContext(),"Please Enter Number",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Random rand = new Random();
        ir = rand.nextInt(21);

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
