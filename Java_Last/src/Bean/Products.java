package Bean;

public class Products {
    private Integer id;
    private String p_name;
    private Double price;
    private Integer p_number;
    private String category;

    public Products(Integer id, String name, Double price, Integer number, String category) {
        this.id = id;
        this.p_name = name;
        this.price = price;
        this.p_number = number;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getP_number() {
        return p_number;
    }

    public void setP_number(Integer number) {
        this.p_number = number;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + p_name + '\'' +
                ", price=" + price +
                ", number=" + p_number +
                ", category='" + category + '\'' +
                '}';
    }
}

