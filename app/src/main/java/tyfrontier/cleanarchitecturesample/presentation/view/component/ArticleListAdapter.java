package tyfrontier.cleanarchitecturesample.presentation.view.component;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import tyfrontier.cleanarchitecturesample.domain.model.Article;

public class ArticleListAdapter extends ArrayAdapter<Article> {

    private List<Article> articles = new ArrayList<>();
    private int mItemLayoutResource;

    public ArticleListAdapter(Context context, @LayoutRes int resource) {
        super(context, resource);
        mItemLayoutResource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mItemLayoutResource, null);
        }

        ArticleListItemView itemView = (ArticleListItemView)convertView;
        itemView.setTag(position);

        Article article = articles.get(position);
        if (article != null) {
            itemView.setTitle(article.getTitle());
            itemView.setUserName(article.getUserName());
            itemView.setTags(concatenateTags(article.getTags()));
            itemView.setTime(DateUtils.getRelativeTimeSpanString(
                    article.getCreatedAt().getTime(), System.currentTimeMillis(), 0));
        }

        return convertView;
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public Article getItem(int position) {
        return articles.get(position);
    }

    public void clearItem() {
        articles.clear();
        notifyDataSetChanged();
    }

    public void addItem(Article article) {
        articles.add(article);
        notifyDataSetChanged();
    }

    private String concatenateTags(List<String> tags) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String tag : tags) {
            stringBuilder.append(stringBuilder.length() > 0 ? ", " + tag : tag);
        }

        return stringBuilder.toString();
    }
}
