package tyfrontier.cleanarchitecturesample.domain.model;

import java.net.URL;
import java.util.Date;
import java.util.List;

public class Article {
    private final String id;
    private final String title;
    private final List<String> tags;
    private final String userName;
    private final Date createdAt;
    private final URL url;

    public Article(String id, String title, List<String> tags, String userName, Date createdAt, URL url) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (tags == null) {
            throw new IllegalArgumentException();
        }

        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (createdAt == null) {
            throw new IllegalArgumentException();
        }

        if (url == null) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.title = title;
        this.tags = tags;
        this.userName = userName;
        this.createdAt = createdAt;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getUserName() {
        return userName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public URL getUrl() {
        return url;
    }
}
