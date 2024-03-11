package siwweh.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import siwweh.Salo;
import siwweh.item.custom.*;

public class ModItems {

    public static final Item SALO;
    public static final Item SALT;
    public static final Item COOKED_SALO;
    public static final Item SMOKED_SALO;
    public static final Item BACON;
    public static final Item GOLDEN_SALO;
    public static final Item LIVING_SALO;
    public static final Item SALOKADZE;
    public static final Item ENDER_SALO;
    public static final Item ROTTEN_SALO;

    public static final Item VEGAN_SALO;
    public static final Item SUPER_SMALL_SALO;
    public static final Item SUPER_BIG_SALO;
    public static final Item AEGISALO;
    public static final Item STONE_SALO;
    public static final Item TRANSPARENT_SALO;



    static {
        SALO = registerItem("salo", new SaloItem(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                        FoodComponent.Builder().hunger(10).saturationModifier(15f).meat().build())));
        SALT = registerItem("salt", new Item(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                        FoodComponent.Builder().hunger(1).saturationModifier(2f).alwaysEdible().statusEffect(new
                        StatusEffectInstance(StatusEffects.POISON, 30, 1), 1.0f).build())));
        COOKED_SALO = registerItem("cooked_salo", new Item(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                        FoodComponent.Builder().hunger(13).saturationModifier(17f).meat().build())));
        SMOKED_SALO = registerItem("smoked_salo", new Item(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                        FoodComponent.Builder().hunger(13).saturationModifier(17f).meat().build())));
        BACON = registerItem("bacon", new Item(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                        FoodComponent.Builder().hunger(11).saturationModifier(13f).meat().build())));
        GOLDEN_SALO = registerItem("golden_salo", new Item(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                        FoodComponent.Builder().hunger(15).saturationModifier(19.5f).meat().build())));
        LIVING_SALO = registerItem("living_salo", new LivingSaloItem(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                        FoodComponent.Builder().hunger(-8).saturationModifier(-10f).meat().statusEffect(new
                        StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0f).alwaysEdible().build())));
        SALOKADZE = registerItem("salokadze", new SalokadzeItem(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                        FoodComponent.Builder().hunger(6).saturationModifier(10f).meat().alwaysEdible().build())));
        ENDER_SALO = registerItem("ender_salo", new EnderSaloItem(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                        FoodComponent.Builder().hunger(6).saturationModifier(10f).meat().alwaysEdible().build())));
        ROTTEN_SALO = registerItem("rotten_salo", new Item(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                        FoodComponent.Builder().hunger(6).saturationModifier(8f).meat().statusEffect(new
                        StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.6f).build())));
        VEGAN_SALO = registerItem("vegan_salo", new Item(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                FoodComponent.Builder().hunger(6).saturationModifier(10f).build())));
        SUPER_SMALL_SALO = registerItem("super_small_salo", new Item(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                FoodComponent.Builder().hunger(2).saturationModifier(5f).meat().statusEffect(new
                StatusEffectInstance(Salo.SMALL, 1200, 0), 1.0f).alwaysEdible().snack().build())));
        SUPER_BIG_SALO = registerItem("super_big_salo", new SuperBigSaloItem(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                FoodComponent.Builder().hunger(99).saturationModifier(999f).meat().build())));
        STONE_SALO = registerItem("stone_salo", new StoneSaloItem(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                FoodComponent.Builder().hunger(0).saturationModifier(0f).alwaysEdible().build())));
        AEGISALO = registerItem("aegisalo", new Item(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                FoodComponent.Builder().hunger(2).saturationModifier(5f).meat().statusEffect(new
                StatusEffectInstance(Salo.UNDYING, 6000, 0), 1.0f).alwaysEdible().build())));
        TRANSPARENT_SALO = registerItem("transparent_salo", new Item(new FabricItemSettings().group(ModItemGroup.SALO_FOOD).food(new
                FoodComponent.Builder().hunger(5).saturationModifier(8f).meat().statusEffect(new
                StatusEffectInstance(StatusEffects.INVISIBILITY, 3600, 0), 1.0f).alwaysEdible().build())));
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Salo.MOD_ID, name), item);
    }
    public static void registerModItems(){
        Salo.LOGGER.debug("Registering mod items for" + Salo.MOD_ID);
    }
}
