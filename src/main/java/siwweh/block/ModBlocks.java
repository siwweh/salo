package siwweh.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import siwweh.Salo;
import siwweh.item.ModItemGroup;

public class ModBlocks {
    public static final Block STONE_SALT = registerBlock("stone_salt",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool()),
            ModItemGroup.SALO_BLOCK);
    public static final Block SALTER = registerBlock("salter",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(2.5f)),
            ModItemGroup.SALO_BLOCK);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(Salo.MOD_ID, name), block );
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(Salo.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks(){
        Salo.LOGGER.debug("Registering ModBlocks for " + Salo.MOD_ID);
    }
}
