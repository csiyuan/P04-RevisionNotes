package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText etNote;
    RadioButton rgStar;
    RadioGroup rgStars;
    Button btnInsertNote, btnShowList;
    ArrayList<Note> aa;

    int requestData = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgStars = findViewById(R.id.radioGroupStars);
        etNote = findViewById(R.id.editTextNote);
        btnInsertNote = findViewById(R.id.buttonInsertNote);
        btnShowList = findViewById(R.id.buttonShowList);
//      btnShowGood = findViewById(R.id.buttonShowGood);

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        btnInsertNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rgStar = (RadioButton) findViewById(rgStars.getCheckedRadioButtonId());
                DBHelper db = new DBHelper(MainActivity.this);
                if (Integer.valueOf(rgStar.getText().toString()) > 0 && !etNote.getText().toString().isEmpty()) {

                    db.insertNote(etNote.getText().toString().trim(), Integer.valueOf(rgStar.getText().toString()));
                    Toast.makeText(MainActivity.this,"Inserted", Toast.LENGTH_LONG).show();

                    Log.d("Insert Database", "added into database");
                } else
                    Log.d("Insert Database", "Failed to insert, no value entries");
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, SecondActivity.class);
              //  intent.putExtra("good", false);
                startActivity(intent);
            }
        });
    }


}
