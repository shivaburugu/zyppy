package zyppys.com.customer.landing;


import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import zyppys.com.customer.R;
import zyppys.com.customer.landing.carpool.CarpoolFragment;
import zyppys.com.customer.landing.cars.CarsFragment;
import zyppys.com.customer.landing.hotel.HotelsFragment;
import zyppys.com.customer.landing.packages.PackageFragment;


public class LandingActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener,
        PackageFragment.OnPackageFragmentInteractionListener{


    private View carpoolView,carsView,hotelsView,packageView;
    private CarsFragment mCarsFragment;
    private CarpoolFragment mCarpoolFragment;
    private HotelsFragment mHotelsFragment;
    private PackageFragment mPackageFragment;

    private final String TAG_CARS_FRAGMENT = CarsFragment.class.getSimpleName();
    private final String TAG_CAR_POOL_FRAGMENT = CarpoolFragment.class.getSimpleName();
    private final String TAG_PACKAGE_FRAGMENT = PackageFragment.class.getSimpleName();
    private final String TAG_HOTELS_FRAGMENT = HotelsFragment.class.getSimpleName();

    private String currentFragment = TAG_PACKAGE_FRAGMENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initializeTabs();
        initializeDrawerLayout(toolbar);
        loadDefaultView();
    }

    private void loadDefaultView() {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag(currentFragment);
        if (prev != null) {
            ft.remove(prev);
        }
        PackageFragment packageFragment = new PackageFragment();
        packageFragment.setRetainInstance(false);
        ft.replace(R.id.fragment_container, packageFragment, TAG_PACKAGE_FRAGMENT);
        ft.commit();

    }

    private void initializeDrawerLayout(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initializeTabs(){
        carpoolView = findViewById(R.id.carpool_layout);
        carsView = findViewById(R.id.cars_layout);
        hotelsView = findViewById(R.id.hotels_layout);
        packageView = findViewById(R.id.package_layout);
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
        getMenuInflater().inflate(R.menu.landing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cars_layout:
                showCarsLayout();
                break;
            case R.id.carpool_layout:
                showCarpoolLayout();
                break;
            case R.id.hotels_layout:
                showHotelsLayout();
                break;
            case R.id.package_layout:
                showPackageLayout();
                break;
        }
    }

    private void showCarsLayout(){

    }

    private void showCarpoolLayout(){

    }

    private void showHotelsLayout(){

    }

    private void showPackageLayout(){

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
