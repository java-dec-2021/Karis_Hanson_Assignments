public class Wizard extends Human {
    
    public Wizard(){
        this.setHealth(50);
        this.setIntelligence(8);
    }
    public void heal(Human human){
        int humanHealth = human.getHealth();
        int wizardIntelligence = this.getIntelligence();
        human.setHealth(humanHealth+wizardIntelligence);
    }
    public void fireball(Human human){
        int wizardIntelligence = this.getIntelligence();
        int humanHealth = human.getHealth();
        human.setHealth(humanHealth-(wizardIntelligence*3));
    }


}