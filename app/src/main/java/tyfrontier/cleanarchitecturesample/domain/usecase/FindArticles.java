package tyfrontier.cleanarchitecturesample.domain.usecase;

import rx.Observable;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

public interface FindArticles extends UseCase<Integer, Observable<Article>> {
}
