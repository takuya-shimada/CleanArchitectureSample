package tyfrontier.cleanarchitecturesample;

import android.app.Application;

import tyfrontier.cleanarchitecturesample.di.component.ApplicationComponent;
import tyfrontier.cleanarchitecturesample.di.component.DaggerApplicationComponent;
import tyfrontier.cleanarchitecturesample.di.module.ApplicationModule;

public class MainApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
