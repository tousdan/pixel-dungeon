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
package com.tousdan.deepdungeon.items;

import java.util.HashMap;

import com.tousdan.deepdungeon.Dungeon;
import com.tousdan.deepdungeon.items.armor.Armor;
import com.tousdan.deepdungeon.items.armor.ClothArmor;
import com.tousdan.deepdungeon.items.armor.LeatherArmor;
import com.tousdan.deepdungeon.items.armor.MailArmor;
import com.tousdan.deepdungeon.items.armor.PlateArmor;
import com.tousdan.deepdungeon.items.armor.ScaleArmor;
import com.tousdan.deepdungeon.items.potions.Potion;
import com.tousdan.deepdungeon.items.potions.PotionOfExperience;
import com.tousdan.deepdungeon.items.potions.PotionOfFrost;
import com.tousdan.deepdungeon.items.potions.PotionOfHealing;
import com.tousdan.deepdungeon.items.potions.PotionOfInvisibility;
import com.tousdan.deepdungeon.items.potions.PotionOfLevitation;
import com.tousdan.deepdungeon.items.potions.PotionOfLiquidFlame;
import com.tousdan.deepdungeon.items.potions.PotionOfMight;
import com.tousdan.deepdungeon.items.potions.PotionOfMindVision;
import com.tousdan.deepdungeon.items.potions.PotionOfParalyticGas;
import com.tousdan.deepdungeon.items.potions.PotionOfPurity;
import com.tousdan.deepdungeon.items.potions.PotionOfStrength;
import com.tousdan.deepdungeon.items.potions.PotionOfToxicGas;
import com.tousdan.deepdungeon.items.rings.Ring;
import com.tousdan.deepdungeon.items.rings.RingOfAccuracy;
import com.tousdan.deepdungeon.items.rings.RingOfDetection;
import com.tousdan.deepdungeon.items.rings.RingOfElements;
import com.tousdan.deepdungeon.items.rings.RingOfEvasion;
import com.tousdan.deepdungeon.items.rings.RingOfHaggler;
import com.tousdan.deepdungeon.items.rings.RingOfHaste;
import com.tousdan.deepdungeon.items.rings.RingOfHerbalism;
import com.tousdan.deepdungeon.items.rings.RingOfMending;
import com.tousdan.deepdungeon.items.rings.RingOfPower;
import com.tousdan.deepdungeon.items.rings.RingOfSatiety;
import com.tousdan.deepdungeon.items.rings.RingOfShadows;
import com.tousdan.deepdungeon.items.rings.RingOfThorns;
import com.tousdan.deepdungeon.items.scrolls.Scroll;
import com.tousdan.deepdungeon.items.scrolls.ScrollOfChallenge;
import com.tousdan.deepdungeon.items.scrolls.ScrollOfIdentify;
import com.tousdan.deepdungeon.items.scrolls.ScrollOfLullaby;
import com.tousdan.deepdungeon.items.scrolls.ScrollOfMagicMapping;
import com.tousdan.deepdungeon.items.scrolls.ScrollOfMirrorImage;
import com.tousdan.deepdungeon.items.scrolls.ScrollOfPsionicBlast;
import com.tousdan.deepdungeon.items.scrolls.ScrollOfRecharging;
import com.tousdan.deepdungeon.items.scrolls.ScrollOfRemoveCurse;
import com.tousdan.deepdungeon.items.scrolls.ScrollOfTeleportation;
import com.tousdan.deepdungeon.items.scrolls.ScrollOfTerror;
import com.tousdan.deepdungeon.items.scrolls.ScrollOfUpgrade;
import com.tousdan.deepdungeon.items.scrolls.ScrollOfWeaponUpgrade;
import com.tousdan.deepdungeon.items.wands.Wand;
import com.tousdan.deepdungeon.items.wands.WandOfAmok;
import com.tousdan.deepdungeon.items.wands.WandOfAvalanche;
import com.tousdan.deepdungeon.items.wands.WandOfBlink;
import com.tousdan.deepdungeon.items.wands.WandOfDisintegration;
import com.tousdan.deepdungeon.items.wands.WandOfFirebolt;
import com.tousdan.deepdungeon.items.wands.WandOfFlock;
import com.tousdan.deepdungeon.items.wands.WandOfLightning;
import com.tousdan.deepdungeon.items.wands.WandOfMagicMissile;
import com.tousdan.deepdungeon.items.wands.WandOfPoison;
import com.tousdan.deepdungeon.items.wands.WandOfRegrowth;
import com.tousdan.deepdungeon.items.wands.WandOfSlowness;
import com.tousdan.deepdungeon.items.wands.WandOfTelekinesis;
import com.tousdan.deepdungeon.items.wands.WandOfTeleportation;
import com.tousdan.deepdungeon.items.weapon.Weapon;
import com.tousdan.deepdungeon.items.weapon.melee.BattleAxe;
import com.tousdan.deepdungeon.items.weapon.melee.Dagger;
import com.tousdan.deepdungeon.items.weapon.melee.Glaive;
import com.tousdan.deepdungeon.items.weapon.melee.Knuckles;
import com.tousdan.deepdungeon.items.weapon.melee.Longsword;
import com.tousdan.deepdungeon.items.weapon.melee.Mace;
import com.tousdan.deepdungeon.items.weapon.melee.Quarterstaff;
import com.tousdan.deepdungeon.items.weapon.melee.ShortSword;
import com.tousdan.deepdungeon.items.weapon.melee.Spear;
import com.tousdan.deepdungeon.items.weapon.melee.Sword;
import com.tousdan.deepdungeon.items.weapon.melee.WarHammer;
import com.tousdan.deepdungeon.items.weapon.missiles.Boomerang;
import com.tousdan.deepdungeon.items.weapon.missiles.CurareDart;
import com.tousdan.deepdungeon.items.weapon.missiles.Dart;
import com.tousdan.deepdungeon.items.weapon.missiles.IncendiaryDart;
import com.tousdan.deepdungeon.items.weapon.missiles.Javelin;
import com.tousdan.deepdungeon.items.weapon.missiles.Shuriken;
import com.tousdan.deepdungeon.items.weapon.missiles.Tamahawk;
import com.tousdan.deepdungeon.plants.Dreamweed;
import com.tousdan.deepdungeon.plants.Earthroot;
import com.tousdan.deepdungeon.plants.Fadeleaf;
import com.tousdan.deepdungeon.plants.Firebloom;
import com.tousdan.deepdungeon.plants.Icecap;
import com.tousdan.deepdungeon.plants.Plant;
import com.tousdan.deepdungeon.plants.Sorrowmoss;
import com.tousdan.deepdungeon.actors.hero.Hero;
import com.tousdan.deepdungeon.actors.mobs.npcs.Wandmaker.Rotberry;
import com.tousdan.deepdungeon.plants.Sungrass;
import com.tousdan.deepdungeon.items.bags.Bag;
import com.tousdan.deepdungeon.items.food.Food;
import com.tousdan.deepdungeon.items.food.MysteryMeat;
import com.tousdan.deepdungeon.items.food.Pasty;
import com.watabou.utils.Random;

