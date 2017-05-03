
public class View {
    public void menu(){
        System.out.println("***Menu***");
        System.out.println("Write 1 to order new products");
        System.out.println("Write 2 to...");
    }

    public void newProducts(){
        System.out.println("***Menu***");
        System.out.println("You are ordering new products");
        System.out.println("Please type TYPE, NAME, ID, QUANTITY of product");
    }
    public void finished(String information){
        System.out.println(information);
    }
}
