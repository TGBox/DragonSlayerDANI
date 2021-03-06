package current.meta;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by
 * Daniel Roesch
 * as "Nils Darmstrong".
 * -----------------
 * For "DragonSlayerDANI",
 * on 28.05.2017, 22:51.
 */
public class Constants {

  /*
   *  Explanation concerning itemID, toolID, boosterID, mapID, etc.
   *
   *  mapID:
   *  ranges from 1 to 10.
   *
   *  itemID:
   *  gets translated into toolID, boosterID, etc.
   *
   *  boosterID:
   *  ranges from 20 to 30
   *
   *  questID:
   *  ranges from 100 to 200 by three each time. reward items get ID + 1 of questId.
   *
   *  dungeonID:
   *  matches corresponding mapID
   *
   *
   */

  // Enums for the game.
  public enum Command {
    north, south, east, west, find, fight, run, bagFight, bag, use, delete, map, status, help,
    manual
  }

  public enum Difficulty {
    Baby, Novice, Warrior, God
  }

  public enum UserNames {
    Dickie_Fingers, Winky_Ding_Dong, Gaylord, I_have_a_small_dick, Too_cool_for_a_real_name
  }

  public enum DragonNames {
    Smaug, Drogon, Igneel, Porunga, Shenlong, Mushu, Predaking, Tabaluga,
    Toothless, Alduin, Kalameet, Paarthurnax, Spyro
  }

  public enum EnemyNames {
    Fairy, Spider, Gnome, Elf, Ghoul, Dwarf, Mummy, Zombie, Goblin, Ogre, Skeleton,
    Troll, Living_Tree, Griffin, Golem, Knight, Unicorn, Centaur, Minotaur, Vampire,
    Werewolf, Phoenix, Demon
  }

  public enum EnemyNamePrefixes {
    almost_dead, wounded, very_weak, tiny, young, weak, small, regular, angry, strong, large,
    very_strong, huge, gigantic, monstrous, evil, nightmare, hellish
  }

  public enum WeaponNames {
    spoon, stick, fork, stone, knife, hammer, dagger, tomahawk, rapier, club, spear, axe, katana,
    morning_star, sword, longsword, greatsword
  }

  public enum WeaponPrefixes {
    useless, broken, deformed, lightweight, blunt, regular, aerodynamic, sharpened, razor_sharp,
    hardened, heavy, ultimate
  }

  public enum FieldNames {
    grass_field, forest_field, field_with_a_river, field_with_a_few_trees, field_with_a_small_lake,
    muddy_field
  }

  public enum SpecialFieldNames {
    enchanted_forest_field, field_with_an_entrance_to_a_dungeon, burned_ground
  }

  public enum DungeonFieldNames {
    dungeon_exit, rocky_ground, muddy_ground, treasure_field
  }

  public enum HealingPrefixNames {
    cursed, half_empty, dark_purple, partially_empty, blue_colored, light_green, glowing, enchanted
  }

  public enum HealingAdjectives {
    tiny, small, regular_sized, big, large, huge
  }


  // Corresponding value sets.
  public static final int[] ENEMY_HEALTH = new int[]{
      22, 30, 35, 40, 50, 60, 65, 70, 75, 85, 90,
      95, 102, 111, 120, 125, 130, 137, 142, 156,
      166, 177, 188
  };

  public static final double[] PREFIX_VALUES = new double[]{
      0.22, 0.42, 0.50, 0.65, 0.75, 0.85, 0.95, 1.00, 1.11, 1.20, 1.33,
      1.42, 1.55, 1.65, 1.75, 1.80, 1.85, 1.99
  };

  public static final int[] WEAPON_ATTACK_VALUES = new int[]{
      8, 12, 18, 25, 33, 42, 55, 65, 75, 85, 95, 102, 111,
      123, 142, 166, 179
  };

