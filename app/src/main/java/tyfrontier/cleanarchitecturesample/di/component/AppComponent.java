package tyfrontier.cleanarchitecturesample.di.component;

import javax.inject.Singleton;

import dagger.Component;
import tyfrontier.cleanarchitecturesample.MainApplication;
import tyfrontier.cleanarchitecturesample.di.component.screen.TopScreenComponent;
import tyfrontier.cleanarchitecturesample.di.module.AppModule;
import tyfrontier.cleanarchitecturesample.di.module.DataModule;
import tyfrontier.cleanarchitecturesample.di.module.DomainModule;
import tyfrontier.cleanarchitecturesample.di.module.screen.TopScreenModule;

@Component(
        modules = {
                AppModule.class,
                DomainModule.class,
                DataModule.class,
        }
)
@Singleton
public interface AppComponent {
    void inject(MainApplication mainApplication);

    TopScreenComponent plus(TopScreenModule topScreenModule);
}
