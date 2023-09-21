package Queue;

public class Customer {
    int id;
    String name;
    String work;

    public Customer() {
    }

    public Customer(int id, String name, String work) {
        this.id = id;
        this.name = name;
        this.work = work;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", work='" + work + '\''
                ;
    }
}
