package tyfrontier.cleanarchitecturesample.di.component;

import javax.inject.Singleton;

import dagger.Component;
import tyfrontier.cleanarchitecturesample.di.module.DomainModule;
import tyfrontier.cleanarchitecturesample.di.module.TestDataModule;
import tyfrontier.cleanarchitecturesample.domain.usecase.FindArticlesTest;

@Component(
        modules = {
                TestDataModule.class,
                DomainModule.class,
        }
)
@Singleton
public interface TestDomainComponent {
    void inject(FindArticlesTest findArticlesTest);
}
