package com.example.zzcors.tube;


import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.List;

class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {

    Context context = null;
    private List<VideoInfo> videoInfos;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, subtitle;
        public VideoView videoview;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            videoview = (VideoView) view.findViewById(R.id.VideoView);
        }
    }


    public VideoAdapter(List<VideoInfo> moviesList) {
        this.videoInfos = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    public void setVideo(VideoView videoview,String url){
        try {
            // Start the MediaController
            MediaController mediacontroller = new MediaController(context);
//            mediacontroller.setAnchorView(videoview);
            // Get the URL from String VideoURL
            Log.e("checkURL001",""+url);
            Uri video = Uri.parse("http://192.168.0.105/"+url);///tube/video/5.mp4");
            videoview.setMediaController(mediacontroller);
//            videoview.setLayoutParams(new LayoutParams(600,600));
            videoview.setVideoURI(video);
            videoview.seekTo(100);
//            videoview.set
//            videoview.start();

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

//        videoview.requestFocus();
//        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            // Close the progress bar and play the video
//            public void onPrepared(MediaPlayer mp) {
//                videoview.start();
//            }
//        });
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        VideoInfo videoInfo = videoInfos.get(position);
        holder.title.setText(videoInfo.getVideo_title());
        holder.subtitle.setText(videoInfo.getVideo_subtitle());
        this.setVideo(holder.videoview,videoInfo.getVideo_url());
//        holder.videoview.setText(videoInfo.getId_user());

    }

    @Override
    public int getItemCount() {
        return videoInfos.size();
    }
}