package mx.com.bwl.model;

public class Peticion {
	private int userId;
	private String itemId;
	private double discount;
	
	public Peticion() {
		super();
	}

	public Peticion(int userId, String itemId, double discount) {
		super();
		this.userId = userId;
		this.itemId = itemId;
		this.discount = discount;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
