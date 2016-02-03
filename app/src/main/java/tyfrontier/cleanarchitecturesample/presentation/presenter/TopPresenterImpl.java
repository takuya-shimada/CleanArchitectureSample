package tyfrontier.cleanarchitecturesample.presentation.presenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
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
    }

    @Override
    public void onResume() {
        subscribe(findArticles.call(1), new ArticleSubscriber());
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onDestroy() {
        subscription.unsubscribe();
    }

    @Override
    public void onClickListItem(Article article) {
        activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(article.getUrl().toString())));
    }

    @Override
    public void onClickAboutAppMenu() {
        topView.showAboutApp();
    }

    private void subscribe(Observable observable, Subscriber subscriber) {
        subscription = observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    private final class ArticleSubscriber extends Subscriber<List<Article>> {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(List<Article> articles) {
            topView.showArticles(articles);
        }
    }
}
