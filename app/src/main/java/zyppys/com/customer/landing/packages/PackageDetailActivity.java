package zyppys.com.customer.landing.packages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import zyppys.com.customer.R;
import zyppys.com.customer.utils.ItemClickSupport;


public class PackageDetailActivity extends AppCompatActivity {

    public static String EXTRA_PACKAGE_DETAILS = "PackageDetails";
    private RecyclerView mRecyclerView;
    private ArrayList<PackageModel> carsModel;
    private CarsSelectionAdapter mAdapter;
    private PackageModel mPackageModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_detail);
        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        mPackageModel = getIntent().getParcelableExtra(EXTRA_PACKAGE_DETAILS);

        ImageView iv_img = (ImageView)findViewById(R.id.img_package);
        if(mPackageModel != null && mPackageModel.getImgURL() != null) {
            Glide.with(this).load(mPackageModel.getImgURL()).into(iv_img);
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ArrayList<CarsSelectionModel> carsSeectionModelList = getCarsModel();
        mAdapter = new CarsSelectionAdapter(carsSeectionModelList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setSelectedItem(0);
        ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                mAdapter.setSelectedItem(position);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    public ArrayList<CarsSelectionModel> getCarsModel() {
        ArrayList<CarsSelectionModel> carsModel = new ArrayList<>();
        carsModel.add(new CarsSelectionModel(R.drawable.tier_car1,"Tata indica or equivalent"));
        carsModel.add(new CarsSelectionModel(R.drawable.tier_car2,"Toyota Etios or equivalent"));
        carsModel.add(new CarsSelectionModel(R.drawable.tier_car3,"Toyota Innova"));

        return carsModel;
    }
}