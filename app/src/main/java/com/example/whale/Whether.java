//package com.example.whale;
//
//import com.google.gson.annotations.SerializedName;
//
//import java.util.List;
//
//public class Whether {
//
//
//
//    private String obsrValue;
//
//    public String getObsrValue() {
//        return obsrValue;
//    }
//
//    public void setObsrValue(String obsrValue) {
//        this.obsrValue = obsrValue;
//    }
//}
//
//class Wheather {
//    @SerializedName("response")
//    private Response response;
//
//    public Response getResponse() {
//        return response;
//    }
//
//    public void setResponse(Response response) {
//        this.response = response;
//    }
//}
//
//class Response {
//
//    @SerializedName("header")
//    private Header header;
//    @SerializedName("body")
//    private Body body;
//
//    public Header getHeader() {
//        return header;
//    }
//
//    public void setHeader(Header header) {
//        this.header = header;
//    }
//
//    public Body getBody() {
//        return body;
//    }
//
//    public void setBody(Body body) {
//        this.body = body;
//    }
//}
//
//
//class Header {
//
//    @SerializedName("resultCode")
//    private int resultCode;
//
//    @SerializedName("resultMsg")
//    private String resultMsg;
//
//    public int getResultCode() {
//        return resultCode;
//    }
//
//    public void setResultCode(int resultCode) {
//        this.resultCode = resultCode;
//    }
//
//    public String getResultMsg() {
//        return resultMsg;
//    }
//
//    public void setResultMsg(String resultMsg) {
//        this.resultMsg = resultMsg;
//    }
//
//}
//
//class Body {
//
//    @SerializedName("dataType")
//    private String dataType;
//    @SerializedName("items")
//    private Items items;
//
//    @SerializedName("pageNo")
//    private Integer pageNo;
//    @SerializedName("numOfRows")
//    private Integer numOfRows;
//    @SerializedName("totalCount")
//    private Integer totalCount;
//
//    public String getDataType() {
//        return dataType;
//    }
//
//    public void setDataType(String dataType) {
//        this.dataType = dataType;
//    }
//
//    public Items getItems() {
//        return items;
//    }
//
//    public void setItems(Items items) {
//        this.items = items;
//    }
//
//    public Integer getPageNo() {
//        return pageNo;
//    }
//
//    public void setPageNo(Integer pageNo) {
//        this.pageNo = pageNo;
//    }
//
//    public Integer getNumOfRows() {
//        return numOfRows;
//    }
//
//    public void setNumOfRows(Integer numOfRows) {
//        this.numOfRows = numOfRows;
//    }
//
//    public Integer getTotalCount() {
//        return totalCount;
//    }
//
//    public void setTotalCount(Integer totalCount) {
//        this.totalCount = totalCount;
//    }
//
//}
//
//class Items {
//
//    @SerializedName("item")
//    private List<Item> item = null;
//
//    public List<Item> getItem() {
//        return item;
//    }
//
//    public void setItem(List<Item> item) {
//        this.item = item;
//    }
//
//}
//
//class Item {
//
//    @SerializedName("base_date")
//    private String baseDate;
//    @SerializedName("base_time")
//    private String baseTime;
//    @SerializedName("category")
//    private String category;
//    @SerializedName("nx")
//    private Integer nx;
//    @SerializedName("ny")
//    private Integer ny;
//    @SerializedName("obsrValue")
//    private String obsrValue;
//
//    public String getBaseDate() {
//        return baseDate;
//    }
//
//    public void setBaseDate(String baseDate) {
//        this.baseDate = baseDate;
//    }
//
//    public String getBaseTime() {
//        return baseTime;
//    }
//
//    public void setBaseTime(String baseTime) {
//        this.baseTime = baseTime;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public Integer getNx() {
//        return nx;
//    }
//
//    public void setNx(Integer nx) {
//        this.nx = nx;
//    }
//
//    public Integer getNy() {
//        return ny;
//    }
//
//    public void setNy(Integer ny) {
//        this.ny = ny;
//    }
//
//    public String getObsrValue() {
//        return obsrValue;
//    }
//
//    public void setObsrValue(String obsrValue) {
//        this.obsrValue = obsrValue;
//    }
//
//}
//
