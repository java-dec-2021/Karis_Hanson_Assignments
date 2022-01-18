import java.util.ArrayList;
public class Pokemon{
    private String name;
    private int health;
    private String type;
    public static int count =0;
    
    
    public Pokemon(){
        Pokemon.count++;
    }
    public Pokemon(String name, int health, String type) {
        this.name = name;
        this.health = health;
        this.type = type;
        Pokemon.count ++;
        
    }
    public int getHealth() {
        return health;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    public void attackPokemon(Pokemon pokemon){
        pokemon.health -=10;
    }
    
    public static int getCount(){
        return count;
    }

}