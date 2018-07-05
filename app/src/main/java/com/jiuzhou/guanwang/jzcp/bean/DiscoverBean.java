package com.jiuzhou.guanwang.jzcp.bean;

/**
 * Created by Administrator on 2018/7/4.
 */

public class DiscoverBean {

    /**
     * flash_time : 2018-05-28 02:06:35
     * league_name : 挪超
     * level : 1
     * title : 萨尔普斯堡 VS 斯塔贝克
     * content : 【优劣对比】<br>主队-定位球进攻(强)VS客队-避免个人失误(弱)<br>主队-定位球进攻(强)VS客队-避免在危险区域内犯规(弱)<br>主队-把握机会能力(强)VS客队-限制对方创造机会(非常弱)<br>
     * router : mojiety://forecast_detail?match_id=709989&model=data&tab=
     * flash_id : 5684
     * news_tag :
     */

    private String flash_time;
    private String league_name;
    private int level;
    private String title;
    private String content;
    private String router;
    private int flash_id;
    private String news_tag;

    public String getFlash_time() {
        return flash_time;
    }

    public void setFlash_time(String flash_time) {
        this.flash_time = flash_time;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public int getFlash_id() {
        return flash_id;
    }

    public void setFlash_id(int flash_id) {
        this.flash_id = flash_id;
    }

    public String getNews_tag() {
        return news_tag;
    }

    public void setNews_tag(String news_tag) {
        this.news_tag = news_tag;
    }
}
