package com.dizzyd.survey;

import com.dizzyd.survey.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Survey.MODID, name = Survey.NAME, version = Survey.VERSION, acceptedMinecraftVersions = "[1.12]", useMetadata = true)
public class Survey {
	public static final String MODID = "survey";
	public static final String NAME = "Survey";
	public static final String VERSION = "0.0.1";

	@SidedProxy(clientSide = "com.dizzyd.survey.proxy.ClientProxy",
				serverSide = "com.dizzyd.survey.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Mod.Instance
	public static Survey instance;

	public static Logger logger = LogManager.getLogger("Survey");

	public static Config config;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		config = new Config(event);
	}

}
