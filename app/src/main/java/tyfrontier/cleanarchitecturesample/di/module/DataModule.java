package tyfrontier.cleanarchitecturesample.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tyfrontier.cleanarchitecturesample.data.api.WebApiImpl;
import tyfrontier.cleanarchitecturesample.domain.net.WebApi;

@Module
public class DataModule {

    @Provides @Singleton
    public WebApi provideWebApi(WebApiImpl webApi) {
        return webApi;
    }
}
