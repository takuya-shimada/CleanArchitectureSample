package tyfrontier.cleanarchitecturesample.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tyfrontier.cleanarchitecturesample.data.api.ApiService;
import tyfrontier.cleanarchitecturesample.data.api.ApiServiceFactory;

@Module
public class ApiServiceModule {

    @Provides @Singleton
    public ApiService apiService() {
        return ApiServiceFactory.createRetrofitService(ApiService.class, "https://qiita.com/");
    }
}
