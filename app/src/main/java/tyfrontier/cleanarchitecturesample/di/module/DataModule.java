package tyfrontier.cleanarchitecturesample.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tyfrontier.cleanarchitecturesample.data.api.WebApiImpl;
import tyfrontier.cleanarchitecturesample.data.cache.CacheService;
import tyfrontier.cleanarchitecturesample.data.cache.CacheServiceImpl;
import tyfrontier.cleanarchitecturesample.data.api.WebApi;

@Module
public class DataModule {

    @Provides @Singleton
    public WebApi webApi(WebApiImpl webApi) {
        return webApi;
    }

    @Provides @Singleton
    public CacheService cacheService(CacheServiceImpl cacheService) {
        return cacheService;
    }
}
