/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aditi
 */
public class Address {
    private String homeStreetAddress;    
    private byte homeUnitNumber;         
    private char homeCityInitial;        
    private float homeStateCode;         
    private double homeZipCode;          
    private int homePhoneNumber;         

   
    private String workStreetAddress;    
    private short workUnitNumber;        
    private char workCityInitial;        
    private long workStateCode;          
    private int workZipCode;             
    private long workPhoneNumber;
    
    public String getHomeStreetAddress() {
        return homeStreetAddress;
    }

    public void setHomeStreetAddress(String homeStreetAddress) {
        this.homeStreetAddress = homeStreetAddress;
    }

    public byte getHomeUnitNumber() {
        return homeUnitNumber;
    }

    public void setHomeUnitNumber(byte homeUnitNumber) {
        this.homeUnitNumber = homeUnitNumber;
    }

    public char getHomeCityInitial() {
        return homeCityInitial;
    }

    public void setHomeCityInitial(char homeCityInitial) {
        this.homeCityInitial = homeCityInitial;
    }

    public float getHomeStateCode() {
        return homeStateCode;
    }

    public void setHomeStateCode(float homeStateCode) {
        this.homeStateCode = homeStateCode;
    }

    public double getHomeZipCode() {
        return homeZipCode;
    }

    public void setHomeZipCode(double homeZipCode) {
        this.homeZipCode = homeZipCode;
    }

    public int getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(int homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public String getWorkStreetAddress() {
        return workStreetAddress;
    }

    public void setWorkStreetAddress(String workStreetAddress) {
        this.workStreetAddress = workStreetAddress;
    }

    public short getWorkUnitNumber() {
        return workUnitNumber;
    }

    public void setWorkUnitNumber(short workUnitNumber) {
        this.workUnitNumber = workUnitNumber;
    }

    public char getWorkCityInitial() {
        return workCityInitial;
    }

    public void setWorkCityInitial(char workCityInitial) {
        this.workCityInitial = workCityInitial;
    }

    public long getWorkStateCode() {
        return workStateCode;
    }

    public void setWorkStateCode(long workStateCode) {
        this.workStateCode = workStateCode;
    }

    public int getWorkZipCode() {
        return workZipCode;
    }

    public void setWorkZipCode(int workZipCode) {
        this.workZipCode = workZipCode;
    }

    public long getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public void setWorkPhoneNumber(long workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }
    
    
}
