package tyfrontier.cleanarchitecturesample.di.component;

import javax.inject.Singleton;

import dagger.Component;
import tyfrontier.cleanarchitecturesample.di.module.DataModule;
import tyfrontier.cleanarchitecturesample.domain.net.WebApiTest;

@Component(
        modules = {
                DataModule.class,
        }
)
@Singleton
public interface TestDataComponent {
    void inject(WebApiTest webApiTest);
}
