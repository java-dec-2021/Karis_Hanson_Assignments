public class HumanTest {
    public static void main(String[] args) {
        
        Ninja ninja = new Ninja();
        Wizard wizard = new Wizard();
        Samurai samurai = new Samurai();
        ninja.getHealth();
        wizard.getHealth();
        samurai.getHealth();
        System.out.println(samurai.howMany());
        // samurai.meditate();
        // samurai.getHealth();
        // samurai.deathBlow(ninja);
        // ninja.getHealth();
        // samurai.getHealth();
        // ninja.steal(samurai);
        // ninja.getHealth();
        // samurai.getHealth();
        // ninja.runAway();
        // ninja.getHealth();
        wizard.heal(ninja);
        ninja.getHealth();
        wizard.fireball(samurai);
        samurai.getHealth();



    }
}