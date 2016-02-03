package tyfrontier.cleanarchitecturesample.data.api;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;
import tyfrontier.cleanarchitecturesample.data.api.dto.ArticleDto;
import tyfrontier.cleanarchitecturesample.data.api.mapper.ArticleMapper;
import tyfrontier.cleanarchitecturesample.domain.model.Article;
import tyfrontier.cleanarchitecturesample.domain.net.WebApi;

public class WebApiImpl implements WebApi {

    private static final String BASE_URL = "https://qiita.com/";

    private ApiService apiService = ApiServiceFactory.createRetrofitService(ApiService.class, BASE_URL);

    @Inject
    public WebApiImpl() {
    }

    @Override
    public Observable<List<Article>> getArticles(int page, int perPage) {
        return apiService.getArticles(page, perPage, null).map(new Func1<List<ArticleDto>, List<Article>>() {
            @Override
            public List<Article> call(List<ArticleDto> articleDtos) {
            return new ArticleMapper().map(articleDtos);
            }
        });
    }
}
