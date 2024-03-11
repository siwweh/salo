package siwweh.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import siwweh.item.ModItems;

public class DeadSaloItem extends Item {

    public DeadSaloItem(Item.Settings settings) {
        super(settings);
    }

    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
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
            entity.damage(DamageSource.MAGIC, 50);
        }
        return ActionResult.success(user.world.isClient);
    }
}
