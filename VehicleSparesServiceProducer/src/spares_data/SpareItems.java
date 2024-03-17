package spares_data;

public class SpareItems {
	
	private int SpareId;
	private String SpareName;
	private double SparePrice;
	private double Sparediscount;
	private double netPrice;
	private int Quantity;


	public SpareItems(int SpareId, String SpareName, double SparePrice, double Sparediscount, int Quantity) {
		super();
		this.SpareId = SpareId;
		this.SpareName = SpareName;
		this.SparePrice = SparePrice;
		this.Sparediscount = Sparediscount;
		this.Quantity = Quantity;
		calculateNetPrice();
	}
	
	
	public int getSpareId() {
		return SpareId;
	}

	
	public void setSpareId(int spareId) {
		SpareId = spareId;
	}

	
	public String getSpareName() {
		return SpareName;
	}

	
	public void setSpareName(String spareName) {
		SpareName = spareName;
	}

	
	public double getSparePrice() {
		return SparePrice;
	}

	
	public void setSparePrice(double sparePrice) {
		SparePrice = sparePrice;
	}

	
	public double getSparediscount() {
		return Sparediscount;
	}

	
	public void setSparediscount(double sparediscount) {
		Sparediscount = sparediscount;
	}

	
	public double getNetPrice() {
		return netPrice;
	}

	
	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	public int getQuantity() {
		return Quantity;
	}


	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public void calculateNetPrice() {
		this.netPrice = SparePrice * ((100.00 - Sparediscount) / 100);
	}
	

}
