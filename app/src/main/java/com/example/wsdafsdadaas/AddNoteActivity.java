package com.example.wsdafsdadaas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNoteActivity extends Activity implements View.OnClickListener {

    //widges
    private Button addTodobtn;
    private EditText subjectEditText;
    private EditText descEditText;
    private DBmanager dBmanager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Record");
        setContentView(R.layout.activity_add_country);

        subjectEditText= findViewById(R.id.subject_editText);
        descEditText= findViewById(R.id.description_editText);
        addTodobtn= findViewById(R.id.add_record);

        dBmanager= new DBmanager(this);
        dBmanager.open();
        addTodobtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_record:
                final String name= subjectEditText.getText().toString();
                final String desc= descEditText.getText().toString();

                dBmanager.insert(name, desc);

                Intent main=new Intent(AddNoteActivity.this,
                        MainActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);


        }
    }
}