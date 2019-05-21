package mazegame.entity;

public class Shield extends Item {
    private int bonus;

    public Shield(int bonus) {
        this.bonus = bonus;
    }

    public Shield(String label, int value, int weight, String description, int bonus) {
        super(label, value, weight, description);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
