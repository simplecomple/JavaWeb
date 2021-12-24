package Bean;

public class O {
    private Integer id;
    private String u_name;
    private Integer s_id;
    private String name;
    private Integer count;
    public O(Integer id,String u_name,Integer s_id,String name,Integer count){
        this.id = id;
        this.u_name = u_name;
        this.s_id = s_id;
        this.name = name;
        this.count = count;
    }
    public Integer getCount() {
        return count;
    }

    public Integer getId() {
        return id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public String getName() {
        return name;
    }

    public String getU_name() {
        return u_name;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

}
