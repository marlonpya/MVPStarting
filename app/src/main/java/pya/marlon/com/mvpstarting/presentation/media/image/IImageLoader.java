package pya.marlon.com.mvpstarting.presentation.media.image;

import android.widget.ImageView;

/**
 * Created by marlonpya on 21/06/17.
 */

public interface IImageLoader {
    void load(String url, ImageView imageView);
    void load(String url, ImageView imageView, int placeHolder);
    void loadDefault(String url, ImageView imageView);
    //void load(String path, ImageView imageView);
}
