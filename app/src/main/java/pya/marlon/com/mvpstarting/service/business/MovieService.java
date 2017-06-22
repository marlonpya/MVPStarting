package pya.marlon.com.mvpstarting.service.business;

import java.util.List;

import pya.marlon.com.mvpstarting.domain.dto.ServiceResponse;
import pya.marlon.com.mvpstarting.domain.model.MovieBean;
import rx.Subscription;

/**
 * Created by marlonpya on 22/06/17.
 */

public interface MovieService {
    Subscription getMovies(ServiceResponse<List<MovieBean>> response);
}
