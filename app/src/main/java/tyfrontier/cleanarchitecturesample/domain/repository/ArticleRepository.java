package tyfrontier.cleanarchitecturesample.domain.repository;

import rx.Observable;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

public interface ArticleRepository {

    Observable<Article> findArticles(int requestIndex);
}
