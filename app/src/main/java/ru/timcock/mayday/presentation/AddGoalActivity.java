package ru.timcock.mayday.presentation;

import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;
import java.util.Arrays;

import ru.timcock.mayday.R;
import ru.timcock.mayday.data.Note;
import ru.timcock.mayday.data.db.NoteDB;

public class AddGoalActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name, descr, tag, date1,date2;
    ImageView imageBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);
        name=findViewById(R.id.editTextNoteName);
        descr=findViewById(R.id.editTextNoteDescription);
        descr=findViewById(R.id.editTextNoteTags);
        date1=findViewById(R.id.editTextDate1);
        date2=findViewById(R.id.editTextDate2);
        imageBack=findViewById(R.id.imageViewBack);
        imageBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonCreateNote:
                NoteItem item = new NoteItem(name.getText().toString(),
                        format(DateTime.now().toLocalDate().toString(DateTimeFormat.forPattern("MM:dd"))),
                        descr.getText().toString(), new ArrayList<String>(Arrays.asList(tag.getText().toString().split(" "))));
                new NoteDB(this)
                        .insert(new Note("kew0rker11@gmail.com", name.getText().toString(),
                                descr.getText().toString(), "",
                                format(DateTime.now().toLocalDate().toString(DateTimeFormat.forPattern("MM:dd"))),
                                tag.getText().toString()));
                Intent intent = new Intent(this, NotesActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
            case R.id.imageViewBack:
                finish();
                overridePendingTransition(0,0);
                break;
        }
    }
}