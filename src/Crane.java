
public class Crane {
    Model model;
    public Crane() throws Exception{
        model = new Model();

    }
    public void storeToDatabase(int pallet_id, int product_id, int shelf_id, int quantity ){
        try {
            model.updateAddQuantityIntoDatabase(product_id, quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getFromDatabase(int product_id, int quantity) {
    	try {
    		model.updateSubQuantityIntoDatabase(product_id, quantity);
    	} catch (Exception e){
    		e.printStackTrace();
    	}
    }
    


}
