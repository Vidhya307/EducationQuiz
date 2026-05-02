package com.example.educationquiz;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;
public class QuizActivity extends AppCompatActivity {
 private int round, currentQuestion = 0, score = 0;
 private String[][] questions;
 private int[] correctAnswers;
 private TextView tvRoundTitle, tvQuestion, tvProgress;
 private RadioGroup radioGroup;
 private RadioButton[] options = new RadioButton[4];
 private LinearProgressIndicator progressBar;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_quiz);
 round = getIntent().getIntExtra("round", 1);
 int prevScore1 = getIntent().getIntExtra("score1", 0);
 int prevScore2 = getIntent().getIntExtra("score2", 0);
 tvRoundTitle = findViewById(R.id.tvRoundTitle);
 tvQuestion = findViewById(R.id.tvQuestion);
 tvProgress = findViewById(R.id.tvProgress);
 radioGroup = findViewById(R.id.radioGroupOptions);
 progressBar = findViewById(R.id.progressBar);
 options[0] = findViewById(R.id.rbOption1);
 options[1] = findViewById(R.id.rbOption2);
 options[2] = findViewById(R.id.rbOption3);
 options[3] = findViewById(R.id.rbOption4);
 loadRoundData();
 loadQuestion();
MaterialButton btnNext = findViewById(R.id.btnNext);
 btnNext.setOnClickListener(v -> {
 int selected = radioGroup.getCheckedRadioButtonId();
 if (selected == -1) {
 Toast.makeText(this, "Please select an answer!", 
Toast.LENGTH_SHORT).show();
 return;
 }
 int idx = radioGroup.indexOfChild(findViewById(selected));
 if (idx == correctAnswers[currentQuestion]) score++;
 currentQuestion++;
 if (currentQuestion < questions.length) {
 loadQuestion();
 } else {
 Intent intent;
 if (round < 3) {
 intent = new Intent(this, QuizActivity.class);
 intent.putExtra("round", round + 1);
 intent.putExtra("score1", round == 1 ? score : prevScore1);
 intent.putExtra("score2", round == 2 ? score : prevScore2);
 } else {
 intent = new Intent(this, ResultActivity.class);
 intent.putExtra("score1", prevScore1);
 intent.putExtra("score2", prevScore2);
 intent.putExtra("score3", score);
 }
 startActivity(intent);
 finish();
 }
 });
 }
 private void loadRoundData() {
 if (round == 1) {
 tvRoundTitle.setText("Round 1: Technical Quiz");
 questions = new String[][]{
 {"What does OS stand for?","Open Source","Operating System","Output 
Stream","Optical Scanner"},
 {"Which protocol is used for email?","FTP","HTTP","SMTP","TCP"},
 {"Full form of SQL?","Soft Query Language","Structured Query 
Language","Simple Query Logic","System Query Layer"},
 {"RAM is which type of memory?","Read Only","Volatile","NonVolatile","Cache"},
 {"Which layer handles routing?","Data 
Link","Transport","Network","Application"}
 };
 correctAnswers = new int[]{1, 2, 1, 1, 2};
 } else if (round == 2) {
 tvRoundTitle.setText("Round 2: Aptitude Quiz");
 questions = new String[][]{
 {"Next in series: 2,4,8,16,?","24","32","28","20"},
 {"20% of 250 is?","40","50","60","55"},
 {"Train 60km/hr speed in m/s?","10","16.67","20","12"},
 {"Ratio 3:5. Total=40, larger part?","15","25","20","24"},
{"SI on Rs.1000 at 5% for 
2yrs?","Rs.100","Rs.150","Rs.200","Rs.50"}
 };
 correctAnswers = new int[]{1, 1, 1, 1, 0};
 } else {
 tvRoundTitle.setText("Round 3: Coding Quiz");
 questions = new String[][]{
 {"Keyword for constant in 
Java?","static","final","const","define"},
 {"Output of print(2**3) in Python?","6","8","9","5"},
 {"Time complexity of Binary Search?","O(n)","O(n^2)","O(log 
n)","O(1)"},
 {"Which data structure uses LIFO?","Queue","Stack","Linked 
List","Tree"},
 {"for loop range(5) iterates how many times?","4","5","6","3"}
 };
 correctAnswers = new int[]{1, 1, 2, 1, 1};
 }
 progressBar.setMax(questions.length);
 }
 private void loadQuestion() {
 radioGroup.clearCheck();
 tvProgress.setText("Question " + (currentQuestion+1) + " of " + 
questions.length);
 progressBar.setProgress(currentQuestion + 1);
 String[] q = questions[currentQuestion];
 tvQuestion.setText(q[0]);
 for (int i = 0; i < 4; i++) options[i].setText(q[i+1]);
 }
}
