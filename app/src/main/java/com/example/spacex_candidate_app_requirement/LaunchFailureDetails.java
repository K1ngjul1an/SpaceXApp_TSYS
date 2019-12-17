package com.example.spacex_candidate_app_requirement;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class LaunchFailureDetails implements Parcelable {

    public static final Creator<LaunchFailureDetails> CREATOR = new Creator<LaunchFailureDetails>() {
        @Override
        public LaunchFailureDetails createFromParcel(Parcel parcel) {
            return new LaunchFailureDetails(parcel);
        }

        @Override
        public LaunchFailureDetails[] newArray(int size) {
            return new LaunchFailureDetails[size];
        }
    };

    @SerializedName("time")
    private Integer time=0;

    @SerializedName("altitude")
    private Integer altitude=0;

    @SerializedName("reason")
    private String reason="";

    public LaunchFailureDetails(Integer time, Integer altitude, String reason) {
        this.time = time;
        this.altitude = altitude;
        this.reason = reason;
    }

    public LaunchFailureDetails(Parcel parcel) {
        time = parcel.readInt();
        altitude = parcel.readInt();
        reason = parcel.readString();
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if(altitude == null) {
            dest.writeInt(0);
        }
        else{
            dest.writeInt(altitude);
        }
        if(time == null){
            dest.writeInt(0);
        }
        else{
            dest.writeInt(time);
        }

        if (reason == null){
            dest.writeString("");
        }
        else{
            dest.writeString(reason);
        }
    }
}
