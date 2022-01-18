public class Samurai extends Human{
    private int numOfSamurai =0;
    public Samurai(){
        this.setHealth(200);
        numOfSamurai++;

    }
    public void deathBlow(Human human){
        int samuraiHeath =this.getHealth();
        human.setHealth(0);
        this.setHealth(samuraiHeath-(samuraiHeath/2));
    }
    public void meditate(){
        int samuraiHeath=this.getHealth();
        this.setHealth(samuraiHeath +(samuraiHeath/2));
    }
    public int howMany(){
        return numOfSamurai;
    }
}