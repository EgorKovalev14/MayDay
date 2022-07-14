package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.timcock.mayday.R;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button=findViewById(R.id.buttonContinue3);
        button.setOnClickListener(this);
        skip=findViewById(R.id.textViewSkip1);
        skip.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonContinue3:
                Intent intent = new Intent(this, PreRegActivity.class);
                startActivity(intent);
                break;
            case R.id.textViewSkip1:
                Intent intent1=new Intent(this, PreRegActivity.class);
                startActivity(intent1);
                break;
        }
    }
}