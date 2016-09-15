package com.example.sarathkumar.guesstheceleb;

import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public class DownloadPics extends AsyncTask<String,Void,String>{


        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;
            InputStream inputStream;
            InputStreamReader inputStreamReader;
            BufferedReader bufferedReader;

            try {

                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection)url.openConnection();

                InputStream inp = urlConnection.getInputStream();

                InputStreamReader re = new InputStreamReader(inp);

                BufferedReader bf = new BufferedReader(re);

                StringBuilder stringBuilder = new StringBuilder();

                String line;

                //int data = re.read();

                while ((line = bf.readLine()) != null)
                {
                    stringBuilder.append(line);
                   // Log.i("tag",line);

                }

                inp.close();

                result = stringBuilder.toString();

                return result;

            }

            catch (Exception e) {

            e.printStackTrace();

            }

            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadPics pics = new DownloadPics();
        String result = "null";

        try {
            result = pics.execute("http://www.posh24.com/celebrities").get();

            String[] StrPage = result.split("<div class=\"sidebarContainer\">");

            Pattern p = Pattern.compile("img src=\"(.*?)\"");
            Matcher m = p.matcher(StrPage[0]);

            while(m.find())
            {
                System.out.println(m.group(1));

            }

            Pattern p1 = Pattern.compile("alt=\"(.*?)\"");
            Matcher m1 = p1.matcher(StrPage[0]);

            while(m1.find())
            {
                System.out.println(m1.group(1));

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
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
