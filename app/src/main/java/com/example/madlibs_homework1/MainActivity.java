package com.example.madlibs_homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    private Button button_start;
    //api


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_start = findViewById(R.id.button_start);
        button_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                launchSecondActivity(v);
            }
        });
    }



    public void launchSecondActivity(View view){
        //create an intent, from mainactivity and to secondactivty
      Intent intent = new Intent(MainActivity.this,SecondActivity.class);
      startActivity(intent);
    }


}