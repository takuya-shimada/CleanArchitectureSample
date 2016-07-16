package tyfrontier.cleanarchitecturesample.data.cache;

public interface CacheObject<T> {

    T map();

    void map(T model);

}
