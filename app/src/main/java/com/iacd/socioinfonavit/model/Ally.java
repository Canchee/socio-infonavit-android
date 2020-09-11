package com.iacd.socioinfonavit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ally {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("slug")
    private String slug;
    @SerializedName("mini_logo_file_name")
    private String miniLogoFileName;
    @SerializedName("mini_logo_full_path")
    private String miniLogoFullPath;

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getMiniLogoFileName() {
        return miniLogoFileName;
    }

    public void setMiniLogoFileName(String miniLogoFileName) {
        this.miniLogoFileName = miniLogoFileName;
    }

    public String getMiniLogoFullPath() {
        return miniLogoFullPath;
    }

    public void setMiniLogoFullPath(String miniLogoFullPath) {
        this.miniLogoFullPath = miniLogoFullPath;
    }
}
