package tyfrontier.cleanarchitecturesample.presentation.presenter;

import tyfrontier.cleanarchitecturesample.domain.model.Article;

public interface TopPresenter extends Presenter {

    void onClickListItem(Article article);

    void onBindEnd(int position);

    void onClickAboutAppMenu();
}
