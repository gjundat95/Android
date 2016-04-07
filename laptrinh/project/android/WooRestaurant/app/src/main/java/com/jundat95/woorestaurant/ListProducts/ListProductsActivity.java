package com.jundat95.woorestaurant.ListProducts;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jundat95.woorestaurant.Library.Config;
import com.jundat95.woorestaurant.ListProducts.Fragments.Dinner.DinnerFragment;
import com.jundat95.woorestaurant.ListProducts.Fragments.Drink.DrinkFragment;
import com.jundat95.woorestaurant.ListProducts.Fragments.Home.HomeFragment;
import com.jundat95.woorestaurant.R;
import com.jundat95.woorestaurant.ServiceHandler.ServiceHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListProductsActivity extends AppCompatActivity {

    private ProgressDialog pDialog;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private ArrayList<ListProductsOBJ> listProductsOBJs = new ArrayList<ListProductsOBJ>();

    // Fragment
    HomeFragment homeFragment = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);
        // Add toolbar
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Show home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Set up Tablayout
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //homeFragment.setListProductsOBJs(listProductsOBJs);
        // Doan nay ban goi cai set list nay k dung
        //vi cai list nay no k co gi. Phai goi no sau khi da extrack json
        viewPagerAdapter.addFragment(homeFragment, "Home");
        viewPagerAdapter.addFragment(new DrinkFragment(),"Drink");
        viewPagerAdapter.addFragment(new DinnerFragment(), "Dinner");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        //ok bay gio ban muon  cho cai list do vao fragment nap

    }

    @Override
    protected void onResume() {
        super.onResume();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSONWooRestaurant().execute("http://10.0.3.2/woores/wc-api/v2/products");
            }
        });
        //lay du lieu tron onResume vi minh phai de co cai app no set up het giao dien
        //roi moi lay du lieu do lai. neu k thi cai nay co thread no ve trc giao dien
        //duoc hien thi len se loi
    }

    public class ReadJSONWooRestaurant extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... params) {

            String url = params[0];
            ServiceHandler handler = new ServiceHandler();
            String FileJSON = handler.makeServiceCall(url,ServiceHandler.GET,Config.getKeyPair());
            return FileJSON;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Hiển thị dialog
            pDialog = new ProgressDialog(ListProductsActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            // Test
            //Toast.makeText(ListProductsActivity.this,s,Toast.LENGTH_SHORT).show();
            // Xu ly file JSON
            try {
                JSONObject root = new JSONObject(s);
                JSONArray arr = root.getJSONArray("products");
                for(int i = 0; i < arr.length(); i++){
                    ListProductsOBJ product = new ListProductsOBJ();
                    JSONObject listProducts = arr.getJSONObject(i);
                    // Get Obj Products
                    product.setId(listProducts.getInt("id"));
                    product.setTitle(listProducts.getString("title"));
                    product.setPrice(listProducts.getString("price"));
                    product.setSale_price(listProducts.getString("sale_price"));
                    product.setDescription(listProducts.getString("description"));
                    product.setAverage_rating(listProducts.getString("average_rating"));
                    product.setRating_count(listProducts.getInt("rating_count"));
                    // Categories
                    JSONArray categories = listProducts.getJSONArray("categories");
                    product.setCategories((String)categories.get(0));
                    // images
                    JSONArray images = listProducts.getJSONArray("images");
                    JSONObject srcImages = images.getJSONObject(0);
                    // Proccesing Image
                    String urlImage = srcImages.getString("src");
                    product.setSrcImage(urlImage);
                    listProductsOBJs.add(product);
                }
                //Toast.makeText(ListProductsActivity.this,listProductsOBJs.size()+"",Toast.LENGTH_LONG).show();
                homeFragment.setListProductsOBJs(listProductsOBJs);
                // Tắt dialog
                if (pDialog.isShowing())
                    pDialog.dismiss();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}

