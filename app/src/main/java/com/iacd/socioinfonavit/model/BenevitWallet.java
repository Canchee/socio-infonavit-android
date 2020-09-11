package com.iacd.socioinfonavit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BenevitWallet {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("display_text")
    private String displayText;
    @SerializedName("icon")
    private String icon;
    @SerializedName("path")
    private String path;
    @SerializedName("primary_color")
    private String primaryColor;
    @SerializedName("secondary_color")
    private String secondaryColor;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("display_index")
    private Integer displayIndex;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("mobile_cover_url")
    private Object mobileCoverURL;
    @SerializedName("desktop_cover_url")
    private Object desktopCoverURL;
    @SerializedName("max_level")
    private Integer maxLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(Integer displayIndex) {
        this.displayIndex = displayIndex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Object getMobileCoverURL() {
        return mobileCoverURL;
    }

    public void setMobileCoverURL(Object mobileCoverURL) {
        this.mobileCoverURL = mobileCoverURL;
    }

    public Object getDesktopCoverURL() {
        return desktopCoverURL;
    }

    public void setDesktopCoverURL(Object desktopCoverURL) {
        this.desktopCoverURL = desktopCoverURL;
    }

    public Integer getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }
}
