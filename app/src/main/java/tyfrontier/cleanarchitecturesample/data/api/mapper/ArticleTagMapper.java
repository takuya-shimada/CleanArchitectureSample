package tyfrontier.cleanarchitecturesample.data.api.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tyfrontier.cleanarchitecturesample.data.api.dto.ArticleTagDto;

public class ArticleTagMapper {

    public List<String> map(Collection<ArticleTagDto> articleTagDtoCollection) {
        List<String> tagList = new ArrayList<>();
        for (ArticleTagDto tagDto : articleTagDtoCollection) {
            tagList.add(tagDto.name);
        }

        return tagList;
    }
}
