package mazegame.entity;

public class Weapon extends Item {
    private String damage;

    public Weapon(String damage) {
        this.damage = damage;
    }

    public Weapon(String label, int value, int weight, String description, String damage) {
        super(label, value, weight, description);
        this.damage = damage;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }
}
