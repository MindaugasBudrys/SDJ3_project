
public class View {
    public void menu(){
        System.out.println("***Menu***");
        System.out.println("Write 1 to order products");
        System.out.println("Write 2 to...");
    }

    public void newProducts(){
        System.out.println("***Menu***");
        System.out.println("");
        System.out.println("Write product ID from the list");
    }
    public void finished(String information){
        System.out.println(information);
    }
}
