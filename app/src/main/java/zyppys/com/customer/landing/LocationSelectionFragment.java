package zyppys.com.customer.landing;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import zyppys.com.customer.R;
import zyppys.com.customer.landing.packages.LocationsListAdapter;
import zyppys.com.customer.utils.ItemClickSupport;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnLocationSelected} interface
 * to handle interaction events.
 * Use the {@link LocationSelectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LocationSelectionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnLocationSelected mListener;

    private RecyclerView mRecyclerView;
    private LocationsListAdapter mAdapter;
    public LocationSelectionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LocationSelectionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LocationSelectionFragment newInstance(String param1, String param2) {
        LocationSelectionFragment fragment = new LocationSelectionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_location_selection, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        final ArrayList<String> locationsList = getLocationsList();
        mAdapter = new LocationsListAdapter(locationsList, getActivity());
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                if(mListener != null){
                    mListener.OnLocationSelected(locationsList.get(position));
                }
            }
        });
        return view;
    }


    private ArrayList<String> getLocationsList(){
        ArrayList<String> locationList = new ArrayList<>();
        locationList.add("Hyderabad");
        locationList.add("Bangalore");
        locationList.add("Tiruathi");
        locationList.add("Chennai");
        locationList.add("Pune");
        return locationList;
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String locationName) {
        if (mListener != null) {
            mListener.OnLocationSelected(locationName);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLocationSelected) {
            mListener = (OnLocationSelected) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnLocationSelected");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnLocationSelected {
        // TODO: Update argument type and name
        void OnLocationSelected(String locationName);
    }
}
