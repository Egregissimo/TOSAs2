package it.unipd.tos.business;

import static org.junit.Assert.*;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.typeItem;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class BellaNapoliTest {
	
	private RestaurantBill restaurant = new BellaNapoli();;
	
	/*
	 * Insieme che supera i 20 ordini. Gli ordini sono 23
	 */
	public static List<MenuItem> orderWithError() {
		return Arrays.asList(new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5)
				);
	}
	
	@Test(expected = RestaurantBillException.class)
	public void exeptionTest() throws RestaurantBillException {
		restaurant.getOrderPrice(orderWithError());
	}
	
	
	/*
	 * Ordine per contare il numero di pizze.
	 * Inoltre serve per rimuovere la pizza meno costosa.
	 * Le pizze sono 11 e gli ordini totali 16
	 */
	public static List orderToCountPizzas() {
		return Arrays.asList(new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 7.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 7.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 7.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 7.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 7.5)
				);
	}
	
	@Test
	public void removeCheapestPizzaTest() throws RestaurantBillException {
		assertEquals(92.5, restaurant.getOrderPrice(orderToCountPizzas()), 0);
	}
	
	@Test
	public void getNumPizzaTest() {
		BellaNapoli test = new BellaNapoli();
		assertEquals(11, test.getNumPizza(orderToCountPizzas()));
	}
	
	/*
	 * Ordine che supera i 100 euro per ottenere il 5% di sconto
	 */
	public static List orderToHaveDiscount() {
		return Arrays.asList(new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5)
				);
	}
	
	@Test
	public void over100Test() throws RestaurantBillException {
		assertEquals(96.425, restaurant.getOrderPrice(orderToHaveDiscount()), 0);
	}
	
	/*
	 * Ordine per superare i 100 euro e superare le 10 pizze
	 */
	public static List orderToRemovePizzaAndDiscount() {
		return Arrays.asList(new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PIZZA, "Margherita", 5.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5),
				new MenuItem(typeItem.PRIMI, "Spaghetti", 10.5)
				);
	}
	
	@Test
	public void removePizzaAndGetDiscountTest() throws RestaurantBillException {
		assertEquals(102.125, restaurant.getOrderPrice(orderToRemovePizzaAndDiscount()), 0);
	}

}
