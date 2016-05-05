package tyfrontier.cleanarchitecturesample.data.api.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArticleTagDto {

    @SerializedName("name")
    @Expose
    public String name;

    public static List<String> map(Collection<ArticleTagDto> articleTagDtoCollection) {
        List<String> tagList = new ArrayList<>();
        for (ArticleTagDto tagDto : articleTagDtoCollection) {
            tagList.add(tagDto.name);
        }

        return tagList;
    }
}
