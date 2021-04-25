package com.e.kahloon_village;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class emp_schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_schedule);
        Bundle b4 = getIntent().getExtras();
        String type = b4.getString("type");
        String mID = b4.getString("ID");
        empscheduleBackgroundWorker empback = new empscheduleBackgroundWorker(this);
        empback.execute(type,mID);
    }
}
