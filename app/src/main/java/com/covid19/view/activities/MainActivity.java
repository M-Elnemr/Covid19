package com.covid19.view.activities;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.covid19.R;
import com.covid19.view.fragments.SummaryFragment;
import com.trycatch.mysnackbar.TSnackbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    public static TSnackbar bSnack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        final ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content).getRootView();

        bSnack = TSnackbar.make(viewGroup, "", TSnackbar.LENGTH_INDEFINITE, TSnackbar.APPEAR_FROM_BOTTOM_TO_TOP);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,
                new SummaryFragment(), "summary").commit();
    }
}
