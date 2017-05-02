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
    Scanner scanner = new Scanner(System.in);

    do{
        view.menu();
        choice = scanner.nextInt();

        switch (choice) {

            case 1:

                iface.orderNewGoods("#"+choice);

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
