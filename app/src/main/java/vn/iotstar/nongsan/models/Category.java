package vn.iotstar.nongsan.models;

public class Category {
   private String id, name, description, thumb;

    public Category() {
    }

    public Category(String id, String name, String description, String thumb) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumb = thumb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
