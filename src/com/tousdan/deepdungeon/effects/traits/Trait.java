package com.tousdan.deepdungeon.effects.traits;

import com.tousdan.deepdungeon.actors.Char;

/**
 * A trait. Heroes are born with certain traits which will impact how they survive in the dungeon.
 */
public interface Trait extends com.watabou.utils.Bundlable {
    String name();

    int strengthAdjustment();


    int adjustAttackRoll(Char target);
    int adjustDamageRoll(Char target);

    int adjustDefenseRoll(Char attacker);


}
