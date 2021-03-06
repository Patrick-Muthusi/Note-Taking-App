package com.example.wsdafsdadaas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifyNotes extends Activity implements View.OnClickListener {

    private EditText titleText;
    private Button updateBtn, deleteBtn;
    private EditText descText;

    private Long _id;
    private DBmanager dBmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Modify Record");
        setContentView(R.layout.activity_modify_country);

        dBmanager= new DBmanager(this);
        dBmanager.open();

        titleText=findViewById(R.id.subject_editText);
        descText=findViewById(R.id.description_editText);
        updateBtn=findViewById(R.id.btn_update);
        deleteBtn= findViewById(R.id.btn_delete);

        Intent intent= getIntent();
        String id=intent.getStringExtra("id");
        String name=intent.getStringExtra("title");
        String desc= intent.getStringExtra("desc");

        _id= Long.parseLong(id);

        titleText.setText(name);
        descText.setText(desc);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_update:
                String title=titleText.getText().toString();
                String desc= descText.getText().toString();
                dBmanager.update(_id, title, desc);
                this.returnHome();
                break;

            case R.id.btn_delete:
                dBmanager.delete(_id);
                this.returnHome();
                break;
        }
    }

    public void returnHome(){
        Intent home_intent= new Intent(getApplicationContext(),
                MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);

    }
}