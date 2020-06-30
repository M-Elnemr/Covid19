package com.covid19.mvp.model;

import android.util.Log;

import com.covid19.network.RetrofitClient;
import com.covid19.responses.CasesByCountryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsModel implements DetailsContract.IModel {

    private DetailsContract.IPresenter presenter;
    private String countryName;
    private String dateFrom;
    private String dateTo;

    public DetailsModel(DetailsContract.IPresenter presenter, String countryName, String dateFrom, String dateTo) {
        this.presenter = presenter;
        this.countryName = countryName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    @Override
    public void getData() {
        RetrofitClient.getApi().getConfirmedCasesByCountry(countryName, dateFrom, dateTo)
                .enqueue(new Callback<List<CasesByCountryResponse>>() {
                    @Override
                    public void onResponse(Call<List<CasesByCountryResponse>> call, Response<List<CasesByCountryResponse>> response) {
                        if (response.code() == 200) {
                            presenter.onSuccess(response.body());
                        } else {
                            presenter.onFailed("Error code number : " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<CasesByCountryResponse>> call, Throwable t) {
                        presenter.onFailed(t.getMessage());
                        Log.d("TAG", "onFailure: "+t.getMessage());

                    }
                });
    }
}
