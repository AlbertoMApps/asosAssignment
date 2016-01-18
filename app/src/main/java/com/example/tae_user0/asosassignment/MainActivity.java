package com.example.tae_user0.asosassignment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.tae_user0.asosassignment.Adapter.CatAdapter;
import com.example.tae_user0.asosassignment.Constants.Constant;
import com.example.tae_user0.asosassignment.Fragments.ProductDetailsFragment;
import com.example.tae_user0.asosassignment.Fragments.ProductsByIDFragment;
import com.example.tae_user0.asosassignment.api.iMensCats;
import com.example.tae_user0.asosassignment.api.iProductDetail;
import com.example.tae_user0.asosassignment.api.iProductsByID;
import com.example.tae_user0.asosassignment.api.iWomenCats;
import com.example.tae_user0.asosassignment.api.itemClickListener;
import com.example.tae_user0.asosassignment.api.itemClickListener2;
import com.example.tae_user0.asosassignment.api.itemClickListener3;
import com.example.tae_user0.asosassignment.model.modelAPI1.Listing;
import com.example.tae_user0.asosassignment.model.modelAPI1.MainModel;
import com.example.tae_user0.asosassignment.model.modelAPI2.ProductsByIDModel;
import com.example.tae_user0.asosassignment.model.modelAPI3.ProductDetailsModel;


