package com.iacd.socioinfonavit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Benevits {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("title")
    private String title;
    @SerializedName("instructions")
    private String instructions;
    @SerializedName("expiration_date")
    private String expirationDate;
    @SerializedName("active")
    private boolean active;
    @SerializedName("primary_color")
    private String primaryColor;
    @SerializedName("has_coupons")
    private boolean hasCoupons;
    @SerializedName("vector_file_name")
    private String vectorFileName;
    @SerializedName("vector_full_path")
    private String vectorFullPath;
    @SerializedName("slug")
    private String slug;
    @SerializedName("wallet")
    private BenevitWallet benevitWallet;
    @SerializedName("territories")
    private List<Territories> territories = null;
    @SerializedName("ally")
    private Ally ally;
    @Expose(serialize = false,deserialize = false)
    private Boolean isLocked = true;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public boolean isHasCoupons() {
        return hasCoupons;
    }

    public void setHasCoupons(boolean hasCoupons) {
        this.hasCoupons = hasCoupons;
    }

    public String getVectorFileName() {
        return vectorFileName;
    }

    public void setVectorFileName(String vectorFileName) {
        this.vectorFileName = vectorFileName;
    }

    public String getVectorFullPath() {
        return vectorFullPath;
    }

    public void setVectorFullPath(String vectorFullPath) {
        this.vectorFullPath = vectorFullPath;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public BenevitWallet getBenevitWallet() {
        return benevitWallet;
    }

    public void setBenevitWallet(BenevitWallet benevitWallet) {
        this.benevitWallet = benevitWallet;
    }

    public List<Territories> getTerritories() {
        return territories;
    }

    public void setTerritories(List<Territories> territories) {
        this.territories = territories;
    }

    public Ally getAlly() {
        return ally;
    }

    public void setAlly(Ally ally) {
        this.ally = ally;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }
}
