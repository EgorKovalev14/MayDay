package ru.timcock.mayday.presentation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.timcock.mayday.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.buttonContinue1);
        button.setOnClickListener(this);
        skip=findViewById(R.id.textViewSkip);
        skip.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonContinue1:
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.textViewSkip:
                Intent intent1=new Intent(this, PreRegActivity.class);
                startActivity(intent1);
                break;
        }

    }
}