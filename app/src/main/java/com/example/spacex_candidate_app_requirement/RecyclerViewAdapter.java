package com.example.spacex_candidate_app_requirement;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<PastLaunchesData> dataList;
    Context context;

    public RecyclerViewAdapter(List<PastLaunchesData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

//        viewHolder.textView.setText("Object printed here");

        viewHolder.missionName.setText("Mission Name: " + dataList.get(position).getMissionName());
//        Log.e("hello florida",dataList.get(position).getLinks().getMissionPatchSmall().toString());

        viewHolder.rocketName.setText("Rocket Name: " + dataList.get(position).getRocketDetail().getRocketName());
        viewHolder.launchDateLocal.setText("Date of Launch: " + dataList.get(position).getLaunchDateLocal());
        viewHolder.siteName.setText("Launch Site Name: " + dataList.get(position).getLaunchSite());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build()
                .load(dataList.get(position).getLinks().getMissionPatchSmall())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(viewHolder.missionImage);

        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("MissionDetails", dataList.get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView missionName, rocketName, siteName, launchDateLocal;
        ImageView missionImage;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            missionName = (TextView)itemView.findViewById(R.id.missionName);
            rocketName = (TextView)itemView.findViewById(R.id.rocketName);
            siteName = (TextView)itemView.findViewById(R.id.siteName);
            launchDateLocal = (TextView)itemView.findViewById(R.id.launchDateLocal);
            missionImage = (ImageView)itemView.findViewById(R.id.missionImage);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }

}
