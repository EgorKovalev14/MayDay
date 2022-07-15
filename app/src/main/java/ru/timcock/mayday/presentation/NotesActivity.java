package ru.timcock.mayday.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import ru.timcock.mayday.R;

public class NotesActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    BottomNavigationItemView item1,item2,item3,item4, item5;
    ArrayList<BottomNavigationItemView> array = new ArrayList<>();
    ListView listView;
    ArrayList<NoteItem> notes = new ArrayList<>();
    ImageView addNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        addNote=findViewById(R.id.imageView8);
        addNote.setOnClickListener(this);
        item1=findViewById(R.id.item_1);
        item2=findViewById(R.id.item_2);
        item3=findViewById(R.id.item_3);
        item4=findViewById(R.id.item_4);
        item5=findViewById(R.id.item_5);
        array.add(item1);
        array.add(item2);
        array.add(item3);
        array.add(item4);
        array.add(item5);
        for(BottomNavigationItemView b : array){
            b.setChecked(false);
        }
        item4.setChecked(true);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("yuguyygvygv");
        notes.add(new NoteItem("Qwerty", "qwerty", "qwerty", arrayList));
        listView=findViewById(R.id.noteList);
        NoteAdapter adapter = new NoteAdapter(this, notes);
        listView.setAdapter(adapter);
        NoteItem newItem = (NoteItem) getIntent().getSerializableExtra("NEWITEM");
        if(newItem!=null){
            notes.add(newItem);
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageView8:
                Intent intent = new Intent(this, AddNote.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                break;
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_2:
                Intent intent = new Intent(this, DreamsActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;
            case R.id.item_1:
                Intent intent1=new Intent(this, GoalsActivity.class);
                startActivity(intent1);
                overridePendingTransition(0, 0);
                break;
            case R.id.item_3:
                Intent intent2=new Intent(this, TaskActivity.class);
                startActivity(intent2);
                overridePendingTransition(0, 0);
                break;
            case R.id.item_5:
                Intent intent3=new Intent(this, TipsActivity.class);
                startActivity(intent3);
                overridePendingTransition(0, 0);
                break;
        }
        return false;
    }
}