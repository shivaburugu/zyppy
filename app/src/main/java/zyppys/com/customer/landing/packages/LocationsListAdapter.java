package zyppys.com.customer.landing.packages;

/**
 * Created by Apple on 4/23/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import zyppys.com.customer.R;

public class LocationsListAdapter extends RecyclerView.Adapter<LocationsListAdapter.MyViewHolder> {

    private List<String> locationsList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView locationName;
        public View locationLayout;

        public MyViewHolder(View view) {
            super(view);
            locationName = (TextView) view.findViewById(R.id.location_name);
            locationLayout = view.findViewById(R.id.location_item_layout);
        }
    }


    public LocationsListAdapter(List<String> locationsList, Context ctx) {
        this.locationsList = locationsList;
        this.mContext = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_location_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.locationName.setText(locationsList.get(position));
    }

    @Override
    public int getItemCount() {
        return locationsList.size();
    }
}
