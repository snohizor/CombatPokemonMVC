package controller;

import model.Attack;
import model.Pokemon;

public class PokemonController {

    public Pokemon pkmn1 = Pokemon.pkm1;
    public Pokemon pkmn2 = Pokemon.pkm2;
    Attack charge = new Attack("Tackle", 40, 95); //
    Attack roar = new Attack("Roar", 0, 100); //

    public static void chooseAttack(Pokemon pokemon, Pokemon opponent){
        GameController.msg = "What is " + pokemon.getName() + " gonna do ?" +
                "\n" + IDisplayConsoleController.getDisplayAttacks(pokemon);
        Attack.choosenAttack = pokemon.getAtksList().get(GameController.scan());
    }
}
