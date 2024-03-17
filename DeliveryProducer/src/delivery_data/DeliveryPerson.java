package delivery_data;

public class DeliveryPerson {
    
    private int personId;
    private String person;
    private double salary;
    private double additionalAmount;
    private double netPrice;
    
   private String deliveryItem;
   
	public String getDeliveryItem() {
	return deliveryItem;
}
public void setDeliveryItem(String deliveryItem) {
	this.deliveryItem = deliveryItem;
}
	private int age;
    private String address;
    private String branch;
    
    public DeliveryPerson(int personId, String person, double salary, double additionalAmount, int age,String deliveryItem ,String address, String branch) {
		super();
		this.personId = personId;
		this.person = person;
		this.salary = salary;
		this.additionalAmount = additionalAmount;

		this.age = age;
		this.address = address;
		this.deliveryItem=deliveryItem;
		this.branch = branch;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getAdditionalAmount() {
		return additionalAmount;
	}
	public void setAdditionalAmount(double additionalAmount) {
		this.additionalAmount = additionalAmount;
	}
	public double getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}

    
    

}

