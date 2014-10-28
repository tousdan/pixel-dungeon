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

import com.tousdan.deepdungeon.Assets;
import com.tousdan.deepdungeon.Dungeon;
import com.tousdan.deepdungeon.actors.buffs.Invisibility;
import com.tousdan.deepdungeon.effects.CellEmitter;
import com.tousdan.deepdungeon.effects.Speck;
import com.tousdan.deepdungeon.effects.SpellSprite;
import com.tousdan.deepdungeon.items.Item;
import com.tousdan.deepdungeon.levels.Level;
import com.tousdan.deepdungeon.levels.Terrain;
import com.tousdan.deepdungeon.scenes.GameScene;
import com.tousdan.deepdungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;

public class ScrollOfMagicMapping extends Scroll {

	private static final String TXT_LAYOUT = "You are now aware of the level layout.";
	
	{
		name = "Scroll of Magic Mapping";
	}
	
	@Override
	protected void doRead() {
		
		int length = Level.LENGTH;
		int[] map = Dungeon.level.map;
		boolean[] mapped = Dungeon.level.mapped;
		boolean[] discoverable = Level.discoverable;
		
		boolean noticed = false;
		
		for (int i=0; i < length; i++) {
			
			int terr = map[i];
			
			if (discoverable[i]) {
				
				mapped[i] = true;
				if ((Terrain.flags[terr] & Terrain.SECRET) != 0) {
					
					Level.set( i, Terrain.discover( terr ) );						
					GameScene.updateMap(i);
					
					if (Dungeon.visible[i]) {
						GameScene.discoverTile( i, terr );
						discover( i );
						
						noticed = true;
					}
				}
			}
		}
		Dungeon.observe();
		
		GLog.i(TXT_LAYOUT);
		if (noticed) {
			Sample.INSTANCE.play( Assets.SND_SECRET );
		}
		
		SpellSprite.show(Item.curUser, SpellSprite.MAP);
		Sample.INSTANCE.play( Assets.SND_READ );
		Invisibility.dispel();
		
		setKnown();
		
		Item.curUser.spendAndNext( TIME_TO_READ );
	}
	
	@Override
	public String desc() {
		return
			"When this scroll is read, an image of crystal clarity will be etched into your memory, " +
			"alerting you to the precise layout of the level and revealing all hidden secrets. " +
			"The locations of items and creatures will remain unknown.";
	}
	
	@Override
	public int price() {
		return isKnown() ? 25 * quantity : super.price();
	}
	
	public static void discover( int cell ) {
		CellEmitter.get(cell).start( Speck.factory(Speck.DISCOVER), 0.1f, 4 );
	}
}
