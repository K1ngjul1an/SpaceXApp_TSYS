package com.example.spacex_candidate_app_requirement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    ImageView missionImage;
    TextView flightNumber, missionName, launchYear, launchDateLocal, rocket, rocketId, rocketName, rocketType, launchSite, siteId;
    TextView siteNameLong, launchSuccess, launchFailureDetails, time, altitude, reason, links,  missionPatch, missionPatchSmall, articleLink;
    TextView  wikipedia, videoLink, youtubeId, details;

    PastLaunchesData pastLaunchesData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        pastLaunchesData = getIntent().getParcelableExtra("MissionDetails");
        Log.e("Details Activity Data",pastLaunchesData.getMissionName());

        missionImage = (ImageView)findViewById(R.id.missionImage);
        flightNumber = (TextView)findViewById(R.id.flightNumber);
        missionName = (TextView)findViewById(R.id.missionName);
        launchYear = (TextView)findViewById(R.id.launchYear);
        launchDateLocal = (TextView)findViewById(R.id.launchDateLocal);
        rocket = (TextView)findViewById(R.id.rocket);
        rocketId = (TextView)findViewById(R.id.rocketId);
        rocketName = (TextView)findViewById(R.id.rocketName);
        rocketType = (TextView)findViewById(R.id.rocketType);
        launchSite = (TextView)findViewById(R.id.launchSite);
        siteId = (TextView)findViewById(R.id.siteId);
        siteNameLong = (TextView)findViewById(R.id.siteNameLong);
        launchSuccess = (TextView)findViewById(R.id.launchSuccess);
        launchFailureDetails = (TextView)findViewById(R.id.launchFailureDetails);
        time = (TextView)findViewById(R.id.time);
        altitude = (TextView)findViewById(R.id.altitude);
        reason = (TextView)findViewById(R.id.reason);
        links = (TextView)findViewById(R.id.links);
        missionPatch = (TextView)findViewById(R.id.missionPatch);
        missionPatchSmall = (TextView)findViewById(R.id.missionPatchSmall);
        articleLink = (TextView)findViewById(R.id.articleLink);
        wikipedia = (TextView)findViewById(R.id.wikipedia);
        videoLink = (TextView)findViewById(R.id.videoLink);
        youtubeId = (TextView)findViewById(R.id.youtubeId);
        details = (TextView)findViewById(R.id.details);

        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this));
        builder.build()
                .load(pastLaunchesData.getLinks().getMissionPatch())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(missionImage);

        flightNumber.setText("Flight Number: " + pastLaunchesData.getFlightNumber());
        missionName.setText("Mission Name: " + pastLaunchesData.getMissionName());
        launchYear.setText("Launch Year: " + pastLaunchesData.getLaunchYear());
        launchDateLocal.setText("Launch Date Local: " + pastLaunchesData.getLaunchDateLocal());
        rocket.setText("Rocket: ");
        rocketId.setText("Rocket ID: " + pastLaunchesData.getRocketDetail().getRocketId());
        rocketName.setText("Rocket Name: " + pastLaunchesData.getRocketDetail().getRocketName());
        rocketType.setText("Rocket Type: " + pastLaunchesData.getRocketDetail().getRocketType());
        launchSite.setText("Launch Site: ");
        siteId.setText("Site ID: " + pastLaunchesData.getLaunchSite().getSiteId());
        siteNameLong.setText("Site Name Long: " + pastLaunchesData.getLaunchSite().getSiteNameLong());
        launchFailureDetails.setText("Launch Failure Details: ");

        if ( pastLaunchesData.getLaunchSuccess()) {
            launchSuccess.setText("Launch Successful");
        }
        else {
            launchSuccess.setText("Launch Failure!");

            if (pastLaunchesData.getLaunchFailureDetails().getAltitude() == 0) {
                altitude.setText("Altitude data not available!");
            }
            else {
                altitude.setText("Altitude: " + pastLaunchesData.getLaunchFailureDetails().getAltitude().toString());
            }
            if ( pastLaunchesData.getLaunchFailureDetails().getTime() == 0 ){
                time.setText("Time Unavailable");
            }
            else {
                time.setText("Time: " + pastLaunchesData.getLaunchFailureDetails().getTime().toString());
            }
            reason.setText("Reason: " + pastLaunchesData.getLaunchFailureDetails().getReason());
        }


//        altitude.setText(pastLaunchesData.getLaunchFailureDetails().getAltitude().toString());

        links.setText("Links: ");
        missionPatch.setText("Mission Patch: " + pastLaunchesData.getLinks().getMissionPatch());
        missionPatchSmall.setText("Mission Patch Small: " + pastLaunchesData.getLinks().getMissionPatchSmall());
        articleLink.setText("Article Link: " + pastLaunchesData.getLinks().getArticleLink());
        wikipedia.setText("Wikipedia: " + pastLaunchesData.getLinks().getWikipedia());
        videoLink.setText("Video Link: " + pastLaunchesData.getLinks().getVideoLink());
        youtubeId.setText("Youtube ID: " + pastLaunchesData.getLinks().getYoutubeId());

        Log.e("Print", "At DetailsActivity");
    }
}
