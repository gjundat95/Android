package com.jundat95.woorestaurant.ListProducts.Fragments.Home;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jundat95.woorestaurant.ListProducts.ListProductsDB;
import com.jundat95.woorestaurant.ListProducts.ListProductsOBJ;
import com.jundat95.woorestaurant.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jundat95 on 28/03/2016.
 */
public class HomeFragmentAdapter extends ArrayAdapter<ListProductsOBJ> {

    private ProgressDialog pDialog;
    private ListProductsDB listDBs = new ListProductsDB();

    //ViewHolder
    private static class ViewHolder{

        LinearLayout linearLayout;
        TextView title;
        TextView description;
        TextView price;
        TextView sale_price;
        TextView average_rating;
        TextView rating_count;
        ImageButton imageButton;
        ImageView image;
    }

    public HomeFragmentAdapter(Context context, int resource, List<ListProductsOBJ> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ListProductsOBJ listProductsOBJ = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_list_products,parent,false);
        }

        // Find ID
        final ViewHolder viewHolder = new ViewHolder();
        viewHolder.linearLayout = (LinearLayout)convertView.findViewById(R.id.row_list_product_linearlayout);
        viewHolder.title = (TextView)convertView.findViewById(R.id.row_list_product_title);
        viewHolder.description = (TextView)convertView.findViewById(R.id.row_list_product_description);
        viewHolder.price = (TextView)convertView.findViewById(R.id.row_list_product_price);
        viewHolder.sale_price = (TextView)convertView.findViewById(R.id.row_list_product_sale);
        viewHolder.image = (ImageView)convertView.findViewById(R.id.row_list_product_image);
        viewHolder.imageButton = (ImageButton)convertView.findViewById(R.id.row_list_product_addcart);

        // Set Values
        viewHolder.title.setText(listProductsOBJ.getTitle());
        viewHolder.description.setText(listProductsOBJ.getDescription());
        viewHolder.price.setText(listProductsOBJ.getPrice());
        viewHolder.sale_price.setText(listProductsOBJ.getSale_price());

        // Set Image
        if(viewHolder.image != null){
            if(listProductsOBJ.getSrcImage() != null){
                Picasso.with(convertView.getContext())
                        .load(listProductsOBJ.getSrcImage().replaceAll("localhost","10.0.3.2"))
                        .resize(200,150)
                        .centerCrop()
                        .into(viewHolder.image);
            }
        }
        viewHolder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listDBs.addDbs(listProductsOBJ);
                Log.d(null,listDBs.getDbs().size()+"");
            }
        });

        return convertView;
    }

}

