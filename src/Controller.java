import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Controller {

    Interface iface;
    View view;

public Controller(View v, Interface m){
    this.view = v;
    this.iface = m;
}
public void menu()throws RemoteException{
    int choice;
    String type;
    String name;
    int id;
    int quantity;
    Scanner scanner = new Scanner(System.in);

    do{
        view.menu();
        choice = scanner.nextInt();

        switch (choice) {

            case 1:
                view.newProducts();
                type = scanner.next();
                name = scanner.next();
                id = scanner.nextInt();
                quantity = scanner.nextInt();
                //iface.orderNewGoods(type, name, id, quantity);
                view.finished("Type: " + type + " Name: " + name + " ID: " + id + " Quantity: " + quantity);
                break;
//            case 2:
//
//                view.insertDate();
//                day1 = scanner.nextInt();
//                month1 = scanner.nextInt();
//                year1 = scanner.nextInt();
//                System.out.println(model
//                        .getReservation(day1, month1, year1));
//
//                break;
        }
    }while (choice > 0 || choice < 3);
}
}
