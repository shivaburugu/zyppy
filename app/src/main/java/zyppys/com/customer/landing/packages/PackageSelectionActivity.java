package zyppys.com.customer.landing.packages;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import zyppys.com.customer.R;
import zyppys.com.customer.landing.LocationSelectionFragment;


public class PackageSelectionActivity extends AppCompatActivity implements LocationSelectionFragment.OnLocationSelected,PackageFragment.OnPackageFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_selection);

        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.home);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        LocationSelectionFragment locatoinSelectionFragment = new LocationSelectionFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, locatoinSelectionFragment,LocationSelectionFragment.class.getSimpleName());
        transaction.commit();
    }

    @Override
    public void OnLocationSelected(String locationSelected) {
        PackageFragment packageFragment = new PackageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, packageFragment,LocationSelectionFragment.class.getSimpleName());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
