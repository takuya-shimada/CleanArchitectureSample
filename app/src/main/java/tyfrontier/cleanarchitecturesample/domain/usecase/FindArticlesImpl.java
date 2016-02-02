package tyfrontier.cleanarchitecturesample.domain.usecase;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import tyfrontier.cleanarchitecturesample.domain.model.Article;
import tyfrontier.cleanarchitecturesample.domain.model.ArticleService;

public class FindArticlesImpl implements FindArticles {

    private final ArticleService articleService;

    @Inject
    public FindArticlesImpl(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public Observable<List<Article>> call(Integer page) {
        return articleService.findArticles(page);
    }
}
