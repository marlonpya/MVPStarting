package pya.marlon.com.mvpstarting.presentation.media.image;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by marlonpya on 21/06/17.
 */

public class ImageGlide implements IImageLoader{

    @Override
    public void load(String url, ImageView imageView) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @Override
    public void load(String url, ImageView imageView, int placeHolder) {
        Glide.with(imageView.getContext()).load(url).placeholder(placeHolder).into(imageView);
    }

    @Override
    public void loadDefault(String url, ImageView imageView) {
        Glide.with(imageView.getContext()).load(url).placeholder(android.R.mipmap.sym_def_app_icon).into(imageView);
    }
}
