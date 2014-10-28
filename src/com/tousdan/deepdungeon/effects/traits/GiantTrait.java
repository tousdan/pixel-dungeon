package com.tousdan.deepdungeon.effects.traits;

import com.tousdan.deepdungeon.actors.Char;
import com.tousdan.deepdungeon.actors.mobs.Attribute;

/**
 * The hero is a giant.
 *
 * They have a hard time time dealing with small creatures, but when they hit them they ususally
 * are no longer a threat.
 */
public class GiantTrait extends BaseTrait {

    @Override
    public String name() {
        return "Giant";
    }

    @Override
    public int strengthAdjustment() {
        return 2;
    }

    @Override
    public int adjustDefenseRoll(Char attacker) {
        if(isSmall(attacker)) {
            return -5;
        }

        return 0;
    }

    @Override
    public int adjustAttackRoll(Char target) {
        if(isSmall(target)) {
            return -5;
        }

        return 0;
    }

    @Override
    public int adjustDamageRoll(Char target) {
        if(isSmall(target)) {
            return 10;
        }

        return 0;
    }

    private boolean isSmall(Char it) {
        return it.hasAttribute(Attribute.SMALL);
    }
}
