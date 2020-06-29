
package com.covid19.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;
@SuppressWarnings("unused")
public class SummaryResponse {

    @SerializedName("Countries")
    private List<Country> mCountries;
    @SerializedName("Date")
    private String mDate;
    @SerializedName("Global")
    private Global mGlobal;

    public List<Country> getCountries() {
        return mCountries;
    }

    public void setCountries(List<Country> countries) {
        mCountries = countries;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public Global getGlobal() {
        return mGlobal;
    }

    public void setGlobal(Global global) {
        mGlobal = global;
    }

    public class Country {

        @SerializedName("Country")
        private String mCountry;
        @SerializedName("CountryCode")
        private String mCountryCode;
        @SerializedName("Date")
        private String mDate;
        @SerializedName("NewConfirmed")
        private Long mNewConfirmed;
        @SerializedName("NewDeaths")
        private Long mNewDeaths;
        @SerializedName("NewRecovered")
        private Long mNewRecovered;
        @SerializedName("Slug")
        private String mSlug;
        @SerializedName("TotalConfirmed")
        private Long mTotalConfirmed;
        @SerializedName("TotalDeaths")
        private Long mTotalDeaths;
        @SerializedName("TotalRecovered")
        private Long mTotalRecovered;

        public String getCountry() {
            return mCountry;
        }

        public void setCountry(String country) {
            mCountry = country;
        }

        public String getCountryCode() {
            return mCountryCode;
        }

        public void setCountryCode(String countryCode) {
            mCountryCode = countryCode;
        }

        public String getDate() {
            return mDate;
        }

        public void setDate(String date) {
            mDate = date;
        }

        public Long getNewConfirmed() {
            return mNewConfirmed;
        }

        public void setNewConfirmed(Long newConfirmed) {
            mNewConfirmed = newConfirmed;
        }

        public Long getNewDeaths() {
            return mNewDeaths;
        }

        public void setNewDeaths(Long newDeaths) {
            mNewDeaths = newDeaths;
        }

        public Long getNewRecovered() {
            return mNewRecovered;
        }

        public void setNewRecovered(Long newRecovered) {
            mNewRecovered = newRecovered;
        }

        public String getSlug() {
            return mSlug;
        }

        public void setSlug(String slug) {
            mSlug = slug;
        }

        public Long getTotalConfirmed() {
            return mTotalConfirmed;
        }

        public void setTotalConfirmed(Long totalConfirmed) {
            mTotalConfirmed = totalConfirmed;
        }

        public Long getTotalDeaths() {
            return mTotalDeaths;
        }

        public void setTotalDeaths(Long totalDeaths) {
            mTotalDeaths = totalDeaths;
        }

        public Long getTotalRecovered() {
            return mTotalRecovered;
        }

        public void setTotalRecovered(Long totalRecovered) {
            mTotalRecovered = totalRecovered;
        }

    }

    public class Global {

        @SerializedName("NewConfirmed")
        private Long mNewConfirmed;
        @SerializedName("NewDeaths")
        private Long mNewDeaths;
        @SerializedName("NewRecovered")
        private Long mNewRecovered;
        @SerializedName("TotalConfirmed")
        private Long mTotalConfirmed;
        @SerializedName("TotalDeaths")
        private Long mTotalDeaths;
        @SerializedName("TotalRecovered")
        private Long mTotalRecovered;

        public Long getNewConfirmed() {
            return mNewConfirmed;
        }

        public void setNewConfirmed(Long newConfirmed) {
            mNewConfirmed = newConfirmed;
        }

        public Long getNewDeaths() {
            return mNewDeaths;
        }

        public void setNewDeaths(Long newDeaths) {
            mNewDeaths = newDeaths;
        }

        public Long getNewRecovered() {
            return mNewRecovered;
        }

        public void setNewRecovered(Long newRecovered) {
            mNewRecovered = newRecovered;
        }

        public Long getTotalConfirmed() {
            return mTotalConfirmed;
        }

        public void setTotalConfirmed(Long totalConfirmed) {
            mTotalConfirmed = totalConfirmed;
        }

        public Long getTotalDeaths() {
            return mTotalDeaths;
        }

        public void setTotalDeaths(Long totalDeaths) {
            mTotalDeaths = totalDeaths;
        }

        public Long getTotalRecovered() {
            return mTotalRecovered;
        }

        public void setTotalRecovered(Long totalRecovered) {
            mTotalRecovered = totalRecovered;
        }

    }

}
