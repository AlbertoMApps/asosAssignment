package com.example.tae_user0.asosassignment.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.tae_user0.asosassignment.Fragments.FragmentImageProductDetail;
import com.example.tae_user0.asosassignment.model.modelAPI3.ProductDetailsModel;

import java.util.List;

/**
 * Created by TAE_user0 on 05/01/2016.
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private ProductDetailsModel productModel;

    public ScreenSlidePagerAdapter(FragmentManager fm, ProductDetailsModel productModel) {
        super(fm);
        this.productModel = productModel;
    }


    @Override
    public Fragment getItem(int position) {
        FragmentImageProductDetail fipd =  new FragmentImageProductDetail();
        fipd.setImagesList(getListImages().get(position).toString());
        return fipd;
    }

    @Override
    public int getCount() {
        return getListImages().size();
    }
    public List<String> getListImages(){
        return this.productModel.getProductImageUrls();
    }
}
