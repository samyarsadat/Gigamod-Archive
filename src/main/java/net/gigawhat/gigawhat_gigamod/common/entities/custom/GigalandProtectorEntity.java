// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.common.entities.custom;


import net.gigawhat.gigawhat_gigamod.Gigamod;
import net.gigawhat.gigawhat_gigamod.core.util.SoundEventsInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookAtWithoutMovingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GigalandProtectorEntity extends IronGolemEntity 
{
    private int attackAnimationTick;
    private static final ResourceLocation LOOT_TABLE = new ResourceLocation(Gigamod.MOD_ID, "entities/gigaland_protector");

    public GigalandProtectorEntity(EntityType<? extends IronGolemEntity> type, World worldln) 
    {
        super(type, worldln);
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() 
    {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 60.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 6.0D).add(Attributes.FOLLOW_RANGE, 25.0D).add(Attributes.ATTACK_KNOCKBACK, 3.5D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    protected void registerGoals() 
    {
        super.registerGoals();

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WanderingTraderEntity.class, false));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2D, true));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new SwimGoal(this));
        this.goalSelector.addGoal(8, new LookAtWithoutMovingGoal(this, LivingEntity.class, 4.0F, 2.0F));
    }

    @Override
    public void aiStep() 
    {
        super.aiStep();

        if (this.attackAnimationTick > 0) 
        {
            --this.attackAnimationTick;
        }
  
        if (getHorizontalDistanceSqr(this.getDeltaMovement()) > (double)2.5000003E-7F && this.random.nextInt(5) == 0) 
        {
            int i = MathHelper.floor(this.getX());
            int j = MathHelper.floor(this.getY() - (double)0.2F);
            int k = MathHelper.floor(this.getZ());
            
            BlockPos pos = new BlockPos(i, j, k);
            BlockState blockstate = this.level.getBlockState(pos);

            if (!blockstate.isAir(this.level, pos)) 
            {
                this.level.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getX() + ((double)this.random.nextFloat() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + ((double)this.random.nextFloat() - 0.5D) * (double)this.getBbWidth(), 4.0D * ((double)this.random.nextFloat() - 0.5D), 0.5D, ((double)this.random.nextFloat() - 0.5D) * 4.0D);
            }
        }
    }
  

    @Override
    public boolean isBaby() 
    {
        return false;
    }

    @Override
    protected int getExperienceReward(PlayerEntity player)
    {
        int min_xp = 1;
        int max_xp = 5;

        return (int) ((Math.random() * (max_xp - min_xp)) + min_xp);
    }

    @Override
    protected ResourceLocation getDefaultLootTable() 
    {
        return LOOT_TABLE;
    }

    /*@Override
    protected SoundEvent getAmbientSound() 
    {
        return SoundEvents.IRON_GOLEM_REPAIR;
    }*/

    @Override
    protected SoundEvent getDeathSound() 
    {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
    {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    /*@Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) 
    {
        this.playSound(SoundEvents.IRON_GOLEM_STEP, 0.15F, 1.0F);
    }*/

    @OnlyIn(Dist.CLIENT)
    @Override
    public void handleEntityEvent(byte p_70103_1_) 
    {
        if (p_70103_1_ == 4) 
        {
            this.attackAnimationTick = 10;
            this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        } 
       
        else 
        {
            super.handleEntityEvent(p_70103_1_);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) 
    {
        if (!super.doHurtTarget(entityIn)) 
        {
            return false;
        }

        else 
        {
            if (entityIn instanceof LivingEntity && !(entityIn instanceof WanderingTraderEntity)) 
            {
                this.attackAnimationTick = 10;
                this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);

                ((LivingEntity) entityIn).addEffect(new EffectInstance(Effects.BLINDNESS, 110));
                ((LivingEntity) entityIn).addEffect(new EffectInstance(Effects.WEAKNESS, 450));
                ((LivingEntity) entityIn).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 200));
            }

            else if (entityIn instanceof WanderingTraderEntity) 
            {
                this.attackAnimationTick = 10;
                this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);

                ((LivingEntity) entityIn).addEffect(new EffectInstance(Effects.HARM, 100));
                ((LivingEntity) entityIn).addEffect(new EffectInstance(Effects.WEAKNESS, 450));
                ((LivingEntity) entityIn).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 300));
            }

            return true;
        }
    }

    @Override
    protected ActionResultType mobInteract(PlayerEntity player, Hand hand) 
    {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        
        if (item != Items.REDSTONE) 
        {
            return ActionResultType.PASS;
        }
        
        else 
        {
            float f = this.getHealth();
            this.heal(12.0F);
           
            if (this.getHealth() == f) 
            {
                return ActionResultType.PASS;
            } 
           
            else 
            {
                float f1 = 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F;
                this.playSound(SoundEvents.ENDER_CHEST_OPEN, 1.0F, f1);
              
                if (!player.abilities.instabuild) 
                {
                    itemstack.shrink(1);
                }
  
                return ActionResultType.sidedSuccess(this.level.isClientSide);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public int getAttackAnimationTick() 
    {
       return this.attackAnimationTick;
    }
}