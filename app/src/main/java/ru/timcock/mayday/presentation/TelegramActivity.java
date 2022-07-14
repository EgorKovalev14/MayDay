package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.timcock.mayday.R;

public class TelegramActivity extends AppCompatActivity implements View.OnClickListener {
    Button finishButton;
    TextView loginTelegram;
    EditText editTextTelegram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telegram);
        finishButton = findViewById(R.id.buttonContinueTelegram);
        loginTelegram=findViewById(R.id.textViewLoginTelegram);
        editTextTelegram=findViewById(R.id.editTextTelegram);
        finishButton.setOnClickListener(this);
        loginTelegram.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonContinueTelegram:
                Intent intent = new Intent(this, GoalsActivity.class);
                startActivity(intent);
                break;
            case R.id.textViewLoginTelegram:
                Intent intent1=new Intent(this,LoginActivity.class);
                startActivity(intent1);
                break;
        }
    }
}