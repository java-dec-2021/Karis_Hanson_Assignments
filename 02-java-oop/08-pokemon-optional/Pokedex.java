import java.util.ArrayList;

public class Pokedex extends AbstractPokemon{
    private ArrayList<Pokemon> myPokemons;

    public ArrayList<Pokemon> getMyPokemons() {
        return myPokemons;
    }

    public void listPokemon(){
        for(Pokemon poke : myPokemons){
            System.out.println(poke.getName());
        }
    }
}