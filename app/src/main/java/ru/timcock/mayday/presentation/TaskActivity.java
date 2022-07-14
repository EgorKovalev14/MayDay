package ru.timcock.mayday.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import ru.timcock.mayday.R;

public class TaskActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    BottomNavigationItemView item1,item2,item3,item4, item5;
    ArrayList<BottomNavigationItemView> array = new ArrayList<>();

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
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
        item3.setChecked(true);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        tabLayout=findViewById(R.id.TL);
        FragmentContainerView fragment = findViewById(R.id.MainFragment);
        getSupportFragmentManager().beginTransaction().replace(R.id.MainFragment,new CalendarFragment()).commit();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.MainFragment,new CalendarFragment()).commit();
                    break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.MainFragment,new CalendarFragment()).commit();
                    break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onClick(View view) {

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