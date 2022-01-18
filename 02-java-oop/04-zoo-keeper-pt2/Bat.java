public class Bat extends Mammal{
    public void fly(){
        System.out.println("Wooshh, bat took off");
        int energy = this.getEnergyLevel();
        energy = energy-50;
        this.setEnergyLevel(energy);
    }
    public void eatHumans(){
        System.out.println("Bat ate a human...");
        int energy = this.getEnergyLevel();
        energy = energy+25;
        this.setEnergyLevel(energy);
    }
    public void attackTown(){
        System.out.println("Town is burning!!");
        int energy = this.getEnergyLevel();
        energy = energy-100;
        this.setEnergyLevel(energy);
    }
    }