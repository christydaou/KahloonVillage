package com.e.kahloon_village;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class frt_restaurant extends AppCompatActivity {
    String mID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frt_restaurant);
        Bundle b4 = getIntent().getExtras();
        mID = b4.getString("ID");
    }

    public void OnCheck1(View view){
        seerestBackgroundWorker srestback = new seerestBackgroundWorker(this);
        srestback.execute(mID);
    }
    public void OnWrite1(View view){
        Intent intent2 = new Intent(getApplicationContext(),write_restaurant.class);
        Bundle b4 = new Bundle();
        b4.putString("ID",mID);
        intent2.putExtras(b4);
        startActivity(intent2);
    }
}
