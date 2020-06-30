package com.covid19.mvp.model;

import com.covid19.network.RetrofitClient;
import com.covid19.responses.SummaryResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SummaryModel implements SummaryContract.IModel {

    private SummaryContract.IPresenter presenter;

    @Inject
    public SummaryModel(SummaryContract.IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getData() {

        RetrofitClient.getApi().getSummary().enqueue(new Callback<SummaryResponse>() {
            @Override
            public void onResponse(Call<SummaryResponse> call, Response<SummaryResponse> response) {
                if (response.code() == 200){
                    presenter.onSuccess(response.body());
                }else {
                    presenter.onFailed("Error code number : "+ response.code());
                }
            }

            @Override
            public void onFailure(Call<SummaryResponse> call, Throwable t) {
                presenter.onFailed(t.getMessage());
            }
        });
    }
}
