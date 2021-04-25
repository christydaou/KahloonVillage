package com.e.kahloon_village;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;


public class empTask extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    String mID,firstname,type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_task);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        Bundle b3 = getIntent().getExtras();
        type = b3.getString("type");
        mID = b3.getString("ID");
        firstname = b3.getString("FirstName");
        //text.setText(...)
        TextView tvfawtitle = (TextView) findViewById(R.id.textviewFaqTitle1);
        TextView tvabout =(TextView) findViewById(R.id.textviewabout1);
        TextView tvfaq =(TextView) findViewById(R.id.textviewfaq1);
        TextView tv1 = (TextView) findViewById(R.id.textview3);
        TextView tvabouttitle =(TextView) findViewById(R.id.textviewaboutitle1);
        TextView  tvScroll = (TextView) findViewById(R.id.textview3);
        drawer = findViewById(R.id.drawer_layout1);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_draw_open,R.string.navigation_draw_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        tvfawtitle.setTypeface(null, Typeface.BOLD);
        tvScroll.setTypeface(null, Typeface.BOLD);
        tv1.setSelected(true); //for enabling the text to loop
        tvabouttitle.setTypeface(null,Typeface.BOLD);

        StringBuilder sb1 = new StringBuilder();
        String intro = "This Village idea started out when a couple of people foresaw the demand for a whole new level of confort in Lebanon, they also wanted to tackle the problem related" +
                " to the lack of new user experience technologies that Lebanese people are in need for, so this is where this project began. \nKahloon Village's job is to let our clients feel" +
                "as if they were sitting in their own houses where the services are directly provided when requested \nThe way we care for our clients is by going down to the field " +
                "asking them about information regarding the activity that they wish to see along with their creative ideas to develop the village in the best possible way. \n Welcome Home";
        sb1.append(intro);
        tvabout.setText(sb1.toString());

        StringBuilder sb2 = new StringBuilder();
        String  faq1 = "We are currently located in Nammoura, Lebanon." +
                "\n-Emrgency Hotline #1: 71-111111                               " +
                "\n-Emrgency Hotline #2 : 04-123123                               ";
        sb2.append(faq1);
        tvfaq.setText(sb2.toString());
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.nav_person:
                Intent intent = new Intent(getApplicationContext(),emp_profile.class);
                Bundle b3 = new Bundle();
                b3.putString("type",type);
                b3.putString("ID",mID);
                b3.putString("FirstName",firstname);
                intent.putExtras(b3);
                startActivity(intent);
                break;
            case R.id.nav_schedule:
                Intent intent1 = new Intent(getApplicationContext(),emp_schedule.class);
                Bundle b4 = new Bundle();
                b4.putString("type",type);
                b4.putString("ID",mID);
                intent1.putExtras(b4);
                startActivity(intent1);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
