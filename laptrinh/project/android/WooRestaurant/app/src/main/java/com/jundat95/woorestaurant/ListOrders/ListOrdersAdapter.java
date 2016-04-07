package com.jundat95.woorestaurant.ListOrders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jundat95.woorestaurant.CustomImageView.ImageConvert;
import com.jundat95.woorestaurant.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jundat95 on 18/03/2016.
 */
public class ListOrdersAdapter extends ArrayAdapter<ListOrdersOBJ> {

    ImageView listordersPhoto;
    TextView listordersID;
    TextView listordersName;
    TextView listordersAddress;
    TextView listordersTime;
    ImageView listordersPaid;


    public ListOrdersAdapter(Context context, int resource, List<ListOrdersOBJ> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get data item for this positon
        ListOrdersOBJ ordersOBJ = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_list_orders,parent,false);
        }
        // Lookup view for data population
        listordersPhoto = (ImageView)convertView.findViewById(R.id.row_list_order_Photo);
        listordersID = (TextView)convertView.findViewById(R.id.row_list_order_ID);
        listordersName = (TextView)convertView.findViewById(R.id.row_list_order_Name);
        listordersAddress = (TextView)convertView.findViewById(R.id.row_list_order_Address);
        listordersTime = (TextView)convertView.findViewById(R.id.row_list_order_Time);
        listordersPaid = (ImageView)convertView.findViewById(R.id.row_list_order_Paid);

        // Populate the data into the template view using the data object
        listordersID.setText("ID Orders: "+ordersOBJ.getOrderID());
        listordersName.setText(ordersOBJ.getOrderName());
        listordersAddress.setText(ordersOBJ.getOrderAddress());
        // Edit Time
        SimpleDateFormat input = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        SimpleDateFormat output = new SimpleDateFormat("HH:mm");
        try {
            Date date = input.parse(ordersOBJ.getOrderTime());
            listordersTime.setText(output.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(ordersOBJ.isOrderPaid()){
            listordersPaid.setImageResource(R.drawable.ok);
        }else{
            listordersPaid.setImageResource(R.drawable.ok);
        }

        // Custom imageview
        Bitmap bitmap = BitmapFactory.decodeResource(convertView.getResources(), R.drawable.wordpress);
        Bitmap imageCirler = ImageConvert.getRoundedCornerBitmap(bitmap,100);
        listordersPhoto.setImageBitmap(imageCirler);

        return convertView;
    }

}
