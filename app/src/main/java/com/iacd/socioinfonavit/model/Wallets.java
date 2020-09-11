package com.iacd.socioinfonavit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wallets {
    @SerializedName("id")
    private Integer id;
    @SerializedName("display_index")
    private Integer displayIndex;
    @SerializedName("display_text")
    private String displayText;
    @SerializedName("icon")
    private String icon;
    @SerializedName("path")
    private String path;
    @SerializedName("max_level")
    private Integer maxLevel;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("name")
    private String name;
    @SerializedName("benevit_count")
    private Integer benevitCount;
    @SerializedName("mobile_cover_url")
    private String mobileCoverURL;
    @SerializedName("desktop_cover_url")
    private String desktopCoverURL;
    @SerializedName("member_level")
    private Integer memberLevel;
    @SerializedName("primary_color")
    private String primaryColor;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(Integer displayIndex) {
        this.displayIndex = displayIndex;
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

    public Integer getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBenevitCount() {
        return benevitCount;
    }

    public void setBenevitCount(Integer benevitCount) {
        this.benevitCount = benevitCount;
    }

    public Object getMobileCoverURL() {
        return mobileCoverURL;
    }

    public void setMobileCoverURL(String mobileCoverURL) {
        this.mobileCoverURL = mobileCoverURL;
    }

    public Object getDesktopCoverURL() {
        return desktopCoverURL;
    }

    public void setDesktopCoverURL(String desktopCoverURL) {
        this.desktopCoverURL = desktopCoverURL;
    }

    public Integer getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }
}
