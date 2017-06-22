package pya.marlon.com.mvpstarting.domain.dto;

/**
 * Created by marlonpya on 22/06/17.
 */

public interface ServiceResponse<T> {
    void onSucces(T response);
    void onError(String message);
}
