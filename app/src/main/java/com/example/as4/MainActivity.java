package com.example.as4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Model_Vote> list = new ArrayList<>();

    TextView Candidate1_text,Candidate2_text,Candidate3_text;
    Button btn_vote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Candidate1_text = findViewById(R.id.candidate1);
        Candidate2_text = findViewById(R.id.candidate2);
        Candidate3_text = findViewById(R.id.candidate3);
        btn_vote = findViewById(R.id.btn_voit);
        ReadVotes();

        btn_vote.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,Second.class);
            startActivity(intent);

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ReadVotes();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ReadVotes();
    }

    private void ReadVotes(){
        int candidate1 = 0;
        int candidate2 = 0;
        int candidate3 = 0;
        for (int i = 0; i< list.size(); i++){
            if (list.get(i).getCandidate().equals("Candidate 1")){
                candidate1++;
            }else if (list.get(i).getCandidate().equals("Candidate 2")){
                candidate2++;
            }else{
                candidate3++;
            }
        }
        Candidate1_text.setText(getResources().getString(R.string.cadidate1)+" "+candidate1);
        Candidate2_text.setText(getResources().getString(R.string.cadidate2)+" "+candidate2);
        Candidate3_text.setText(getResources().getString(R.string.cadidate3)+" "+candidate3);
    }
}