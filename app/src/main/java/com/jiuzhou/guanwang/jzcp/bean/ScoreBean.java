package com.jiuzhou.guanwang.jzcp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/26.
 */

public class ScoreBean {

    /**
     * title : 主队-<font color='#FC5A5A'>1胜</font><font color='#4D9BF6'>3平</font><font color='#2BC57C'>2负</font>
     * history_list : [{"match_id":524885,"host_name":"门兴","away_name":"<font color='#FF0000'>奥格斯堡<\/font>","host_team_image":"http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1089.png","away_team_image":"http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1923.png","match_desc":"德甲","match_time_detail":"2015-09-24 02:00:00 +0800","host_score":4,"away_score":2,"score":"4:2","match_result_desc":"负","match_result_color":"#2BC57C","odds_desc":"-0.25"},{"match_id":525038,"host_name":"<font color='#FF0000'>奥格斯堡<\/font>","away_name":"门兴","host_team_image":"http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1923.png","away_team_image":"http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1089.png","match_desc":"德甲","match_time_detail":"2016-02-28 22:30:00 +0800","host_score":2,"away_score":2,"score":"2:2","match_result_desc":"平","match_result_color":"#4D9BF6","odds_desc":"+0.25"},{"match_id":596292,"host_name":"<font color='#FF0000'>奥格斯堡<\/font>","away_name":"门兴","host_team_image":"http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1923.png","away_team_image":"http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1089.png","match_desc":"德甲","match_time_detail":"2016-12-17 22:30:00 +0800","host_score":1,"away_score":0,"score":"1:0","match_result_desc":"胜","match_result_color":"#FC5A5A","odds_desc":"0.0"},{"match_id":596446,"host_name":"门兴","away_name":"<font color='#FF0000'>奥格斯堡<\/font>","host_team_image":"http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1089.png","away_team_image":"http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1923.png","match_desc":"德甲","match_time_detail":"2017-05-06 21:30:00 +0800","host_score":1,"away_score":1,"score":"1:1","match_result_desc":"平","match_result_color":"#4D9BF6","odds_desc":"-0.75"},{"match_id":672932,"host_name":"<font color='#FF0000'>奥格斯堡<\/font>","away_name":"门兴","host_team_image":"http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1923.png","away_team_image":"http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1089.png","match_desc":"德甲","match_time_detail":"2017-08-26 21:30:00 +0800","host_score":2,"away_score":2,"score":"2:2","match_result_desc":"平","match_result_color":"#4D9BF6","odds_desc":"+0.25"},{"match_id":673083,"host_name":"门兴","away_name":"<font color='#FF0000'>奥格斯堡<\/font>","host_team_image":"http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1089.png","away_team_image":"http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1923.png","match_desc":"德甲","match_time_detail":"2018-01-20 22:30:00 +0800","host_score":2,"away_score":0,"score":"2:0","match_result_desc":"负","match_result_color":"#2BC57C","odds_desc":"-0.25"}]
     */

    private String title;
    private List<HistoryListBean> history_list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HistoryListBean> getHistory_list() {
        return history_list;
    }

    public void setHistory_list(List<HistoryListBean> history_list) {
        this.history_list = history_list;
    }

    public static class HistoryListBean {
        /**
         * match_id : 524885
         * host_name : 门兴
         * away_name : <font color='#FF0000'>奥格斯堡</font>
         * host_team_image : http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1089.png
         * away_team_image : http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1923.png
         * match_desc : 德甲
         * match_time_detail : 2015-09-24 02:00:00 +0800
         * host_score : 4
         * away_score : 2
         * score : 4:2
         * match_result_desc : 负
         * match_result_color : #2BC57C
         * odds_desc : -0.25
         */

        private int match_id;
        private String host_name;
        private String away_name;
        private String host_team_image;
        private String away_team_image;
        private String match_desc;
        private String match_time_detail;
        private int host_score;
        private int away_score;
        private String score;
        private String match_result_desc;
        private String match_result_color;
        private String odds_desc;

        public int getMatch_id() {
            return match_id;
        }

        public void setMatch_id(int match_id) {
            this.match_id = match_id;
        }

        public String getHost_name() {
            return host_name;
        }

        public void setHost_name(String host_name) {
            this.host_name = host_name;
        }

        public String getAway_name() {
            return away_name;
        }

        public void setAway_name(String away_name) {
            this.away_name = away_name;
        }

        public String getHost_team_image() {
            return host_team_image;
        }

        public void setHost_team_image(String host_team_image) {
            this.host_team_image = host_team_image;
        }

        public String getAway_team_image() {
            return away_team_image;
        }

        public void setAway_team_image(String away_team_image) {
            this.away_team_image = away_team_image;
        }

        public String getMatch_desc() {
            return match_desc;
        }

        public void setMatch_desc(String match_desc) {
            this.match_desc = match_desc;
        }

        public String getMatch_time_detail() {
            return match_time_detail;
        }

        public void setMatch_time_detail(String match_time_detail) {
            this.match_time_detail = match_time_detail;
        }

        public int getHost_score() {
            return host_score;
        }

        public void setHost_score(int host_score) {
            this.host_score = host_score;
        }

        public int getAway_score() {
            return away_score;
        }

        public void setAway_score(int away_score) {
            this.away_score = away_score;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getMatch_result_desc() {
            return match_result_desc;
        }

        public void setMatch_result_desc(String match_result_desc) {
            this.match_result_desc = match_result_desc;
        }

        public String getMatch_result_color() {
            return match_result_color;
        }

        public void setMatch_result_color(String match_result_color) {
            this.match_result_color = match_result_color;
        }

        public String getOdds_desc() {
            return odds_desc;
        }

        public void setOdds_desc(String odds_desc) {
            this.odds_desc = odds_desc;
        }
    }
}
