package tyfrontier.cleanarchitecturesample.domain.model;

import java.util.List;

import rx.Observable;
import tyfrontier.cleanarchitecturesample.domain.net.WebApi;

public class ArticleService {

    private static final int ARTICLE_NUM_PER_PAGE = 20;

    private final WebApi webApi;

    public ArticleService(WebApi webApi) {
        this.webApi = webApi;
    }

    public Observable<List<Article>> findArticles(int page) {
        return webApi.getArticles(page, ARTICLE_NUM_PER_PAGE);
    }
}
