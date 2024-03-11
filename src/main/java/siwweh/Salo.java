package siwweh;

import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import siwweh.block.ModBlocks;
import siwweh.effect.ModEffects;
import siwweh.effect.custom.BUFFEffect;
import siwweh.effect.custom.SmallEffect;
import siwweh.effect.custom.UndyingEffect;
import siwweh.item.ModItems;

public class Salo implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "salo";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final StatusEffect SMALL = new SmallEffect();
	public static final StatusEffect UNDYING = new UndyingEffect();
	public static final StatusEffect BUFF = new BUFFEffect();




	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEffects.registerModEffects();
		LOGGER.info("Salo mod initialize");
		Registry.register(Registry.STATUS_EFFECT, new Identifier("salo", "small"), SMALL);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("salo", "buff"), BUFF);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("salo", "undying"), UNDYING);
	}
}