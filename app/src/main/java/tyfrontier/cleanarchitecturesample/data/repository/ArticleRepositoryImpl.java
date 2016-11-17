package tyfrontier.cleanarchitecturesample.data.repository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import tyfrontier.cleanarchitecturesample.data.cache.ArticleDto;
import tyfrontier.cleanarchitecturesample.data.cache.CacheService;
import tyfrontier.cleanarchitecturesample.domain.model.Article;
import tyfrontier.cleanarchitecturesample.domain.net.WebApi;
import tyfrontier.cleanarchitecturesample.domain.repository.ArticleRepository;

public class ArticleRepositoryImpl implements ArticleRepository {

    private static final int NUM_PER_PAGE = 20;

    private final WebApi webApi;
    private final CacheService cache;

    @Inject
    public ArticleRepositoryImpl(WebApi webApi, CacheService cache) {
        this.webApi = webApi;
        this.cache = cache;
    }

    @Override
    public Observable<List<Article>> findArticles(int requestIndex) {
        return cache.count(ArticleDto.class) < requestIndex + 1
                ? webApi.getArticles(requestIndex / NUM_PER_PAGE + 1, NUM_PER_PAGE)
                    .doOnNext(article -> cache.set(ArticleDto.class, article))
                    .toList()
                : cache.get(ArticleDto.class);
    }
}
