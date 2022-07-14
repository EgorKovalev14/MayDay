package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import ru.timcock.mayday.R;

public class AntiActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anti);
        arrow = findViewById(R.id.arrow);
        arrow.setOnClickListener(this);
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