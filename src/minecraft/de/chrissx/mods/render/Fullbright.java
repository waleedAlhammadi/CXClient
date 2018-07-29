package de.chrissx.mods.render;

import de.chrissx.mods.Bindable;
import de.chrissx.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class Fullbright extends Mod {

	float gammaBefore;
	
	public Fullbright() {
		super("FullBright");
	}
	
	@Override
	public void toggle() {
		enabled = !enabled;
		GameSettings gs = mc.gameSettings;
		if(enabled) {
			gammaBefore = gs.gammaSetting;
			gs.gammaSetting = 100;
		}else
			gs.gammaSetting = gammaBefore;
		mc.renderGlobal.loadRenderers();
	}
}