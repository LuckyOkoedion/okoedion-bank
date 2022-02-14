package com.lucky.OkoedionBank.Pojo;


public class RobotCpu {
    private String model;
    private String serialNumber;
    private String manufacturedDate;
    private String category;

    public  RobotCpu() {

    }

    public  RobotCpu(String model, String serialNumber,
                     String manufacturedDate, String category) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.category = category;
        this.manufacturedDate = manufacturedDate;

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
