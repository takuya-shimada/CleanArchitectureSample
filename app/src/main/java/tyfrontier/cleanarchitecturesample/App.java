package tyfrontier.cleanarchitecturesample;

import android.app.Application;

import tyfrontier.cleanarchitecturesample.di.component.AppComponent;
import tyfrontier.cleanarchitecturesample.di.component.DaggerAppComponent;
import tyfrontier.cleanarchitecturesample.di.module.AppModule;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent appComponent() {
        return appComponent;
    }
}
