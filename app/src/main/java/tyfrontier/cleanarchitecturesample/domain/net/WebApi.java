package tyfrontier.cleanarchitecturesample.domain.net;

import java.util.List;

import rx.Observable;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

public interface WebApi {

    Observable<List<Article>> getArticles(int page, int perPage);
}
