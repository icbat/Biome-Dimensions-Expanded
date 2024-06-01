package com.example.icbat.biomedimensionsexpanded;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;

import java.awt.*;
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
		List<PortalToDimension> portals = new ArrayList<>();
		portals.add(new PortalToDimension(Blocks.SANDSTONE, "beach",  new Color(147, 71, 129)));
		portals.add(new PortalToDimension(Blocks.CHISELED_SANDSTONE, "desert",  new Color(174, 119, 31)));
		portals.add(new PortalToDimension(Blocks.RED_MUSHROOM_BLOCK, "mooshroom",  new Color(122, 32, 26)));

		portals.add(new PortalToDimension(Blocks.STRIPPED_BAMBOO_BLOCK, "bamboo_jungle",  new Color(104, 114, 32)));
		portals.add(new PortalToDimension(Blocks.STRIPPED_MANGROVE_LOG, "swamp",  new Color(91, 58, 35)));
		portals.add(new PortalToDimension(Blocks.STRIPPED_BIRCH_LOG, "birch",  new Color(162, 162, 130)));
		portals.add(new PortalToDimension(Blocks.STRIPPED_DARK_OAK_LOG, "dark_forest",  new Color(57, 40, 29)));
		portals.add(new PortalToDimension(Blocks.STRIPPED_CHERRY_LOG, "cherry_grove",  new Color(153, 75, 124)));
		portals.add(new PortalToDimension(Blocks.STRIPPED_ACACIA_LOG, "savanna",  new Color(147, 60, 23)));
		portals.add(new PortalToDimension(Blocks.STRIPPED_JUNGLE_LOG, "jungle",  new Color(80, 112, 45)));

		portals.add(new PortalToDimension(Blocks.SNOW_BLOCK, "snowy_plains",  new Color(200, 205, 204)));
		portals.add(new PortalToDimension(Blocks.POWDER_SNOW, "snowy_slopes",  new Color(201, 206, 205)));
		portals.add(new PortalToDimension(Blocks.ICE, "grove",  new Color(127, 180, 196)));
		portals.add(new PortalToDimension(Blocks.PACKED_ICE, "ice_spikes",  new Color(87, 137, 150)));
		portals.add(new PortalToDimension(Blocks.BLUE_ICE, "frozen_ocean",  new Color(47, 145, 176)));

		// Honey Block -> Meadow, Flower Forest
		// Seaweed Block -> Deep Ocean
		// Slime Block -> ???
		// Stripped Pine Block -> ???
		// ??? -> Badlands
		// ??? -> Dripstone
		// ??? -> Lush Caves
		// ??? -> Mountain Biomes?
		// ??? -> Sunflower Fields?

        LOGGER.info("Adding {} biome portals", portals.size());

		for (PortalToDimension portal : portals) {
            LOGGER.debug("Adding portal for: {}", portal.dimension_id());
			CustomPortalBuilder.beginPortal()
					.frameBlock(portal.portal_block())
					.destDimID(new Identifier(MOD_ID, portal.dimension_id()))
					.tintColor(portal.portal_color().getRed(), portal.portal_color().getBlue(), portal.portal_color().getGreen())
					.onlyLightInOverworld()
					.registerPortal();
		}

		LOGGER.info("Finished adding biome portals");
	}
}

/**
 * @param portal_block the Minecraft block with which to make the portal from
 * @param dimension_id string must exactly match the filename for the corresponding dimension in resources/data/<>/dimension
 * */
record PortalToDimension(Block portal_block, String dimension_id, Color portal_color) {}