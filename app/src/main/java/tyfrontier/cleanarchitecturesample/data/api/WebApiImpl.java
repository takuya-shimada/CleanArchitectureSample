package tyfrontier.cleanarchitecturesample.data.api;

import javax.inject.Inject;

import rx.Observable;
import tyfrontier.cleanarchitecturesample.data.api.dto.ArticleDto;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

public class WebApiImpl implements WebApi {

    private ApiService apiService;

    @Inject
    public WebApiImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<Article> getArticles(int page, int perPage) {
        return apiService.getArticles(page, perPage, null)
                .flatMapIterable(articleDtoList -> articleDtoList)
                .map(ArticleDto::map);
    }
}
