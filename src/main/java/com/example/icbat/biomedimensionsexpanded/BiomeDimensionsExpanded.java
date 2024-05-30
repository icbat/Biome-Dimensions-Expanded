package com.example.icbat.biomedimensionsexpanded;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.Blocks;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;

import java.util.HashMap;
import java.util.Map;

public class BiomeDimensionsExpanded implements ModInitializer {
	public static final String MOD_ID = "biome-dimensions-expanded";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");


		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.BAMBOO_BLOCK)
				.destDimID(new Identifier(MOD_ID, "test-dimension"))
				.tintColor(33, 33, 33)
				.onlyLightInOverworld()
				.registerPortal();
	}
}