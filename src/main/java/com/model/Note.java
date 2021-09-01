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

    private final Date creationData = new Date();
    private Date lastUpdateData = new Date();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        lastUpdateData = new Date();
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        lastUpdateData = new Date();
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        lastUpdateData = new Date();
        this.thirdName = thirdName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        lastUpdateData = new Date();
        this.nickname = nickname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        lastUpdateData = new Date();
        this.comment = comment;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        lastUpdateData = new Date();
        this.group = group;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        lastUpdateData = new Date();
        this.homeNumber = homeNumber;
    }

    public String getFirstMobileNumber() {
        return firstMobileNumber;
    }

    public void setFirstMobileNumber(String firstMobileNumber) {
        lastUpdateData = new Date();
        this.firstMobileNumber = firstMobileNumber;
    }

    public String getSecondMobileNumber() {
        return secondMobileNumber;
    }

    public void setSecondMobileNumber(String secondMobileNumber) {
        lastUpdateData = new Date();
        this.secondMobileNumber = secondMobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        lastUpdateData = new Date();
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        lastUpdateData = new Date();
        this.skype = skype;
    }

    public int getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(int postIndex) {
        lastUpdateData = new Date();
        this.postIndex = postIndex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        lastUpdateData = new Date();
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        lastUpdateData = new Date();
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        lastUpdateData = new Date();
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        lastUpdateData = new Date();
        this.flat = flat;
    }

    public String getName() {
        return name;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public Date getCreationData() {
        return creationData;
    }

    public Date getLastUpdateData() {
        return lastUpdateData;
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
}
