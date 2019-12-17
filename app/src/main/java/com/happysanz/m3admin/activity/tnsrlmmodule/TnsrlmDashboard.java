package com.happysanz.m3admin.activity.tnsrlmmodule;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.happysanz.m3admin.R;
import com.happysanz.m3admin.activity.loginmodule.ChangePasswordActivity;
import com.happysanz.m3admin.activity.loginmodule.SplashScreenActivity;
import com.happysanz.m3admin.activity.piamodule.PiaProfileActivity;
import com.happysanz.m3admin.activity.piamodule.TaskActivity;
import com.happysanz.m3admin.utils.PreferenceStorage;

public class TnsrlmDashboard extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    Context context;
    RelativeLayout pia, mobilizationPlan, tnsrlmStaff, dashBoard;
    LinearLayout piaTnsrlm, centerTnsrlm, mobilizerTnsrlm, studentsTnsrlm, graph;
    Boolean visib = false;
    boolean doubleBackToExitPressedOnce = false;
    TextView userName;
    private TextView profile, aboutUs, changePassword, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_tnsrlm);
        toolbar = (Toolbar) findViewById(R.id.activity_toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        initializeNavigationDrawer();
        context = getApplicationContext();
        pia = (RelativeLayout) findViewById(R.id.pia_layout);
        pia.setOnClickListener(this);
        mobilizationPlan = (RelativeLayout) findViewById(R.id.mobilization_layout);
        mobilizationPlan.setOnClickListener(this);
        tnsrlmStaff = (RelativeLayout) findViewById(R.id.tnsrlm_layout);
        tnsrlmStaff.setOnClickListener(this);
        profile = findViewById(R.id.user_profile);
        profile.setOnClickListener(this);
        dashBoard = (RelativeLayout) findViewById(R.id.dash_layout);
        dashBoard.setOnClickListener(this);

        logout =  findViewById(R.id.logout);
        logout.setOnClickListener(this);

        piaTnsrlm = findViewById(R.id.tnsrlm_pia_layout);
        piaTnsrlm.setOnClickListener(this);
        centerTnsrlm = findViewById(R.id.tnsrlm_center_layout);
        centerTnsrlm.setOnClickListener(this);
        mobilizerTnsrlm = findViewById(R.id.tnsrlm_mobilizer_layout);
        mobilizerTnsrlm.setOnClickListener(this);
        studentsTnsrlm = findViewById(R.id.tnsrlm_student_layout);
        studentsTnsrlm.setOnClickListener(this);
        graph = findViewById(R.id.graph_layout);
        graph.setOnClickListener(this);


        userName = findViewById(R.id.user_profile_name);
        userName.setText(PreferenceStorage.getUserName(this));

        PreferenceStorage.saveTnsrlmCheck(this,true);

    }

    public void doLogout() {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.edit().clear().commit();
//        TwitterUtil.getInstance().resetTwitterRequestToken();

        Intent homeIntent = new Intent(this, SplashScreenActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        this.finish();
    }

    @Override
    public void onBackPressed() {
        //Checking for fragment count on backstack
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit.", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            super.onBackPressed();
            return;
        }
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
        if (view == aboutUs){
            Intent intent = new Intent(getApplicationContext(), TaskActivity.class);
            startActivity(intent);
        }
        if (view == changePassword){
            Intent intent = new Intent(getApplicationContext(), ChangePasswordActivity.class);
            startActivity(intent);
        }
        if (view == dashBoard){
            Intent intent = new Intent(getApplicationContext(), TnsrlmDashboard.class);
            startActivity(intent);
        }
        if (view == piaTnsrlm){
            Intent intent = new Intent(getApplicationContext(), PiaActivity.class);
            startActivity(intent);
        }
        if (view == centerTnsrlm){
            Intent intent = new Intent(getApplicationContext(), PiaCenterActivity.class);
            startActivity(intent);
        }
        if (view == mobilizerTnsrlm){
            Intent intent = new Intent(getApplicationContext(), PiaMobilizerActivity.class);
            startActivity(intent);
        }
        if (view == studentsTnsrlm){
            Intent intent = new Intent(getApplicationContext(), PiaProspectsActivity.class);
            startActivity(intent);
        }
        if (view == graph){
            Intent intent = new Intent(getApplicationContext(), GraphActivity.class);
            startActivity(intent);
        }
        if (view == logout){
            android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Logout");
            alertDialogBuilder.setMessage("Do you really want to logout?");
            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    SharedPreferences sharedPreferences =
                            PreferenceManager.getDefaultSharedPreferences(context);
                    sharedPreferences.edit().clear().commit();
//        TwitterUtil.getInstance().resetTwitterRequestToken();

                    Intent homeIntent = new Intent(context, SplashScreenActivity.class);
                    homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(homeIntent);
                    finish();
                }
            });
            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialogBuilder.show();
        }

    }
}