package com.example.tae_user0.asosassignment.Fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tae_user0.asosassignment.Adapter.ScreenSlidePagerAdapter;
import com.example.tae_user0.asosassignment.R;
import com.example.tae_user0.asosassignment.api.itemClickListener3;
import com.example.tae_user0.asosassignment.model.modelAPI3.ProductDetailsModel;

/**
 * Created by TAE_user0 on 26/12/2015.
 */

public class ProductDetailsFragment extends Fragment implements View.OnClickListener {

    private ProductDetailsModel productDetailsModel;
    private TextView txtAddBag;
    private String txtProdName, price;
    private itemClickListener3 click3;
    private int cont ;
   // private RecyclerView recyclerView;
    //private productDetailsAdapter mAdapter;

    public ProductDetailsFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_product_details, container, false);
        this.click3 = (itemClickListener3)getActivity();//instance of the itemClick
        //gridLayoutModel3(getProductDetailsModel(), rootView);

        // Instantiate a ViewPager and a PagerAdapter.
        ViewPager mPager = (ViewPager)rootView.findViewById(R.id.pager);
        ScreenSlidePagerAdapter mPagerAdapter = new ScreenSlidePagerAdapter(getActivity().getSupportFragmentManager(), getProductDetailsModel());
        mPager.setAdapter(mPagerAdapter);

        TextView txtTitle = (TextView) rootView.findViewById(R.id.txtTitle);
        TextView txtStock = (TextView) rootView.findViewById(R.id.txtStock);
        TextView txtSet = (TextView) rootView.findViewById(R.id.txtSet);
        TextView txtAddInfo = (TextView) rootView.findViewById(R.id.txtAddInfo);
        txtAddBag = (TextView) rootView.findViewById(R.id.btnAddBag);
        //Initialization of strings that we are going to reuse, like prodTitle and produPrice
        this.txtProdName = this.getProductDetailsModel().getTitle();
        this.price = this.getProductDetailsModel().getCurrentPrice();
        txtTitle.setText(txtProdName);
        if( this.getProductDetailsModel().getInStock())
            txtStock.setText("In Stock");
        else
            txtStock.setText("Not in Stock");
        if( this.getProductDetailsModel().getIsInSet())
            txtSet.setText("In set");
        else
            txtSet.setText("Not in set");
        txtAddInfo.setText(this.getProductDetailsModel().getAdditionalInfo());
        txtAddBag.setText("Add to bag " + price);
        txtAddBag.setOnClickListener((View.OnClickListener) this);

        return rootView;
    }


    //grid view for the Details of Products Model in the Fragment API3.
    /**public void gridLayoutModel3(ProductDetailsModel productDetailsModel, View v){
        //grid view declaration
        //ProductDetailsModel detailsModel = this.getProductDetailsModel();
        recyclerView = (RecyclerView) v.findViewById(R.id.listDetails);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(),2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // adapter set into recycler view
        mAdapter = new productDetailsAdapter(productDetailsModel, R.layout.details_item, getActivity().getApplicationContext());
        recyclerView.setAdapter(mAdapter);
    }**/

    //methods to set and get the product Id
    public void setProductDetailsModel(ProductDetailsModel productDetailsModel){
        this.productDetailsModel= productDetailsModel;
    }
    public ProductDetailsModel getProductDetailsModel(){
        return this.productDetailsModel;
    }
//    public void setClick3(itemClickListener3 click3){
//        this.click3=click3;
//    }

    @Override
    public void onClick(View v) {
        //setClick3( );
        cont++;
        this.click3.addBagBtn(this.txtProdName, this.price, cont);
        //Toast.makeText(getContext(), "Button Add bag clicked", Toast.LENGTH_SHORT).show();
    }
}
