package zyppys.com.customer.landing.packages;

/**
 * Created by Apple on 4/23/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import zyppys.com.customer.R;

public class PackagesListAdapter extends RecyclerView.Adapter<PackagesListAdapter.MyViewHolder> {

    private List<PackageModel> PackageModelsList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tourName, total;
        public ImageView iv_background;

        public MyViewHolder(View view) {
            super(view);
            tourName = (TextView) view.findViewById(R.id.tv_tour_name);
            total = (TextView) view.findViewById(R.id.tv_total);
            iv_background = (ImageView) view.findViewById(R.id.img_package);
        }
    }


    public PackagesListAdapter(List<PackageModel> PackageModelsList, Context ctx) {
        this.PackageModelsList = PackageModelsList;
        this.mContext = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_package, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PackageModel PackageModel = PackageModelsList.get(position);
        Glide.with(mContext).load(PackageModel.getImgURL()).into(holder.iv_background);
        holder.tourName.setText(PackageModel.getName());
        holder.total.setText(PackageModel.getTotalAmt());
    }

    @Override
    public int getItemCount() {
        return PackageModelsList.size();
    }
}
