package tyfrontier.cleanarchitecturesample.di.component;

import javax.inject.Singleton;

import dagger.Component;
import tyfrontier.cleanarchitecturesample.di.module.DataModule;
import tyfrontier.cleanarchitecturesample.di.module.DomainModule;
import tyfrontier.cleanarchitecturesample.domain.usecase.FindArticlesTest;

@Component(
        modules = {
                DataModule.class,
                DomainModule.class,
        }
)
@Singleton
public interface TestDomainComponent {
    void inject(FindArticlesTest findArticlesTest);
}
