package com.happysanz.m3admin.activity.piamodule;

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
import android.widget.TextView;

import com.happysanz.m3admin.R;

public class PiaDashboard extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    Context context;
    RelativeLayout prospect, user, addPlan, task, tracking, controlPanel, expView, dashBoard;
    TextView scheme, center, project, trade, batch, tradeAndBatch, time;
    LinearLayout subMenu;
    Boolean visib = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_pia);
        toolbar = (Toolbar) findViewById(R.id.activity_toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        initializeNavigationDrawer();
        context = getApplicationContext();
        subMenu = (LinearLayout) findViewById(R.id.sub_menu);
        expView = (RelativeLayout) findViewById(R.id.exp_view);
        expView.setOnClickListener(this);
        prospect = (RelativeLayout) findViewById(R.id.pros_layout);
        prospect.setOnClickListener(this);
        user = (RelativeLayout) findViewById(R.id.user_layout);
        user.setOnClickListener(this);
        addPlan = (RelativeLayout) findViewById(R.id.add_plan_layout);
        addPlan.setOnClickListener(this);
        task = (RelativeLayout) findViewById(R.id.task_layout);
        task.setOnClickListener(this);
        tracking = (RelativeLayout) findViewById(R.id.tracking_layout);
        tracking.setOnClickListener(this);
        controlPanel = (RelativeLayout) findViewById(R.id.control_panel_layout);
        controlPanel.setOnClickListener(this);

        scheme = (TextView) findViewById(R.id.txt_scheme);
        scheme.setOnClickListener(this);
        project = (TextView) findViewById(R.id.txt_project);
        project.setOnClickListener(this);
        center = (TextView) findViewById(R.id.txt_center);
        center.setOnClickListener(this);
        trade = (TextView) findViewById(R.id.txt_trade);
        trade.setOnClickListener(this);
        batch = (TextView) findViewById(R.id.txt_batch);
        batch.setOnClickListener(this);
        tradeAndBatch = (TextView) findViewById(R.id.txt_trade_batch);
        tradeAndBatch.setOnClickListener(this);
        time = (TextView) findViewById(R.id.txt_time);
        time.setOnClickListener(this);

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
        if (view == expView){
            visib = !visib;
            if (visib) {
                subMenu.setVisibility(View.VISIBLE);
            } else {
                subMenu.setVisibility(View.GONE);
            }
        }
        if (view == prospect){
            Intent intent = new Intent(getApplicationContext(), ProspectsActivity.class);
            startActivity(intent);
        }
        if (view == user){
            Intent intent = new Intent(getApplicationContext(), UserActivity.class);
            startActivity(intent);
        }
        if (view == addPlan){
            Intent intent = new Intent(getApplicationContext(), AddPlanActivity.class);
            startActivity(intent);
        }
        if (view == task){
            Intent intent = new Intent(getApplicationContext(), TaskActivity.class);
            startActivity(intent);
        }
        if (view == tracking){
            Intent intent = new Intent(getApplicationContext(), TrackingActivity.class);
            startActivity(intent);
        }
        if (view == controlPanel){
            Intent intent = new Intent(getApplicationContext(), ControlPanelActivity.class);
            startActivity(intent);
        }
        if (view == scheme){
            Intent intent = new Intent(getApplicationContext(), SchemeActivity.class);
            startActivity(intent);
        }
        if (view == center){
            Intent intent = new Intent(getApplicationContext(), CenterActivity.class);
            startActivity(intent);
        }
        if (view == project){
            Intent intent = new Intent(getApplicationContext(), ProjectPlanActivity.class);
            startActivity(intent);
        }
        if (view == trade){
            Intent intent = new Intent(getApplicationContext(), TradeActivity.class);
            startActivity(intent);
        }
        if (view == batch){
            Intent intent = new Intent(getApplicationContext(), BatchActivity.class);
            startActivity(intent);
        }
        if (view == tradeAndBatch){
            Intent intent = new Intent(getApplicationContext(), TradeAndBatchActivity.class);
            startActivity(intent);
        }
        if (view == time){
            Intent intent = new Intent(getApplicationContext(), TimeActivity.class);
            startActivity(intent);
        }
        if (view == dashBoard){
            Intent intent = new Intent(getApplicationContext(), PiaDashboard.class);
            startActivity(intent);
        }
    }
}