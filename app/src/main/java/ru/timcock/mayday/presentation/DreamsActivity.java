package ru.timcock.mayday.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.timcock.mayday.R;
import ru.timcock.mayday.data.Dream;
import ru.timcock.mayday.data.Note;
import ru.timcock.mayday.data.db.DreamDB;
import ru.timcock.mayday.data.db.NoteDB;

public class DreamsActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    BottomNavigationItemView item1,item2,item3,item4, item5;
    ArrayList<BottomNavigationItemView> array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dreams);
        ImageView addNote = findViewById(R.id.imageView9);
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
        item2.setChecked(true);
    bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        ArrayList<NoteItem> notes = new ArrayList(0);
        for (Dream d : new DreamDB(this).selectAll()) {
            notes.add(new NoteItem(d.getDream_name(), d.getDream_dt(),
                    d.getImg_text(), new ArrayList<String>(Arrays.asList(d.getDream_tags().split(" ")))));
        }
        ListView listView = findViewById(R.id.noteList);
        NoteAdapter adapter = new NoteAdapter(this, notes);
        listView.setAdapter(adapter);
        NoteItem newItem = (NoteItem) getIntent().getSerializableExtra("NEWITEM");
        if(newItem!=null){
            notes.add(newItem);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, AddDream.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_1:
                Intent intent = new Intent(this, GoalsActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;
            case R.id.item_3:
                Intent intent1=new Intent(this, TaskActivity.class);
                startActivity(intent1);
                overridePendingTransition(0, 0);
                break;
            case R.id.item_4:
                Intent intent2=new Intent(this, NotesActivity.class);
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
