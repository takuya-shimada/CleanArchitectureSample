package tyfrontier.cleanarchitecturesample.di.module.screen;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import tyfrontier.cleanarchitecturesample.di.PerActivity;
import tyfrontier.cleanarchitecturesample.presentation.presenter.TopPresenter;
import tyfrontier.cleanarchitecturesample.presentation.presenter.TopPresenterImpl;
import tyfrontier.cleanarchitecturesample.presentation.view.TopView;

@Module
public class TopScreenModule {

    private final Activity activity;
    private final TopView topView;

    public TopScreenModule(Activity activity, TopView topView) {
        this.activity = activity;
        this.topView = topView;
    }

    @Provides
    Activity activity() {
        return this.activity;
    }

    @Provides @PerActivity
    TopPresenter topPresenter(TopPresenterImpl topPresenter) {
        return topPresenter;
    }

    @Provides @PerActivity
    TopView topView() {
        return topView;
    }
}
