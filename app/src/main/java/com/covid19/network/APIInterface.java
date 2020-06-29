package com.covid19.network;

import com.covid19.responses.CasesByCountryResponse;
import com.covid19.responses.SummaryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("summary")
    Call<SummaryResponse> getSummary();

    @GET("country/{country}/status/confirmed")
    Call<List<CasesByCountryResponse>> getConfirmedCasesByCountry(@Path("country") String countryName,
                                                                 @Query("from") String from,
                                                                 @Query("to") String to);
}
