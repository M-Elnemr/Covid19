package com.covid19.mvp.model;

import com.covid19.responses.CasesByCountryResponse;

import java.util.List;

public class DetailsContract {

    public interface IView {
        void onDataReceived(List<CasesByCountryResponse> data);

        void onResponseFailure(String error);
    }

    public interface IPresenter {
        void onDataRequested();

        void onSuccess(List<CasesByCountryResponse> data);

        void onFailed(String error);
    }

    public interface IModel {
        void getData();
    }
}
