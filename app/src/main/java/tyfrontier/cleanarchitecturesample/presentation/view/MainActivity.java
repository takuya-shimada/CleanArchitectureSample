package tyfrontier.cleanarchitecturesample.presentation.view;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import tyfrontier.cleanarchitecturesample.App;
import tyfrontier.cleanarchitecturesample.R;
import tyfrontier.cleanarchitecturesample.di.module.screen.TopScreenModule;
import tyfrontier.cleanarchitecturesample.domain.model.Article;
import tyfrontier.cleanarchitecturesample.presentation.presenter.TopPresenter;
import tyfrontier.cleanarchitecturesample.presentation.view.component.AboutAppDialog;
import tyfrontier.cleanarchitecturesample.presentation.view.component.ArticleListAdapter;

public class MainActivity extends AppCompatActivity implements TopView {

    @Inject TopPresenter topPresenter;

    @BindView(R.id.root) ViewGroup rootView;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.list) RecyclerView listView;

    private ArticleListAdapter articleListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((App)getApplication()).appComponent().plus(new TopScreenModule(this, this)).inject(this);
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

    @Override
    public void initView() {
        articleListAdapter = new ArticleListAdapter(this,
                topPresenter::onClickListItem,
                topPresenter::onBindEnd);
        setSupportActionBar(toolbar);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(articleListAdapter);
        listView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void resetView() {
        articleListAdapter.clearItem();
    }

    @Override
    public void addArticle(List<Article> articles) {
        for (Article article : articles) {
            articleListAdapter.addItem(article);
        }
    }

    @Override
    public void showAboutApp() {
        new AboutAppDialog().show(getSupportFragmentManager(), null);
    }

    @Override
    public void showError(int stringResId) {
        Snackbar.make(rootView, stringResId, Snackbar.LENGTH_SHORT).show();
    }
}
