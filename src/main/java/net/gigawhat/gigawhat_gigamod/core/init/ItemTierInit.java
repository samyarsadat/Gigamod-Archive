// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.core.init;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum ItemTierInit implements IItemTier 
{
    GIGALIUM(4, 1825, 8.6f, 3.5f, 18, () -> Ingredient.of(ItemInit.GIGALIUM_INGOT.get()));
 
    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyValue<Ingredient> repairIngredient;

	ItemTierInit(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient)
	{
		this.level = level;
		this.uses = uses;
		this.speed = speed;
		this.damage = damage;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = new LazyValue<>(repairIngredient);
	}

    @Override
    public int getUses() 
	{
       return uses;
    }

    @Override
    public float getSpeed() 
	{
       return speed;
    }

    @Override
    public float getAttackDamageBonus() 
	{
       return damage;
    }

    @Override
    public int getLevel() 
	{
       return level;
    }

    @Override
    public int getEnchantmentValue() 
	{
       return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() 
	{
       return repairIngredient.get();
    }
}