package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
	ListView lv;
	ArrayAdapter aa;
	ArrayList<Note> note;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO implement the Custom ListView
		setContentView(R.layout.activity_second);

		lv = findViewById(R.id.lv);

		Intent intent = getIntent();
		note = new ArrayList<Note>();




		DBHelper dbHelper = new DBHelper(SecondActivity.this);
		note = dbHelper.getAllNotes();

		aa = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, note);
		lv.setAdapter(aa);


	}


}
