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
}
