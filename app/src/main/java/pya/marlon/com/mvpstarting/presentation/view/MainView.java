package pya.marlon.com.mvpstarting.presentation.view;

import pya.marlon.com.mvpstarting.domain.model.MovieBean;

/**
 * Created by marlonpya on 22/06/17.
 */

public interface MainView {
    void showLoading();
    void hideLoading();
    void loadMovies();
    void showMessage(String message);
    void goToDescription(MovieBean movie);
}
