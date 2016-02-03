package tyfrontier.cleanarchitecturesample.presentation.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import tyfrontier.cleanarchitecturesample.MainApplication;
import tyfrontier.cleanarchitecturesample.R;
import tyfrontier.cleanarchitecturesample.di.component.screen.DaggerTopScreenComponent;
import tyfrontier.cleanarchitecturesample.di.module.ActivityModule;
import tyfrontier.cleanarchitecturesample.di.module.screen.TopScreenModule;
import tyfrontier.cleanarchitecturesample.domain.model.Article;
import tyfrontier.cleanarchitecturesample.presentation.presenter.TopPresenter;
import tyfrontier.cleanarchitecturesample.presentation.view.component.AboutAppDialog;
import tyfrontier.cleanarchitecturesample.presentation.view.component.ArticleListAdapter;

public class MainActivity extends AppCompatActivity implements TopView {

    @Inject TopPresenter topPresenter;

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.list) ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerTopScreenComponent.builder()
                .applicationComponent(((MainApplication)getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .topScreenModule(new TopScreenModule(this))
                .build()
                .inject(this);
        if (topPresenter != null) {
            topPresenter.onCreate();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (topPresenter != null) {
            topPresenter.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (topPresenter != null) {
            topPresenter.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (topPresenter != null) {
            topPresenter.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (topPresenter != null) {
            topPresenter.onDestroy();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_app:
                topPresenter.onClickAboutAppMenu();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnItemClick(R.id.list)
    public void onListItemClick(int position) {
        topPresenter.onClickListItem((Article)listView.getAdapter().getItem(position));
    }

    @Override
    public void initView() {
        setSupportActionBar(toolbar);
    }

    @Override
    public void showArticles(List<Article> articles) {
        listView.setAdapter(new ArticleListAdapter(this, R.layout.article_list_item, articles));
    }

    @Override
    public void showAboutApp() {
        new AboutAppDialog().show(getSupportFragmentManager(), null);
    }
}
