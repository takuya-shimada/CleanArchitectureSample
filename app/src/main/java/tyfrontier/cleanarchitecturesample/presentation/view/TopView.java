package tyfrontier.cleanarchitecturesample.presentation.view;

import java.util.List;

import tyfrontier.cleanarchitecturesample.domain.model.Article;

public interface TopView {

    void initView();

    void resetView();

    void addArticle(List<Article> article);

    void showAboutApp();

    void showError(int stringResId);
}
