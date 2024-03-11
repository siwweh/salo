package siwweh.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import siwweh.Salo;

@Mixin(LivingEntity.class)
public abstract class SaloLivingEntityMixin {

    @Inject(method = "tryUseTotem", at = @At("TAIL"), cancellable = true)
    public void tryUseTotem0(DamageSource source, CallbackInfoReturnable<Boolean> cir){
        LivingEntity entity = (LivingEntity)(Object) this;
        if(entity.hasStatusEffect(Salo.UNDYING)){
            entity.setHealth(entity.getMaxHealth());
            entity.clearStatusEffects();
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 255));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 255));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 100, 255));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 255));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 1));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 1));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 800, 0));
            cir.setReturnValue(Boolean.TRUE);
        }

    }
}
