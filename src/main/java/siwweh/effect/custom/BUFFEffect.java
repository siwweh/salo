package siwweh.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class BUFFEffect extends StatusEffect {
    public BUFFEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xffef07);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }


    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1, amplifier));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1, amplifier));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1, amplifier));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1, amplifier));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1, amplifier));
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if(entity instanceof PlayerEntity){
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 600, amplifier));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 600, amplifier));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 600, amplifier));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, amplifier));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, amplifier));
        }
    }
}
