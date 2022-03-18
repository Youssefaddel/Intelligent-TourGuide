package com.modernacademy.Itourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.modernacademy.Itourguide.qrscanner.Activity.QrActivity;

public class Draweractivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    PlacesFragment places;
    FragmentManager fragManager;
    NavigationView navigationView;
    Button btnsignout;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();

        setTitle(R.string.places);
        places = new PlacesFragment();
        fragManager = getSupportFragmentManager();
        fragManager.beginTransaction().replace(R.id.frame,places).commit();
//        item.setChecked(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

     /*   if (savedInstanceState == null) {
            MenuItem item =  navigationView.getMenu().getItem(0);
            onNavigationItemSelected(item);
        } */
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.places) {
//            setTitle(R.string.places);
//            places = new PlacesFragment();
//            fragManager = getSupportFragmentManager();
//            fragManager.beginTransaction().replace(R.id.frame,places).commit();
//            item.setChecked(true);
        } else if (id == R.id.detection) {
            setTitle("Detection");
            startActivity(new Intent(Draweractivity.this,UserActivity.class));
        } else if (id == R.id.logout) {
            setTitle("logout");
            mAuth.signOut();
            startActivity(new Intent(Draweractivity.this,LoginActivity.class));
            finish();
        } else if (id == R.id.Scanner) {
            setTitle("Scanner");
            startActivity(new Intent(Draweractivity.this,QrActivity.class));
        } else if (id == R.id.Map) {
            setTitle("Map");
            location(29.983145,31.282762);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    public static double lat, lng;

    public void location(double latitude,double longitude) {

        lat = latitude;
        lng = longitude;
        String label = "I'm Here!";
        String uriBegin = "geo:" + lat + "," + lng;
        String query = latitude + "," + longitude + "(" + label + ")";
        String encodedQuery = Uri.encode(query);
        String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
        Uri uri = Uri.parse(uriString);
        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW,uri);
        startActivity(mapIntent);
    }


}
