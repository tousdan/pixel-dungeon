package com.tousdan.deepdungeon.effects.traits;

import com.tousdan.deepdungeon.actors.hero.Hero;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Generates the traits for a hero
 */
public class TraitsGenerator {
    private Hero hero;

    private int kindsOfTraits;
    private List<Class<? extends Trait>> traitBag;

    public TraitsGenerator(Hero hero) {
        this.hero = hero;
        this.traitBag = new ArrayList<>();

        this.kindsOfTraits = 0;
        registerTrait(GiantTrait.class, 1);
    }

    public Collection<Trait> generateTraits(int amount) {
        Set<Class<? extends Trait>> generated = new HashSet<>(amount);
        List<Trait> traits = new ArrayList<>(amount);

        if(amount > kindsOfTraits) {
            amount = kindsOfTraits;
        }

        while(amount > 0) {
            Class<? extends Trait> chosen = traitBag.get(com.watabou.utils.Random.IntRange(0, traitBag.size()));

            if(!generated.contains(chosen)) {
                generated.add(chosen);
                try {
                    traits.add(chosen.newInstance());
                } catch(InstantiationException | IllegalAccessException ex) {
                    throw new RuntimeException("Couldn't generate Trait", ex);
                }
                amount--;
            }
        }

        return traits;
    }

    private void registerTrait(Class<? extends Trait> trait, int occurences) {
        if(occurences <= 0) {
            return;
        }

        this.kindsOfTraits++;

        while(occurences > 0) {
            traitBag.add(trait);
            occurences--;
        }
    }
}
