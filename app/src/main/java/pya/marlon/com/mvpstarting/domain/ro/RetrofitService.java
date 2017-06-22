package pya.marlon.com.mvpstarting.domain.ro;

import java.util.List;

import pya.marlon.com.mvpstarting.domain.model.MovieBean;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by marlonpya on 22/06/17.
 */

public interface RetrofitService {
    @GET("users/arriolac/starred")
    Observable<List<MovieBean>> getMovies();
}
