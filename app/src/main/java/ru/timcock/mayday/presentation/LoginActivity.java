package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.timcock.mayday.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button continueLoginButton;
    TextView registerLoginTextView;
    EditText loginEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        continueLoginButton=findViewById(R.id.buttonContinueLogin);
        registerLoginTextView=findViewById(R.id.textViewRegisterLogin);
        loginEditText=findViewById(R.id.editTextLogin);
        continueLoginButton.setOnClickListener(this);
        registerLoginTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.textViewRegisterLogin:
                Intent intent = new Intent(this, NameActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonContinueLogin:
                Intent intent1=new Intent(this, PasswordLoginActivity.class);
                startActivity(intent1);
                break;
        }
    }
}