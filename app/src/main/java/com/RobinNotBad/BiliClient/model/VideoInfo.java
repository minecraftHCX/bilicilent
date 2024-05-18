package com.RobinNotBad.BiliClient.model;


import java.io.Serializable;
import java.util.ArrayList;

public class VideoInfo implements Serializable {    //自定义类需要加这个才能传输
    public String bvid;
    public long aid;
    public String title;
    public ArrayList<UserInfo> staff; //UP主列表
    public String cover;
    public String description;
    public String duration;
    public Stats stats;
    public String timeDesc;
    public ArrayList<String> pagenames;
    public ArrayList<Long> cids;

    public boolean upowerExclusive; //充电专属
    public String argueMsg; //争议信息
    public boolean isCooperation; //联合投稿
    public boolean isSteinGate; //互动视频
    public boolean is360; //全景视频

    public long epid; //如果是番剧则不为空，应自动跳转


    public VideoInfo(){}
}
