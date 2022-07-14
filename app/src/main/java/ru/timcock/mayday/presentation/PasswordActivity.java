package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.timcock.mayday.R;

public class PasswordActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonFinishReg;
    TextView textViewLoginTelegram;
    EditText editTextTelegram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        buttonFinishReg=findViewById(R.id.buttonContinueTelegram);
        textViewLoginTelegram=findViewById(R.id.textViewLoginTelegram);
        editTextTelegram=findViewById(R.id.editTextTelegram);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonContinueTelegram:
                Intent intent = new Intent(this, GoalsActivity.class);
                startActivity(intent);
                break;
        }
    }
}