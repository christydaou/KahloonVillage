package com.e.kahloon_village;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class frt_pay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frt_pay);
        Bundle b3 = getIntent().getExtras();
        String mID = b3.getString("ID");

        frtpayBackgroundWorker frtpayback = new frtpayBackgroundWorker(this);
        frtpayback.execute(mID);
    }
}
