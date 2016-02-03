package tyfrontier.cleanarchitecturesample.data.api.mapper;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import tyfrontier.cleanarchitecturesample.data.api.dto.ArticleDto;
import tyfrontier.cleanarchitecturesample.domain.model.Article;

public class ArticleMapper {

    private static final String QIITA_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private final SimpleDateFormat timeFormat = new SimpleDateFormat(QIITA_TIME_FORMAT, Locale.getDefault());

    public Article map(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }

        try {
            return new Article(
                    articleDto.id,
                    articleDto.title,
                    new ArticleTagMapper().map(articleDto.tags),
                    articleDto.user.id,
                    timeFormat.parse(articleDto.createdAt),
                    new URL(articleDto.url));
        } catch (ParseException | MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<Article> map(Collection<ArticleDto> articleDtoCollection) {
        List<Article> articleList = new ArrayList<>();
        Article article;
        for (ArticleDto userEntity : articleDtoCollection) {
            article = map(userEntity);
            if (article != null) {
                articleList.add(article);
            }
        }

        return articleList;
    }
}
