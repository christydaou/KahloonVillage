package com.e.kahloon_village;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class write_bungalow extends AppCompatActivity {
    String mID,type;
    EditText clientID,checkOut,checkIn,bungalowID,availability,rentingdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_bungalow);
        Bundle b2 = getIntent().getExtras();
        checkOut = findViewById(R.id.editText10);
        clientID = findViewById(R.id.editText9);
        bungalowID = findViewById(R.id.editText13);
        checkIn = findViewById(R.id.editText11);
        availability = findViewById(R.id.editText12);
        rentingdate = findViewById(R.id.editText14);
        mID = b2.getString("ID");
    }
    public void OnAdd(View view){
        String mclientID = clientID.getText().toString();
        String mcheckOut = checkOut.getText().toString();
        String mcheckIn = checkIn.getText().toString();
        String mbungalowID = bungalowID.getText().toString();
        String mavailable = availability.getText().toString();
        String mrentingdate = rentingdate.getText().toString();
        writebungBackgroundWorker wrbback = new writebungBackgroundWorker(this);
        wrbback.execute(mclientID,mID,mbungalowID,mcheckIn,mcheckOut,mavailable,mrentingdate);
    }
}
