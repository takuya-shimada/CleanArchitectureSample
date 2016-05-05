package tyfrontier.cleanarchitecturesample.data.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import tyfrontier.cleanarchitecturesample.domain.model.Article;
import tyfrontier.cleanarchitecturesample.domain.net.WebApi;
import tyfrontier.cleanarchitecturesample.domain.repository.ArticleRepository;

public class ArticleRepositoryImpl implements ArticleRepository {

    private final WebApi webApi;
    private final List<Article> cache = new ArrayList<>();

    @Inject
    public ArticleRepositoryImpl(WebApi webApi) {
        this.webApi = webApi;
    }

    @Override
    public Observable<Article> findArticles() {
        return cache.isEmpty() ? webApi.getArticles(1, 20).doOnNext(cache::add) : Observable.from(cache);
    }
}
