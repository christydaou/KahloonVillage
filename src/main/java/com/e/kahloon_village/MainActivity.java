package com.e.kahloon_village;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText csID, csfName;
    Spinner spinner;
    String cstype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        csID = findViewById(R.id.csFirstName);
        csfName = findViewById(R.id.csLastName);
        spinner = (Spinner) findViewById(R.id.title_entry);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Who_Are_You,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void OnLogin (View view){
        String cs_ID = csID.getText().toString();
        String cs_fName = csfName.getText().toString();

        csBackgroundWorker csback = new csBackgroundWorker(this);
        csback.execute(cstype,cs_ID,cs_fName);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      cstype = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
