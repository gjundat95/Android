package com.jundat95.woorestaurant.ListProducts.Fragments.Home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jundat95.woorestaurant.ListProducts.ListProductsOBJ;
import com.jundat95.woorestaurant.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ArrayList<ListProductsOBJ> listProductsOBJs = new ArrayList<>();// phai khoi tao vi
    //cai ham onCreateView co adapter no goi thang nay.
    //Ban nen doc qua cai vong doi app va fragment nhe. Nhu vay se hieu.
    private ListView listView;
    private View view;
    private HomeFragmentAdapter adapter;


    public HomeFragment() {
        // Required empty public constructor
    }

    public void setListProductsOBJs(ArrayList<ListProductsOBJ> list){
        this.listProductsOBJs = new ArrayList<ListProductsOBJ>(list);
        //thi tai day ban do du lieu len lít view thoi
        adapter = new HomeFragmentAdapter(getActivity(),R.layout.row_list_products,listProductsOBJs);
        listView = (ListView)view.findViewById(R.id.listview_fragment_home);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home,container,false);
        listView = (ListView)view.findViewById(R.id.listview_fragment_home);
        adapter = new HomeFragmentAdapter(getActivity(),R.layout.row_list_products,listProductsOBJs);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }


}
