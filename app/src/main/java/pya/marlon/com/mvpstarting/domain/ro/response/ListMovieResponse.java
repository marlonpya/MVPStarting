package pya.marlon.com.mvpstarting.domain.ro.response;

import java.util.List;

import pya.marlon.com.mvpstarting.domain.model.MovieBean;

/**
 * Created by marlonpya on 22/06/17.
 */

public class ListMovieResponse {
    private List<MovieBean> movies;

    public List<MovieBean> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieBean> movies) {
        this.movies = movies;
    }
}
