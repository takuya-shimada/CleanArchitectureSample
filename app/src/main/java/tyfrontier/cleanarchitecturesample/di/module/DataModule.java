package tyfrontier.cleanarchitecturesample.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tyfrontier.cleanarchitecturesample.data.api.WebApiImpl;
import tyfrontier.cleanarchitecturesample.data.repository.ArticleRepositoryImpl;
import tyfrontier.cleanarchitecturesample.domain.net.WebApi;
import tyfrontier.cleanarchitecturesample.domain.repository.ArticleRepository;

@Module
public class DataModule {

    @Provides @Singleton
    public WebApi webApi(WebApiImpl webApi) {
        return webApi;
    }

    @Provides @Singleton
    public ArticleRepository articleRepository(ArticleRepositoryImpl articleRepository) {
        return articleRepository;
    }
}
