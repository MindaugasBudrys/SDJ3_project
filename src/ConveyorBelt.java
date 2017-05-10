import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ConveyorBelt implements Serializable{
    private ArrayList<SmallPallet> pallets;

    public ConveyorBelt(){
    this.pallets = new ArrayList<SmallPallet>();
    }
    public void addNewPallets(ArrayList<SmallPallet> p) throws RemoteException{
    	pallets = p;
    }
    
    public SmallPallet getToShelf(){
        SmallPallet palletToShelf = null;
        for(int i = 0; i < pallets.size(); i++){
            if(pallets.get(i).toStore()){
                palletToShelf = pallets.get(i);
                pallets.remove(i);
                break;
            }
        }
        return palletToShelf;
    }
    
    public ArrayList<SmallPallet> getPallets(){
    	return pallets;
    }

}
