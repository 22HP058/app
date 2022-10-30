package com.example.whale;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ModelWeather {

    private String rainType;
    private String humidity;
    private String sky;
    private String temp;
    private String fcstTime;
    private String uuu;
    private String vvv;
    private String vec;
    private String wsd;
    private String pop;
    private String wav;
    private String pcp;
    private String sno;

    public ModelWeather() {


    }

    public ModelWeather(ModelWeather model) {
        rainType = model.getRainType();
        humidity = model.getHumidity();
        sky = model.getSky();
        temp = model.getTemp();
        fcstTime = model.getFcstTime();
        uuu = model.getUuu();
        vvv = model.getVvv();
        vec = model.getVec();
        wsd = model.getWsd();
        pop = model.getPop();
        wav = model.getWav();
        pcp = model.getPcp();
        sno = model.getSno();
    }

    public String getRainType() {
        return rainType;
    }

    public void setRainType(String rainType) {
        this.rainType = rainType;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSky() {
        return sky;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFcstTime() {
        return fcstTime;
    }

    public void setFcstTime(String fcstTime) {
        this.fcstTime = fcstTime;
    }

    public String getUuu() {
        return uuu;
    }

    public void setUuu(String uuu) {
        this.uuu = uuu;
    }

    public String getVvv() {
        return vvv;
    }

    public void setVvv(String vvv) {
        this.vvv = vvv;
    }

    public String getVec() {
        return vec;
    }

    public void setVec(String vec) {
        this.vec = vec;
    }

    public String getWsd() {
        return wsd;
    }

    public void setWsd(String wsd) {
        this.wsd = wsd;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getWav() {
        return wav;
    }

    public void setWav(String wav) {
        this.wav = wav;
    }

    public String getPcp() {
        return pcp;
    }

    public void setPcp(String pcp) {
        this.pcp = pcp;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}

class WEATHER {
    @SerializedName("response")
    private RESPONSE response;

    public RESPONSE getResponse() {
        return response;
    }

    public void setResponse(RESPONSE response) {
        this.response = response;
    }
}

class RESPONSE {
    @SerializedName("header")
    private HEADER header;
    @SerializedName("body")
    private BODY body;

    public HEADER getHeader() {
        return header;
    }

    public void setHeader(HEADER header) {
        this.header = header;
    }

    public BODY getBody() {
        return body;
    }

    public void setBody(BODY body) {
        this.body = body;
    }
}

class HEADER {
    @SerializedName("resultCode")
    private int resultCode;
    @SerializedName("resultMsg")
    private String resultMsg;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}

class BODY {
    @SerializedName("dataType")
    private String dataType;
    @SerializedName("items")
    private ITEMS items;
    @SerializedName("numOfRows")
    private int numOfRows;
    @SerializedName("pageNo")
    private int pageNo;
    @SerializedName("totalCount")
    private int totalCount;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public ITEMS getItems() {
        return items;
    }

    public void setItems(ITEMS items) {
        this.items = items;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}

class ITEMS {
    @SerializedName("item")
    private List<ITEM> item = null;

    public List<ITEM> getItem() {
        return item;
    }

    public void setItem(List<ITEM> item) {
        this.item = item;
    }
}

class ITEM {
    @SerializedName("base_date")
    private String baseDate;
    @SerializedName("base_time")
    private String baseTime;
    @SerializedName("category")
    private String category;
    @SerializedName("fcsDate")
    private String fcstDate;
    @SerializedName("fcstTime")
    private String fcstTime;
    @SerializedName("fcstValue")
    private String fcstValue;
    @SerializedName("nx")
    private int nx;
    @SerializedName("ny")
    private int ny;

    public String getBaseDate() {
        return baseDate;
    }

    public void setBaseDate(String baseDate) {
        this.baseDate = baseDate;
    }

    public String getBaseTime() {
        return baseTime;
    }

    public void setBaseTime(String baseTime) {
        this.baseTime = baseTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFcstDate() {
        return fcstDate;
    }

    public void setFcstDate(String fcstDate) {
        this.fcstDate = fcstDate;
    }

    public String getFcstTime() {
        return fcstTime;
    }

    public void setFcstTime(String fcstTime) {
        this.fcstTime = fcstTime;
    }

    public String getFcstValue() {
        return fcstValue;
    }

    public void setFcstValue(String fcstValue) {
        this.fcstValue = fcstValue;
    }

    public int getNx() {
        return nx;
    }

    public void setNx(int nx) {
        this.nx = nx;
    }

    public int getNy() {
        return ny;
    }

    public void setNy(int ny) {
        this.ny = ny;
    }
}

