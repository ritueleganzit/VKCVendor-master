package com.eleganzit.vkcvendor;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eleganzit.vkcvendor.fragment.CompletedPoFragment;
import com.eleganzit.vkcvendor.fragment.EntryFragment;
import com.eleganzit.vkcvendor.fragment.MarkPOFragment;
import com.eleganzit.vkcvendor.fragment.PlanFragment;
import com.eleganzit.vkcvendor.fragment.ViewDefectsFragment;
import com.eleganzit.vkcvendor.util.UserLoggedInSession;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    UserLoggedInSession userLoggedInSession;

    TextView plan, entry, textTitle, tv_defects;
    LinearLayout tablayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        textTitle = findViewById(R.id.textTitle);
        tv_defects = findViewById(R.id.tv_defects);
        plan = findViewById(R.id.plan);
        tablayout = findViewById(R.id.tablayout);
        entry = findViewById(R.id.entry);
        setSupportActionBar(toolbar);
        userLoggedInSession = new UserLoggedInSession(HomeActivity.this);

        getSupportActionBar().setElevation(0);
        toolbar.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlanFragment myPhotosFragment = new PlanFragment();
                getSupportFragmentManager().beginTransaction()
                        .addToBackStack("HomeActivity")
                        .replace(R.id.container, myPhotosFragment, "TAG")
                        .commit();
            }
        });
        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EntryFragment myPhotosFragment = new EntryFragment();
                getSupportFragmentManager().beginTransaction()
                        .addToBackStack("HomeActivity")
                        .replace(R.id.container, myPhotosFragment, "TAG")
                        .commit();
            }
        });
        tv_defects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDefectsFragment myPhotosFragment = new ViewDefectsFragment();
                getSupportFragmentManager().beginTransaction()
                        .addToBackStack("HomeActivity")
                        .replace(R.id.container, myPhotosFragment, "TAG")
                        .commit();
            }
        });
        textTitle.setText("HOME");

        tablayout.setVisibility(View.VISIBLE);
        PlanFragment myPhotosFragment = new PlanFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, myPhotosFragment, "TAG")
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            tablayout.setVisibility(View.VISIBLE);
            textTitle.setText("HOME");

            PlanFragment myPhotosFragment = new PlanFragment();
            getSupportFragmentManager().beginTransaction()
                    .addToBackStack("HomeActivity")
                    .replace(R.id.container, myPhotosFragment, "TAG")
                    .commit();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(HomeActivity.this, MessageActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else if (id == R.id.markpo) {
            tablayout.setVisibility(View.GONE);
            textTitle.setText("MARK PO COMPLETE");
            MarkPOFragment myPhotosFragment = new MarkPOFragment();
            getSupportFragmentManager().beginTransaction()
                    .addToBackStack("HomeActivity")
                    .replace(R.id.container, myPhotosFragment, "TAG")
                    .commit();
        } else if (id == R.id.nav_manage) {

            tablayout.setVisibility(View.GONE);
            textTitle.setText("COMPLETED PO");
            CompletedPoFragment myPhotosFragment = new CompletedPoFragment();
            getSupportFragmentManager().beginTransaction()
                    .addToBackStack("HomeActivity")
                    .replace(R.id.container, myPhotosFragment, "TAG")
                    .commit();

        } else if (id == R.id.nav_logout) {
            userLoggedInSession.logoutUser();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
}
