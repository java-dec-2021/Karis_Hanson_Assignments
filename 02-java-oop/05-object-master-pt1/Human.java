public class Human {
    private int health = 100;
    private int strength = 3;
    private int stealth = 3;
    private int intelligence = 3;

    public void setStrength(int strength){
        this.strength = strength;
    }
    public void setStealth(int stealth){
        this.stealth = stealth;
    }
    public void setIntelligence(int intelligence){
        this. intelligence = intelligence;
    }   
    public int getStrength(){
        System.out.println("Strength: "+strength);
        return strength;
    }
    public int getHealth(){
        System.out.println("Health: "+health);
        return health;
    }
    public int getStealth(){
        System.out.println("Stealth: "+stealth);
        return stealth;
    }
    public int getIntelligence(){
        System.out.println("Intelligence: "+intelligence);
        return intelligence;
    }

    public void attack(Human human){
        human.health = human.health - this.strength;
    }
}