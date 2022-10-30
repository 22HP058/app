package com.example.whale;

public class Data {
    private int tem;
    private int hum;
    private int dus;

    public Data(int tem, int hum, int dus) {
        this.tem = tem;
        this.hum = hum;
        this.dus = dus;
    }

    public int getTem() {
        return tem;
    }

    public void setTem(int tem) {
        this.tem = tem;
    }

    public int getHum() {
        return hum;
    }

    public void setHum(int hum) {
        this.hum = hum;
    }

    public int getDus() {
        return dus;
    }

    public void setDus(int dus) {
        this.dus = dus;
    }
}
