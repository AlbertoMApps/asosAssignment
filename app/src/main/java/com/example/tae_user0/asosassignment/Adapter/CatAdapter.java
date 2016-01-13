package com.example.tae_user0.asosassignment.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tae_user0.asosassignment.R;
import com.example.tae_user0.asosassignment.api.itemClickListener;
import com.example.tae_user0.asosassignment.model.modelAPI1.Listing;
import com.example.tae_user0.asosassignment.model.modelAPI1.MainModel;

import java.util.List;

/**
 * Created by TAE_user0 on 20/12/2015.
 */
public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {

    private MainModel menCats;
    private int rowLayout;
    private Context mContext;
    private LayoutInflater inflater;
    private itemClickListener clickListener;
    private List<Listing>list;

    public CatAdapter(MainModel menCats, int rowLayout, Context context, itemClickListener clickListener) {
        this.menCats = menCats;
        this.rowLayout = rowLayout;
        this.mContext = context;
        this.clickListener = clickListener;
        inflater = LayoutInflater.from(context);
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = inflater.inflate(rowLayout, parent, false);
        //view.setOnClickListener(new View.OnClickListener(this) {
        return new ViewHolder(view, clickListener, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        list = menCats.getListing();
        //innerclass
        viewHolder.txtCatName.setText(list.get(i).getName());
        //reference to the innerclass
        View v = new View(mContext);
        viewHolder = new ViewHolder(v, this.clickListener, this);
        viewHolder.onClick(v);
            //catID = list.get(i).getCategoryId();
        //Implementation from another listener to get the information from the list
       // }
//        viewHolder.setClickListener(new itemClickListener() {
//            @Override
//            public void onClick(View view, int catID) {
//                Log.i("Adapter", "position "+catID);

//            }
//        });

        /**Picasso.with(mContext)
                .load(menCat.getImg())
                .resize(100, 100)
                .into(viewHolder.img);**/

    }


    public int getItemCount() {
        return this.menCats==null?0: menCats.getListing().size();
    }

    /**getList to the view and send it to the listener**/
    public List<Listing> getList(){
        return list;
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView img;
        private TextView txtCatName;
        private CatAdapter cat;
        private itemClickListener clickListener;

        public ViewHolder(View itemView, itemClickListener clickListener, CatAdapter cat) {
            super(itemView);
            //img = (ImageView) itemView.findViewById(R.id.img);
            txtCatName = (TextView) itemView.findViewById(R.id.txtCatName);
            itemView.setOnClickListener(this);
            this.clickListener = clickListener;
            //get outer class
            this.cat = cat;
        }

        @Override
        public void onClick(View v) {
            //getdapaterPosition could be -1...when you click on the nav bar, so we avoid it
            if(getAdapterPosition()!=-1) {
                String catID = cat.getList().get(getAdapterPosition()).getCategoryId();
                String catName = cat.getList().get(getAdapterPosition()).getName();
                 //Log.i("catID", catID);
                clickListener.onClick(v, catID, catName);
            }
        }
//        public void setClickListener (itemClickListener clickListener){
//            this.clickListener = clickListener;
//        }
    }
}
