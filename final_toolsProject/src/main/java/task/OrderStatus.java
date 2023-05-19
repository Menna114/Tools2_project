package task;

public enum OrderStatus {
	PREPARING("preparing"),
	DELIVERED("delivered"),
	CANCELLED("cancelled");
	
	
	OrderStatus(String status)
	{
		this.status=status;
	}
	
	private final String status;
	
	public String getStatus() {
        return status;
    }
}
