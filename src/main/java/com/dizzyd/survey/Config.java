package com.dizzyd.survey;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class Config {

	private File configFile;
	private Configuration configRoot;

	public Config(FMLPreInitializationEvent e) {
		this.configFile = e.getSuggestedConfigurationFile();
		this.reload();
	}

	public void reload() {
		configRoot = new Configuration(configFile);
		configRoot.load();

		if (configRoot.hasChanged()) {
			configRoot.save();
		}
	}

	public Configuration getConfigRoot() {
		return configRoot;
	}
}
