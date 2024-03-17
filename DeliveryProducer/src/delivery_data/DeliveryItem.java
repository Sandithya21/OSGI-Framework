package delivery_data;

public class DeliveryItem {
    private int itemId;
    private String description;
    private double weight;
    private String status; // Example: "Pending", "In Transit", "Delivered"

    public DeliveryItem(int itemId, String description, double weight, String status) {
        this.itemId = itemId;
        this.description = description;
        this.weight = weight;
        this.status = status;
    }

    // Getters and Setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DeliveryItem{" +
                "itemId=" + itemId +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", status='" + status + '\'' +
                '}';
    }
}

