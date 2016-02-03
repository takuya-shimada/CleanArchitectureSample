package tyfrontier.cleanarchitecturesample.di.module;

import dagger.Module;
import dagger.Provides;
import tyfrontier.cleanarchitecturesample.domain.model.ArticleService;
import tyfrontier.cleanarchitecturesample.domain.net.WebApi;
import tyfrontier.cleanarchitecturesample.domain.usecase.FindArticles;
import tyfrontier.cleanarchitecturesample.domain.usecase.FindArticlesImpl;

@Module
public class DomainModule {

    @Provides
    public FindArticles provideFindArticles(FindArticlesImpl findArticles) {
        return findArticles;
    }

    @Provides
    public ArticleService provideArticleService(WebApi webApi) {
        return new ArticleService(webApi);
    }
}
