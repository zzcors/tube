package com.example.zzcors.tube;

public class VideoInfo {

    private int id_video;
    private int id_user;
    private String video_title;
    private String video_url;
    private String video_subtitle;

    public VideoInfo() {

    }
    public VideoInfo(int id_video, int id_user, String video_title, String video_url, String video_subtitle) {
        this.id_video = id_video;
        this.id_user = id_user;
        this.video_title = video_title;
        this.video_url = video_url;
        this.video_subtitle = video_subtitle;
    }

    @Override
    public String toString() {
        return "VideoInfo{" +
                "id_video=" + id_video +
                ", id_user=" + id_user +
                ", video_title='" + video_title + '\'' +
                ", video_url='" + video_url + '\'' +
                ", video_subtitle='" + video_subtitle + '\'' +
                '}';
    }

    public int getId_video() {

        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getVideo_subtitle() {
        return video_subtitle;
    }

    public void setVideo_subtitle(String video_subtitle) {
        this.video_subtitle = video_subtitle;
    }
}
