package tyfrontier.cleanarchitecturesample.di.module;

import dagger.Module;
import dagger.Provides;
import tyfrontier.cleanarchitecturesample.domain.model.ArticleService;
import tyfrontier.cleanarchitecturesample.domain.net.WebApi;
import tyfrontier.cleanarchitecturesample.domain.usecase.FindArticles;
import tyfrontier.cleanarchitecturesample.domain.usecase.FindArticlesImpl;

@Module
public class TestDomainModule {

    @Provides
    public FindArticles findArticles(FindArticlesImpl findArticles) {
        return findArticles;
    }

    @Provides
    public ArticleService articleService(WebApi webApi) {
        return new ArticleService(webApi);
    }
}
