package com.example.quizapptesting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapptesting.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    TextView t1_question, timer ;
    int total = 0;
    int correct = 0;
    DatabaseReference reference;

    int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.Opt1);
        b2 = (Button)findViewById(R.id.Opt2);
        b3 = (Button)findViewById(R.id.Opt3);
        b4 = (Button)findViewById(R.id.Opt4);

        t1_question = (TextView)findViewById(R.id.questionsTxt);
        timer = (TextView)findViewById(R.id.timer);

        updateQuestion();
        reverseTimer(30, timer);

    }

    private void updateQuestion() {
        total++;
        if (total>4){
            Intent i = new Intent(MainActivity.this, RActivity.class);
            i.putExtra("total", String.valueOf(total));
            i.putExtra("correct", String.valueOf(correct));
            i.putExtra("incorrect", String.valueOf(wrong));
            startActivity(i);

        }
        else {
            reference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Question question = snapshot.getValue(Question.class);

                    t1_question.setText(question.getQuestion());
                    b1.setText(question.getOption1());
                    b2.setText(question.getOption2());
                    b3.setText(question.getOption3());
                    b4.setText(question.getOption4());

                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b1.getText().toString().equals(question.getAnswer())) {

                                b1.setBackgroundColor(Color.GREEN);

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(Color.BLUE);

                                        updateQuestion();

                                    }
                                }, 10);
                            } else {
                                wrong = wrong+1;
                                b1.setBackgroundColor(Color.RED);

                                if (b2.getText().toString().equals(question.getAnswer())) {
                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);

                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.BLUE);
                                        b2.setBackgroundColor(Color.BLUE);
                                        b3.setBackgroundColor(Color.BLUE);
                                        b4.setBackgroundColor(Color.BLUE);
                                        updateQuestion();
                                    }
                                }, 10);

                            }
                        }
                    });

                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b2.getText().toString().equals(question.getAnswer()))
                            {
                                b2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },10);
                            }
                            else {
                                wrong = wrong+1;
                                b2.setBackgroundColor(Color.RED);

                                if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);

                                }
                                Handler handler = new Handler();
                                handler.postDelayed(() -> {
                                    b1.setBackgroundColor(Color.BLUE);
                                    b2.setBackgroundColor(Color.BLUE);
                                    b3.setBackgroundColor(Color.BLUE);
                                    b4.setBackgroundColor(Color.BLUE);
                                    updateQuestion();
                                }, 10);

                            }

                        }
                    });

                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b3.getText().toString().equals(question.getAnswer()))
                            {
                                b3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },10);
                            }
                            else {
                                wrong = wrong+1;
                                b3.setBackgroundColor(Color.RED);

                                if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);

                                }
                                Handler handler = new Handler();
                                handler.postDelayed(() -> {
                                    b1.setBackgroundColor(Color.BLUE);
                                    b2.setBackgroundColor(Color.BLUE);
                                    b3.setBackgroundColor(Color.BLUE);
                                    b4.setBackgroundColor(Color.BLUE);
                                    updateQuestion();
                                }, 10);

                            }
                        }
                    });

                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b4.getText().toString().equals(question.getAnswer()))
                            {
                                b4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },10);
                            }
                            else {
                                wrong = wrong+1;
                                b4.setBackgroundColor(Color.RED);

                                if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);

                                }
                                Handler handler = new Handler();
                                handler.postDelayed(() -> {
                                    b1.setBackgroundColor(Color.BLUE);
                                    b2.setBackgroundColor(Color.BLUE);
                                    b3.setBackgroundColor(Color.BLUE);
                                    b4.setBackgroundColor(Color.BLUE);
                                    updateQuestion();
                                }, 10);

                            }
                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

    public void reverseTimer(int seconds, final TextView tv){

        new CountDownTimer(seconds * 1000 + 1000, 1000){


            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minites = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minites)
                        + ":" + String.format("%02d", seconds));


            }


            public void onFinish() {
                tv.setText("Complete");
                Intent myintent = new Intent(MainActivity.this, RActivity.class);
                myintent.putExtra("total",String.valueOf(total));
                myintent.putExtra("correct",String.valueOf(correct));
                myintent.putExtra("incorrect",String.valueOf(wrong));
                startActivity(myintent);

            }
        }.start();
    }
}