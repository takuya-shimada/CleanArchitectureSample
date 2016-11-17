package tyfrontier.cleanarchitecturesample.di.component;

import javax.inject.Singleton;

import dagger.Component;
import tyfrontier.cleanarchitecturesample.di.module.ApiServiceModule;
import tyfrontier.cleanarchitecturesample.di.module.TestDataModule;
import tyfrontier.cleanarchitecturesample.domain.net.WebApiTest;

@Component(
        modules = {
                TestDataModule.class,
                ApiServiceModule.class,
        }
)
@Singleton
public interface TestDataComponent {
    void inject(WebApiTest webApiTest);
}
