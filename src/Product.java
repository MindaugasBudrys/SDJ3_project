import java.io.Serializable;

public class Product implements Serializable{

    String type;
    String name;
    int id;

    public Product(String t, String n, int i){
        this.type = t;
        this.name = n;
        this.id = i;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
