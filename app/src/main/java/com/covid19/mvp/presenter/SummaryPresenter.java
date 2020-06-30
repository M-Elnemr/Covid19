package com.covid19.mvp.presenter;

import com.covid19.mvp.model.SummaryContract;
import com.covid19.mvp.model.SummaryModel;
import com.covid19.responses.SummaryResponse;

import javax.inject.Inject;

public class SummaryPresenter implements SummaryContract.IPresenter {

    private SummaryContract.IModel model;
    private SummaryContract.IView view;

    @Inject
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
