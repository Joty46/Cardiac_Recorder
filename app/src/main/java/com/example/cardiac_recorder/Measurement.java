package com.example.cardiac_recorder;

public class Measurement {

    private String date;
    private String time;
    private int systolicPressure;
    private int diastolicPressure;
    private int heartRate;
    private String comment;

    public Measurement(String date, String time, int systolicPressure, int diastolicPressure, int heartRate, String comment) {
        this.date = date;
        this.time = time;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.heartRate = heartRate;
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getSystolicPressure() {
        return systolicPressure;
    }

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", systolicPressure=" + systolicPressure +
                ", diastolicPressure=" + diastolicPressure +
                ", heartRate=" + heartRate +
                ", comment='" + comment + '\'' +
                '}';
    }

}
