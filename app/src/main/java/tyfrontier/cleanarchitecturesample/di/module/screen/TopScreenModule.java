package tyfrontier.cleanarchitecturesample.di.module.screen;

import dagger.Module;
import dagger.Provides;
import tyfrontier.cleanarchitecturesample.di.PerActivity;
import tyfrontier.cleanarchitecturesample.presentation.presenter.TopPresenter;
import tyfrontier.cleanarchitecturesample.presentation.presenter.TopPresenterImpl;
import tyfrontier.cleanarchitecturesample.presentation.view.TopView;

@Module
public class TopScreenModule {

    private final TopView topView;

    public TopScreenModule(TopView topView) {
        this.topView = topView;
    }

    @Provides @PerActivity
    TopPresenter provideTopPresenter(TopPresenterImpl topPresenter) {
        return topPresenter;
    }

    @Provides @PerActivity
    TopView provideTopView() {
        return topView;
    }
}
