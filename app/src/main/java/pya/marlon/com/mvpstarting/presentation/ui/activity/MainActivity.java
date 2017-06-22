package pya.marlon.com.mvpstarting.presentation.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pya.marlon.com.mvpstarting.R;
import pya.marlon.com.mvpstarting.domain.model.MovieBean;
import pya.marlon.com.mvpstarting.presentation.adapter.MovieAdapter;
import pya.marlon.com.mvpstarting.presentation.presenter.MainPresenter;
import pya.marlon.com.mvpstarting.presentation.view.MainView;

public class MainActivity extends BaseActivity implements MainView, SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "MainActivity";
    @BindView(R.id.container) View container;
    @BindView(R.id.rvMovie) RecyclerView recyclerView;
    @BindView(R.id.srlMovie) SwipeRefreshLayout swipeRefreshLayout;

    private MainPresenter mainPresenter;
    private List<MovieBean> listMovieResponse;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        swipeRefreshLayout.setOnRefreshListener(this);
        initAdapter();
        mainPresenter = new MainPresenter();
        mainPresenter.addView(this);
        //mainPresenter.loadMovies();
        loadMovies();
    }

    private void initAdapter() {
        adapter = new MovieAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void loadMovies() {
        listMovieResponse = mainPresenter.loadMovies();
        if (listMovieResponse != null) {
            adapter.load(listMovieResponse);
        }
    }

    @Override
    public void showMessage(String message) {
        super.showMessage(container, message);
    }

    @Override
    public void goToDescription(MovieBean movie) {
        mainPresenter.click(movie);
    }

    @Override
    public void onRefresh() {
        loadMovies();
    }
}
