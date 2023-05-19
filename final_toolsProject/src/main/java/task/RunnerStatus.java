package task;

public enum RunnerStatus {
	
	AVAILABLE("available"),
	BUSY("busy");
	
	
	RunnerStatus(String status)
	{
		this.status=status;
	}
	
	private final String status;
	
	public String getValue() {
        return status;
    }

}