  public static final double[] WEAPON_PREFIX_VALUES = new double[]{
      0.33, 0.42, 0.66, 0.75, 0.87, 1.00, 1.12, 1.32, 1.42,
      1.55, 1.75, 2.00
  };

  public static final double[] HEALING_PREFIX_VALUES = new double[]{
      0.33, 0.50, 0.66, 0.75, 1.00, 1.32, 1.42, 1.99
  };

  public static final int[] HEALING_VALUES = new int[]{
      25, 50, 75, 100, 125, 150
  };

  // Accuracies for normal weapons.
  // Smaller accuracy value == better hitting chance!
  public static final double[] ACCURACIES = new double[]{
      0.25, 0.30, 0.35, 0.40, 0.45, 0.50, 0.55, 0.60, 0.65, 0.70
  };

  // Boss enemy constants.
  public static final int BOSS_BASE_LIFE = 125;
  public static final int BOSS_LIFE_MULTIPLIER = 50;
  public static final double BOSS_MULTIPLIER_BABY = 0.42;
  public static final double BOSS_MULTIPLIER_NOVICE = 0.75;
  public static final double BOSS_MULTIPLIER_WARRIOR = 1.25;
  public static final double BOSS_MULTIPLIER_GOD = 2.00;
  public static final int BOSS_BASE_ATTACK = 65;
  public static final int BOSS_ATTACK_MULTIPLIER = 10;
  public static final double BOSS_ACCURACY_BABY = 0.89;
  public static final double BOSS_ACCURACY_NOVICE = 0.70;
  public static final double BOSS_ACCURACY_WARRIOR = 0.55;
  public static final double BOSS_ACCURACY_GOD = 0.42;

  // Map constants.
  public static final int DUNGEON_MIN_WIDTH = 3;
  public static final int DUNGEON_MIN_HEIGHT = 3;
  public static final int DUNGEON_MAX_WIDTH = 6;
  public static final int DUNGEON_MAX_HEIGHT = 6;
  public static final int MAP_MIN_WIDTH = 5;
  public static final int MAP_MIN_HEIGHT = 5;
  public static final int MAP_MAX_WIDTH = 7;
  public static final int MAP_MAX_HEIGHT = 7;

  // Player constants.
  public static final int HEALTH_BABY = 150;
  public static final int HEALTH_NOVICE = 115;
  public static final int HEALTH_WARRIOR = 80;
  public static final int HEALTH_GOD = 60;

  /**
   * method to get the amount of elements in one specific enum group.
   *
   * @param nameOfEnum String name of the enumeration.
   * @return int length of the array, or -1 if incorrect String was given.
   */
  public static int getLength(String nameOfEnum) {
    switch (nameOfEnum) {
      case "DragonNames":
        return DragonNames.values().length;
      case "EnemyNames":
        return EnemyNames.values().length;
      case "EnemyNamePrefixes":
        return EnemyNamePrefixes.values().length;
      case "WeaponNames":
        return WeaponNames.values().length;
      case "WeaponPrefixes":
        return WeaponPrefixes.values().length;
      case "FieldNames":
        return FieldNames.values().length;
      case "SpecialFieldNames":
        return SpecialFieldNames.values().length;
      case "DungeonFieldNames":
        return DungeonFieldNames.values().length;
      case "HealingPrefixNames":
        return HealingPrefixNames.values().length;
      case "HealingAdjectives":
        return HealingAdjectives.values().length;
      default:
        return -1;
    }
  }

  /**
   * method to generate the correct String representation from the given enum.
   * replaces underscore chars with whitespaces to enhance the appearance.
   *
   * @param enumeration the enum that should be displayed.
   * @return String representation of the given enum.
   */
  public static String asString(Enum enumeration) {
    String str = String.valueOf(enumeration);
    return str.replace('_', ' ');
  }

