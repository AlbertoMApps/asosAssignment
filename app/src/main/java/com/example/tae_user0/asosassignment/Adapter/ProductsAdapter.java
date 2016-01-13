package com.example.tae_user0.asosassignment.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tae_user0.asosassignment.R;
import com.example.tae_user0.asosassignment.api.itemClickListener2;
import com.example.tae_user0.asosassignment.model.modelAPI2.Listing;
import com.example.tae_user0.asosassignment.model.modelAPI2.ProductsByIDModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by TAE_user0 on 26/12/2015.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private ProductsByIDModel listProductsID;
    private int rowLayout;
    private Context mContext;
    private LayoutInflater inflater;
    private itemClickListener2 clickListener;
    List<Listing> list;

    public ProductsAdapter(ProductsByIDModel listProductsID, int rowLayout, Context context, itemClickListener2 clickListener) {
        this.listProductsID = listProductsID;
        this.rowLayout = rowLayout;
        this.mContext = context;
        this.clickListener = clickListener;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = inflater.inflate(rowLayout, parent, false);
        return new ViewHolder(view, this.clickListener, this);
    }

    @Override
    public void onBindViewHolder(ProductsAdapter.ViewHolder viewHolder, int i) {
        list = listProductsID.getListings();
        //binding the list with the viewholder
        viewHolder.txtPrice.setText(list.get(i).getBasePrice().toString());
        Picasso.with(mContext)
         .load(list.get(i).getProductImageUrl().get(0))
         .resize(100, 100)
         .into(viewHolder.img);
        //innerclass
        View v = new View(mContext);
        viewHolder = new ViewHolder(v, this.clickListener, this);
        viewHolder.onClick(v);
    }



    public int getItemCount() {
        return this.listProductsID==null?0: this.listProductsID.getListings().size();
    }
    public List<Listing> getList(){
       return list;
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView img;
        private TextView txtPrice;
        private ProductsAdapter prodDetails;
        private itemClickListener2 clickListener;

        public ViewHolder(View itemView, itemClickListener2 clickListener, ProductsAdapter prodDetails) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imgProduct);
            txtPrice = (TextView) itemView.findViewById(R.id.txtPrice);
            //prodDetails
            itemView.setOnClickListener(this);
            this.clickListener = clickListener;
            this.prodDetails = prodDetails;//get outer class

        }

        @Override
        public void onClick(View v) {
            //getdapaterPosition could be -1...when you click on the nav bar, so we avoid it
            if(getAdapterPosition()!=-1) {
                String prodID = prodDetails.getList().get(getAdapterPosition()).getProductId().toString();
                clickListener.onClick(v, prodID);
            }
        }
    }
}