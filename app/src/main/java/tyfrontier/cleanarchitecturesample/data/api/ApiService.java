package tyfrontier.cleanarchitecturesample.data.api;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import tyfrontier.cleanarchitecturesample.data.api.dto.ArticleDto;

public interface ApiService {

    @GET("api/v2/items")
    Observable<List<ArticleDto>> getArticles(
            @Query("page") int page,
            @Query ("per_page") int per_page,
            @Query("query") String query);
}
