package com.example.educationquiz;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
public class ResultActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_result);
 int s1 = getIntent().getIntExtra("score1", 0);
 int s2 = getIntent().getIntExtra("score2", 0);
 int s3 = getIntent().getIntExtra("score3", 0);
 int total = s1 + s2 + s3;
 TextView tvResult = findViewById(R.id.tvResult);
 tvResult.setText(
 "Quiz Completed!\n\n" +
Round 1 - Technical: " + s1 + "/5\n" +
 "Round 2 - Aptitude: " + s2 + "/5\n" +
 "Round 3 - Coding: " + s3 + "/5\n\n" +
 "Total Score: " + total + "/15"
 );
 MaterialButton btnRestart = findViewById(R.id.btnRestart);
 btnRestart.setOnClickListener(v -> {
 Intent intent = new Intent(this, MainActivity.class);
 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
 startActivity(intent); finish();
 });
 MaterialButton btnExit = findViewById(R.id.btnExit);
 btnExit.setOnClickListener(v -> finishAffinity());
 }
}
