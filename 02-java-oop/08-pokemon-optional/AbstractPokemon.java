public abstract class AbstractPokemon implements PokemonInterface{
    public Pokemon createPokemon(String name, int health, String type){
        Pokemon pokemon = new Pokemon(name, health, type);
        return pokemon;
    }
    public String pokemonInfo(Pokemon pokemon){
        String info = "Name: " + pokemon.getName() + " Health: "+ pokemon.getHealth()+ " Type: "+pokemon.getType();
        return info;
    }

}
