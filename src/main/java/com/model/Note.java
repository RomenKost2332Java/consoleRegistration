package com.model;

import java.util.Date;

public class Note {
    private static final String SPACE = " ";
    private static final String DOT = ".";
    private static final String DELIMITER = ", ";

    private String firstName;
    private String secondName;
    private String thirdName;

    private String name;
    private String nickname;

    private String comment;
    private Group group;

    private String homeNumber;
    private String firstMobileNumber;
    private String secondMobileNumber;

    private String email;
    private String skype;

    private int postIndex;
    private String city;
    private String street;
    private String house;
    private String flat;

    private String fullAddress;

    private Date addDate = new Date();
    private Date lastUpdateDate = new Date();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        lastUpdateDate = new Date();
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        lastUpdateDate = new Date();
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        lastUpdateDate = new Date();
        this.thirdName = thirdName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        lastUpdateDate = new Date();
        this.nickname = nickname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        lastUpdateDate = new Date();
        this.comment = comment;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        lastUpdateDate = new Date();
        this.group = group;
    }

    public void setGroup(String group) {
        setGroup(Group.valueOf(group));
    }


    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        lastUpdateDate = new Date();
        this.homeNumber = homeNumber;
    }

    public String getFirstMobileNumber() {
        return firstMobileNumber;
    }

    public void setFirstMobileNumber(String firstMobileNumber) {
        lastUpdateDate = new Date();
        this.firstMobileNumber = firstMobileNumber;
    }

    public String getSecondMobileNumber() {
        return secondMobileNumber;
    }

    public void setSecondMobileNumber(String secondMobileNumber) {
        lastUpdateDate = new Date();
        this.secondMobileNumber = secondMobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        lastUpdateDate = new Date();
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        lastUpdateDate = new Date();
        this.skype = skype;
    }

    public int getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(int postIndex) {
        lastUpdateDate = new Date();
        this.postIndex = postIndex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        lastUpdateDate = new Date();
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        lastUpdateDate = new Date();
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        lastUpdateDate = new Date();
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        lastUpdateDate = new Date();
        this.flat = flat;
    }

    public String getName() {
        return name;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public Date getAddDate() {
        return addDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void generateName(){
        name = secondName
                + SPACE
                + firstName.charAt(0)
                + DOT;
    }

    public void generateFullAddress(){
        fullAddress = postIndex + DELIMITER
                + city + DELIMITER
                + street + DELIMITER
                + house + DELIMITER
                + flat;
    }

    public void setAddData(){
        addDate = new Date();
    }
}
