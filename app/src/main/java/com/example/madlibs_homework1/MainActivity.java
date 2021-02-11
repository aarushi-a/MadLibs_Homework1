package com.example.madlibs_homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {
    private Button button_start;
    //private List<String> values;

    //api
    private static final String api_url="http://madlibz.herokuapp.com/api/random";
    private static AsyncHttpClient client = new AsyncHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_start = findViewById(R.id.button_start);
        button_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                launchNextActivity(v);
            }
        });
    }



    public void launchNextActivity(View view){
        //create an intent, from main activity and to second activity
        //when button clicked, send get request to API and send data to 2nd activity
        //set header
        client.addHeader("Accept","application/json");
        //get request
        client.get(api_url, new AsyncHttpResponseHandler(){

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    Log.d("api.response", new String(responseBody));

                    ArrayList<String> list= new ArrayList<String>();

                    try{
                        JSONObject json = new JSONObject(new String(responseBody));
                        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                        intent.putExtra("title",json.getString("title"));
                        intent.putExtra("blanks", json.getString("blanks"));
                        //values = new ArrayList<String>();

                        JSONArray array = json.getJSONArray("value");

                        for (int i = 0; i < array.length(); i++) {
                            String object =array.getString(i);
                            list.add(object);
                        }
                        intent.putExtra("value", list);
                        startActivity(intent);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Log.e("api.error", new String(responseBody));
                    }

            });

        }
    }