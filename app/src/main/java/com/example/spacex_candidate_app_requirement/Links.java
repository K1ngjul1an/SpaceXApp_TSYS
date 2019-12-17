package com.example.spacex_candidate_app_requirement;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Links implements Parcelable {

    public static final Creator<Links> CREATOR = new Creator<Links>() {
        @Override
        public Links createFromParcel(Parcel parcel) {
            return new Links(parcel);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
        }
    };

    @SerializedName("mission_patch")
    private String missionPatch;

    @SerializedName("mission_patch_small")
    private String missionPatchSmall;

    @SerializedName("article_link")
    private String articleLink;

    @SerializedName("wikipedia")
    private String wikipedia;

    @SerializedName("video_link")
    private String videoLink;

    @SerializedName("youtube_id")
    private String youtubeId;

    public Links(String missionPatch, String missionPatchSmall, String articleLink, String wikipedia, String videoLink, String youtubeId) {
        this.missionPatch = missionPatch;
        this.missionPatchSmall = missionPatchSmall;
        this.articleLink = articleLink;
        this.wikipedia = wikipedia;
        this.videoLink = videoLink;
        this.youtubeId = youtubeId;
    }

    public Links(Parcel parcel) {
        missionPatch = parcel.readString();
        missionPatchSmall = parcel.readString();
        articleLink = parcel.readString();
        wikipedia = parcel.readString();
        videoLink = parcel.readString();
        youtubeId = parcel.readString();
    }

    public String getMissionPatchSmall() {
        return missionPatchSmall;
    }

    public void setMissionPatchSmall(String missionPatchSmall) {
        this.missionPatchSmall = missionPatchSmall;
    }

    public String getMissionPatch() {
        return missionPatch;
    }

    public void setMissionPatch(String missionPatch) {
        this.missionPatch = missionPatch;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(missionPatch);
        dest.writeString(missionPatchSmall);
        dest.writeString(articleLink);
        dest.writeString(wikipedia);
        dest.writeString(videoLink);
        dest.writeString(youtubeId);
    }
}
