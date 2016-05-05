package tyfrontier.cleanarchitecturesample.domain.model;

import javax.inject.Inject;

import rx.Observable;
import tyfrontier.cleanarchitecturesample.domain.repository.ArticleRepository;

public class ArticleService {

    private final ArticleRepository articleRepository;

    @Inject
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Observable<Article> findArticles(int requestIndex) {
        return articleRepository.findArticles(requestIndex);
    }
}
