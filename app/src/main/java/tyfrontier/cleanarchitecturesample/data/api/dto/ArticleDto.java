package tyfrontier.cleanarchitecturesample.data.api.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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
}
