package mazegame.entity;

public class NonPlayerCharacter extends Character {
    private boolean hostile;
    private String conversation;

    public NonPlayerCharacter(boolean hostile, String conversation) {
        this.hostile = hostile;
        this.conversation = conversation;
    }

    public NonPlayerCharacter(String name, boolean hostile, String conversation) {
        super(name);
        this.hostile = hostile;
        this.conversation = conversation;
    }

    public NonPlayerCharacter(String name, int agility, int lifepoints, int strength, boolean hostile, String conversation){
        super(name, agility, lifepoints, strength);
        this.hostile = hostile;
        this.conversation = conversation;
    }

    public boolean isHostile() {
        return hostile;
    }

    public void setHostile(boolean hostile) {
        this.hostile = hostile;
    }

    public String getConversation() {
        return conversation;
    }

    public void setConversation(String conversation) {
        this.conversation = conversation;
    }

    public String getName(){
        return super.getName();
    }

    public int getLifePoints(){
        return super.getLifePoints();
    }

    public void setLifePoints(int lifePoints){
        super.setLifePoints(lifePoints);
    }

    public void lessenLifePoints(int attackScore){
        if(this.getLifePoints() > 0){
            int newLifePoints = this.getLifePoints() - attackScore;
            this.setLifePoints(newLifePoints);
        }
        System.out.println(displayNPCStat());
    }

    public String displayNPCStat(){
        String response = "";
        if(this!=null){
            if(this.getLifePoints() < 1){
                response += String.format("%-15s is dead!!!", this.getName());
            }
            response = "-------------------------\n";
            response += String.format("%-15s\n", this.getName());
            response += String.format("%-20s\t%d\n", "Health", this.getLifePoints());
        } else {
            response = "No NPC here.";
        }

        return response;
    }
}
