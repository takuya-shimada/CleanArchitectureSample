package tyfrontier.cleanarchitecturesample.di.module;

import dagger.Module;
import dagger.Provides;
import tyfrontier.cleanarchitecturesample.data.repository.ArticleRepositoryImpl;
import tyfrontier.cleanarchitecturesample.domain.model.ArticleService;
import tyfrontier.cleanarchitecturesample.domain.usecase.FindArticles;
import tyfrontier.cleanarchitecturesample.domain.usecase.FindArticlesImpl;

@Module
public class DomainModule {

    @Provides
    public FindArticles findArticles(FindArticlesImpl findArticles) {
        return findArticles;
    }

    @Provides
    public ArticleService articleService(ArticleRepositoryImpl articleRepository) {
        return new ArticleService(articleRepository);
    }
}
