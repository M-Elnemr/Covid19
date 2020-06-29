package com.covid19.model;

import com.covid19.responses.SummaryResponse;

public class SummaryContract {

    public interface IView {
        void onDataReceived(SummaryResponse noticeArrayList);

        void onResponseFailure(String error);

    }

    public interface IPresenter {
        void onRequestData();

        void onSuccess(SummaryResponse noticeArrayList);

        void onFailed(String error);
    }

    public interface IModel {
        void getData();
    }

}
