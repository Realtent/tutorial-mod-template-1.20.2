package net.realtent.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.realtent.tutorialmod.block.ModBlocks;
import net.realtent.tutorialmod.entity.ModEntities;
import net.realtent.tutorialmod.entity.custom.PorcupineEntity;
import net.realtent.tutorialmod.item.ModItemGroups;
import net.realtent.tutorialmod.item.ModItems;
import net.realtent.tutorialmod.sound.ModSounds;
import net.realtent.tutorialmod.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// https://fabric.moddedmc.wiki/basic-problem-solving
public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();

		ModSounds.registerSounds();

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);

		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
	}
}