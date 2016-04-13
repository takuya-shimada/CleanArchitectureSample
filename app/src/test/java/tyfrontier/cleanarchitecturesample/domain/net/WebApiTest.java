package tyfrontier.cleanarchitecturesample.domain.net;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import javax.inject.Inject;

import rx.observers.TestSubscriber;
import tyfrontier.cleanarchitecturesample.di.component.DaggerTestDataComponent;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;

public class WebApiTest {

    @Inject WebApi webApi;

    @Before
    public void setUp() throws Exception {
        DaggerTestDataComponent.builder().build().inject(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetArticles() throws Exception {
        final int articleNumPerPage = 30;
        TestSubscriber<List<Article>> testSubscriber = new TestSubscriber<>();

        webApi.getArticles(1, articleNumPerPage).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        List<Article> articleList = testSubscriber.getOnNextEvents().get(0);

        assertThat(articleList, hasSize(greaterThan(0)));
        assertThat(articleList, hasSize(lessThan(articleNumPerPage + 1)));
    }
}