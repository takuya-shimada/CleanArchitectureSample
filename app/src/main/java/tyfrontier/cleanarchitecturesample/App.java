package tyfrontier.cleanarchitecturesample;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import tyfrontier.cleanarchitecturesample.di.component.AppComponent;
import tyfrontier.cleanarchitecturesample.di.component.DaggerAppComponent;
import tyfrontier.cleanarchitecturesample.di.module.AppModule;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        RealmConfiguration config = new RealmConfiguration.Builder(this).build();
        Realm.deleteRealm(config);
        Realm.setDefaultConfiguration(config);
    }

    public AppComponent appComponent() {
        return appComponent;
    }
}
