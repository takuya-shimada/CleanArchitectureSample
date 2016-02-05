package tyfrontier.cleanarchitecturesample.di.component.screen;

import dagger.Subcomponent;
import tyfrontier.cleanarchitecturesample.di.PerActivity;
import tyfrontier.cleanarchitecturesample.di.module.screen.TopScreenModule;
import tyfrontier.cleanarchitecturesample.presentation.view.MainActivity;

@Subcomponent(
        modules = {
                TopScreenModule.class,
        }
)

@PerActivity
public interface TopScreenComponent {
    void inject(MainActivity mainActivity);
}
