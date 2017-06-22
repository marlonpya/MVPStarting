package pya.marlon.com.mvpstarting.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pya.marlon.com.mvpstarting.R;
import pya.marlon.com.mvpstarting.domain.model.MovieBean;
import pya.marlon.com.mvpstarting.presentation.media.image.ImageLoader;
import pya.marlon.com.mvpstarting.presentation.media.image.ImageType;

/**
 * Created by marlonpya on 21/06/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<MovieBean> movies;
    private LayoutInflater inflater;
    private ImageLoader imageLoader;

    public MovieAdapter(Context context) {
        this.movies = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
        this.imageLoader = new ImageLoader(ImageType.GLIDE);
    }

    public void load(List<MovieBean> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.row_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(MovieAdapter.ViewHolder holder, int position) {
        final MovieBean movieBean = movies.get(position);
        holder.text_repo_name.setText(movieBean.name);
        holder.text_repo_description.setText(movieBean.description);
        holder.text_language.setText(movieBean.language);
        holder.text_stars.setText(movieBean.stargazersCount + "");
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_repo_name) TextView text_repo_name;
        @BindView(R.id.text_repo_description) TextView text_repo_description;
        @BindView(R.id.text_language) TextView text_language;
        @BindView(R.id.text_stars) TextView text_stars;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
