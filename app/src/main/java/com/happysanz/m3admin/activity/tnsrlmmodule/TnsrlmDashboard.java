package com.happysanz.m3admin.activity.tnsrlmmodule;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.happysanz.m3admin.R;

public class TnsrlmDashboard extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    Context context;
    RelativeLayout pia, mobilizationPlan, tnsrlmStaff, profile, dashBoard;
    Boolean visib = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_tnsrlm);
        toolbar = (Toolbar) findViewById(R.id.activity_toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        initializeNavigationDrawer();
        context = getApplicationContext();
        pia = (RelativeLayout) findViewById(R.id.exp_view);
        pia.setOnClickListener(this);
        mobilizationPlan = (RelativeLayout) findViewById(R.id.pros_layout);
        mobilizationPlan.setOnClickListener(this);
        tnsrlmStaff = (RelativeLayout) findViewById(R.id.user_layout);
        tnsrlmStaff.setOnClickListener(this);
        profile = (RelativeLayout) findViewById(R.id.add_plan_layout);
        profile.setOnClickListener(this);
        dashBoard = (RelativeLayout) findViewById(R.id.dash_layout);
        dashBoard.setOnClickListener(this);

    }

    private void initializeNavigationDrawer() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            public void onDrawerClosed(View view) {

            }

            public void onDrawerOpened(View drawerView) {
//                String userProfileName = PreferenceStorage.getName(getApplicationContext());
//                String url = PreferenceStorage.getUserPicture(ParentDashBoardActivity.this);
//
//                Log.d(TAG, "user name value" + userProfileName);
//                if ((userProfileName != null) && !userProfileName.isEmpty()) {
//                    String[] splitStr = userProfileName.split("\\s+");
//                    navUserProfileName.setText("Hi, " + splitStr[0]);
//                }
//
//                if (((url != null) && !(url.isEmpty())) && !(url.equalsIgnoreCase(mCurrentUserProfileUrl))) {
//                    Log.d(TAG, "image url is " + url);
//                    mCurrentUserProfileUrl = url;
//                    Picasso.with(ParentDashBoardActivity.this).load(url).noPlaceholder().error(R.drawable.ab_logo).into(imgNavProfileImage);
//                }
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        // enable ActionBar app icon to behave as action to toggle nav drawer
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onClick(View view) {
        if (view == pia){
            Intent intent = new Intent(getApplicationContext(), PiaActivity.class);
            startActivity(intent);
        }
        if (view == mobilizationPlan){
            Intent intent = new Intent(getApplicationContext(), MobilizationPlanActivity.class);
            startActivity(intent);
        }
        if (view == tnsrlmStaff){
            Intent intent = new Intent(getApplicationContext(), TnsrlmStaffActivity.class);
            startActivity(intent);
        }
        if (view == profile){
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
        }
        if (view == dashBoard){
            Intent intent = new Intent(getApplicationContext(), TnsrlmDashboard.class);
            startActivity(intent);
        }
    }
}