package com.ghadif.persistence.schema.rulebook.weapon.property;

import lombok.Getter;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Getter
public enum WeaponPropertyType {

    AMMUNITION("""
            You can use a weapon that has the ammunition property to make a ranged attack only if you have ammunition to fire from the weapon.
            Each time you attack with the weapon, you expend one piece of ammunition.
            If you use a weapon that has the ammunition property to make a melee attack, you treat the weapon as an improvised weapon.
            """),
    AUTO("""
            Automatic weapons can only fire in burst or rapid modes.
            If the weapon has both burst and rapid properties, you choose which mode to use.
            You can only use one mode at a time.
            """),
    BURST("""
            When you would make a ranged weapon attack with a weapon with the burst property,
            you can instead spray a 10-foot-cube area within range with shots,
            consuming ammunition equal to the burst number.
            Each creature in the area must make a Dexterity saving throw (DC = 8 + your bonus to attacks with the weapon)
            or take the weapon’s normal damage.
            If the targeted area is beyond normal range but within long range, affected targets have advantage on the save.
            """),
    DEXTERITY("""
            A weapon with this special property requires more skill to control.
            While wielding it, you have disadvantage on attack rolls unless you meet the Dexterity requirement.
            """),
    DISGUISED("""
            You have advantage on Charisma (Deception) checks made to hide the nature of a disguised weapon.
            """),
    DOUBLE("""
            This weapon be used with one or two hands.
            A damage value in parentheses appears with the property-the damage when the weapon is used with Double-Weapon Fighting.
            See the rules for Double-Weapon Fighting in chapter 9.
            """),
    FINESSE("""
            When making an attack with a finesse weapon, you use your choice of your Strength or Dexterity modifier for the attack and damage rolls.
            You must use the same modifier for both rolls.
            """),
    FIXED("""
            A weapon with the fixed property does not fill the hand, but you can’t use the weapon while the hand is full.
            Additionally, you have a +10 bonus to ability checks and saving throws to avoid being disarmed of this weapon.
            """),
    HEAVY("""
            When you hit with an attack roll using Strength with this weapon, you deal additional damage equal to half your Strength modifier (rounded up, minimum of +1).
            """),
    HIDDEN("""
            You have advantage on Dexterity (Sleight of Hand) checks made to conceal a hidden weapon.
            """),
    LIGHT("""
            A light weapon is small and easy to handle, making it ideal for use when engaging in Double- or Two-Weapon Fighting.
            See the rules for Double- and Two-Weapon Fighting in chapter 9.
            """),
    LUMINOUS("""
            A weapon with the luminous property sheds dim light in a 5-foot radius while activated.
            Additionally, Dexterity (Stealth) checks made while the weapon is activated have disadvantage.
            """),
    RANGE("""
            A weapon that can be used to make a ranged attack has a range shown in parentheses after the ammunition or thrown property.
            The range lists two numbers.
            The first is the weapon’s normal range in feet, and the second indicates the weapon’s maximum range.
            When attacking a target beyond normal range, you have disadvantage on the attack roll.
            You can’t attack a target beyond the weapon’s long range.
            """),
    RAPID("""
            When you would make a ranged weapon attack with a weapon with the rapid property, you can instead unload on a single target, consuming ammunition equal to the rapid number.
            The target must make a Dexterity saving throw (DC = 8 + your bonus to attacks with the weapon).
            On a failed save, roll the weapon’s damage dice twice and add them together, adding relevant modifiers as normal.
            If the target is beyond normal range but within long range, it has advantage on the save.
            """),
    REACH("""
            This weapon adds 5 feet to your reach with it.
            """),
    RELOAD("""
            A limited number of shots can be made with a weapon that has the reload property.
            A character must then reload it using an action or a bonus action (the character’s choice).
            You must have one free hand to reload.
            """),
    RETURNING("""
            When you throw a weapon with the returning property, it automatically returns to your hand after the attack is complete, whether you hit or miss.
            """),
    SPECIAL("""
            A weapon with the special property has unusual rules governing its use, explained in the weapon’s description (see “Special Weapons” later in this section).
            """),
    STRENGTH("""
            A weapon with this special property has a heavy kickback.
            While wielding it, you have disadvantage on attack rolls unless you meet the Strength requirement.
            If the weapon has the burst or rapid property, you must meet the Strength requirement to use this feature.
            """),
    THROWN("""
            If a weapon has the thrown property, you can throw the weapon to make a ranged attack.
            If the weapon is a melee weapon, you use the same ability modifier for that attack roll and damage roll that you would use for a melee attack with the weapon.
            """),
    TWO_HANDED("""
            This weapon requires two hands to use.
            """),
    VERSATILE("""
            This weapon can be used with one or two hands.
            A damage value in parentheses appears with the property-the damage when the weapon is used with two hands to make a melee attack.
            """);

    private final String description;

    WeaponPropertyType(String description) {
        this.description = description;
    }
}
