public class Ninja extends Human{
    public Ninja(){
        this.setStealth(10);
    }
    public void steal(Human human){
        int ninjaStealth = this.getStealth();
        int humanHealth = human.getHealth();
        human.setHealth(humanHealth-ninjaStealth);
        this.setHealth(this.getHealth()+ninjaStealth);
    }
    public void runAway(){
        this.setHealth(this.getHealth()-10);
    }
    

}