package com.example.spacex_candidate_app_requirement;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Rocket implements Parcelable {

    public static final Creator<Rocket> CREATOR = new Creator<Rocket>() {
        @Override
        public Rocket createFromParcel(Parcel parcel) {
            return new Rocket(parcel);
        }

        @Override
        public Rocket[] newArray(int size) {
            return new Rocket[size];
        }
    };

    @SerializedName("rocket")
    private String rocket;

    @SerializedName("rocket_id")
    private String rocketId;

    @SerializedName("rocket_name")
    private String rocketName;

    @SerializedName("rocket_type")
    private String rocketType;

    public Rocket(String rocket, String rocketId, String rocketName, String rocketType) {
        this.rocket = rocket;
        this.rocketId = rocketId;
        this.rocketName = rocketName;
        this.rocketType = rocketType;
    }

    public Rocket(Parcel parcel) {
        rocket = parcel.readString();
        rocketId = parcel.readString();
        rocketName = parcel.readString();
        rocketType = parcel.readString();
    }

    public String getRocketId() {
        return rocketId;
    }

    public String getRocket() {
        return rocket;
    }

    public void setRocket(String rocket) {
        this.rocket = rocket;
    }

    public void setRocketId(String rocketId) {
        this.rocketId = rocketId;
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }

    public String getRocketType() {
        return rocketType;
    }

    public void setRocketType(String rocketType) {
        this.rocketType = rocketType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(rocket);
        dest.writeString(rocketId);
        dest.writeString(rocketName);
        dest.writeString(rocketType);
    }
}
