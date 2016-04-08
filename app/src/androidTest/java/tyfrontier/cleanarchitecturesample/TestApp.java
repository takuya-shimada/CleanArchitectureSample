package tyfrontier.cleanarchitecturesample;

import tyfrontier.cleanarchitecturesample.di.component.DaggerTestAppComponent;
import tyfrontier.cleanarchitecturesample.di.component.TestAppComponent;
import tyfrontier.cleanarchitecturesample.di.module.TestAppModule;

public class TestApp extends App {

    TestAppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerTestAppComponent.builder()
                .testAppModule(new TestAppModule(this))
                .build();
    }

    @Override
    public TestAppComponent appComponent() {
        return appComponent;
    }
}