package mazegame.entity;

public class Shield extends Item {
    private int bonus;

    public Shield(int bonus) {
        this.bonus = bonus;
    }

    public Shield(int value, int weight, String description, int bonus) {
        super(value, weight, description);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
