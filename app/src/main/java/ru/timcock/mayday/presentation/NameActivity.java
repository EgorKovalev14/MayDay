package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.timcock.mayday.R;

public class NameActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextName;
    Button buttonContinueName;
    TextView textViewLoginName;
    static String nameFromRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        editTextName=findViewById(R.id.editTextName);
        buttonContinueName=findViewById(R.id.buttonContinueName);
        textViewLoginName=findViewById(R.id.textViewLoginName);
        buttonContinueName.setOnClickListener(this);
        textViewLoginName.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonContinueName:
                if (editTextName.getText().toString().length()!=0) {
                    nameFromRegistration = editTextName.getText().toString();
                    Intent intent = new Intent(this, EmailActivity.class);
                    startActivity(intent);
                }
                break;

        }

    }
}