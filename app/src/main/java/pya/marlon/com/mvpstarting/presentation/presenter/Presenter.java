package pya.marlon.com.mvpstarting.presentation.presenter;

/**
 * Created by marlonpya on 22/06/17.
 */

public interface Presenter<T> {
    void addView(T view);
    void removeView(T view);
}
