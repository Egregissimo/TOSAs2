////////////////////////////////////////////////////////////////////
// [Nicola] [Carlesso] [1123257]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class RestaurantBillException extends Throwable{
	
	public RestaurantBillException() {
		super("Too much orders");
	}
	
	public RestaurantBillException(String message) {
		super(message);
	}
}
