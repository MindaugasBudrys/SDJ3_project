import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;;


@WebService
@SOAPBinding(style = Style.RPC)
public interface iWebService {
	
	@WebMethod String[] getProductsList() throws Exception;
	@WebMethod String orderProductsForArrivalThroughWebService(String[] listOfProductsForWarehouse) throws Exception;
	@WebMethod String orderProductsForDepartureThroughWebService(String[] listOfProductsForDeparture) throws Exception;
}
