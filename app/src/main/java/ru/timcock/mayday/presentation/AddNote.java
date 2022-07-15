package ru.timcock.mayday.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Arrays;

import ru.timcock.mayday.R;
import ru.timcock.mayday.data.Note;
import ru.timcock.mayday.data.db.NoteDB;

public class AddNote extends AppCompatActivity implements View.OnClickListener {
    Button buttonContinue;
    ImageView imageView;
    EditText name, description, tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        buttonContinue=findViewById(R.id.buttonCreateNote);
        buttonContinue.setOnClickListener(this);
        imageView=findViewById(R.id.imageViewBack);
        imageView.setOnClickListener(this);
        name=findViewById(R.id.editTextNoteName);
        description=findViewById(R.id.editTextNoteDescription);
        tags=findViewById(R.id.editTextNoteTags);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonCreateNote:
                NoteItem item = new NoteItem(name.getText().toString(),
                        format(DateTime.now().toLocalDate().toString(DateTimeFormat.forPattern("MM:dd"))),
                        description.getText().toString(), new ArrayList<String>(Arrays.asList(tags.getText().toString().split(" "))));
                new NoteDB(this)
                        .insert(new Note("kew0rker11@gmail.com", name.getText().toString(),
                                description.getText().toString(), "",
                                format(DateTime.now().toLocalDate().toString(DateTimeFormat.forPattern("MM:dd"))),
                                tags.getText().toString()));
                Intent intent = new Intent(this, NotesActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
            case R.id.imageViewBack:
                finish();
                overridePendingTransition(0,0);
                break;
        }

    }

    public String format(String s) {
        switch (s.substring(0, 2)) {
            case "01": { return s.substring(3, s.length()) + " января";}
            case "02": {  return s.substring(3, s.length()) + " февраля";}
            case "03": {  return s.substring(3, s.length()) + " марта";}
            case "04": {  return s.substring(3, s.length()) + " апреля";}
            case "05": {  return s.substring(3, s.length()) + " мая";}
            case "06": {  return s.substring(3, s.length()) + " июня";}
            case "07": {  return s.substring(3, s.length()) + " июля";}
            case "08": {  return s.substring(3, s.length()) + " августа";}
            case "09": {  return s.substring(3, s.length()) + " сенября";}
            case "10": {  return s.substring(3, s.length()) + " октября";}
            case "11": {  return s.substring(3, s.length()) + " ноября";}
            case "12": {  return s.substring(3, s.length()) + " декабря";}
        } return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}