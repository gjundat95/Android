package com.jundat95.woorestaurant.Orders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jundat95.woorestaurant.R;

import java.util.List;

/**
 * Created by jundat95 on 20/03/2016.
 */
public class OrdersAdapter extends ArrayAdapter<ItemOrders> {

    public OrdersAdapter(Context context, int resource, List<ItemOrders> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemOrders itemOrders = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_orders,parent,false);
        }

        TextView itemSTT = (TextView)convertView.findViewById(R.id.row_order_stt);
        TextView itemName = (TextView)convertView.findViewById(R.id.row_order_name);
        TextView itemPrice = (TextView)convertView.findViewById(R.id.row_order_price);
        TextView itemQuantity = (TextView)convertView.findViewById(R.id.row_order_quantity);

        itemSTT.setText(""+position);
        itemName.setText(itemOrders.getName());
        itemPrice.setText(itemOrders.getPrice()+"$");
        itemQuantity.setText("x"+ itemOrders.getQuantity());

        return convertView;
    }
}
