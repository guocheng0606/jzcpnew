package com.jiuzhou.guanwang.jzcp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */

public class HomeNewsBean {

    /**
     * newsId : 47778
     * newsTitle : 纪念建党97周年 省体彩中心开展主题党日活动
     * isShow : 2
     * releaseStage : 1
     * newsAuthor : 13822
     * programaId : 1
     * imgType : 4
     * releaseStatus : 1
     * readNum : 0
     * newsModel : 6月29日，省体彩中心开展纪念建党97周年，全体党员不忘初心、重温入党志愿书主题党日活动。

     * createAt : 1530328358000
     * recommendNum : 0
     * opposeNum : 0
     * shareNum : 0
     * collectNum : 0
     * isTop : 1
     * newsFlag : 0
     * userId : 0
     * userName : wangdi2017
     * programaName : 热点
     * newsImg : [{"id":114294,"newsId":47778,"width":550,"height":637,"imgUrl":"http://info.zgtcb.com/news_img/20180630/1530328319150091895.png"},{"id":114295,"newsId":47778,"width":503,"height":318,"imgUrl":"http://info.zgtcb.com/news_img/20180630/1530328335463032119.png"}]
     * newsUrl : http://news.zgtcb.com/statichtml/47778.html
     * releaseTime : null
     * newsType : ZGTCB
     */

    private int newsId;
    private String newsTitle;
    private int isShow;
    private String releaseStage;
    private int newsAuthor;
    private int programaId;
    private int imgType;
    private int releaseStatus;
    private int readNum;
    private String newsModel;
    private long createAt;
    private int recommendNum;
    private int opposeNum;
    private int shareNum;
    private int collectNum;
    private int isTop;
    private int newsFlag;
    private int userId;
    private String userName;
    private String programaName;
    private String newsUrl;
    private Object releaseTime;
    private String newsType;
    private List<NewsImgBean> newsImg;

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public String getReleaseStage() {
        return releaseStage;
    }

    public void setReleaseStage(String releaseStage) {
        this.releaseStage = releaseStage;
    }

    public int getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(int newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    public int getProgramaId() {
        return programaId;
    }

    public void setProgramaId(int programaId) {
        this.programaId = programaId;
    }

    public int getImgType() {
        return imgType;
    }

    public void setImgType(int imgType) {
        this.imgType = imgType;
    }

    public int getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(int releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public String getNewsModel() {
        return newsModel;
    }

    public void setNewsModel(String newsModel) {
        this.newsModel = newsModel;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public int getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(int recommendNum) {
        this.recommendNum = recommendNum;
    }

    public int getOpposeNum() {
        return opposeNum;
    }

    public void setOpposeNum(int opposeNum) {
        this.opposeNum = opposeNum;
    }

    public int getShareNum() {
        return shareNum;
    }

    public void setShareNum(int shareNum) {
        this.shareNum = shareNum;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    public int getNewsFlag() {
        return newsFlag;
    }

    public void setNewsFlag(int newsFlag) {
        this.newsFlag = newsFlag;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProgramaName() {
        return programaName;
    }

    public void setProgramaName(String programaName) {
        this.programaName = programaName;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public Object getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Object releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public List<NewsImgBean> getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(List<NewsImgBean> newsImg) {
        this.newsImg = newsImg;
    }

    public static class NewsImgBean {
        /**
         * id : 114294
         * newsId : 47778
         * width : 550
         * height : 637
         * imgUrl : http://info.zgtcb.com/news_img/20180630/1530328319150091895.png
         */

        private int id;
        private int newsId;
        private int width;
        private int height;
        private String imgUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNewsId() {
            return newsId;
        }

        public void setNewsId(int newsId) {
            this.newsId = newsId;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
