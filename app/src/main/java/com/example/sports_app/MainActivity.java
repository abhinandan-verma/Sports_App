package com.example.sports_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    //dataSource
    private List<Sport> sportList;
    //Adapter
    private  CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        sportList = new ArrayList<>();

        Sport s1 = new Sport("FootBall",R.drawable.football);
        Sport s2 = new Sport("Cricket",R.drawable.cricket);
        Sport s3 = new Sport("BasketBall",R.drawable.basketball);
        Sport s4 = new Sport("Tennis",R.drawable.tennis);
        Sport s5 = new Sport("Volleyball",R.drawable.volleyball);
        Sport s6 = new Sport("Kabaddi",R.drawable.kabaddi);
        Sport s7 = new Sport("Badminton",R.drawable.badminton);
        sportList.add(s1);
        sportList.add(s2);
        sportList.add(s3);
        sportList.add(s4);
        sportList.add(s5);
        sportList.add(s6);
        sportList.add(s7);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new CustomAdapter(sportList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
    public void  onClick(View v,int pos){
        Toast.makeText(this,
                "you choose "+sportList.get(pos).getSportName(),
                Toast.LENGTH_SHORT).show();
    }


}