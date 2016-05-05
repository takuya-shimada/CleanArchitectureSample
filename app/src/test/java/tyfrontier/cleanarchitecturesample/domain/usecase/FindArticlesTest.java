package tyfrontier.cleanarchitecturesample.domain.usecase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import javax.inject.Inject;

import rx.observers.TestSubscriber;
import tyfrontier.cleanarchitecturesample.di.component.DaggerTestDomainComponent;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class FindArticlesTest {

    @Inject FindArticles findArticles;

    @Before
    public void setUp() throws Exception {
        DaggerTestDomainComponent.builder().build().inject(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCall() throws Exception {
        TestSubscriber<Article> testSubscriber = new TestSubscriber<>();

        findArticles.call(1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        List<Article> articleList = testSubscriber.getOnNextEvents();

        assertThat(articleList, hasSize(greaterThan(0)));
    }
}