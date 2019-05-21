package mazegame.entity;

public class Weapon extends Item {
    private int damage;

    public Weapon(int damage) {
        this.damage = damage;
    }

    public Weapon(String label, int value, int weight, String description, int damage) {
        super(label, value, weight, description);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
