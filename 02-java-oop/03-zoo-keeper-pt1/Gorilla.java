public class Gorilla extends Mammal{

    public void throwSomething(){
        System.out.println("The gorilla has thrown something");
        int energy = this.getEnergyLevel();
        energy = energy-5;
        this.setEnergyLevel(energy);
    }
    public void eatBananas(){
        System.out.println("The gorilla is full of bananas!");
            int energy = this.getEnergyLevel();
        energy = energy+10;
        this.setEnergyLevel(energy);
    }
    public void climb(){
        System.out.println("The gorilla climbed a tree, and is tired now");
            int energy = this.getEnergyLevel();
        energy = energy-10;
        this.setEnergyLevel(energy);
    }
}