public class Generator {

	public static enum Category {
		WEAPON	( 15,	Weapon.class ),
		ARMOR	( 10,	Armor.class ),
		POTION	( 50,	Potion.class ),
		SCROLL	( 40,	Scroll.class ),
		WAND	( 4,	Wand.class ),
		RING	( 2,	Ring.class ),
		SEED	( 5,	Plant.Seed.class ),
		FOOD	( 0,	Food.class ),
		GOLD	( 50,	Gold.class );
		
		public Class<?>[] classes;
		public float[] probs;
		
		public float prob;
		public Class<? extends Item> superClass;
		
		private Category( float prob, Class<? extends Item> superClass ) {
			this.prob = prob;
			this.superClass = superClass;
		}
		
		public static int order( Item item ) {
			for (int i=0; i < values().length; i++) {
				if (values()[i].superClass.isInstance( item )) {
					return i;
				}
			}
			
			return item instanceof Bag ? Integer.MAX_VALUE : Integer.MAX_VALUE - 1;
		}
	};
	
	private static HashMap<Category,Float> categoryProbs = new HashMap<Generator.Category, Float>();
	
	static {
		
		Category.GOLD.classes = new Class<?>[]{ 
			Gold.class };
		Category.GOLD.probs = new float[]{ 1 };
		
		Category.SCROLL.classes = new Class<?>[]{ 
			ScrollOfIdentify.class,
			ScrollOfTeleportation.class,
			ScrollOfRemoveCurse.class,
			ScrollOfUpgrade.class,
			ScrollOfRecharging.class,
			ScrollOfMagicMapping.class,
			ScrollOfChallenge.class,
			ScrollOfTerror.class,
			ScrollOfLullaby.class,
			ScrollOfWeaponUpgrade.class,
			ScrollOfPsionicBlast.class,
			ScrollOfMirrorImage.class };
		Category.SCROLL.probs = new float[]{ 30, 10, 15, 0, 10, 15, 12, 8, 8, 0, 4, 6 };
		
		Category.POTION.classes = new Class<?>[]{ 
			PotionOfHealing.class,
			PotionOfExperience.class,
			PotionOfToxicGas.class,
			PotionOfParalyticGas.class,
			PotionOfLiquidFlame.class,
			PotionOfLevitation.class,
			PotionOfStrength.class,
			PotionOfMindVision.class,
			PotionOfPurity.class,
			PotionOfInvisibility.class,
			PotionOfMight.class,
			PotionOfFrost.class };
		Category.POTION.probs = new float[]{ 45, 4, 15, 10, 15, 10, 0, 20, 12, 10, 0, 10 };
		
		Category.WAND.classes = new Class<?>[]{ 
			WandOfTeleportation.class,
			WandOfSlowness.class,
			WandOfFirebolt.class,
			WandOfRegrowth.class,
			WandOfPoison.class,
			WandOfBlink.class,
			WandOfLightning.class,
			WandOfAmok.class,
			WandOfTelekinesis.class,
			WandOfFlock.class,
			WandOfMagicMissile.class,
			WandOfDisintegration.class,
			WandOfAvalanche.class };
		Category.WAND.probs = new float[]{ 10, 10, 15, 6, 10, 11, 15, 10, 6, 10, 0, 5, 5 };
		
		Category.WEAPON.classes = new Class<?>[]{ 
			Dagger.class,
			Knuckles.class,
			Quarterstaff.class,
			Spear.class,
			Mace.class,
			Sword.class,
			Longsword.class,
			BattleAxe.class,
			WarHammer.class,
			Glaive.class,
			ShortSword.class,
			Dart.class,
			Javelin.class,
			IncendiaryDart.class,
			CurareDart.class,
			Shuriken.class,
			Boomerang.class,
			Tamahawk.class };
		Category.WEAPON.probs = new float[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1 };
		
		Category.ARMOR.classes = new Class<?>[]{ 
			ClothArmor.class,
			LeatherArmor.class,
			MailArmor.class,
			ScaleArmor.class,
			PlateArmor.class };
		Category.ARMOR.probs = new float[]{ 1, 1, 1, 1, 1 };
		
		Category.FOOD.classes = new Class<?>[]{ 
			Food.class, 
			Pasty.class,
			MysteryMeat.class };
		Category.FOOD.probs = new float[]{ 4, 1, 0 };
			
		Category.RING.classes = new Class<?>[]{ 
			RingOfMending.class,
			RingOfDetection.class,
			RingOfShadows.class,
			RingOfPower.class,
			RingOfHerbalism.class,
			RingOfAccuracy.class,
			RingOfEvasion.class,
			RingOfSatiety.class,
			RingOfHaste.class,
			RingOfElements.class,
			RingOfHaggler.class,
			RingOfThorns.class };
		Category.RING.probs = new float[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 };
		
		Category.SEED.classes = new Class<?>[]{ 
			Firebloom.Seed.class,
			Icecap.Seed.class,
			Sorrowmoss.Seed.class,
			Dreamweed.Seed.class,
			Sungrass.Seed.class,
			Earthroot.Seed.class,
			Fadeleaf.Seed.class,
			Rotberry.Seed.class };
		Category.SEED.probs = new float[]{ 1, 1, 1, 1, 1, 1, 1, 0 };
	}
	
