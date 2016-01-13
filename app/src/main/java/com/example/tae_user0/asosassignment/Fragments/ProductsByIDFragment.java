package com.example.tae_user0.asosassignment.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tae_user0.asosassignment.Adapter.ProductsAdapter;
import com.example.tae_user0.asosassignment.R;
import com.example.tae_user0.asosassignment.api.itemClickListener2;
import com.example.tae_user0.asosassignment.model.modelAPI2.ProductsByIDModel;

import java.util.ArrayList;

public class ProductsByIDFragment extends Fragment {
    private ArrayList<String> catsInfo;
    private ProductsByIDModel productsByIDModel;
    private RecyclerView recyclerView;
    private ProductsAdapter mAdapter;
    private itemClickListener2 itemClickListener;

    public ProductsByIDFragment(){

    }
/*** get a new instance to get the mainModel from the main***/
//    public static ProductsByIDFragment newInstance(ArrayList catsInfo) {
//        Log.i("main", " Info "+catsInfo.get(0));
//        Bundle bundle = new Bundle();
//        bundle.putParcelableArrayList("listCatsInfo", catsInfo);
//        ProductsByIDFragment f = new ProductsByIDFragment();
//        f.setArguments(bundle);
//        return f;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //gridLayoutModel2(getProductsByIDModel());
        itemClickListener = (itemClickListener2) getActivity();

    }

    public void setCat(ArrayList<String> cat){
        this.catsInfo = cat;
    }
    public void setListProducts(ProductsByIDModel productsByIDModel){this.productsByIDModel=productsByIDModel;}
    public ProductsByIDModel getProductsByIDModel() { return  productsByIDModel;}

    //grid view for the Products Model in the Fragment API2.
    public void gridLayoutModel2(ProductsByIDModel productsModel, View v){
        //grid view declaration
        ProductsByIDModel productsID = getProductsByIDModel();
        recyclerView = (RecyclerView) v.findViewById(R.id.listProducts);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(),2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // adapter set into recycler view
        mAdapter = new ProductsAdapter(productsID, R.layout.products_item, getActivity().getApplicationContext(),itemClickListener );
        recyclerView.setAdapter(mAdapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products_id, container, false);
//        ArrayList list = (ArrayList)getArguments().getParcelableArrayList("listCatsInfo");
        TextView catName = (TextView) view.findViewById(R.id.txtCategory);
        gridLayoutModel2(getProductsByIDModel(), view);
        //Log.i("MAIN", " list of cats " + catsInfo.get(1));
        catName.setText(catsInfo.get(1));
        return view;
    }

}
