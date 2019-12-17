package com.example.spacex_candidate_app_requirement;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // A dialog showing a progress indicator and an optional text message or view.
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        // Creating an instance of interface
        SpaceXDataInterface service = RetrofitInstance.getRetrofit().create(SpaceXDataInterface.class);
        Call<List<PastLaunchesData>> call = service.getMissionDetails();
        call.enqueue(new Callback<List<PastLaunchesData>>() {
            @Override
            public void onResponse(Call<List<PastLaunchesData>> call, Response<List<PastLaunchesData>> response) {
                progressDialog.dismiss();
//                Log.e("hello florida",response.body().toString());
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<PastLaunchesData>> call, Throwable t) {
                progressDialog.dismiss();
//                Log.e("Error",t.toString());
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to generate List of data using RecyclerView with recycler adapter
    private void generateDataList(List<PastLaunchesData> dataList) {
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(dataList, this);
//        Log.e("Print", dataList);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
    }
}