import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class  MainActivity extends AppCompatActivity implements itemClickListener, itemClickListener2, itemClickListener3 {
    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private RecyclerView mRecycler;
    private CatAdapter mAdapter;
    private RestAdapter restAdapt;
    private iMensCats menCats;
    private iWomenCats womenCats;
    private iProductsByID productsID;
    private iProductDetail productDetail;
    private itemClickListener itemClickListener;
    private String prodName;
    private String price;
    private int cont;
//    private itemClickListener2 itemClick2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemClickListener = MainActivity.this;
//        itemClick2 = MainActivity.this;
        //restAdapter for the categories men or women API1
        restAdapt = new RestAdapter.Builder()
                .setEndpoint(Constant.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        menCats = restAdapt.create(iMensCats.class);
        womenCats = restAdapt.create(iWomenCats.class);

        //restAdapter for theAPI2,get pproducts by ID of each category
        productsID = restAdapt.create(iProductsByID.class);
        //restAdapter for the API3, get product detail from a productID
        productDetail = restAdapt.create(iProductDetail.class);


        //Set the navigation drawer layout and navigation view

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //Fabric.with(this, new Crashlytics());
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

       // NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
       // navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        //toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.menu);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawerLayout.openDrawer(Gravity.LEFT);
//            }
//        });

            setSupportActionBar(toolbar);

        //actions for the snack bar (predefined)
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Obtain the shared Tracker instance.
//        MyApplication application = (MyApplication) getApplication();
//        Tracker mTracker = application.getGoogleAnalyticsTracker();
//        mTracker.send(new HitBuilders.ScreenViewBuilder().build());


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //Options selected on toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.logo) {
            Toast.makeText(this, "Logo Clicked", Toast.LENGTH_LONG).show();
            return true;
            /*Intent i=new Intent(MainActivity.this,ProductsByIDFragment.class);
             startActivity(i);
             return true;*/
        } else if (id == R.id.wishlist) {
            Toast.makeText(this, "Wishlist Clicked", Toast.LENGTH_LONG).show();
            /**Intent i=new Intent(MainActivity.this,DetailScreen.class);
             startActivity(i);
             return true;**/
        } else if (id == R.id.basket) {
            AlertDialog a = createSingleListDialog();
            a.show();

        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }
//click on man or women btns
     public void btnMen(View view){
        // Toast.makeText(MainActivity.this, "btnMen", Toast.LENGTH_SHORT).show();

         menCats.getCats(new Callback<MainModel>() {

             @Override
             public void success(MainModel mainModel, Response response) {
                 List<Listing> list = mainModel.getListing();
                // for( int i =0; i<list.size();i++){
                 //   Log.i("Main", "list of men" + list.get(i).getName());
                 //}
                 recyclerModel1(mainModel);
             }

             @Override
             public void failure(RetrofitError error) {
                 errorMessage();
             }

         });
     }
    public void btnWomen(View view){
        //Toast.makeText(MainActivity.this, "btnWomen", Toast.LENGTH_SHORT).show();

        womenCats.getCats(new Callback<MainModel>() {


            @Override
            public void success(MainModel mainModel, Response response) {
                recyclerModel1(mainModel);
            }

            @Override
            public void failure(RetrofitError error) {
                errorMessage();
            }
        });
    }
//recycler view for the Main Model in the Navigation Drawer API1. Method called from the btns*****
    public void recyclerModel1(MainModel mainModel){
        //recycler view declaration
        mRecycler = (RecyclerView) findViewById(R.id.list);
        mRecycler.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        mRecycler.setItemAnimator(new DefaultItemAnimator());

        // adapter set into recycler view
        mAdapter = new CatAdapter(mainModel, R.layout.men_women_item, getApplicationContext(), itemClickListener);
        mRecycler.setAdapter(mAdapter);
//        mAdapter.setClickListener(this);
    }

//click on categories to get the categoryID
    @Override
    public void onClick(View v, final String catID, String catName) {
        //Log.i("MainActivity", "item cat position " + catID+ " item cat Name: "+catName );
        //connect to the 1st fragment to send the info
        ArrayList<String>list=getListInforForFragment(catID, catName);
//        ProductsByIDFragment catFragment = ProductsByIDFragment.newInstance(list);
        //fragment products by ID
        final ProductsByIDFragment catFragment = new ProductsByIDFragment();
        catFragment.setCat(list);

        //connect  to the API1 ProductsByID, to get the information depending on ID of category from men or women cats
        productsID.getCatalog(catID, new Callback<ProductsByIDModel>() {
            @Override
            public void success(ProductsByIDModel productsByIDModel, Response response) {
                //String id = catID;
//                for (int i = 0; i < productsByIDModel.getListings().size(); i++) {
//                    int IDprod = productsByIDModel.getListings().get(i).getProductId();
//                    Log.i("main", "produsct id  " + IDprod);
//                }
                //send the second model to the fragment created
                catFragment.setListProducts(productsByIDModel);

                //fragment call
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_products_id, catFragment, "fragment");
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);

            }

            @Override
            public void failure(RetrofitError error) {
                errorMessage();
            }
        });

    }


    //click on the products to get the productId and get the productDetails
    public void onClick(View v, final String productID) {
        //fragment productsDetails
        final ProductDetailsFragment prodFragment = new ProductDetailsFragment();
        //callback to the model to get the productDetails from the productIDDetail
        productDetail.getProductDetail(productID, new Callback<ProductDetailsModel>() {

            @Override
            public void success(ProductDetailsModel productDetailsModel, Response response) {
                //String productIDClicked = productID;
                prodFragment.setProductDetailsModel(productDetailsModel);
                //fragment call
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_products_id, prodFragment, "fragment");
                fragmentTransaction.commit();
            }

            @Override
            public void failure(RetrofitError error) {
                errorMessage();
            }
        });
    }
    //click on the btnAddBag
    @Override
    public void addBagBtn(String prod, String price, int cont) {
        Toast.makeText(this, prod +cont, Toast.LENGTH_SHORT).show();
        this.prodName = prod;
        this.price =price;
        this.cont = cont;
    }

                                        //**********Methods*********//

    //get the list with the info for the secondfragment such as Id per category from category and name of categories of products
    public ArrayList<String> getListInforForFragment(String catID, String catName){
        ArrayList<String> list = new ArrayList<String>();
        if (list.isEmpty()) {
            list.add(catID);
            list.add(catName);
        } else {
            for (int i =0; i < list.size();i++ ){
                list.remove(i);
            }
        }
        return list;
    }
    //error message to display in case there's an error clicking one of the btns
    public void errorMessage(){
        Toast.makeText(MainActivity.this, "failure charging data", Toast.LENGTH_SHORT).show();
    }

    public AlertDialog createSingleListDialog() {
        final CharSequence[] items = {this.prodName +" "+ this.price+","};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cart View")
                .setCancelable(true)
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        items[item]=null;
                        Toast.makeText(getApplicationContext(), "You have deleted : " + items[item], Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        dialog.cancel();
                    }
                })
                .setPositiveButton("Purchase", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // MainActivity.this.finish();
                        Toast.makeText(MainActivity.this, "Purchase selected", Toast.LENGTH_SHORT);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        dialog.cancel();
                    }
                });
         return builder.create();
    }

//click on navigation items

//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }


}


