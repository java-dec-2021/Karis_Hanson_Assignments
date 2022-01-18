public class Galaxy extends Phone implements Ringable{
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        super(versionNumber,batteryPercentage,carrier, ringTone);
    }
    @Override
    public String ring(){
        String ring = "Galaxy " +this.getVersionNumber() + " says "+this.getRingTone();
        return ring;

    }
    @Override
    public String unlock(){
        return "Unlocking via finger print";

    }
    @Override
    public void displayInfo(){
        System.out.println("Galaxy " +this.getVersionNumber() + " from " +this.getCarrier());
    }
}