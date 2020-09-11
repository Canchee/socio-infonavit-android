package com.iacd.socioinfonavit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LandingBenevits {

    @SerializedName("unlocked")
    private List<Benevits> unlockedBenevits = null;
    @SerializedName("locked")
    private List<Benevits> lockedBenevits = null;

    public List<Benevits> getUnlockedBenevits() {
        return unlockedBenevits;
    }

    public void setUnlockedBenevits(List<Benevits> unlockedBenevits) {
        this.unlockedBenevits = unlockedBenevits;
    }

    public List<Benevits> getLockedBenevits() {
        return lockedBenevits;
    }

    public void setLockedBenevits(List<Benevits> lockedBenevits) {
        this.lockedBenevits = lockedBenevits;
    }
}