	public static void reset() {
		for (Category cat : Category.values()) {
			categoryProbs.put( cat, cat.prob );
		}
	}
	
	public static Item random() {
		return random( Random.chances( categoryProbs ) );
	}
	
	public static Item random( Category cat ) {
		try {
			
			categoryProbs.put( cat, categoryProbs.get( cat ) / 2 );
			
			switch (cat) {
			case ARMOR:
				return randomArmor();
			case WEAPON:
				return randomWeapon();
			default:
				return ((Item)cat.classes[Random.chances( cat.probs )].newInstance()).random();
			}
			
		} catch (Exception e) {

			return null;
			
		}
	}
	
	public static Item random( Class<? extends Item> cl ) {
		try {
			
			return ((Item)cl.newInstance()).random();
			
		} catch (Exception e) {

			return null;
			
		}
	}
	
	public static Armor randomArmor() throws Exception {
		
		int curStr = Hero.STARTING_STR + Dungeon.potionOfStrength;
		
		Category cat = Category.ARMOR;
		
		Armor a1 = (Armor)cat.classes[Random.chances( cat.probs )].newInstance();
		Armor a2 = (Armor)cat.classes[Random.chances( cat.probs )].newInstance();
		
		a1.random();
		a2.random();
		
		return Math.abs( curStr - a1.STR ) < Math.abs( curStr - a2.STR ) ? a1 : a2;
	}
	
	public static Weapon randomWeapon() throws Exception {
		
		int curStr = Hero.STARTING_STR + Dungeon.potionOfStrength;
		
		Category cat = Category.WEAPON;
		
		Weapon w1 = (Weapon)cat.classes[Random.chances( cat.probs )].newInstance();
		Weapon w2 = (Weapon)cat.classes[Random.chances( cat.probs )].newInstance();
		
		w1.random();
		w2.random();
		
		return Math.abs( curStr - w1.STR ) < Math.abs( curStr - w2.STR ) ? w1 : w2;
	}
}
