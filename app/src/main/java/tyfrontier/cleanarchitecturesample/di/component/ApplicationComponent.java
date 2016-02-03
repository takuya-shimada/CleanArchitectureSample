package tyfrontier.cleanarchitecturesample.di.component;

import javax.inject.Singleton;

import dagger.Component;
import tyfrontier.cleanarchitecturesample.MainApplication;
import tyfrontier.cleanarchitecturesample.di.module.ApplicationModule;
import tyfrontier.cleanarchitecturesample.di.module.DataModule;
import tyfrontier.cleanarchitecturesample.di.module.DomainModule;
import tyfrontier.cleanarchitecturesample.domain.usecase.FindArticles;
import tyfrontier.cleanarchitecturesample.domain.usecase.UseCase;

@Component(
        modules = {
                ApplicationModule.class,
                DomainModule.class,
                DataModule.class,
        }
)
@Singleton
public interface ApplicationComponent {
    void inject(MainApplication mainApplication);

    FindArticles getFindArticles();
}
