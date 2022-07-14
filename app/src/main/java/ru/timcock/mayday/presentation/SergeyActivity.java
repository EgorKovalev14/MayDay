package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import ru.timcock.mayday.R;

public class SergeyActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sergey);
        imageView =findViewById(R.id.arrow);
        imageView.setOnClickListener(this);

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