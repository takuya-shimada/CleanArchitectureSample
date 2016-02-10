package tyfrontier.cleanarchitecturesample.domain.usecase;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import tyfrontier.cleanarchitecturesample.TestMainApplication;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

@RunWith(AndroidJUnit4.class)
public class FindArticlesTest {

    @Inject FindArticles findArticles;

    private List<Article> articleList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        ((TestMainApplication) InstrumentationRegistry.getTargetContext().getApplicationContext())
                .appComponent()
                .inject(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCall() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);

        findArticles.call(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Article>>() {
                    @Override
                    public void onCompleted() {
                        signal.countDown();
                    }

                    @Override
                    public void onError(Throwable e) {
                        signal.countDown();
                    }

                    @Override
                    public void onNext(List<Article> articleList) {
                        FindArticlesTest.this.articleList = articleList;
                    }
                });
        signal.await(30, TimeUnit.SECONDS);

        assertThat(articleList, hasSize(greaterThan(0)));
    }
}