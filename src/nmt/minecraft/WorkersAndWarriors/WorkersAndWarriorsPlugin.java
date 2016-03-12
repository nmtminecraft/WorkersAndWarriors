package nmt.minecraft.WorkersAndWarriors;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.plugin.java.JavaPlugin;

import nmt.minecraft.WorkersAndWarriors.Config.PluginConfiguration;
import nmt.minecraft.WorkersAndWarriors.Session.GameSession;

/**
 * Main plugin class. Creates top-level infrastructure, excluding game-session-specific componenets.
 * @author Skyler
 *
 */
public class WorkersAndWarriorsPlugin extends JavaPlugin {
	
	private static final String configFileName = "config.yml";

	public static WorkersAndWarriorsPlugin plugin;
	
	private Set<GameSession> sessions;
	

	
	
	@Override
	public void onLoad() {
		if (!getDataFolder().exists()) {
			getDataFolder().mkdirs();
		}
		
		File configFile = new File(getDataFolder(), WorkersAndWarriorsPlugin.configFileName);
		
		PluginConfiguration.makeConfiguration(configFile);
		
		if (!configFile.exists()) {
			try {
				PluginConfiguration.save(configFile);
			} catch (IOException e) {
				e.printStackTrace();
				getLogger().warning("Unable to save default config file!");
			}
		}
	}
	
	@Override
	public void onEnable() {
		WorkersAndWarriorsPlugin.plugin = this;
		
		this.sessions = new HashSet<GameSession>();
		
	}
	
	@Override
	public void onDisable() {
		for (GameSession session : sessions) {
			session.stop(true);
		}
	}
	
}
