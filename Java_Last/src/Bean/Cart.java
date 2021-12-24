package Bean;

public class Cart {
    private Users user;
    private Sales sale;
    private Integer count;

    public Cart(Users user, Sales sale, Integer number) {
        this.user = user;
        this.sale = sale;
        this.count = number;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Sales getSale() {
        return sale;
    }

    public void setSale(Sales sale) {
        this.sale = sale;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "user=" + user +
                ", sale=" + sale +
                ", count=" + count +
                '}';
    }
}