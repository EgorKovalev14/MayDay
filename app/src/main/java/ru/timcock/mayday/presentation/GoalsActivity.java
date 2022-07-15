package ru.timcock.mayday.presentation;

import static net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent.setEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

import ru.timcock.mayday.R;
import ru.timcock.mayday.data.Dream;
import ru.timcock.mayday.data.db.Tags;

public class GoalsActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    BottomNavigationItemView item1,item2,item3,item4, item5;
    ArrayList<BottomNavigationItemView> array = new ArrayList<>();
    ImageView imageView8;
    EditText ewt;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        ewt = findViewById(R.id.ewt);
        list = findViewById(R.id.noteList);
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
        imageView8=findViewById(R.id.imageView8);
        imageView8.setOnClickListener(this);
        for(BottomNavigationItemView b : array){
            b.setChecked(false);
        }
        item1.setChecked(true);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        setEventListener(this,
                new KeyboardVisibilityEventListener() {
                    @Override
                    public void onVisibilityChanged(boolean b) {
                        if (b) {
                            //Клавиатура открылась
                            list.setVisibility(View.GONE);
                        }
                        else {
                            //Клавиатура закрылась
                            list.setVisibility(View.VISIBLE);
                            ArrayList<NoteItem> notes = new ArrayList(0);
                            for (Dream d : Tags.searchDreams(ewt.getText().toString().split(" ")[0], getApplicationContext())) {
                                notes.add(new NoteItem(d.getDream_name(), d.getDream_dt(),
                                        d.getImg_text(), new ArrayList<String>(Arrays.asList(d.getDream_tags().split(" ")))));
                            }
                            ListView listView = findViewById(R.id.noteList);
                            NoteAdapter adapter = new NoteAdapter(getApplicationContext() , notes);
                            listView.setAdapter(adapter);
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageView8:
                Intent intent = new Intent(this, AddGoalActivity.class);
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
