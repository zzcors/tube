package com.example.zzcors.tube;

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import org.json.JSONArray;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private VideoAdapter mAdapter;
//    Button button;
    public List<VideoInfo> videoInfos = new ArrayList<VideoInfo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the layout from video_main.xml
        setContentView(R.layout.activity_main);
        this.loadData();
        // Locate the button in activity_main.xml
//        button = (Button) findViewById(R.id.MyButton);

        // Capture button clicks
//        button.setOnClickListener(new OnClickListener() {
//            public void onClick(View arg0) {
//
//                // Start NewActivity.class
//                Intent myIntent = new Intent(MainActivity.this,
//                        VideoViewActivity.class);
//                startActivity(myIntent);
//            }
//        });

//        Toolbar toolbar = (Toolbar) findViewById(R.id.);
//        setSupportActionBar(toolbar);
        videoInfos.add(new VideoInfo(1
                ,1
                ,"qweqwe"
                ,"tube/video/5.mp4"
                ,"qweqwewq"));
        setVideoView();

    }
    public void setVideoView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new VideoAdapter(videoInfos);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
    public void loadData() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .header("Authorization", "your token")
                .url("http://192.168.0.105/tube/LoadData.php")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.e("error002",str);
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response.body().string());
                } else {

                    try {
                        JSONArray jsonArray = new JSONArray(str);
                        for(int i = 0;i<jsonArray.length();i++){
                            videoInfos.add(new VideoInfo(jsonArray.getJSONObject(i).getInt("id_video")
                                    ,jsonArray.getJSONObject(i).getInt("id_user")
                                    ,jsonArray.getJSONObject(i).getString("video_title")
                                    ,jsonArray.getJSONObject(i).getString("video_url")
                                    ,jsonArray.getJSONObject(i).getString("video_subtitle")));
                        }
                        videoInfos.remove(0);
                        Log.e("error001",""+videoInfos.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });

    }

}
