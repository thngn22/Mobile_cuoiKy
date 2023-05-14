package vn.iotstar.nongsan.models;

public class Product {
    private int id, idMeal, idCategory;
    private String strMeal, strMealThumb;

    public Product(int id, int idMeal, int idCategory, String strMeal, String strMealThumb) {
        this.id = id;
        this.idMeal = idMeal;
        this.idCategory = idCategory;
        this.strMeal = strMeal;
        this.strMealThumb = strMealThumb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(int idMeal) {
        this.idMeal = idMeal;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }
}
