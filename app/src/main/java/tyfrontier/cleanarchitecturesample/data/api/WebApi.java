package tyfrontier.cleanarchitecturesample.data.api;

import rx.Observable;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

public interface WebApi {

    Observable<Article> getArticles(int page, int perPage);
}
