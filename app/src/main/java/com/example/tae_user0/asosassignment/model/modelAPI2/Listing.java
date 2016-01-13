
package com.example.tae_user0.asosassignment.model.modelAPI2;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Listing {

    @SerializedName("BasePrice")
    @Expose
    private Double BasePrice;
    @SerializedName("Brand")
    @Expose
    private String Brand;
    @SerializedName("CurrentPrice")
    @Expose
    private String CurrentPrice;
    @SerializedName("HasMoreColours")
    @Expose
    private Boolean HasMoreColours;
    @SerializedName("IsInSet")
    @Expose
    private Boolean IsInSet;
    @SerializedName("PreviousPrice")
    @Expose
    private String PreviousPrice;
    @SerializedName("ProductId")
    @Expose
    private Integer ProductId;
    @SerializedName("ProductImageUrl")
    @Expose
    private List<String> ProductImageUrl = new ArrayList<String>();
    @SerializedName("RRP")
    @Expose
    private String RRP;
    @SerializedName("Title")
    @Expose
    private String Title;

    /**
     * 
     * @return
     *     The BasePrice
     */
    public Double getBasePrice() {
        return BasePrice;
    }

    /**
     * 
     * @param BasePrice
     *     The BasePrice
     */
    public void setBasePrice(Double BasePrice) {
        this.BasePrice = BasePrice;
    }

    public Listing withBasePrice(Double BasePrice) {
        this.BasePrice = BasePrice;
        return this;
    }

    /**
     * 
     * @return
     *     The Brand
     */
    public String getBrand() {
        return Brand;
    }

    /**
     * 
     * @param Brand
     *     The Brand
     */
    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public Listing withBrand(String Brand) {
        this.Brand = Brand;
        return this;
    }

    /**
     * 
     * @return
     *     The CurrentPrice
     */
    public String getCurrentPrice() {
        return CurrentPrice;
    }

    /**
     * 
     * @param CurrentPrice
     *     The CurrentPrice
     */
    public void setCurrentPrice(String CurrentPrice) {
        this.CurrentPrice = CurrentPrice;
    }

    public Listing withCurrentPrice(String CurrentPrice) {
        this.CurrentPrice = CurrentPrice;
        return this;
    }

    /**
     * 
     * @return
     *     The HasMoreColours
     */
    public Boolean getHasMoreColours() {
        return HasMoreColours;
    }

    /**
     * 
     * @param HasMoreColours
     *     The HasMoreColours
     */
    public void setHasMoreColours(Boolean HasMoreColours) {
        this.HasMoreColours = HasMoreColours;
    }

    public Listing withHasMoreColours(Boolean HasMoreColours) {
        this.HasMoreColours = HasMoreColours;
        return this;
    }

    /**
     * 
     * @return
     *     The IsInSet
     */
    public Boolean getIsInSet() {
        return IsInSet;
    }

    /**
     * 
     * @param IsInSet
     *     The IsInSet
     */
    public void setIsInSet(Boolean IsInSet) {
        this.IsInSet = IsInSet;
    }

    public Listing withIsInSet(Boolean IsInSet) {
        this.IsInSet = IsInSet;
        return this;
    }

    /**
     * 
     * @return
     *     The PreviousPrice
     */
    public String getPreviousPrice() {
        return PreviousPrice;
    }

    /**
     * 
     * @param PreviousPrice
     *     The PreviousPrice
     */
    public void setPreviousPrice(String PreviousPrice) {
        this.PreviousPrice = PreviousPrice;
    }

    public Listing withPreviousPrice(String PreviousPrice) {
        this.PreviousPrice = PreviousPrice;
        return this;
    }

    /**
     * 
     * @return
     *     The ProductId
     */
    public Integer getProductId() {
        return ProductId;
    }

    /**
     * 
     * @param ProductId
     *     The ProductId
     */
    public void setProductId(Integer ProductId) {
        this.ProductId = ProductId;
    }

    public Listing withProductId(Integer ProductId) {
        this.ProductId = ProductId;
        return this;
    }

    /**
     * 
     * @return
     *     The ProductImageUrl
     */
    public List<String> getProductImageUrl() {
        return ProductImageUrl;
    }

    /**
     * 
     * @param ProductImageUrl
     *     The ProductImageUrl
     */
    public void setProductImageUrl(List<String> ProductImageUrl) {
        this.ProductImageUrl = ProductImageUrl;
    }

    public Listing withProductImageUrl(List<String> ProductImageUrl) {
        this.ProductImageUrl = ProductImageUrl;
        return this;
    }

    /**
     * 
     * @return
     *     The RRP
     */
    public String getRRP() {
        return RRP;
    }

    /**
     * 
     * @param RRP
     *     The RRP
     */
    public void setRRP(String RRP) {
        this.RRP = RRP;
    }

    public Listing withRRP(String RRP) {
        this.RRP = RRP;
        return this;
    }

    /**
     * 
     * @return
     *     The Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * 
     * @param Title
     *     The Title
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    public Listing withTitle(String Title) {
        this.Title = Title;
        return this;
    }

}
