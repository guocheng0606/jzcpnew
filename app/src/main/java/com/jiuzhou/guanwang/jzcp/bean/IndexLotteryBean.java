package com.jiuzhou.guanwang.jzcp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/12.
 */

public class IndexLotteryBean {

    /**
     * code : 1
     * msg : 数据获取成功
     * result : {"curPage":1,"data":[{"addResult":"08","appId":0,"drawId":"2018080","jackpotBonus":"2元冲击500万","longTime":1531238400000,"lotteryCode":"004","lotteryId":2072,"lotteryName":"七乐彩","lotteryType":1,"result":"03,06,07,15,22,26,30","resultTest":null,"resultTime":1531238400000,"salesAmount":"5379008"}],"totalNum":1,"totalPage":1}
     * time : 1531358682236
     */

    private int code;
    private String msg;
    private ResultBean result;
    private long time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public static class ResultBean {
        /**
         * curPage : 1
         * data : [{"addResult":"08","appId":0,"drawId":"2018080","jackpotBonus":"2元冲击500万","longTime":1531238400000,"lotteryCode":"004","lotteryId":2072,"lotteryName":"七乐彩","lotteryType":1,"result":"03,06,07,15,22,26,30","resultTest":null,"resultTime":1531238400000,"salesAmount":"5379008"}]
         * totalNum : 1
         * totalPage : 1
         */

        private int curPage;
        private int totalNum;
        private int totalPage;
        private List<DataBean> data;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(int totalNum) {
            this.totalNum = totalNum;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * addResult : 08
             * appId : 0
             * drawId : 2018080
             * jackpotBonus : 2元冲击500万
             * longTime : 1531238400000
             * lotteryCode : 004
             * lotteryId : 2072
             * lotteryName : 七乐彩
             * lotteryType : 1
             * result : 03,06,07,15,22,26,30
             * resultTest : null
             * resultTime : 1531238400000
             * salesAmount : 5379008
             */

            private String addResult;
            private int appId;
            private String drawId;
            private String jackpotBonus;
            private long longTime;
            private String lotteryCode;
            private int lotteryId;
            private String lotteryName;
            private int lotteryType;
            private String result;
            private Object resultTest;
            private long resultTime;
            private String salesAmount;

            public String getAddResult() {
                return addResult;
            }

            public void setAddResult(String addResult) {
                this.addResult = addResult;
            }

            public int getAppId() {
                return appId;
            }

            public void setAppId(int appId) {
                this.appId = appId;
            }

            public String getDrawId() {
                return drawId;
            }

            public void setDrawId(String drawId) {
                this.drawId = drawId;
            }

            public String getJackpotBonus() {
                return jackpotBonus;
            }

            public void setJackpotBonus(String jackpotBonus) {
                this.jackpotBonus = jackpotBonus;
            }

            public long getLongTime() {
                return longTime;
            }

            public void setLongTime(long longTime) {
                this.longTime = longTime;
            }

            public String getLotteryCode() {
                return lotteryCode;
            }

            public void setLotteryCode(String lotteryCode) {
                this.lotteryCode = lotteryCode;
            }

            public int getLotteryId() {
                return lotteryId;
            }

            public void setLotteryId(int lotteryId) {
                this.lotteryId = lotteryId;
            }

            public String getLotteryName() {
                return lotteryName;
            }

            public void setLotteryName(String lotteryName) {
                this.lotteryName = lotteryName;
            }

            public int getLotteryType() {
                return lotteryType;
            }

            public void setLotteryType(int lotteryType) {
                this.lotteryType = lotteryType;
            }

            public String getResult() {
                return result;
            }

            public void setResult(String result) {
                this.result = result;
            }

            public Object getResultTest() {
                return resultTest;
            }

            public void setResultTest(Object resultTest) {
                this.resultTest = resultTest;
            }

            public long getResultTime() {
                return resultTime;
            }

            public void setResultTime(long resultTime) {
                this.resultTime = resultTime;
            }

            public String getSalesAmount() {
                return salesAmount;
            }

            public void setSalesAmount(String salesAmount) {
                this.salesAmount = salesAmount;
            }
        }
    }
}
