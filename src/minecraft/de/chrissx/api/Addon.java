package de.chrissx.api;

import de.chrissx.HackedClient;
import de.chrissx.addons.AddonManager;
import de.chrissx.mods.StopListener;
import net.minecraft.client.Minecraft;

public abstract class Addon implements StopListener {

	/**
	 * Gets the AddonManager
	 * @return The AddonManager
	 */
	public AddonManager getManager() {
		return getClient().getAddonManager();
	}
	
	/**
	 * Gets the HackedClient-instance
	 * @return The HackedClient's instance
	 */
	public HackedClient getClient() {
		return HackedClient.getClient();
	}
	
	private final Minecraft mc = Minecraft.getMinecraft();
	
	private final String name;
	
	/**
	 * Gets the Minecraft-class's instance
	 * @return The Minecraft-instance
	 */
	public Minecraft getMinecraft() {
		return mc;
	}
	
	/**
	 * 
	 * @param name The name of the addon
	 */
	public Addon(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void onStop() {}
}
