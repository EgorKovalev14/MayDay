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
    Button buttonContinuePassword;
    TextView textViewLoginPassword;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        buttonContinuePassword=findViewById(R.id.buttonContinuePassword);
        textViewLoginPassword=findViewById(R.id.textViewLoginPassword);
        editTextPassword=findViewById(R.id.editTextPassword);
        buttonContinuePassword.setOnClickListener(this);
        textViewLoginPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonContinuePassword:
                Intent intent = new Intent(this, TelegramActivity.class);
                startActivity(intent);
                break;
            case R.id.textViewLoginPassword:
                Intent intent1=new Intent(this,LoginActivity.class);
                startActivity(intent1);
                break;
        }
    }
}