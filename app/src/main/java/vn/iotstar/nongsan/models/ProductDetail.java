package vn.iotstar.nongsan.models;

public class ProductDetail {
    private int id;
    private String meal, area_, category, instructions, strMealThumb;
    private double price;

    public ProductDetail(int id, String meal, String area_, String category, String instructions, String strMealThumb, double price) {
        this.id = id;
        this.meal = meal;
        this.area_ = area_;
        this.category = category;
        this.instructions = instructions;
        this.strMealThumb = strMealThumb;
        this.price = price;
    }

    public ProductDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getArea_() {
        return area_;
    }

    public void setArea_(String area_) {
        this.area_ = area_;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public double getPrice() {
        return price * 22000;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
