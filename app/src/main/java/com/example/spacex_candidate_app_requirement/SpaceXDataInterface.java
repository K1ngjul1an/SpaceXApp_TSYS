package com.example.spacex_candidate_app_requirement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SpaceXDataInterface {

    @GET("/v3/launches/past")
    Call<List<PastLaunchesData>> getMissionDetails();
}
