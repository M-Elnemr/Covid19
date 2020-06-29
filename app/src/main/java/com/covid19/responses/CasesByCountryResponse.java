
package com.covid19.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class CasesByCountryResponse {

    @SerializedName("Country")
    private String mCountry;
    @SerializedName("CountryCode")
    private String mCountryCode;
    @SerializedName("Province")
    private String mProvince;
    @SerializedName("City")
    private String mCity;
    @SerializedName("CityCode")
    private String mCityCode;
    @SerializedName("Lat")
    private String mLat;
    @SerializedName("Lon")
    private String mLon;
    @SerializedName("Cases")
    private Long mCases;
    @SerializedName("Status")
    private String mStatus;
    @SerializedName("Date")
    private String mDate;

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getCountryCode() {
        return mCountryCode;
    }

    public void setCountryCode(String mCountryCode) {
        this.mCountryCode = mCountryCode;
    }

    public String getProvince() {
        return mProvince;
    }

    public void setProvince(String mProvince) {
        this.mProvince = mProvince;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String mCity) {
        this.mCity = mCity;
    }

    public String getCityCode() {
        return mCityCode;
    }

    public void setCityCode(String mCityCode) {
        this.mCityCode = mCityCode;
    }

    public String getLat() {
        return mLat;
    }

    public void setLat(String mLat) {
        this.mLat = mLat;
    }

    public String getLon() {
        return mLon;
    }

    public void setLon(String mLon) {
        this.mLon = mLon;
    }

    public Long getCases() {
        return mCases;
    }

    public void setCases(Long mCases) {
        this.mCases = mCases;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

}
