import java.io.Serializable;

public class Product implements Serializable{

    String type;
    String name;
    int id;

    public Product( int i, String n, String t){
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
