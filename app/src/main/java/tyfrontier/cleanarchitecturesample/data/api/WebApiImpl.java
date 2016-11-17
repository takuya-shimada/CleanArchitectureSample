package tyfrontier.cleanarchitecturesample.data.api;

import javax.inject.Inject;

import rx.Observable;
import tyfrontier.cleanarchitecturesample.data.api.dto.ArticleDto;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

public class WebApiImpl implements WebApi {

    private static final String BASE_URL = "https://qiita.com/";

    private ApiService apiService = ApiServiceFactory.createRetrofitService(ApiService.class, BASE_URL);

    @Inject
    public WebApiImpl() {
    }

    @Override
    public Observable<Article> getArticles(int page, int perPage) {
        return apiService.getArticles(page, perPage, null)
                .flatMapIterable(articleDtoList -> articleDtoList)
                .map(ArticleDto::map);
    }
}
