package tyfrontier.cleanarchitecturesample.di.component;

import javax.inject.Singleton;

import dagger.Component;
import tyfrontier.cleanarchitecturesample.di.module.TestAppModule;
import tyfrontier.cleanarchitecturesample.di.module.TestDataModule;
import tyfrontier.cleanarchitecturesample.domain.net.WebApiTest;

@Component(
        modules = {
                TestAppModule.class,
                TestDataModule.class,
        }
)
@Singleton
public interface TestAppComponent extends AppComponent {
    void inject(WebApiTest webApiTest);
}
