package Model;

public class Category {
    private String id;        // MongoDB _id
    private String cateName;  // tên category
    private String icons;     // icon

    public Category() {}

    public Category(String id, String cateName, String icons) {
        this.id = id;
        this.cateName = cateName;
        this.icons = icons;
    }

    // Getter & Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", cateName='" + cateName + '\'' +
                ", icons='" + icons + '\'' +
                '}';
    }
}
