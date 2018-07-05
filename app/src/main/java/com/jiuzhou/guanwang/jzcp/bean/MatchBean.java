package com.jiuzhou.guanwang.jzcp.bean;

/**
 * Created by Administrator on 2018/6/26.
 */

public class MatchBean {

    /**
     * match_id : 728285
     * match_week : 周一
     * match_sn : 004
     * match_code : 200
     * host_id : 10
     * away_id : 21
     * host_grade : 0
     * away_grade : 0
     * asia_result : null
     * host_name : 法国
     * away_name : 爱尔兰
     * host_name_en : France
     * away_name_en : Ireland
     * host_name_en_all : France
     * away_name_en_all : Ireland
     * host_team_image : http://7vzspj.com2.z0.glb.clouddn.com/develop/football/1677.png
     * away_team_image : http://7vzspj.com2.z0.glb.clouddn.com/develop/football/21.png
     * season_id : 4683
     * match_desc : 友谊赛
     * match_desc_en : Friendly
     * match_desc_en_all : FIFA Friendly
     * match_desc_short : null
     * host_rank :
     * away_rank :
     * match_time : 05-29 03:00
     * match_time_desc : AM
     * match_time_detail : 2018-05-29 03:00:00 +0800
     * live_desc :
     * host_score : null
     * away_score : null
     * host_half_score : null
     * away_half_score : null
     * score :
     * half_score :
     * match_status : 0
     * match_status_desc : 未开赛
     * level : 2
     * league_id : 15
     * hot : 1899人已查看
     * hot_num : 1899
     * match_show_msg : {"desc":"","color":""}
     * predict_count : 敬请期待预测出炉
     * recommend_star : 91
     * probability : 91
     * content : null
     * predict_item : {}
     * result_matching : 9
     * tag :
     * tag_color :
     * tag_2 :
     * tag_color_2 :
     * tag_url :
     * odds : -1.75
     * odds_v2 : 亚盘 -1.75
     * odds_desc : 五球/五球半
     * index : 8
     * index_desc : 摩羯指数
     * match_result_label :
     * robot_talk : {}
     * care : 0
     * weather : {"weather_desc":"19° 晴朗","weather_influence":"安卡拉","weather_url":"https://ohduoklem.qnssl.com/mojie_match_weather_qing.png","weather_title_url":"https://ohduoklem.qnssl.com/mojie_match_weather_title_qing.png"}
     */

    private int match_id;
    private String match_week;
    private String match_sn;
    private String match_code;
    private int host_id;
    private int away_id;
    private int host_grade;
    private int away_grade;
    private Object asia_result;
    private String host_name;
    private String away_name;
    private String host_name_en;
    private String away_name_en;
    private String host_name_en_all;
    private String away_name_en_all;
    private String host_team_image;
    private String away_team_image;
    private int season_id;
    private String match_desc;
    private String match_desc_en;
    private String match_desc_en_all;
    private Object match_desc_short;
    private String host_rank;
    private String away_rank;
    private String match_time;
    private String match_time_desc;
    private String match_time_detail;
    private String live_desc;
    private Object host_score;
    private Object away_score;
    private Object host_half_score;
    private Object away_half_score;
    private String score;
    private String half_score;
    private int match_status;
    private String match_status_desc;
    private int level;
    private String league_id;
    private String hot;
    private String hot_num;
    private MatchShowMsgBean match_show_msg;
    private String predict_count;
    private int recommend_star;
    private int probability;
    private Object content;
    private PredictItemBean predict_item;
    private int result_matching;
    private String tag;
    private String tag_color;
    private String tag_2;
    private String tag_color_2;
    private String tag_url;
    private String odds;
    private String odds_v2;
    private String odds_desc;
    private int index;
    private String index_desc;
    private String match_result_label;
    private RobotTalkBean robot_talk;
    private String care;
    private WeatherBean weather;

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getMatch_week() {
        return match_week;
    }

    public void setMatch_week(String match_week) {
        this.match_week = match_week;
    }

    public String getMatch_sn() {
        return match_sn;
    }

    public void setMatch_sn(String match_sn) {
        this.match_sn = match_sn;
    }

