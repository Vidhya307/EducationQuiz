package com.example.educationquiz;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
public class MainActivity extends AppCompatActivity {
 @Override
protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 MaterialButton btnStart = findViewById(R.id.btnStartQuiz);
 btnStart.setOnClickListener(v -> {
 Intent intent = new Intent(MainActivity.this, QuizActivity.class);
 intent.putExtra("round", 1);
 intent.putExtra("score1", 0);
 intent.putExtra("score2", 0);
 startActivity(intent);
 });
 }
}
