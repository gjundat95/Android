package com.jundat95.woorestaurant.ListProducts.Fragments.Dinner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jundat95.woorestaurant.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DinnerFragment extends Fragment {


    public DinnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dinner, container, false);
    }


}
