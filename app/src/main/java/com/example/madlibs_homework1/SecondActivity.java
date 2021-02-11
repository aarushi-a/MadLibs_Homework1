package com.example.madlibs_homework1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;

public class SecondActivity extends AppCompatActivity {
    private Button button_goNext;
    private ScrollView scroll_view;
    private TextView textView_2;

    private static final String api_url =  "http://madlibz.herokuapp.com/api/random";
    private static AsyncHttpClient client = new AsyncHttpClient();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //to go to third activity
        button_goNext = findViewById(R.id.button_goNext);
        scroll_view = findViewById(R.id.scroll_view);
        textView_2 = findViewById(R.id.textView_2);

        Intent intent = getIntent();
        textView_2.setText(intent.getStringExtra("title"));

        button_goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity(v);
            }
        });

    }

    public void launchNextActivity(View view){
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        startActivity(intent);

    }
}
