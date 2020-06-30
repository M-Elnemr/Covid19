package com.covid19.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.covid19.R;
import com.covid19.adapter.DetailsAdapter;
import com.covid19.mvp.model.DetailsContract;
import com.covid19.mvp.presenter.DetailsPresenter;
import com.covid19.responses.CasesByCountryResponse;
import com.covid19.util.Constants;
import com.covid19.util.Utils;
import com.trycatch.mysnackbar.Prompt;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryDetailsFragment extends Fragment implements DetailsContract.IView {

    @BindView(R.id.countryName)
    TextView countryName;
    @BindView(R.id.details_recycler)
    RecyclerView detailsRecycler;
    @BindView(R.id.linear_no_internet)
    LinearLayout linearNoInternet;
    @BindView(R.id.linear_no_data)
    LinearLayout linearNoData;
    @BindView(R.id.linear_error)
    LinearLayout linearError;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private DetailsPresenter presenter;
    private DetailsAdapter adapter;
    private String mCountryName;
    private String mFrom = "2020-04-01T00:00:00Z";
    private String mTo = "2020-06-01T00:00:00Z";


    public CountryDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_country_details, container, false);
        ButterKnife.bind(this, v);

        init();
        loadData();

        return v;
    }

    private void init() {
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh.setRefreshing(false);
                loadData();
            }
        });

        Bundle bundle = getArguments();

        if (bundle != null) {
            mCountryName = bundle.getString(Constants.COUNTRY_NAME);

            countryName.setText(mCountryName);
            presenter = new DetailsPresenter(this, mCountryName, mFrom, mTo);

        }

        detailsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        detailsRecycler.setHasFixedSize(true);
    }

    private void loadData() {
        if (!Utils.isNetworkAvailable(getActivity())) {
            Utils.showBSnack(Prompt.ERROR, getString(R.string.no_internet));
            toggle(View.GONE, View.GONE, View.VISIBLE, View.GONE);

            return;
        }

        presenter.onDataRequested();
        Utils.showLoadingSnack();
    }

    @Override
    public void onDataReceived(List<CasesByCountryResponse> data) {
        if (data.size() > 0) {
            Utils.hideBSnack();
            toggle(View.VISIBLE, View.GONE, View.GONE, View.GONE);
            adapter = new DetailsAdapter(getContext(), data);
            detailsRecycler.setAdapter(adapter);
        } else {
            Utils.showBSnack(Prompt.ERROR, getString(R.string.no_data));
            toggle(View.GONE, View.VISIBLE, View.GONE, View.GONE);
        }
    }

    @Override
    public void onResponseFailure(String error) {
        Utils.showBSnack(Prompt.ERROR, error);
        toggle(View.GONE, View.GONE, View.GONE, View.VISIBLE);
    }

    private void toggle(int recycler, int noData, int noInternet, int error) {
        detailsRecycler.setVisibility(recycler);
        linearNoData.setVisibility(noData);
        linearNoInternet.setVisibility(noInternet);
        linearError.setVisibility(error);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        Utils.hideBSnack();
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        Utils.hideBSnack();
        super.onDetach();
    }

}
