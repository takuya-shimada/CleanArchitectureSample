package tyfrontier.cleanarchitecturesample.domain.usecase;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import tyfrontier.cleanarchitecturesample.data.api.WebApi;
import tyfrontier.cleanarchitecturesample.data.cache.ArticleDto;
import tyfrontier.cleanarchitecturesample.data.cache.CacheService;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

public class FindArticlesImpl implements FindArticles {

    private static final int NUM_PER_PAGE = 20;

    private final WebApi webApi;
    private final CacheService cache;

    @Inject
    public FindArticlesImpl(WebApi webApi, CacheService cache) {
        this.webApi = webApi;
        this.cache = cache;
    }

    @Override
    public Observable<List<Article>> call(Integer requestIndex) {
        return cache.count(ArticleDto.class) < requestIndex + 1
                ? webApi.getArticles(requestIndex / NUM_PER_PAGE + 1, NUM_PER_PAGE)
                .doOnNext(article -> cache.set(ArticleDto.class, article))
                .toList()
                : cache.get(ArticleDto.class);
    }
}
