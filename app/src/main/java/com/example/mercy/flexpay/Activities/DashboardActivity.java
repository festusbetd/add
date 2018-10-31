package com.example.mercy.flexpay.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mercy.flexpay.R;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_home) {
            Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_wallet) {
            Intent walletIntent = new Intent(DashboardActivity.this,walletActivity.class);
            startActivity(walletIntent);
            Toast.makeText(this, "Wallet Clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.nav_goals) {
            Intent goalsIntent = new Intent(DashboardActivity.this,GoalsActivity.class);
            startActivity(goalsIntent);
            Toast.makeText(this, "Goals Clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.nav_booking) {
            Intent bookingIntent = new Intent(DashboardActivity.this,BookingActivity.class);
            startActivity(bookingIntent);
            Toast.makeText(this, "Booking Clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.nav_deals) {
            Intent dealsIntent = new Intent(DashboardActivity.this,DealsActivity.class);
            startActivity(dealsIntent);
            Toast.makeText(this, "Deals Clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.nav_profile) {
            Intent dealsIntent = new Intent(DashboardActivity.this,DealsActivity.class);
            startActivity(dealsIntent);
            Toast.makeText(this, "Profile Clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
