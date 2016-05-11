package tyfrontier.cleanarchitecturesample.data.cache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.realm.Realm;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

public class Cache {

    public void addAll(List<Article> list) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> {
            for (Article article : list) {
                realm1.createObject(ArticleDto.class).map(article);
            }

        });
        realm.close();
    }

    public List<Article> getAll() {
        Realm realm = Realm.getDefaultInstance();
        Iterator<ArticleDto> iterator = realm.where(ArticleDto.class).findAll().iterator();
        List<Article> articleList = new ArrayList<>();
        for (; iterator.hasNext(); ) {
            articleList.add(iterator.next().map());
        }
        return articleList;
    }

    public long size() {
        return Realm.getDefaultInstance().where(ArticleDto.class).count();
    }
}
