package com.covid19.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.covid19.R;
import com.covid19.adapter.SummaryAdapter;
import com.covid19.model.SummaryContract;
import com.covid19.presenter.SummaryPresenter;
import com.covid19.responses.SummaryResponse;
import com.covid19.util.Constants;
import com.covid19.util.Utils;
import com.trycatch.mysnackbar.Prompt;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SummaryFragment extends Fragment implements SummaryContract.IView {

    @BindView(R.id.summary_recycler)
    RecyclerView summaryRecycler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.linear_no_internet)
    LinearLayout linearNoInternet;
    @BindView(R.id.linear_no_data)
    LinearLayout linearNoData;
    @BindView(R.id.linear_error)
    LinearLayout linearError;
    private SummaryPresenter presenter;
    private SummaryAdapter adapter;

    public SummaryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_summary, container, false);
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

        presenter = new SummaryPresenter(this);
        summaryRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        summaryRecycler.setHasFixedSize(true);
    }

    private void loadData() {
        if (!Utils.isNetworkAvailable(getActivity())) {
            Utils.showBSnack(Prompt.ERROR, getString(R.string.no_internet));
            toggle(View.GONE, View.GONE, View.VISIBLE, View.GONE);

            return;
        }

        presenter.onRequestData();
        Utils.showLoadingSnack();
    }

    @Override
    public void onDataReceived(SummaryResponse data) {
        if (data.getCountries().size() > 0) {
            Utils.hideBSnack();
            toggle(View.VISIBLE, View.GONE, View.GONE, View.GONE);
            adapter = new SummaryAdapter(getContext(), data.getCountries());
            summaryRecycler.setAdapter(adapter);

            adapter.setListener(new SummaryAdapter.OnProductClick() {
                @Override
                public void onDetails(String countryName) {
                    CountryDetailsFragment countryDetailsFragment = new CountryDetailsFragment();
                    countryDetailsFragment.setEnterTransition(TransitionInflater.from(getActivity()).inflateTransition(android.R.transition.slide_bottom));

                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.COUNTRY_NAME, countryName);
                    countryDetailsFragment.setArguments(bundle);

                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(R.id.main_container, countryDetailsFragment)
                            .addToBackStack(null).commit();
                }
            });

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
        summaryRecycler.setVisibility(recycler);
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
