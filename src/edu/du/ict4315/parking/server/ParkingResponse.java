package edu.du.ict4315.parking.server;

import com.google.gson.Gson;

public class ParkingResponse {

    private int statusCode;
    private String message;

    public ParkingResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
    
    public String toJson() {
        return new Gson().toJson(this);
    }

    public static ParkingResponse fromJson(String json) {
        return new Gson().fromJson(json, ParkingResponse.class);
    }

    @Override
    public String toString() {
        return "ParkingResponse{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                '}';
    }
}