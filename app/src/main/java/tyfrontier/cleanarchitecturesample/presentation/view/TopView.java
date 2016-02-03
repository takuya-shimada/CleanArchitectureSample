package tyfrontier.cleanarchitecturesample.presentation.view;

import java.util.List;

import tyfrontier.cleanarchitecturesample.domain.model.Article;

public interface TopView {

    void initView();

    void showArticles(List<Article> articles);

    void showAboutApp();
}
