package pya.marlon.com.mvpstarting.presentation.presenter;

import android.util.Log;

import java.util.List;

import pya.marlon.com.mvpstarting.domain.dto.ServiceResponse;
import pya.marlon.com.mvpstarting.domain.model.MovieBean;
import pya.marlon.com.mvpstarting.presentation.view.MainView;
import pya.marlon.com.mvpstarting.service.business.MovieService;
import pya.marlon.com.mvpstarting.service.business.impl.MovieImpl;

/**
 * Created by marlonpya on 22/06/17.
 */

public class MainPresenter implements Presenter<MainView> {
    private static final String TAG = "MainPresenter";
    private MainView mainView;
    private MovieService movieService;
    private List<MovieBean> movies;

    public List<MovieBean> loadMovies() {
        mainView.showLoading();
        movieService.getMovies(new ServiceResponse<List<MovieBean>>() {
            @Override
            public void onSucces(List<MovieBean> response) {
                mainView.hideLoading();
                movies = response;
            }

            @Override
            public void onError(String message) {
                Log.d(TAG, "onError: " +  message);
                mainView.hideLoading();
                mainView.showMessage(message);
            }
        });
        return movies;
    }

    public void click(MovieBean movieBean) {
        Log.d(TAG, "click: " + movieBean.toString());
    }

    @Override
    public void addView(MainView view) {
        this.mainView = view;
        this.movieService = new MovieImpl();
    }

    @Override
    public void removeView(MainView view) {
        this.mainView = null;
    }
}
