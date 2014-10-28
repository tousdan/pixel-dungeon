/*
 * Pixel Dungeon
 * Copyright (C) 2012-2014  Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.tousdan.deepdungeon.items.scrolls;

import com.tousdan.deepdungeon.Dungeon;
import com.tousdan.deepdungeon.actors.buffs.Terror;
import com.tousdan.deepdungeon.actors.mobs.Mob;
import com.tousdan.deepdungeon.effects.Flare;
import com.tousdan.deepdungeon.levels.Level;
import com.tousdan.deepdungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.tousdan.deepdungeon.Assets;
import com.tousdan.deepdungeon.actors.buffs.Buff;
import com.tousdan.deepdungeon.actors.buffs.Invisibility;

public class ScrollOfTerror extends Scroll {

	{
		name = "Scroll of Terror";
	}
	
	@Override
	protected void doRead() {
		
		new Flare( 5, 32 ).color( 0xFF0000, true ).show( curUser.sprite, 2f );
		Sample.INSTANCE.play( Assets.SND_READ );
		Invisibility.dispel();
		
		int count = 0;
		Mob affected = null;
		for (Mob mob : Dungeon.level.mobs.toArray( new Mob[0] )) {
			if (Level.fieldOfView[mob.pos]) {
				Terror terror = Buff.affect( mob, Terror.class, Terror.DURATION );
				terror.source = curUser;
				
				count++;
				affected = mob;
			}
		}
		
		switch (count) {
		case 0:
			GLog.i("The scroll emits a brilliant flash of red light");
			break;
		case 1:
			GLog.i( "The scroll emits a brilliant flash of red light and the " + affected.name + " flees!" );
			break;
		default:
			GLog.i( "The scroll emits a brilliant flash of red light and the monsters flee!" );
		}
		setKnown();
		
		curUser.spendAndNext( TIME_TO_READ );
	}
	
	@Override
	public String desc() {
		return
			"A flash of red light will overwhelm all creatures in your field of view with terror, " +
			"and they will turn and flee. Attacking a fleeing enemy will dispel the effect.";
	}
	
	@Override
	public int price() {
		return isKnown() ? 50 * quantity : super.price();
	}
}
