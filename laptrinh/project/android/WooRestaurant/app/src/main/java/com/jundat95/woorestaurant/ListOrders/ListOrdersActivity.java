package com.jundat95.woorestaurant.ListOrders;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jundat95.woorestaurant.Library.Config;
import com.jundat95.woorestaurant.Orders.ItemOrders;
import com.jundat95.woorestaurant.Orders.OrdersActivity;
import com.jundat95.woorestaurant.R;
import com.jundat95.woorestaurant.ServiceHandler.ServiceHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListOrdersActivity extends AppCompatActivity {

    private ProgressDialog pDialog;
    private Toolbar toolbar;
    public ListView listViewOrders;
    public ArrayList<ListOrdersOBJ> listOrdersOBJs = new ArrayList<ListOrdersOBJ>();
    public ItemOrders itemOrderses =  new ItemOrders();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_orders);
        // Add toolbar
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Show home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listViewOrders = (ListView)findViewById(R.id.activity_list_orders_lv);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSONWoorestaurant().execute("http://10.0.3.2/woores/wc-api/v2/orders");
            }
        });
        listViewOrders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListOrdersActivity.this,OrdersActivity.class);
                intent.putExtra("Order",listOrdersOBJs.get(position));
                startActivity(intent);
            }
        });

    }

    public class ReadJSONWoorestaurant extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... params) {
            String url = params[0];
            ServiceHandler handler = new ServiceHandler();
            String fileJSON = handler.makeServiceCall(url,ServiceHandler.GET, Config.getKeyPair());
            return fileJSON;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Hiển thị dialog
            pDialog = new ProgressDialog(ListOrdersActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            // Tắt dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            try{
                JSONObject root = new JSONObject(s);
                JSONArray listOrdersArray = root.getJSONArray("orders");
                for(int i = 0; i < listOrdersArray.length(); i++){

                    // New OBJ
                    ListOrdersOBJ obj = new ListOrdersOBJ();

                    JSONObject listOrders = listOrdersArray.getJSONObject(i);
                    // Get obj
                    obj.setOrderID(listOrders.getInt("order_number"));
                    obj.setOrderNote(listOrders.getString("note"));
                    // Get Time
                    String time = listOrders.getString("completed_at");
                    SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                    SimpleDateFormat output = new SimpleDateFormat("MM/dd/yyyy HH:mm");
                    try {
                        Date date = input.parse(time);
                        obj.setOrderTime(output.format(date));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    // get obj payment_details
                    JSONObject payment_details = listOrders.getJSONObject("payment_details");
                    obj.setOrderPaid(payment_details.getBoolean("paid"));
                    // billing_address
                    JSONObject billing_address = listOrders.getJSONObject("billing_address");
                    obj.setOrderAddress(billing_address.getString("address_1"));
                    obj.setOrderAddress1(billing_address.getString("address_2"));
                    obj.setOrderCity(billing_address.getString("city"));

                    obj.setOrderName(billing_address.getString("first_name") + " " + billing_address.getString("last_name"));
                    obj.setOrderEmail(billing_address.getString("email"));
                    obj.setOrderPhone(billing_address.getString("phone"));
                    // line_items
                    JSONArray line_items_arr = listOrders.getJSONArray("line_items");
                    for(int j = 0; j < line_items_arr.length(); j++){
                        ItemOrders iobj = new ItemOrders();
                        JSONObject line_items = line_items_arr.getJSONObject(j);
                        iobj.setName(line_items.getString("name"));
                        iobj.setPrice(line_items.getString("price"));
                        iobj.setQuantity(line_items.getInt("quantity"));

                        obj.setItemOrders(iobj);
                    }

                    listOrdersOBJs.add(obj);
                }

                ListOrdersAdapter adapter = new ListOrdersAdapter(ListOrdersActivity.this,R.layout.row_list_orders,listOrdersOBJs);
                listViewOrders.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}
