package com.example.sarathkumar.guesstheceleb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> Celeb= new ArrayList<String>();
    ArrayList<String> CelebName= new ArrayList<String>();
    int chose = 0;
    int correct = 0;
    String[] answers = new String[4];
    Button b0;
    Button b1;
    Button b2;
    Button b3;

    ImageView Imgview;
    Bitmap img;

    public void celebchosen(View view)
    {

        if (view.getTag().toString().equals(Integer.toString(correct)))
        {

            Toast.makeText(getApplicationContext(),"Correct !!",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Wrong !!"+CelebName.get(chose),Toast.LENGTH_LONG).show();
        }

        NewQuestion();
    }


    public class ImgDownload extends AsyncTask<String,Void,Bitmap>{


        @Override
        protected Bitmap doInBackground(String... urls) {

            try {
                URL ur = new URL(urls[0]);
                HttpURLConnection con = (HttpURLConnection) ur.openConnection();

                con.connect();

                InputStream  inp = con.getInputStream();

                Bitmap map = BitmapFactory.decodeStream(inp);

                return map;

            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }
    }
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


        Imgview = (ImageView) findViewById(R.id.imageView);
        b0 = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.button2);
        b2 = (Button) findViewById(R.id.button3);
        b3 = (Button) findViewById(R.id.button4);



        DownloadPics pics = new DownloadPics();
        String result = "null";

        try {
            result = pics.execute("http://www.posh24.com/celebrities").get();

            String[] StrPage = result.split("<div class=\"sidebarContainer\">");

            Pattern p = Pattern.compile("img src=\"(.*?)\"");
            Matcher m = p.matcher(StrPage[0]);

            while(m.find())
            {
               Celeb.add(m.group(1));
            }

            Pattern p1 = Pattern.compile("alt=\"(.*?)\"");
            Matcher m1 = p1.matcher(StrPage[0]);

            while(m1.find())
            {
                CelebName.add(m1.group(1));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        NewQuestion();
    }

    public void NewQuestion()
    {

        Random rand = new Random();
        chose = rand.nextInt(Celeb.size());

        ImgDownload imtask = new ImgDownload();



        try {
            img = imtask.execute(Celeb.get(chose)).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Imgview.setImageBitmap(img);

        correct = rand.nextInt(4);

        int incorrect;

        for(int i=0;i<4;i++)
        {

            if ( i == correct) {
                answers[i] =  CelebName.get(chose);
            }
            else {

                incorrect = rand.nextInt(Celeb.size());

                while ( incorrect == correct)
                {
                    incorrect = rand.nextInt(Celeb.size());
                }
                answers[i] = CelebName.get(incorrect);
            }
        }


        b0.setText(answers[0]);
        b1.setText(answers[1]);
        b2.setText(answers[2]);
        b3.setText(answers[3]);
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
