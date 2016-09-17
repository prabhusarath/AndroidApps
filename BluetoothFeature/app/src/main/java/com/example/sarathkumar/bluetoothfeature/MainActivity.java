package com.example.sarathkumar.bluetoothfeature;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter BTooth;

    public void turnoff(View view) {


        BTooth.disable();

        if (BTooth.isEnabled()) {
            Toast.makeText(getApplicationContext(), "Bluetooth Could not be Disabled", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(getApplicationContext(), "Bluetooth turned OFF", Toast.LENGTH_LONG).show();

        }

    }

    public void findDevices(View view)
    {
        Intent i = new Intent(BTooth.ACTION_REQUEST_DISCOVERABLE);
                startActivity(i);

    }

    public void viewdevices(View view)
    {
        Set devices = BTooth.getBondedDevices();

        ListView pairedlistView = (ListView) findViewById(R.id.pairedlistView);

        ArrayList paired = new ArrayList();

        


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(BTooth.isEnabled())
        {
            Toast.makeText(getApplicationContext(),"Bluetooth is Already On",Toast.LENGTH_LONG).show();
        }

        else
        {

            Intent i = new Intent(BTooth.ACTION_REQUEST_ENABLE);
            startActivity(i);

            if (BTooth.isEnabled())
            {
                Toast.makeText(getApplicationContext(),"Bluetooth is Turned On",Toast.LENGTH_LONG).show();
            }
        }
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
