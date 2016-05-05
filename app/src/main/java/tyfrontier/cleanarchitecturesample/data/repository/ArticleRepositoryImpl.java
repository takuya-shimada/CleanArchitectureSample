package tyfrontier.cleanarchitecturesample.data.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import tyfrontier.cleanarchitecturesample.domain.model.Article;
import tyfrontier.cleanarchitecturesample.domain.net.WebApi;
import tyfrontier.cleanarchitecturesample.domain.repository.ArticleRepository;

public class ArticleRepositoryImpl implements ArticleRepository {

    private static final int NUM_PER_PAGE = 20;

    private final WebApi webApi;
    private final List<Article> cache = new ArrayList<>();

    @Inject
    public ArticleRepositoryImpl(WebApi webApi) {
        this.webApi = webApi;
    }

    @Override
    public Observable<Article> findArticles(int requestIndex) {
        return cache.size() < requestIndex + 1
                ? webApi.getArticles(requestIndex / NUM_PER_PAGE + 1, NUM_PER_PAGE)
                        .doOnNext(cache::add)
                : Observable.from(cache);
    }
}
