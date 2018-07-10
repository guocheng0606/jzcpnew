package com.jiuzhou.guanwang.jzcp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/10.
 */

public class FootballBean {

    /**
     * id : 32369
     * title : 海牙热身赛1-2告负，张玉宁首发出战55分钟
     * summary :
     * publishTime : 1531187862000
     * isHeadline : 0
     * headlineWeight : 1
     * category : zq
     * format : 1
     * tag : 荷甲
     * imageList : ["https://qmcms.oss-cn-beijing.aliyuncs.com/sns/image/201807/16481ebabbb.jpg"]
     * lotNo : zq_zgzq
     * _id : 32369
     * tagColor : #f2384b
     * weight : 0
     * videoId : 0
     * visitCount : 38
     */

    private int id;
    private String title;
    private String summary;
    private long publishTime;
    private int isHeadline;
    private int headlineWeight;
    private String category;
    private int format;
    private String tag;
    private String lotNo;
    private int _id;
    private String tagColor;
    private int weight;
    private int videoId;
    private int visitCount;
    private List<String> imageList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public int getIsHeadline() {
        return isHeadline;
    }

    public void setIsHeadline(int isHeadline) {
        this.isHeadline = isHeadline;
    }

    public int getHeadlineWeight() {
        return headlineWeight;
    }

    public void setHeadlineWeight(int headlineWeight) {
        this.headlineWeight = headlineWeight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTagColor() {
        return tagColor;
    }

    public void setTagColor(String tagColor) {
        this.tagColor = tagColor;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }
}
