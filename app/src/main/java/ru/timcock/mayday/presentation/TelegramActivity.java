package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.timcock.mayday.R;

public class TelegramActivity extends AppCompatActivity implements View.OnClickListener {
    Button finishButton;
    TextView loginTelegram, skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telegram);
        finishButton = findViewById(R.id.buttonContinueTelegram);
        loginTelegram=findViewById(R.id.textViewLoginTelegram);
        finishButton.setOnClickListener(this);
        loginTelegram.setOnClickListener(this);
        skip=findViewById(R.id.textViewSkip5);
        skip.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonContinueTelegram:
                Intent telegram = new Intent(Intent.ACTION_VIEW , Uri.parse("http://t.me/ddmastermind_bot"));
                startActivity(telegram);
                break;
            case R.id.textViewLoginTelegram:
                Intent intent1=new Intent(this,LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.textViewSkip5:
                Intent intent = new Intent(this,GoalsActivity.class);
                startActivity(intent);
                break;
        }
    }
}