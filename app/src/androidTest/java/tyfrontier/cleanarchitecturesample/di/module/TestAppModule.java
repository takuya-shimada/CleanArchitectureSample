package tyfrontier.cleanarchitecturesample.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestAppModule {

    private final Application application;

    public TestAppModule(Application application) {
        this.application = application;
    }

    @Provides @Singleton
    Context context() {
        return application;
    }
}
