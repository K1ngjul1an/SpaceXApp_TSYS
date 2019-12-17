package com.example.spacex_candidate_app_requirement;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PastLaunchesData implements Parcelable {

    public static final Creator<PastLaunchesData> CREATOR = new Creator<PastLaunchesData>() {
        @Override
        public PastLaunchesData createFromParcel(Parcel parcel) {
            return new PastLaunchesData(parcel);
        }

        @Override
        public PastLaunchesData[] newArray(int size) {
            return new PastLaunchesData[size];
        }
    };

    @SerializedName("mission_name")
    private String missionName="";

    @SerializedName("launch_date_local")
    private String launchDateLocal;

    @SerializedName("launch_site")
    private LaunchSite launchSite;

    @SerializedName("links")
    private Links links;

    @SerializedName("flight_number")
    private String flightNumber;

    @SerializedName("launch_year")
    private String launchYear;

    @SerializedName("rocket")
    private Rocket rocketDetail;

    @SerializedName("launch_success")
    private boolean launchSuccess;

    @SerializedName("launch_failure_details")
    private LaunchFailureDetails launchFailureDetails;

    @SerializedName("details")
    private String details;

    public PastLaunchesData(String missionName, String launchDateLocal, LaunchSite launchSite, Links links, Rocket rocketDetail, String flightNumber,
                            String launchYear, boolean launchSuccess, LaunchFailureDetails launchFailureDetails, String details) {
        this.missionName = missionName;
        this.launchDateLocal = launchDateLocal;
        this.launchSite = launchSite;
        this.links = links;
        this.rocketDetail = rocketDetail;
        this.flightNumber = flightNumber;
        this.launchYear = launchYear;
        this.launchSuccess = launchSuccess;
        this.launchFailureDetails = launchFailureDetails;
        this.details = details;
    }

    // constructor used for parcel
    public PastLaunchesData(Parcel parcel) {
        missionName = parcel.readString();
        launchDateLocal = parcel.readString();
        launchSite = parcel.readParcelable(LaunchSite.class.getClassLoader());
        links = parcel.readParcelable(Links.class.getClassLoader());
        rocketDetail = parcel.readParcelable(Rocket.class.getClassLoader());
        flightNumber = parcel.readString();
        launchYear = parcel.readString();
        launchSuccess = parcel.readByte() != 0;
        launchFailureDetails = parcel.readParcelable(LaunchFailureDetails.class.getClassLoader());
        details = parcel.readString();
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public void setLaunchDateLocal(String launchDateLocal) {
        this.launchDateLocal = launchDateLocal;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flighNumber) {
        this.flightNumber = flighNumber;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public Rocket getRocketDetail() {
        return rocketDetail;
    }

    public void setRocketDetail(Rocket rocketDetail) {
        this.rocketDetail = rocketDetail;
    }

    public boolean getLaunchSuccess() {
        return launchSuccess;
    }

    public void setLaunchSuccess(boolean launchSuccess) {
        this.launchSuccess = launchSuccess;
    }

    public LaunchFailureDetails getLaunchFailureDetails() {
        return launchFailureDetails;
    }

    public void setLaunchFailureDetails(LaunchFailureDetails launchFailureDetails) {
        this.launchFailureDetails = launchFailureDetails;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(missionName);
        dest.writeString(launchDateLocal);
        dest.writeParcelable(launchSite, flags);
        dest.writeParcelable(links, flags);
        dest.writeParcelable(rocketDetail, flags);
        dest.writeString(flightNumber);
        dest.writeString(launchYear);
        dest.writeByte((byte) (launchSuccess ? 1 : 0));
        dest.writeParcelable(launchFailureDetails, flags);
        dest.writeString(details);
    }
}
