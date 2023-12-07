package com.example.prjcompositlistview_nov27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import model.FileManagement;
import model.Player;
import model.PlayerAdapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvPlayers;
    ArrayList<Player> playerList;
    PlayerAdapter playerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        lvPlayers= findViewById(R.id.lvPlayers);
        lvPlayers.setOnItemClickListener(this);
        playerList= FileManagement.readFile(this,"players.txt");
        playerAdapter= new PlayerAdapter(this,playerList);
        lvPlayers.setAdapter(playerAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "the player name: "+playerList.get(position).getFullName(), Toast.LENGTH_LONG).show();


    }
}