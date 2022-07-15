package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ru.timcock.mayday.R;

public class DescriptionNotesActivity extends AppCompatActivity implements View.OnClickListener {
    TextView name, description, date;
    Button delete;
    ImageView back;
    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_notes);
        name=findViewById(R.id.textViewNotesDescriptionName);
        description=findViewById(R.id.textViewNotesDescription);
        delete=findViewById(R.id.deleteButtonNote);
        delete.setOnClickListener(this);
        back=findViewById(R.id.imageViewBackNote);
        date=findViewById(R.id.textViewNotesDate);
        name.setText(getIntent().getStringExtra("NAME"));
        description.setText(getIntent().getStringExtra("DESCRIPTION"));
        date.setText(getIntent().getStringExtra("DATE"));
        id=getIntent().getIntExtra("ID", 0);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageViewBackNote:
                finish();
                overridePendingTransition(0,0);
                break;
            case R.id.deleteButtonNote:

                break;
        }

    }
}