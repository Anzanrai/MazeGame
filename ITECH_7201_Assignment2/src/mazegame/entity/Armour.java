package mazegame.entity;

public class Armour extends Item {
    private int bonus;

    public Armour(int bonus) {
        this.bonus = bonus;
    }

    public Armour(String label, int value, int weight, String description){
        super(label, value, weight, description);
    }

    public Armour(String label, int value, int weight, String description, int bonus) {
        super(label, value, weight, description);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String toString(){
        return String.format("%-25s\t%-10d\t%-10d\t%-10d", this.getLabel(), this.getValue(), this.getWeight(), this.getBonus());
    }
}
