package tyfrontier.cleanarchitecturesample.domain.net;

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
import tyfrontier.cleanarchitecturesample.TestApp;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;

@RunWith(AndroidJUnit4.class)
public class WebApiTest {

    @Inject WebApi webApi;

    private List<Article> articleList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        ((TestApp)InstrumentationRegistry.getTargetContext().getApplicationContext())
                .appComponent()
                .inject(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetArticles() throws Exception {
        final int articleNumPerPage = 30;
        final CountDownLatch signal = new CountDownLatch(1);

        webApi.getArticles(1, articleNumPerPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Article>>() {
                    @Override
                    public void onCompleted() {
                        signal.countDown();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        signal.countDown();
                    }

                    @Override
                    public void onNext(List<Article> articleList) {
                        WebApiTest.this.articleList = articleList;
                    }
                });
        signal.await(30, TimeUnit.SECONDS);

        assertThat(articleList, hasSize(greaterThan(0)));
        assertThat(articleList, hasSize(lessThan(articleNumPerPage + 1)));
    }
}