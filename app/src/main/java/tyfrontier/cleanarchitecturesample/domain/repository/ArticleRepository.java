package tyfrontier.cleanarchitecturesample.domain.repository;

import java.util.List;

import rx.Observable;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

public interface ArticleRepository {

    Observable<List<Article>> findArticles(int requestIndex);
}
