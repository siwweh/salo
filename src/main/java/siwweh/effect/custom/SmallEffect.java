package siwweh.effect.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleTypes;

public class SmallEffect extends StatusEffect {
    public SmallEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xe9e7e2);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }


    public void setBaseScale(Entity entity, float scale) {
        final ScaleData data = ScaleTypes.BASE.getScaleData(entity);
        final ScaleData data2 = ScaleTypes.MOTION.getScaleData(entity);
        data.setScale(scale);
        data2.setScale(1/scale);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            setBaseScale(entity, (1f/(amplifier+2)));
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        setBaseScale(entity, 1.0f);
    }
}

