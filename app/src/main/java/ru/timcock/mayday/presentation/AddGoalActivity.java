package ru.timcock.mayday.presentation;

import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;
import java.util.Arrays;

import ru.timcock.mayday.R;
import ru.timcock.mayday.data.Goal;
import ru.timcock.mayday.data.Note;
import ru.timcock.mayday.data.db.GoalDB;
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
        tag=findViewById(R.id.editTextNoteTags);
        date1=findViewById(R.id.editTextDate1);
        date2=findViewById(R.id.editTextDate2);
        imageBack=findViewById(R.id.imageViewBack);
        imageBack.setOnClickListener(this);
        Button buttonCreateNote = findViewById(R.id.buttonCreateNote);
        buttonCreateNote.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonCreateNote:
//                NoteItem item = new NoteItem(name.getText().toString(),
//                        format(DateTime.now().toLocalDate().toString(DateTimeFormat.forPattern("yyyy:MM:dd"))),
//                        descr.getText().toString(), new ArrayList<String>(Arrays.asList(tag.getText().toString().split(" "))));
                new GoalDB(this)
                        .insert(new Goal("kew0rker11@gmail.com",
                                tag.getText().toString(),
                                format(DateTime.now().toLocalDate().toString(DateTimeFormat.forPattern("MM:dd"))),
                                format(date1.getText().toString().substring(4, date1.getText().toString().length())),
                                format(date2.getText().toString().substring(4, date2.getText().toString().length())),
                                "asd",
                                descr.getText().toString(),
                                name.getText().toString()));
                Intent intent = new Intent(this, GoalsActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
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

    public String format1(String s) {
        switch (s.substring(4, 6)) {
            case "01": { return s.substring(6, s.length()) + " января";}
            case "02": {  return s.substring(6, s.length()) + " февраля";}
            case "03": {  return s.substring(6, s.length()) + " марта";}
            case "04": {  return s.substring(6, s.length()) + " апреля";}
            case "05": {  return s.substring(6, s.length()) + " мая";}
            case "06": {  return s.substring(6, s.length()) + " июня";}
            case "07": {  return s.substring(6, s.length()) + " июля";}
            case "08": {  return s.substring(6, s.length()) + " августа";}
            case "09": {  return s.substring(6, s.length()) + " сенября";}
            case "10": {  return s.substring(6, s.length()) + " октября";}
            case "11": {  return s.substring(6, s.length()) + " ноября";}
            case "12": {  return s.substring(6, s.length()) + " декабря";}
        } return null;
    }
}