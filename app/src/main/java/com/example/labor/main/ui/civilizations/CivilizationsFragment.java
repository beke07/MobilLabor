package com.example.labor.main.ui.civilizations;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.labor.main.CivilizationApplication;
import com.example.labor.main.component.CivilizationApplicationComponent;
import com.example.labor.main.model.Civilization;

import java.util.List;

public class CivilizationsFragment extends Fragment implements CivilizationScreen {

    private SwipeRefreshLayout swipeRefreshLayoutArtists;

    public CivilizationsFragment() {
        CivilizationApplication.injector.inject(this);
    }

    @Override
    public void showCivilizations(List<Civilization> civilizations) {

    }

    @Override
    public void showNetworkError(String errorMsg) {
        if (swipeRefreshLayoutArtists != null) {
            swipeRefreshLayoutArtists.setRefreshing(false);
        }
        Toast.makeText(getContext(), errorMsg, Toast.LENGTH_LONG).show();
    }
}
