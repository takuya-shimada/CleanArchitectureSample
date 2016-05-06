package tyfrontier.cleanarchitecturesample.presentation.presenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import tyfrontier.cleanarchitecturesample.R;
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
        subscription = findArticles.call(0)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(topView::addArticle, this::showError);
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
    public void onBindEnd(int position) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        subscription = findArticles.call(position + 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(topView::addArticle, this::showError);
    }

    @Override
    public void onClickAboutAppMenu() {
        topView.showAboutApp();
    }

    private void showError(Throwable throwable) {
        AndroidSchedulers.mainThread().createWorker().schedule(() ->
                topView.showError(
                        throwable instanceof IOException ?
                                R.string.list_error_connection :
                                R.string.list_error_other),
                500,
                TimeUnit.MILLISECONDS);
    }
}
