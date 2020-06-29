package com.covid19.presenter;

import com.covid19.model.DetailsContract;
import com.covid19.model.DetailsModel;
import com.covid19.responses.CasesByCountryResponse;

import java.util.List;

public class DetailsPresenter implements DetailsContract.IPresenter {

    private DetailsContract.IView view;
    private DetailsContract.IModel model;


    public DetailsPresenter(DetailsContract.IView view, String countryName, String dateFrom, String dateTo) {
        this.view = view;
        model = new DetailsModel(this, countryName, dateFrom, dateTo);
    }

    @Override
    public void onDataRequested() {
        model.getData();
    }

    @Override
    public void onSuccess(List<CasesByCountryResponse> data) {
        view.onDataReceived(data);
    }

    @Override
    public void onFailed(String error) {
        view.onResponseFailure(error);
    }
}
