package vn.iotstar.nongsan.models;

import java.util.HashMap;

public class ProductDetail {
    private String id, name, thumb, description, category, slug, unit, createdAt, updatedAt;

    private HashMap<String, Object> review;
    private int quantity, price, soldCount;
    private double star;
    private boolean isDrafted, isPublished;

    public ProductDetail() {
    }

    public ProductDetail(String id, String name, String thumb, String description, String category, String slug, String unit, String createdAt, String updatedAt, HashMap<String, Object> review, int quantity, int price, int soldCount, double star, boolean isDrafted, boolean isPublished) {
        this.id = id;
        this.name = name;
        this.thumb = thumb;
        this.description = description;
        this.category = category;
        this.slug = slug;
        this.unit = unit;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.review = review;
        this.quantity = quantity;
        this.price = price;
        this.soldCount = soldCount;
        this.star = star;
        this.isDrafted = isDrafted;
        this.isPublished = isPublished;
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

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public HashMap<String, Object> getReview() {
        return review;
    }

    public void setReview(HashMap<String, Object> review) {
        this.review = review;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(int soldCount) {
        this.soldCount = soldCount;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public boolean isDrafted() {
        return isDrafted;
    }

    public void setDrafted(boolean drafted) {
        isDrafted = drafted;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }
}
