package siwweh.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import siwweh.Salo;

public class ModItemGroup {
    public static final ItemGroup SALO_FOOD = FabricItemGroupBuilder.build(
            new Identifier(Salo.MOD_ID, "salo_food"), () -> new ItemStack(ModItems.SALO)
    );
    public static final ItemGroup SALO_BLOCK = FabricItemGroupBuilder.build(
            new Identifier(Salo.MOD_ID, "salo_block"), () -> new ItemStack(ModItems.SALT)
    );
}
