package com.e.kahloon_village;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class frt_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frt_profile);
        Bundle b1 = getIntent().getExtras();
        String type = b1.getString("type");
        String mID = b1.getString("ID");
        String firstname = b1.getString("FirstName");

        frtprofileBackgroundWorker frtback = new frtprofileBackgroundWorker(this);
        frtback.execute(type,mID,firstname);
    }
}
