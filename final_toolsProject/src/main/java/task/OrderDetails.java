package task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDetails {
	
	private List<Object> myRecipet = new ArrayList<Object>();
	private LocalDateTime date;
	private double deliveryFees;
	private double totalReceipt;
	private String runnerName;
	private String restaurantName;
	private ArrayList<Meal> itemslist;
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public double getDeliveryFees() {
		return deliveryFees;
	}
	public void setDeliveryFees(double deliveryFees) {
		this.deliveryFees = deliveryFees;
	}
	public double getTotalReceipt() {
		return totalReceipt;
	}
	public void setTotalReceipt(double totalReceipt) {
		this.totalReceipt = totalReceipt;
	}
	public String getRunnerName() {
		return runnerName;
	}
	public void setRunnerName(String runnerName) {
		this.runnerName = runnerName;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public ArrayList<Meal> getItemslist() {
		return itemslist;
	}
	public void setItemslist(ArrayList<Meal> itemslist) {
		this.itemslist = itemslist;
	}
	
	public OrderDetails(Orders order)
	{
		itemslist=order.getMeals();
		restaurantName=order.getRestaurantOrders().getName();
		runnerName=order.getRunner().getName();
		date=LocalDateTime.now();
		totalReceipt= deliveryFees +order.Totalprice();
		
	}
	
	
	public List<Object> ReturnMyRecipet() {
		
		myRecipet.add(date);
		myRecipet.add(itemslist);
		myRecipet.add(runnerName);
		myRecipet.add(restaurantName);
		myRecipet.add(totalReceipt);
		
		return myRecipet;
		
	}
	

}
