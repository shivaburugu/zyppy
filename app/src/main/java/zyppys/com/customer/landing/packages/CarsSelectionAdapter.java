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

public class CarsSelectionAdapter extends RecyclerView.Adapter<CarsSelectionAdapter.MyViewHolder> {

    private List<CarsSelectionModel> carsSelectionModelsList;
    private Context mContext;
    private int mSelectedCar = -1;
    private int previousSelection = -1;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView carName;
        public ImageView iv_car;
        public View cardViewHolder;

        public MyViewHolder(View view) {
            super(view);
            cardViewHolder = view.findViewById(R.id.car_container);
            carName = (TextView) view.findViewById(R.id.car_name);
            iv_car = (ImageView) view.findViewById(R.id.iv_car);
        }
    }

    public void setSelectedItem(int position){
        unSelectPreviousItem(mSelectedCar);
        mSelectedCar = position;
        notifyItemChanged(position);
    }

    public void unSelectPreviousItem(int position){
        previousSelection = position;
        notifyItemChanged(previousSelection);
    }

    public CarsSelectionAdapter(List<CarsSelectionModel> carsSelectionModelsList, Context ctx) {
        this.carsSelectionModelsList = carsSelectionModelsList;
        this.mContext = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_car_selection, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CarsSelectionModel carSelectionModel = carsSelectionModelsList.get(position);
        holder.iv_car.setImageResource(carSelectionModel.getResourceID());
        holder.carName.setText(carSelectionModel.getCarName());
        if(mSelectedCar != -1 && mSelectedCar == position) {
            holder.cardViewHolder.setSelected(true);
            holder.cardViewHolder.setAlpha(1);
        }
        if(previousSelection != -1 && previousSelection == position) {
            holder.cardViewHolder.setSelected(false);
            holder.cardViewHolder.setAlpha(0.2f);
        }
    }

    @Override
    public int getItemCount() {
        return carsSelectionModelsList.size();
    }
}
