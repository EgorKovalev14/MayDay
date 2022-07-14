package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.timcock.mayday.R;

public class PasswordLoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button continuePasswordLoginButton;
    TextView registerPasswordTextView;
    EditText loginPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_login);
        continuePasswordLoginButton=findViewById(R.id.buttonContinuePasswordLogin);
        loginPasswordEditText=findViewById(R.id.editTextPasswordLogin);
        registerPasswordTextView=findViewById(R.id.textViewRegisterPassword);
        continuePasswordLoginButton.setOnClickListener(this);
        registerPasswordTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.textViewRegisterPassword:
                Intent intent = new Intent(this,NameActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonContinuePasswordLogin:
                Intent intent1 = new Intent(this,GoalsActivity.class);
                startActivity(intent1);
                break;
        }

    }
}