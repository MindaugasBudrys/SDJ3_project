import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.jws.WebService;

@WebService (targetNamespace ="WarehouseControlWebService")
public class WebServiceBridge implements iWebService{

	WarehouseControl wc;
	
	public WebServiceBridge(WarehouseControl warehouse) {
		this.wc = warehouse;
	}
	
	@Override
	public String orderProductsForArrivalThroughWebService(String[] productsFromWebService) throws Exception {
		ArrayList<String> arrayListOfProducts = new ArrayList<String>();
		
		for (int i = 0; i < productsFromWebService.length; i++) {
			arrayListOfProducts.add(productsFromWebService[i]);
		}
		try {
			wc.orderNewProducts(arrayListOfProducts);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "GREAT!! Your products have been received!!!";
		
	}
	@Override
	public String orderProductsForDepartureThroughWebService(String[] productsFromWebService) throws Exception {
		ArrayList<String> arrayListOfProducts = new ArrayList<String>();
		
		for (int i = 0; i < productsFromWebService.length; i++) {
			arrayListOfProducts.add(productsFromWebService[i]);
		}
		try {
			wc.orderProductsForDeparture(arrayListOfProducts);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "GREAT!! Your products have been sent!!!";
	}

	@Override
	public String[] getProductsList() throws Exception {
		ArrayList<String> arrayFromDB = wc.productSupply.model.getAllProductsFromDatabaseWithQuantity();
		String[] result = new String[arrayFromDB.size()];
		
		for (int i = 0; i < arrayFromDB.size(); i++) {
			System.out.println("Getting product: " + result[i]);
			result[i] = arrayFromDB.get(i);
		}
		
		return result;
	}

}
