
package com.example.tae_user0.asosassignment.model.modelAPI2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FacetValue {

    @SerializedName("Count")
    @Expose
    private Integer Count;
    @SerializedName("Id")
    @Expose
    private String Id;
    @SerializedName("Name")
    @Expose
    private String Name;

    /**
     * 
     * @return
     *     The Count
     */
    public Integer getCount() {
        return Count;
    }

    /**
     * 
     * @param Count
     *     The Count
     */
    public void setCount(Integer Count) {
        this.Count = Count;
    }

    public FacetValue withCount(Integer Count) {
        this.Count = Count;
        return this;
    }

    /**
     * 
     * @return
     *     The Id
     */
    public String getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The Id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    public FacetValue withId(String Id) {
        this.Id = Id;
        return this;
    }

    /**
     * 
     * @return
     *     The Name
     */
    public String getName() {
        return Name;
    }

    /**
     * 
     * @param Name
     *     The Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    public FacetValue withName(String Name) {
        this.Name = Name;
        return this;
    }

}
