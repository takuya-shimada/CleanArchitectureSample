package tyfrontier.cleanarchitecturesample.di.component;

import javax.inject.Singleton;

import dagger.Component;
import tyfrontier.cleanarchitecturesample.di.module.TestAppModule;
import tyfrontier.cleanarchitecturesample.di.module.TestDataModule;
import tyfrontier.cleanarchitecturesample.di.module.TestDomainModule;
import tyfrontier.cleanarchitecturesample.domain.net.WebApiTest;
import tyfrontier.cleanarchitecturesample.domain.usecase.FindArticlesTest;

@Component(
        modules = {
                TestAppModule.class,
                TestDomainModule.class,
                TestDataModule.class,
        }
)
@Singleton
public interface TestAppComponent extends AppComponent {
    void inject(WebApiTest webApiTest);
    void inject(FindArticlesTest findArticlesTest);
}
