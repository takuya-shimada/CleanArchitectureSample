package tyfrontier.cleanarchitecturesample.data.api.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import tyfrontier.cleanarchitecturesample.domain.model.Article;

public class ArticleDto {

    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("created_at")
    @Expose
    public String createdAt;

    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

    @SerializedName("tags")
    @Expose
    public List<ArticleTagDto> tags;

    @SerializedName("url")
    @Expose
    public String url;

    @SerializedName("user")
    @Expose
    public UserDto user;

    private static final String QIITA_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat(QIITA_TIME_FORMAT, Locale.getDefault());

    public static Article map(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }

        try {
            return new Article(
                    articleDto.id,
                    articleDto.title,
                    ArticleTagDto.map(articleDto.tags),
                    articleDto.user.id,
                    timeFormat.parse(articleDto.createdAt),
                    new URL(articleDto.url));
        } catch (ParseException | MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
