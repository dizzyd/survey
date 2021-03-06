package com.dizzyd.survey.proxy;

import com.dizzyd.survey.blocks.BlockStake;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy {

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new BlockStake());
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		BlockStake.INSTANCE.registerItems(event.getRegistry());
	}
}