    public String getMatch_code() {
        return match_code;
    }

    public void setMatch_code(String match_code) {
        this.match_code = match_code;
    }

    public int getHost_id() {
        return host_id;
    }

    public void setHost_id(int host_id) {
        this.host_id = host_id;
    }

    public int getAway_id() {
        return away_id;
    }

    public void setAway_id(int away_id) {
        this.away_id = away_id;
    }

    public int getHost_grade() {
        return host_grade;
    }

    public void setHost_grade(int host_grade) {
        this.host_grade = host_grade;
    }

    public int getAway_grade() {
        return away_grade;
    }

    public void setAway_grade(int away_grade) {
        this.away_grade = away_grade;
    }

    public Object getAsia_result() {
        return asia_result;
    }

    public void setAsia_result(Object asia_result) {
        this.asia_result = asia_result;
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

    public String getHost_name_en() {
        return host_name_en;
    }

    public void setHost_name_en(String host_name_en) {
        this.host_name_en = host_name_en;
    }

    public String getAway_name_en() {
        return away_name_en;
    }

    public void setAway_name_en(String away_name_en) {
        this.away_name_en = away_name_en;
    }

    public String getHost_name_en_all() {
        return host_name_en_all;
    }

    public void setHost_name_en_all(String host_name_en_all) {
        this.host_name_en_all = host_name_en_all;
    }

    public String getAway_name_en_all() {
        return away_name_en_all;
    }

    public void setAway_name_en_all(String away_name_en_all) {
        this.away_name_en_all = away_name_en_all;
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

    public int getSeason_id() {
        return season_id;
    }

    public void setSeason_id(int season_id) {
        this.season_id = season_id;
    }

    public String getMatch_desc() {
        return match_desc;
    }

    public void setMatch_desc(String match_desc) {
        this.match_desc = match_desc;
    }

    public String getMatch_desc_en() {
        return match_desc_en;
    }

    public void setMatch_desc_en(String match_desc_en) {
        this.match_desc_en = match_desc_en;
    }

    public String getMatch_desc_en_all() {
        return match_desc_en_all;
    }

    public void setMatch_desc_en_all(String match_desc_en_all) {
        this.match_desc_en_all = match_desc_en_all;
    }

    public Object getMatch_desc_short() {
        return match_desc_short;
    }

    public void setMatch_desc_short(Object match_desc_short) {
        this.match_desc_short = match_desc_short;
    }

    public String getHost_rank() {
        return host_rank;
    }

    public void setHost_rank(String host_rank) {
        this.host_rank = host_rank;
    }

    public String getAway_rank() {
        return away_rank;
    }

    public void setAway_rank(String away_rank) {
        this.away_rank = away_rank;
    }

    public String getMatch_time() {
        return match_time;
    }

    public void setMatch_time(String match_time) {
        this.match_time = match_time;
    }

    public String getMatch_time_desc() {
        return match_time_desc;
    }

    public void setMatch_time_desc(String match_time_desc) {
        this.match_time_desc = match_time_desc;
    }

    public String getMatch_time_detail() {
        return match_time_detail;
    }

    public void setMatch_time_detail(String match_time_detail) {
        this.match_time_detail = match_time_detail;
    }

    public String getLive_desc() {
        return live_desc;
    }

    public void setLive_desc(String live_desc) {
        this.live_desc = live_desc;
    }

    public Object getHost_score() {
        return host_score;
    }

    public void setHost_score(Object host_score) {
        this.host_score = host_score;
    }

    public Object getAway_score() {
        return away_score;
    }

    public void setAway_score(Object away_score) {
        this.away_score = away_score;
    }

    public Object getHost_half_score() {
        return host_half_score;
    }

    public void setHost_half_score(Object host_half_score) {
        this.host_half_score = host_half_score;
    }

    public Object getAway_half_score() {
        return away_half_score;
    }

    public void setAway_half_score(Object away_half_score) {
        this.away_half_score = away_half_score;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getHalf_score() {
        return half_score;
    }

    public void setHalf_score(String half_score) {
        this.half_score = half_score;
    }

    public int getMatch_status() {
        return match_status;
    }

    public void setMatch_status(int match_status) {
        this.match_status = match_status;
    }

    public String getMatch_status_desc() {
        return match_status_desc;
    }

    public void setMatch_status_desc(String match_status_desc) {
        this.match_status_desc = match_status_desc;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getHot_num() {
        return hot_num;
    }

    public void setHot_num(String hot_num) {
        this.hot_num = hot_num;
    }

    public MatchShowMsgBean getMatch_show_msg() {
        return match_show_msg;
    }

    public void setMatch_show_msg(MatchShowMsgBean match_show_msg) {
        this.match_show_msg = match_show_msg;
    }

    public String getPredict_count() {
        return predict_count;
    }

    public void setPredict_count(String predict_count) {
        this.predict_count = predict_count;
    }

    public int getRecommend_star() {
        return recommend_star;
    }

    public void setRecommend_star(int recommend_star) {
        this.recommend_star = recommend_star;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public PredictItemBean getPredict_item() {
        return predict_item;
    }

    public void setPredict_item(PredictItemBean predict_item) {
        this.predict_item = predict_item;
    }

    public int getResult_matching() {
        return result_matching;
    }

    public void setResult_matching(int result_matching) {
        this.result_matching = result_matching;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag_color() {
        return tag_color;
    }

    public void setTag_color(String tag_color) {
        this.tag_color = tag_color;
    }

    public String getTag_2() {
        return tag_2;
    }

    public void setTag_2(String tag_2) {
        this.tag_2 = tag_2;
    }

    public String getTag_color_2() {
        return tag_color_2;
    }

    public void setTag_color_2(String tag_color_2) {
        this.tag_color_2 = tag_color_2;
    }

    public String getTag_url() {
        return tag_url;
    }

    public void setTag_url(String tag_url) {
        this.tag_url = tag_url;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    public String getOdds_v2() {
        return odds_v2;
    }

    public void setOdds_v2(String odds_v2) {
        this.odds_v2 = odds_v2;
    }

    public String getOdds_desc() {
        return odds_desc;
    }

    public void setOdds_desc(String odds_desc) {
        this.odds_desc = odds_desc;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getIndex_desc() {
        return index_desc;
    }

    public void setIndex_desc(String index_desc) {
        this.index_desc = index_desc;
    }

    public String getMatch_result_label() {
        return match_result_label;
    }

    public void setMatch_result_label(String match_result_label) {
        this.match_result_label = match_result_label;
    }

    public RobotTalkBean getRobot_talk() {
        return robot_talk;
    }

    public void setRobot_talk(RobotTalkBean robot_talk) {
        this.robot_talk = robot_talk;
    }

    public String getCare() {
        return care;
    }

    public void setCare(String care) {
        this.care = care;
    }

    public WeatherBean getWeather() {
        return weather;
    }

    public void setWeather(WeatherBean weather) {
        this.weather = weather;
    }

    public static class MatchShowMsgBean {
    }

    public static class PredictItemBean {
    }

    public static class RobotTalkBean {
    }

    public static class WeatherBean {
        /**
         * weather_desc : 19° 晴朗
         * weather_influence : 安卡拉
         * weather_url : https://ohduoklem.qnssl.com/mojie_match_weather_qing.png
         * weather_title_url : https://ohduoklem.qnssl.com/mojie_match_weather_title_qing.png
         */

        private String weather_desc;
        private String weather_influence;
        private String weather_url;
        private String weather_title_url;

        public String getWeather_desc() {
            return weather_desc;
        }

        public void setWeather_desc(String weather_desc) {
            this.weather_desc = weather_desc;
        }

        public String getWeather_influence() {
            return weather_influence;
        }

        public void setWeather_influence(String weather_influence) {
            this.weather_influence = weather_influence;
        }

        public String getWeather_url() {
            return weather_url;
        }

        public void setWeather_url(String weather_url) {
            this.weather_url = weather_url;
        }

        public String getWeather_title_url() {
            return weather_title_url;
        }

        public void setWeather_title_url(String weather_title_url) {
            this.weather_title_url = weather_title_url;
        }
    }
}
