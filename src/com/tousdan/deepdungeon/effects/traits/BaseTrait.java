package com.tousdan.deepdungeon.effects.traits;

import com.tousdan.deepdungeon.actors.Char;

/**
 * Created by tousdan on 26/10/14.
 */
public abstract class BaseTrait implements Trait {
    private static String CLASS;

    public abstract String name();

    @Override
    public int strengthAdjustment() {
        return 0;
    }

    @Override
    public int adjustAttackRoll(Char target) {
        return 0;
    }

    @Override
    public int adjustDefenseRoll(Char attacker) {
        return 0;
    }

    @Override
    public int adjustDamageRoll(Char target) {
        return 0;
    }

    @Override
    public void restoreFromBundle( com.watabou.utils.Bundle bundle ) {

    }

    @Override
    public void storeInBundle( com.watabou.utils.Bundle bundle ) {

    }




}
