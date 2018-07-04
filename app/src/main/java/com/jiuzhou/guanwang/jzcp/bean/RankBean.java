package com.jiuzhou.guanwang.jzcp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by guocheng on 2018/7/2.
 */

public class RankBean {

    /**
     * title : 中甲
     * ranks_data : [{"ranking":1,"team_name":"上海上港","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_3259_1.png","played":11,"wins":7,"ties":2,"losses":2,"goalsFor/goalsAgainst":"27/10","points":23,"team_id":3259,"goalsFor_goalsAgainst":"27/10"},{"ranking":2,"team_name":"山东鲁能","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_3152_2.png","played":11,"wins":7,"ties":2,"losses":2,"goalsFor/goalsAgainst":"18/9","points":23,"team_id":3152,"goalsFor_goalsAgainst":"18/9"},{"ranking":3,"team_name":"北京国安","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_3148_1.png","played":11,"wins":6,"ties":4,"losses":1,"goalsFor/goalsAgainst":"25/16","points":22,"team_id":3148,"goalsFor_goalsAgainst":"25/16"},{"ranking":4,"team_name":"江苏苏宁","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_3151_2.png","played":11,"wins":6,"ties":1,"losses":4,"goalsFor/goalsAgainst":"18/13","points":19,"team_id":3151,"goalsFor_goalsAgainst":"18/13"},{"ranking":5,"team_name":"广州恒大","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_3149_1.png","played":11,"wins":5,"ties":3,"losses":3,"goalsFor/goalsAgainst":"19/16","points":18,"team_id":3149,"goalsFor_goalsAgainst":"19/16"},{"ranking":6,"team_name":"广州富力","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_3154_3.png","played":11,"wins":5,"ties":2,"losses":4,"goalsFor/goalsAgainst":"22/23","points":17,"team_id":3154,"goalsFor_goalsAgainst":"22/23"},{"ranking":7,"team_name":"上海申花","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_3150_1.png","played":11,"wins":5,"ties":2,"losses":4,"goalsFor/goalsAgainst":"17/19","points":17,"team_id":3150,"goalsFor_goalsAgainst":"17/19"},{"ranking":8,"team_name":"天津泰达","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_3160_2.png","played":11,"wins":4,"ties":3,"losses":4,"goalsFor/goalsAgainst":"16/13","points":15,"team_id":3160,"goalsFor_goalsAgainst":"16/13"},{"ranking":9,"team_name":"天津权健","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_248164.png","played":11,"wins":4,"ties":3,"losses":4,"goalsFor/goalsAgainst":"14/13","points":15,"team_id":248164,"goalsFor_goalsAgainst":"14/13"},{"ranking":10,"team_name":"河北华夏幸福","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_43292_2.png","played":11,"wins":4,"ties":3,"losses":4,"goalsFor/goalsAgainst":"16/16","points":15,"team_id":149472,"goalsFor_goalsAgainst":"16/16"},{"ranking":11,"team_name":"北京人和","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_3153_2.png","played":11,"wins":4,"ties":3,"losses":4,"goalsFor/goalsAgainst":"8/11","points":15,"team_id":3153,"goalsFor_goalsAgainst":"8/11"},{"ranking":12,"team_name":"重庆斯威","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_43230_2.png?123","played":11,"wins":3,"ties":2,"losses":6,"goalsFor/goalsAgainst":"15/16","points":11,"team_id":43230,"goalsFor_goalsAgainst":"15/16"},{"ranking":13,"team_name":"长春亚泰","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_3161_1.png","played":11,"wins":3,"ties":2,"losses":6,"goalsFor/goalsAgainst":"14/19","points":11,"team_id":3161,"goalsFor_goalsAgainst":"14/19"},{"ranking":14,"team_name":"河南建业","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_3159_1.png","played":11,"wins":3,"ties":2,"losses":6,"goalsFor/goalsAgainst":"7/16","points":11,"team_id":3159,"goalsFor_goalsAgainst":"7/16"},{"ranking":15,"team_name":"大连一方","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_3155_1.png","played":11,"wins":2,"ties":3,"losses":6,"goalsFor/goalsAgainst":"9/22","points":9,"team_id":3155,"goalsFor_goalsAgainst":"9/22"},{"ranking":16,"team_name":"贵州恒丰","team_logo":"http://b1.hoopchina.com.cn/games/teams/csl/9_248156_1.png","played":11,"wins":1,"ties":1,"losses":9,"goalsFor/goalsAgainst":"14/27","points":4,"team_id":248156,"goalsFor_goalsAgainst":"14/27"}]
     */

    private String title;
    private List<RanksDataBean> ranks_data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RanksDataBean> getRanks_data() {
        return ranks_data;
    }

    public void setRanks_data(List<RanksDataBean> ranks_data) {
        this.ranks_data = ranks_data;
    }

    public static class RanksDataBean {
        /**
         * ranking : 1
         * team_name : 上海上港
         * team_logo : http://b1.hoopchina.com.cn/games/teams/csl/9_3259_1.png
         * played : 11
         * wins : 7
         * ties : 2
         * losses : 2
         * goalsFor/goalsAgainst : 27/10
         * points : 23
         * team_id : 3259
         * goalsFor_goalsAgainst : 27/10
         */

        private int ranking;
        private String team_name;
        private String team_logo;
        private int played;
        private int wins;
        private int ties;
        private int losses;
        @SerializedName("goalsFor/goalsAgainst")
        private String _$GoalsForGoalsAgainst84; // FIXME check this code
        private int points;
        private int team_id;
        private String goalsFor_goalsAgainst;

        public int getRanking() {
            return ranking;
        }

        public void setRanking(int ranking) {
            this.ranking = ranking;
        }

        public String getTeam_name() {
            return team_name;
        }

        public void setTeam_name(String team_name) {
            this.team_name = team_name;
        }

        public String getTeam_logo() {
            return team_logo;
        }

        public void setTeam_logo(String team_logo) {
            this.team_logo = team_logo;
        }

        public int getPlayed() {
            return played;
        }

        public void setPlayed(int played) {
            this.played = played;
        }

        public int getWins() {
            return wins;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public int getTies() {
            return ties;
        }

        public void setTies(int ties) {
            this.ties = ties;
        }

        public int getLosses() {
            return losses;
        }

        public void setLosses(int losses) {
            this.losses = losses;
        }

        public String get_$GoalsForGoalsAgainst84() {
            return _$GoalsForGoalsAgainst84;
        }

        public void set_$GoalsForGoalsAgainst84(String _$GoalsForGoalsAgainst84) {
            this._$GoalsForGoalsAgainst84 = _$GoalsForGoalsAgainst84;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public int getTeam_id() {
            return team_id;
        }

        public void setTeam_id(int team_id) {
            this.team_id = team_id;
        }

        public String getGoalsFor_goalsAgainst() {
            return goalsFor_goalsAgainst;
        }

        public void setGoalsFor_goalsAgainst(String goalsFor_goalsAgainst) {
            this.goalsFor_goalsAgainst = goalsFor_goalsAgainst;
        }
    }
}
