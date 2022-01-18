public class Mammal {
    private int energyLevel = 100;

    public int getEnergyLevel(){
        return energyLevel;
    }
    public void setEnergyLevel(int energy){
        this.energyLevel = energy;
    }
    public int displayEnergy(){
        System.out.println("energy level: "+ energyLevel);
        return energyLevel;
    }

}