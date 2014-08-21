package com.watabou.pixeldungeon.items;

import com.watabou.pixeldungeon.actors.blobs.Blob;
import com.watabou.pixeldungeon.actors.blobs.Fire;
import com.watabou.pixeldungeon.actors.hero.Hero;
import com.watabou.pixeldungeon.levels.Level;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.pixeldungeon.utils.GLog;
import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Lighter, used to light nearby things on fire.
 */
public class Lighter extends Item {
    private static final String LIGHT = "LIGHT";

    {
        name = "Lighter";
        image = ItemSpriteSheet.ROSE;

        unique = true;
        defaultAction = LIGHT;
    }

    @Override
    public boolean isUpgradable() {
        return false;
    }

    @Override
    public boolean isIdentified() {
        return true;
    }

    @Override
    public String info() {
        return "A lighter. Use it to light things on fire";
    }

    @Override
    public ArrayList<String> actions(Hero hero) {
        ArrayList<String> actions = new ArrayList<String>();

        actions.add(LIGHT);

        return actions;
    }

    @Override
    public void execute(Hero hero, String action) {
        if(LIGHT.equals(action)) {
            int heroPos = hero.pos;

            Collection<Integer> flamable = new ArrayList<Integer>();

            for (int i : Level.NEIGHBOURS4) {
                int location = heroPos + i;
                if (Level.flamable[location]) {
                    flamable.add(location);
                }
            }

            if(flamable.isEmpty()) {
                GLog.w("There's nothing to light around you.");
            } else {
                if(Random.Float() < 0.25) {
                    GLog.n("You were not able to light a fire.");
                } else {
                    for (int location : flamable) {
                        GameScene.add(Blob.seed(location, 1, Fire.class));
                    }
                }
            }
        } else {
            super.execute(hero, action);
        }
    }
}
