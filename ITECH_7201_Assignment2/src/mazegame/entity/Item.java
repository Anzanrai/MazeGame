package mazegame.entity;

public class Item {
    private String label;
    private int value;
    private int weight;
    private String description;

    public Item() {
    }

    public Item(String label, int value, int weight, String description) {
        this.label = label;
        this.value = value;
        this.weight = weight;
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }
}
