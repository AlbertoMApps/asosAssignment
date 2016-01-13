
package com.example.tae_user0.asosassignment.model.modelAPI1;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MainModel implements Parcelable{

    @SerializedName("Description")
    @Expose
    private String Description;
    @SerializedName("Listing")
    @Expose
    private List<Listing> Listing = new ArrayList<Listing>();
    @SerializedName("SortType")
    @Expose
    private String SortType;

    protected MainModel(Parcel in) {
        Description = in.readString();
        Listing = in.createTypedArrayList(com.example.tae_user0.asosassignment.model.modelAPI1.Listing.CREATOR);
        SortType = in.readString();
    }

    public static final Creator<MainModel> CREATOR = new Creator<MainModel>() {
        @Override
        public MainModel createFromParcel(Parcel in) {
            return new MainModel(in);
        }

        @Override
        public MainModel[] newArray(int size) {
            return new MainModel[size];
        }
    };

    /**
     * 
     * @return
     *     The Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * 
     * @param Description
     *     The Description
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * 
     * @return
     *     The Listing
     */
    public List<Listing> getListing() {
        return Listing;
    }

    /**
     * 
     * @param Listing
     *     The Listing
     */
    public void setListing(List<Listing> Listing) {
        this.Listing = Listing;
    }

    /**
     * 
     * @return
     *     The SortType
     */
    public String getSortType() {
        return SortType;
    }

    /**
     * 
     * @param SortType
     *     The SortType
     */
    public void setSortType(String SortType) {
        this.SortType = SortType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Description);
        dest.writeTypedList(Listing);
        dest.writeString(SortType);
    }
}
