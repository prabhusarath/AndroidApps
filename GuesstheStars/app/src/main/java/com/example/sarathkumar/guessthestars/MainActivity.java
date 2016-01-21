package com.example.sarathkumar.guessthestars;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    ArrayList<String> celebURLs = new ArrayList<String>();
    ArrayList<String> celebNames = new ArrayList<String>();
    int chosenCeleb = 0;
    int locationOfCorrectAnswer = 0;
    String[] answers = new String[4];

    ImageView imageView;

    Button button0;
    Button button1;
    Button button2;
    Button button3;

    public void celebChosen(View view) {

        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {

            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(getApplicationContext(), "Wrong! It was " + celebNames.get(chosenCeleb), Toast.LENGTH_LONG).show();

        }


        createNewQuestion();
    }

    public class Down extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... urls) {

            String result = "";

// url is of type URL. URL is a datatype in java which holds urls
            URL url;

//this is kinda like a browser
            HttpURLConnection urlConnection = null;
            try {


                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = null;
                try {
                    inputStream = urlConnection.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if ( inputStream != null ) {

//pass the stream to the reader
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String receiveString = "";
                    StringBuilder stringBuilder = new StringBuilder();

//read lines from bufferedReader & store it in receiveString
                    while ( (receiveString = bufferedReader.readLine()) != null ) {

//append the lines to the stringBuilder
                        stringBuilder.append(receiveString);
                    }
//close the stream
                    inputStream.close();

//convert the entire text from stringBuiler to string & store it in result
                    result = stringBuilder.toString();
                    Log.i("msg: ", "returning ret");
                    return result;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "failed";
        }
    }
    public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {


        @Override
        protected Bitmap doInBackground(String... urls) {

            try {

                URL url = new URL(urls[0]);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                
                connection.connect();


                InputStream inputStream = connection.getInputStream();

                Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);

                return myBitmap;


            } catch (MalformedURLException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }

            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        button0 = (Button) findViewById(R.id.b1);
        button1 = (Button) findViewById(R.id.b2);
        button2 = (Button) findViewById(R.id.b3);
        button3 = (Button) findViewById(R.id.b4);

        String da;
        Down d = new Down();
        try {

            da = d.execute("http://www.posh24.com/celebrities").get();
            Log.i("Content", da);

            String[] Celeb = da.split("<div class=\"channelListEntry\">");

            Pattern p = Pattern.compile("<img src=\"(.*?)\"");
            Matcher m = p.matcher(Celeb[0]);

            while (m.find()) {

                celebURLs.add(m.group(1));

            }

            p = Pattern.compile("alt=\"(.*?)\"");
            m = p.matcher(Celeb[0]);

            while (m.find()) {

                celebNames.add(m.group(1));

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createNewQuestion();

    }

    public void createNewQuestion() {

        Random random = new Random();
        chosenCeleb = random.nextInt(celebURLs.size());

        ImageDownloader imageTask = new ImageDownloader();

        Bitmap celebImage;

        try {

            celebImage = imageTask.execute(celebURLs.get(chosenCeleb)).get();

            imageView.setImageBitmap(celebImage);

            locationOfCorrectAnswer = random.nextInt(4);

            int incorrectAnswerLocation;

            for (int i=0; i<4; i++) {

                if (i == locationOfCorrectAnswer) {

                    answers[i] = celebNames.get(chosenCeleb);

                } else {

                    incorrectAnswerLocation = random.nextInt(celebURLs.size());

                    while (incorrectAnswerLocation == chosenCeleb) {

                        incorrectAnswerLocation = random.nextInt(celebURLs.size());

                    }

                    answers[i] = celebNames.get(incorrectAnswerLocation);


                }


            }

            button0.setText(answers[0]);
            button1.setText(answers[1]);
            button2.setText(answers[2]);
            button3.setText(answers[3]);


        } catch (Exception e) {
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
