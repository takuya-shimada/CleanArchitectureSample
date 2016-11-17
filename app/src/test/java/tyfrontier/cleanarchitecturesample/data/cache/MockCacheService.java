package tyfrontier.cleanarchitecturesample.data.cache;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.RealmObject;
import rx.Observable;

public class MockCacheService implements CacheService {

    List<Object> cache = new ArrayList<>();

    @Inject
    public MockCacheService() {
    }

    @Override
    public <T, E extends RealmObject & CacheObject<T>> void set(final Class<E> clazz, T model) {
        cache.add(model);
    }

    @Override
    public <T, E extends RealmObject & CacheObject<T>> Observable<List<T>> get(final Class<E> clazz) {
        if (cache.size() == 0) {
            return Observable.empty();
        }
        return Observable.from((Iterable<T>) cache).toList();
    }

    @Override
    public <T, E extends RealmObject & CacheObject<T>> long count(Class<E> clazz) {
        return cache.size();
    }

    @Override
    public <T, E extends RealmObject & CacheObject<T>> void deleteAll(Class<E> clazz) {
        cache.clear();
    }
}
