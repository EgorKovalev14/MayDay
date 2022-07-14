package ru.timcock.mayday.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import ru.timcock.mayday.R;

public class TipsActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    BottomNavigationItemView item1,item2,item3,item4, item5;
    ArrayList<BottomNavigationItemView> array = new ArrayList<>();
    ImageView image1, image2, image3, image4, image5, image6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
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
        item5.setChecked(true);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        image1=findViewById(R.id.imageView2);
        image2=findViewById(R.id.imageView3);
        image3=findViewById(R.id.imageView4);
        image4=findViewById(R.id.imageView5);
        image5=findViewById(R.id.imageView6);
        image6=findViewById(R.id.imageView7);
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        image5.setOnClickListener(this);
        image6.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageView2:
                Intent intent = new Intent(this, OvchinnikovActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                break;
            case R.id.imageView3:
                Intent intent1 = new Intent(this,SergeyActivity.class);
                startActivity(intent1);
                overridePendingTransition(0,0);
                break;
            case R.id.imageView4:
                Intent intent2 = new Intent(this, MuskActivity.class);
                startActivity(intent2);
                overridePendingTransition(0,0);
                break;
            case R.id.imageView5:
                Intent intent3 = new Intent(this, IWantActivity.class);
                startActivity(intent3);
                overridePendingTransition(0,0);
                break;
            case R.id.imageView6:
                Intent intent4 = new Intent(this, AntiActivity.class);
                startActivity(intent4);
                overridePendingTransition(0,0);
                break;
            case R.id.imageView7:
                Intent intent5 = new Intent(this, MaterialActivity.class);
                startActivity(intent5);
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
            case R.id.item_4:
                Intent intent3=new Intent(this, NotesActivity.class);
                startActivity(intent3);
                overridePendingTransition(0, 0);
                break;
        }
        return false;
    }
}