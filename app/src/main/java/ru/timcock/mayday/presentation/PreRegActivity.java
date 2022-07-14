package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.timcock.mayday.R;

public class PreRegActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_reg);
        button1=findViewById(R.id.buttonHaveAccount);
        button2=findViewById(R.id.buttonRegistration);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonHaveAccount:
                Intent intent = new Intent(this, NameActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonRegistration:
                Intent intent1=new Intent(this,GoalsActivity.class);
                startActivity(intent1);
                break;
        }

    }
}