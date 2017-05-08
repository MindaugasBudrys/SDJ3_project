
public class Crane {
    Model model;
    public Crane() throws Exception{
        model = new Model();

    }
    public void storeToDatabase(int pallet_id, int product_id, int shelf_id, int quantity ){
        try {
            model.insertIntoDatabase(pallet_id, product_id, shelf_id, quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    


}
