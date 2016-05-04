package tyfrontier.cleanarchitecturesample.presentation.presenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import tyfrontier.cleanarchitecturesample.di.PerActivity;
import tyfrontier.cleanarchitecturesample.domain.model.Article;
import tyfrontier.cleanarchitecturesample.domain.usecase.FindArticles;
import tyfrontier.cleanarchitecturesample.presentation.view.TopView;

@PerActivity
public class TopPresenterImpl implements TopPresenter {

    private final Activity activity;
    private final TopView topView;
    private final FindArticles findArticles;

    private Subscription subscription;

    @Inject
    public TopPresenterImpl(Activity activity, TopView topView, FindArticles findArticles) {
        this.activity = activity;
        this.topView = topView;
        this.findArticles = findArticles;
    }

    @Override
    public void onCreate() {
        topView.initView();
    }

    @Override
    public void onStart() {
        topView.resetView();
        subscription = findArticles.call(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(topView::addArticle);
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onStop() {
        subscription.unsubscribe();
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onClickListItem(Article article) {
        activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(article.getUrl().toString())));
    }

    @Override
    public void onClickAboutAppMenu() {
        topView.showAboutApp();
    }
}
