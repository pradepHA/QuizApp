package com.example.quizapptesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RActivity extends AppCompatActivity {

    TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r);
        t1= (TextView)findViewById(R.id.textView4);
        t2= (TextView)findViewById(R.id.textView5);
        t3= (TextView)findViewById(R.id.textView6);

        Intent intent = getIntent();
        String questions = intent.getStringExtra("total");
        String correct = intent.getStringExtra("correct");
        String incorrect = intent.getStringExtra("wrong");

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(incorrect);

    }
}