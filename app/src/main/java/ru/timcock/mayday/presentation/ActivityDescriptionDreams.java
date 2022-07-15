package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ru.timcock.mayday.R;
import ru.timcock.mayday.data.db.DreamDB;

public class ActivityDescriptionDreams extends AppCompatActivity implements View.OnClickListener {
    TextView name, description, date;
    Button delete;
    ImageView back;
    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_dreams);
        name=findViewById(R.id.textViewDreamsDescriptionName);
        description=findViewById(R.id.textViewDreamsDescription);
        delete=findViewById(R.id.deleteButtonDreams);
        delete.setOnClickListener(this);
        back=findViewById(R.id.imageViewBackDreams);
        date=findViewById(R.id.textViewDreamsDate);
        name.setText(getIntent().getStringExtra("NAME"));
        description.setText(getIntent().getStringExtra("dcsr"));
        date.setText(getIntent().getStringExtra("DATE"));
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageViewBackDreams:
                finish();
                overridePendingTransition(0,0);
                break;
            case R.id.deleteButtonDreams:
                new DreamDB(this).delete(name.getText().toString());
                startActivity(new Intent(this, DreamsActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                break;
        }

    }

}