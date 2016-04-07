package com.jundat95.woorestaurant.Orders;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.jundat95.woorestaurant.ListOrders.ListOrdersActivity;
import com.jundat95.woorestaurant.ListOrders.ListOrdersOBJ;
import com.jundat95.woorestaurant.R;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private TextView
            orderName,
            orderAddress,
            orderAddress1,
            orderCity,
            orderNote,
            orderPhone,
            orderEmail,
            orderTime,
            orderPriceToltal;

    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Show home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        findID();
        // Get Intent
        Intent getIntent = getIntent();
        ListOrdersOBJ ordersOBJ = (ListOrdersOBJ)getIntent.getSerializableExtra("Order");
        Integer total = 0;
        ArrayList<ItemOrders> list = new ArrayList<ItemOrders>(ordersOBJ.getItemOrders());
        for(int i = 0; i < list.size(); i++){
            String temp = list.get(i).getPrice().split("\\.")[0];
            total += Integer.parseInt(temp);
        }

        orderName.setText(ordersOBJ.getOrderName());
        orderAddress.setText("Add1: "+ordersOBJ.getOrderAddress());
        orderAddress1.setText("Add2: "+ordersOBJ.getOrderAddress1());
        orderCity.setText("City: "+ordersOBJ.getOrderCity());
        orderNote.setText(ordersOBJ.getOrderNote());
        orderPhone.setText("Phone: "+ordersOBJ.getOrderPhone());
        orderEmail.setText("Email: "+ordersOBJ.getOrderEmail());
        orderTime.setText("Date: "+ordersOBJ.getOrderTime());
        orderPriceToltal.setText(""+total+"$");

        OrdersAdapter adapter = new OrdersAdapter(OrdersActivity.this,R.layout.row_orders,ordersOBJ.getItemOrders());
        lvItems.setAdapter(adapter);
    }

    private void findID(){
        orderName = (TextView)findViewById(R.id.orders_name);
        orderAddress = (TextView)findViewById(R.id.orders_address);
        orderAddress1 = (TextView)findViewById(R.id.orders_address1);
        orderCity = (TextView)findViewById(R.id.orders_city);
        orderNote = (TextView)findViewById(R.id.orders_note);
        orderEmail = (TextView)findViewById(R.id.orders_email);
        orderPhone = (TextView)findViewById(R.id.orders_phone);
        orderTime = (TextView)findViewById(R.id.orders_time);
        lvItems = (ListView)findViewById(R.id.listview_items);
        orderPriceToltal = (TextView)findViewById(R.id.orders_price_total);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, ListOrdersActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
