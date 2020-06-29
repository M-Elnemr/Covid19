package com.covid19.presenter;

import com.covid19.model.SummaryContract;
import com.covid19.model.SummaryModel;
import com.covid19.responses.SummaryResponse;

public class SummaryPresenter implements SummaryContract.IPresenter {

    private SummaryContract.IModel model;
    private SummaryContract.IView view;

    public SummaryPresenter(SummaryContract.IView view) {
        this.view = view;
        model = new SummaryModel(this);
    }

    @Override
    public void onRequestData() {
        model.getData();
    }

    @Override
    public void onSuccess(SummaryResponse data) {
        view.onDataReceived(data);
    }

    @Override
    public void onFailed(String error) {
        view.onResponseFailure(error);
    }
}
