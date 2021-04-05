package com.example.testesono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        getSupportActionBar().hide();
    }

    public void btnJogarOnClick(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}