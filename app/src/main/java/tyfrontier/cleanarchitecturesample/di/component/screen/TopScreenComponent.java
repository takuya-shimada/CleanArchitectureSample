package tyfrontier.cleanarchitecturesample.di.component.screen;

import dagger.Component;
import tyfrontier.cleanarchitecturesample.di.PerActivity;
import tyfrontier.cleanarchitecturesample.di.component.ApplicationComponent;
import tyfrontier.cleanarchitecturesample.di.module.ActivityModule;
import tyfrontier.cleanarchitecturesample.di.module.screen.TopScreenModule;
import tyfrontier.cleanarchitecturesample.presentation.view.MainActivity;

@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                ActivityModule.class,
                TopScreenModule.class,
        }
)

@PerActivity
public interface TopScreenComponent {
    void inject(MainActivity mainActivity);
}
