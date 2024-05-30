package com.example.icbat.biomedimensionsexpanded;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;

import java.util.ArrayList;
import java.util.List;

public class BiomeDimensionsExpanded implements ModInitializer {
	public static final String MOD_ID = "biome-dimensions-expanded";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// TODO Can we make a file for this, so it's not Java-y to write more?
		List<PortalToDimension> portals = new ArrayList<>();
		portals.add(new PortalToDimension(Blocks.SANDSTONE, "desert",  174, 119, 31));

        LOGGER.info("Adding {} biome portals", portals.size());

		for (PortalToDimension portal : portals) {
            LOGGER.debug("Adding portal for: {}", portal.dimension_id());
			CustomPortalBuilder.beginPortal()
					.frameBlock(portal.portal_block())
					.destDimID(new Identifier(MOD_ID, portal.dimension_id()))
					.tintColor(portal.portal_r(), portal.portal_g(), portal.portal_b())
					.onlyLightInOverworld()
					.registerPortal();
		}

		LOGGER.info("Finished adding biome portals");
	}
}

record PortalToDimension(Block portal_block, String dimension_id, int portal_r, int portal_g, int portal_b) {}