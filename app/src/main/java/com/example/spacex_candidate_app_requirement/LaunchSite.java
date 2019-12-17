package com.example.spacex_candidate_app_requirement;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class LaunchSite implements Parcelable {

    public static final Creator<LaunchSite> CREATOR = new Creator<LaunchSite>() {
        @Override
        public LaunchSite createFromParcel(Parcel parcel) {
            return new LaunchSite(parcel);
        }

        @Override
        public LaunchSite[] newArray(int size) {
            return new LaunchSite[size];
        }
    };

    @SerializedName("site_id")
    private String siteId;

    @SerializedName("site_name")
    private String siteName;

    @SerializedName("site_name_long")
    private String siteNameLong;

    public LaunchSite(String siteId, String siteName, String siteNameLong) {
        this.siteId = siteId;
        this.siteName = siteName;
        this.siteNameLong = siteNameLong;
    }

    public LaunchSite(Parcel parcel) {
        siteId = parcel.readString();
        siteName = parcel.readString();
        siteNameLong = parcel.readString();
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteNameLong() {
        return siteNameLong;
    }

    public void setSiteNameLong(String siteNameLong) {
        this.siteNameLong = siteNameLong;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(siteId);
        dest.writeString(siteName);
        dest.writeString(siteNameLong);
    }
}
