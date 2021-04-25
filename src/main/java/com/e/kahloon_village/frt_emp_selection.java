package com.e.kahloon_village;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class frt_emp_selection extends AppCompatActivity {
    String mID,type;
    EditText eventID,place,empid,dates,emptype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frt_emp_selection);
        Bundle b2 = getIntent().getExtras();
        eventID = findViewById(R.id.editText4);
        place = findViewById(R.id.editText);
        emptype = findViewById(R.id.editText2);
        empid = findViewById(R.id.editText3);
        dates = findViewById(R.id.editText5);

        mID = b2.getString("ID");


    }

    public void OnAdd(View view){
        String meventID = eventID.getText().toString();
        String mplace = place.getText().toString();
        String mempid = empid.getText().toString();
        String mdates = dates.getText().toString();
        String mempType = emptype.getText().toString();
        selectionBackgroundWorker slcback = new selectionBackgroundWorker(this);
        slcback.execute(mplace,mID,meventID,mempid,mdates,mempType);
    }

}
