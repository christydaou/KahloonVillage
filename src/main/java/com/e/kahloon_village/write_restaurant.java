package com.e.kahloon_village;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class write_restaurant extends AppCompatActivity {
    String mID,type;
    EditText clientID,tableZone,tablePlace,restID,requestTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_restaurant);
        Bundle b5 = getIntent().getExtras();
        tableZone = findViewById(R.id.editText4);
        clientID = findViewById(R.id.editText);
        restID = findViewById(R.id.editText2);
        requestTime = findViewById(R.id.editText3);
        tablePlace = findViewById(R.id.editText5);

        mID = b5.getString("ID");
    }
    public void OnAdd1(View view){
        String mclientID = clientID.getText().toString();
        String mtableZone = tableZone.getText().toString();
        String mtablePlace = tablePlace.getText().toString();
        String mrestID = restID.getText().toString();
        String mrequestTime = requestTime.getText().toString();

        writerestBackgroundWorker wrbback = new writerestBackgroundWorker(this);
        wrbback.execute(mclientID,mID,mrestID,mtableZone,mtablePlace,mrequestTime);
    }
}
