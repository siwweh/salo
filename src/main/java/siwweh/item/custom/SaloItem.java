package siwweh.item.custom;

import net.fabricmc.fabric.api.event.Event;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import siwweh.item.ModItems;

public class SaloItem extends Item {
    public SaloItem(Item.Settings settings) {
        super(settings);
    }

    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (entity instanceof PigEntity pigEntity) {
            if (pigEntity.isAlive() && user.isSneaking()) {
                if (!user.world.isClient) {
                    if (!user.getAbilities().creativeMode) {
                        ItemStack itemStack = new ItemStack(ModItems.LIVING_SALO);
                        if (!user.getInventory().insertStack(itemStack)) {
                            user.dropItem(itemStack, false);
                        } else {
                            user.getInventory().insertStack(itemStack);
                        }
                        stack.decrement(1);
                    }
                    pigEntity.remove(Entity.RemovalReason.KILLED);
                }
            }
        }
        return ActionResult.success(user.world.isClient);
    }
}
