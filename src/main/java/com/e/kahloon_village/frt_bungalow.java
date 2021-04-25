package com.e.kahloon_village;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class frt_bungalow extends AppCompatActivity {
    String mID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frt_bungalow);
        Bundle b3 = getIntent().getExtras();
       mID = b3.getString("ID");
    }

    public void OnCheck(View view){
        seebungalowBackgroundWorker sbuback = new seebungalowBackgroundWorker(this);
        sbuback.execute(mID);
    }
    public void OnWrite(View view){
        Intent intent2 = new Intent(getApplicationContext(),write_bungalow.class);
        Bundle b4 = new Bundle();
        b4.putString("ID",mID);
        intent2.putExtras(b4);
        startActivity(intent2);
    }
}
