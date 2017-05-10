import java.util.ArrayList;

public class View {
    public void menu(){
        System.out.println("***Menu***");
        System.out.println("Write 1 to get a list of available products");
        System.out.println("Write 2 to order products for the warehouse");
        System.out.println("Write 3 to order products from the warehouse");
    }

    public void orderProduct(){
        System.out.println("*****************************");
        System.out.println("Write product ID and QUANTITY");
    }
    
    public void orderProductForDeparture(){
        System.out.println("*****************************");
        System.out.println("Write product ID and QUANTITY");
    }
}
