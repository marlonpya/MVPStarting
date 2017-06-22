package pya.marlon.com.mvpstarting.presentation.media.image;

/**
 * Created by marlonpya on 21/06/17.
 */

public class ImageLoader {
    private ImageType type;
    private IImageLoader iImageLoader;

    public ImageLoader(ImageType type) {
        this.type = type;
        this.iImageLoader = load();
    }

    private IImageLoader load() {
        switch (type) {
            case GLIDE:     return new ImageGlide();
            case PICASSO:   return null;
            default:        return null;
        }
    }

    public IImageLoader getiImageLoader(){
        return iImageLoader;
    }
}
