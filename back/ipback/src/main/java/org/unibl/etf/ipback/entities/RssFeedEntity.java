package org.unibl.etf.ipback.entities;

public class RssFeedEntity {
    private String title;
    private String link;
    private String description;
    private String category;
    public RssFeedEntity(String title, String link, String description, String category) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
