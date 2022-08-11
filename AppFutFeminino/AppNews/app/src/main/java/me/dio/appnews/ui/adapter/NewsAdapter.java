package me.dio.appnews.ui.adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.dio.appnews.R;
import me.dio.appnews.databinding.NewsItemBinding;
import me.dio.appnews.domain.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {


    private List<News> news;
    public NewsListener favoriteListener;

    public NewsAdapter(List<News> news, NewsListener favoriteListener) {
        this.news = news;
        this.favoriteListener = favoriteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        News news = this.news.get(position);
        holder.bindig.tvNewsTitle.setText(news.getTitle());
        holder.bindig.tvNewsDescription.setText(news.getDescription());
        Picasso.get().load(news.getImage()).into(holder.bindig.ivNewsImage);

        //Implementacao funcionalidade de abrir link.

        holder.bindig.btOpenLink.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(news.getLink()));
            context.startActivity(i);
        });
        //Implementacao funcionalidade de share.
        holder.bindig.ivShare.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, news.getTitle());
            i.putExtra(Intent.EXTRA_TEXT, news.getLink());
            context.startActivity(Intent.createChooser(i, "Share"));
        });

        //Implementacao funcionalidade de favoritar.
        holder.bindig.ivFavorite.setOnClickListener(view -> {
            news.favorite = !news.favorite;
            this.favoriteListener.click(news);
            notifyItemChanged(position);
        });

        int favoriteColor = news.favorite ? R.color.favorite_active : R.color.favorite_inactive;
            holder.bindig.ivFavorite.setColorFilter(context.getResources().getColor(favoriteColor));

    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final NewsItemBinding bindig;

        public ViewHolder(NewsItemBinding bindig) {
            super(bindig.getRoot());
            this.bindig = bindig;
        }
    }

    public interface NewsListener {
       void click(News news);
    }
}
