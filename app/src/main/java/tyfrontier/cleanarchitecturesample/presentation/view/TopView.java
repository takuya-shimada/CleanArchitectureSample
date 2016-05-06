package tyfrontier.cleanarchitecturesample.presentation.view;

import tyfrontier.cleanarchitecturesample.domain.model.Article;

public interface TopView {

    void initView();

    void resetView();

    void addArticle(Article article);

    void showAboutApp();

    void showError(int stringResId);
}
