package siwweh;

import com.ibm.icu.util.CodePointTrie;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import siwweh.block.ModBlocks;
import siwweh.effects.SmallEffect;
import siwweh.effects.UndyingEffect;
import siwweh.item.ModItems;

public class Salo implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "salo";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final StatusEffect SMALL = new SmallEffect();
	public static final StatusEffect UNDYING = new UndyingEffect();


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		LOGGER.info("Salo mod initialize");
		Registry.register(Registry.STATUS_EFFECT, new Identifier("salo", "small"), SMALL);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("salo", "undying"), UNDYING);
	}
}