  /**
   * method to get a specific enum at a given index.
   * converts the enum to an array and gives the element at the desired position.
   *
   * @param nameOfEnum String name of the enum.
   * @param index int index.
   * @return the enum at that index.
   */
  public static Enum getEnumAt(String nameOfEnum, int index) {
    switch (nameOfEnum) {
      case "DragonNames":
        return DragonNames.values()[index];
      case "EnemyNames":
        return EnemyNames.values()[index];
      case "EnemyNamePrefixes":
        return EnemyNamePrefixes.values()[index];
      case "WeaponNames":
        return WeaponNames.values()[index];
      case "WeaponPrefixes":
        return WeaponPrefixes.values()[index];
      case "FieldNames":
        return FieldNames.values()[index];
      case "SpecialFieldNames":
        return SpecialFieldNames.values()[index];
      case "DungeonFieldNames":
        return DungeonFieldNames.values()[index];
      case "HealingPrefixNames":
        return HealingPrefixNames.values()[index];
      case "HealingAdjectives":
        return HealingAdjectives.values()[index];
      default:
        return EnemyNames.Fairy;
    }
  }

  /**
   * method to get a random enum from a specified enum group.
   * generates a random int in the range of the enum and returns the array element of that
   * enum at the given position.
   *
   * @param nameOfEnum String name of the enum.
   * @return the randomly selected enum.
   */
  public static Enum getRandomEnum(String nameOfEnum) {
    switch (nameOfEnum) {
      case "DragonNames":
        return DragonNames.values()[randInt(0, DragonNames.values().length - 1)];
      case "EnemyNames":
        return EnemyNames.values()[randInt(0, EnemyNames.values().length - 1)];
      case "EnemyNamePrefixes":
        return EnemyNamePrefixes.values()[randInt(0, EnemyNamePrefixes.values().length - 1)];
      case "WeaponNames":
        return WeaponNames.values()[randInt(0, WeaponNames.values().length - 1)];
      case "WeaponPrefixes":
        return WeaponPrefixes.values()[randInt(0, WeaponPrefixes.values().length - 1)];
      case "FieldNames":
        return FieldNames.values()[randInt(0, FieldNames.values().length - 1)];
      case "SpecialFieldNames":
        return SpecialFieldNames.values()[randInt(0, SpecialFieldNames.values().length - 1)];
      case "DungeonFieldNames":
        return DungeonFieldNames.values()[randInt(0, DungeonFieldNames.values().length - 1)];
      case "HealingPrefixNames":
        return HealingPrefixNames.values()[randInt(0, HealingPrefixNames.values().length - 1)];
      case "HealingAdjectives":
        return HealingAdjectives.values()[randInt(0, HealingAdjectives.values().length - 1)];
      default:
        return EnemyNames.Fairy;
    }
  }

  /**
   * method to truncate a double value after a certain amount of decimal places.
   * will result in at least 1 decimal place.
   *
   * @param value double value that needs to be truncated.
   * @param decimalPlaces int amount of decimal places.
   * @return the truncated double value.
   */
  public static double truncateDouble(double value, int decimalPlaces) {
    StringBuilder divider = new StringBuilder("1");
    for (int i = 0; i < decimalPlaces; i++) {
      divider.append("0");
    }
    return Math.floor(value * Integer.valueOf(divider.toString())) / Integer.valueOf(
        divider.toString());
  }

  /**
   * method to create a random integer within given bounds.
   * the bounds are inclusive, so the random number can be the bound itself.
   * this method is the preferred standard after java 1.7.
   *
   * @param min int minimum value.
   * @param max int maximum value.
   * @return the randomly generated int.
   */
  private static int randInt(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  /**
   * main method for testing. can be deleted afterwards.
   *
   * @param args .
   */
  public static void main(String[] args) {
    System.out.println(asString(getEnumAt("EnemyNames", 12)));
    System.out.println(asString(getRandomEnum("WeaponNames")));
    System.out.println(truncateDouble(12.1234567890, 2));
    System.out.println(truncateDouble(12.1234567890, 8));
  }

}
