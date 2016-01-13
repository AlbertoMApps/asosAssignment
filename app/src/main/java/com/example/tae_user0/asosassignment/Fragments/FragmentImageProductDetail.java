package com.example.tae_user0.asosassignment.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tae_user0.asosassignment.R;
import com.squareup.picasso.Picasso;

/**
 * Created by TAE_user0 on 05/01/2016.
 */
public class FragmentImageProductDetail extends Fragment {
    String imagesURL;
    public FragmentImageProductDetail() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_slides, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgProductDetails);
        Picasso.with(getActivity()).load(this.getImagesList()).resize(350,150).centerCrop().into(imageView);
        return view;
    }

    //**Extra methods**/
    public void setImagesList(String s) {
        this.imagesURL =s;
    }
    public String getImagesList (){
        return imagesURL;
    }
}
