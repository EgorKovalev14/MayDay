package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import ru.timcock.mayday.R;

public class OvchinnikovActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovchinnikov);
        arrowBack=findViewById(R.id.arrow);
        arrowBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.arrow:
                finish();
                overridePendingTransition(0,0);
                break;
        }
    }
}