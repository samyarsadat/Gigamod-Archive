// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.core.init;

import java.util.function.Supplier;

import net.gigawhat.gigawhat_gigamod.Gigamod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum ArmorMaterialInit implements IArmorMaterial
{
    GIGALIUM("gigalium", 35, new int[]{3, 6, 8, 3}, 13, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.5F, 0.06F, () -> Ingredient.of(ItemInit.GIGALIUM_INGOT.get()));

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairIngredient;
 
    ArmorMaterialInit(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) 
    {
       this.name = name;
       this.durabilityMultiplier = durabilityMultiplier;
       this.slotProtections = slotProtections;
       this.enchantmentValue = enchantmentValue;
       this.sound = sound;
       this.toughness = toughness;
       this.knockbackResistance = knockbackResistance;
       this.repairIngredient = new LazyValue<>(repairIngredient);
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType p_200896_1_) 
    {
        return HEALTH_PER_SLOT[p_200896_1_.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType p_200902_1_) 
    {
        return this.slotProtections[p_200902_1_.getIndex()];
    }

    @Override
    public int getEnchantmentValue() 
    {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() 
    {
        return this.sound;
    }

    @Override
    public Ingredient getRepairIngredient() 
    {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() 
    {
        return Gigamod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() 
    {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() 
    {
        return this.knockbackResistance;
    }
}