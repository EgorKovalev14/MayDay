package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

import ru.timcock.mayday.R;

public class EmailActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextEmail;
    Button continueButton;
    TextView loginTextView;
    static String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        editTextEmail=findViewById(R.id.editTextEmail);
        continueButton=findViewById(R.id.buttonContinueEmail);
        loginTextView=findViewById(R.id.textViewLoginEmail);
        continueButton.setOnClickListener(this);
        loginTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonContinueEmail:
                if(isEmailValid(editTextEmail.getText().toString())) {
                    email = editTextEmail.getText().toString();
                    Intent intent = new Intent(this, PasswordActivity.class);
                    startActivity(intent);
                }
                break;

        }
    }
    public static boolean isEmailValid(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }
}