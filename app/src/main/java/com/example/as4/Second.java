package com.example.as4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import static com.example.as4.MainActivity.list;

public class Second extends AppCompatActivity {
    EditText getname,getid;
    Spinner spinner ;
    ToggleButton toggleButton ;
    Button btn_save;

    String[] Candidate={"Choose Candidate","Candidate 1","Candidate 2","Candidate 3"};
    String selected="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Vote page");
        getid = findViewById(R.id.get_id);
        getname = findViewById(R.id.get_name);
        spinner = findViewById(R.id.spinner);
        toggleButton = findViewById(R.id.toggle);
        btn_save = findViewById(R.id.btn_save);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Candidate);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    selected="";
                }else{
                    selected=Candidate[i];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = getname.getText().toString().trim();
                String id = getid.getText().toString().trim();
                String toggletext = toggleButton.getText().toString().trim();

                if (name.isEmpty()){
                    Toast.makeText(Second.this, "Write Your Name", Toast.LENGTH_SHORT).show();
                }else if (id.isEmpty()){
                    Toast.makeText(Second.this, "Write your ID", Toast.LENGTH_SHORT).show();
                }else if (selected.isEmpty()){
                    Toast.makeText(Second.this, "Select a Candidate", Toast.LENGTH_SHORT).show();
                }else if (toggletext.equals(getResources().getString(R.string.refuse))){
                    Toast.makeText(Second.this, "Accept the terms", Toast.LENGTH_SHORT).show();
                }else{
                    boolean check=false;
                    for (int i= 0 ; i<list.size();i++){
                        if (id.equals(String.valueOf(list.get(i).getVoter()))){
                            check=true;
                        }
                    }
                    if (check){
                        Toast.makeText(Second.this, "You Can't Vote ", Toast.LENGTH_SHORT).show();
                    }else{

                        Model_Vote model = new Model_Vote(Integer.parseInt(id),selected,name);
                        list.add(model);
                        Toast.makeText(Second.this, "Thank You ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}