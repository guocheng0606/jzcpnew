package com.jiuzhou.guanwang.jzcp.bean;

/**
 * Created by Administrator on 2018/7/5.
 */

public class SeasonBean {

    /**
     * season_id : 4718
     * season_name : 日职乙
     * season_name_en : J2 League
     * season_image : https://ojhwnbiut.qnssl.com/develop/football/season/6686.png
     * push :
     * color : E9F6FF
     */

    private int season_id;
    private String season_name;
    private String season_name_en;
    private String season_image;
    private String push;
    private String color;

    public int getSeason_id() {
        return season_id;
    }

    public void setSeason_id(int season_id) {
        this.season_id = season_id;
    }

    public String getSeason_name() {
        return season_name;
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name;
    }

    public String getSeason_name_en() {
        return season_name_en;
    }

    public void setSeason_name_en(String season_name_en) {
        this.season_name_en = season_name_en;
    }

    public String getSeason_image() {
        return season_image;
    }

    public void setSeason_image(String season_image) {
        this.season_image = season_image;
    }

    public String getPush() {
        return push;
    }

    public void setPush(String push) {
        this.push = push;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
