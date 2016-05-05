package tyfrontier.cleanarchitecturesample.presentation.view.component;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tyfrontier.cleanarchitecturesample.R;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

public class ArticleListAdapter extends RecyclerView.Adapter {

    public interface ItemClickListener {
        void onListItemClick(Article article);
    }

    public interface BindEndListener {
        void onBindEnd(int position);
    }

    private final LayoutInflater inflater;

    private final List<Article> articles = new ArrayList<>();
    private final ItemClickListener itemClickListener;
    private final BindEndListener bindEndListener;

    public ArticleListAdapter(Context context, ItemClickListener itemClickListener, BindEndListener bindEndListener) {
        inflater = LayoutInflater.from(context);
        this.itemClickListener = itemClickListener;
        this.bindEndListener = bindEndListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(inflater.inflate(R.layout.article_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ArticleListItemView itemView = (ArticleListItemView)viewHolder.itemView;
        itemView.setTag(position);

        Article article = articles.get(position);
        if (article != null) {
            itemView.setTitle(article.getTitle());
            itemView.setUserName(article.getUserName());
            itemView.setTags(concatenateTags(article.getTags()));
            itemView.setTime(DateUtils.getRelativeTimeSpanString(
                    article.getCreatedAt().getTime(), System.currentTimeMillis(), 0));
            itemView.setOnClickListener(v -> itemClickListener.onListItemClick(article));
        }

        if (position == articles.size() - 1) {
            bindEndListener.onBindEnd(position);
        }
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void clearItem() {
        articles.clear();
        notifyDataSetChanged();
    }

    public void addItem(Article article) {
        articles.add(article);
        notifyItemInserted(getItemCount()-1);
    }

    private String concatenateTags(List<String> tags) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String tag : tags) {
            stringBuilder.append(stringBuilder.length() > 0 ? ", " + tag : tag);
        }

        return stringBuilder.toString();
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
