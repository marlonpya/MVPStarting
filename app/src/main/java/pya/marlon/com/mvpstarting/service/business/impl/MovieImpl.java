package pya.marlon.com.mvpstarting.service.business.impl;

import android.util.Log;

import java.util.List;

import pya.marlon.com.mvpstarting.domain.dto.ServiceResponse;
import pya.marlon.com.mvpstarting.domain.model.MovieBean;
import pya.marlon.com.mvpstarting.presentation.AndroidApplication;
import pya.marlon.com.mvpstarting.service.business.MovieService;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by marlonpya on 22/06/17.
 */

public class MovieImpl implements MovieService{
    private static final String TAG = "MovieImpl";

    @Override
    public Subscription getMovies(ServiceResponse<List<MovieBean>> response) {
        Observable<List<MovieBean>> observable = AndroidApplication.getInstance().getService().getMovies();
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<MovieBean>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.toString(), e);
                        response.onError(e.toString());
                    }

                    @Override
                    public void onNext(List<MovieBean> listMovieResponse) {
                        response.onSucces(listMovieResponse);
                        for (MovieBean movieBean : listMovieResponse) {
                            Log.d(TAG, "onNext: " + movieBean.toString());
                        }
                    }
                });
    }
}
