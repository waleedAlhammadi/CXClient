package de.chrissx.mods.movement;

import java.io.File;

import de.chrissx.Util;
import de.chrissx.mods.Mod;

public class Timer extends Mod {

	float factor = 2;
	File ff;
	
	public Timer() {
		super("Timer");
		ff = getApiFile("factor");
	}

	@Override
	public void processCommand(String[] args) {
		if(args.length == 1)
			toggle();
		else if(args.length == 3 && args[1].equalsIgnoreCase("speed"))
			try {
				factor = Float.parseFloat(args[2]);
				if(enabled)
					net.minecraft.util.Timer.timerSpeed = factor;
			} catch (Exception e) {
				Util.sendMessage("�4Error parsing float.");
			}
		else
			Util.sendMessage("#timer to toggle, #timer speed <double> to change the factor.");
	}
	
	@Override
	public void toggle() {
		enabled = !enabled;
		if(enabled)
			net.minecraft.util.Timer.timerSpeed = factor;
		else
			net.minecraft.util.Timer.timerSpeed = 1;
	}

	@Override
	public void apiUpdate() {
		write(ff, factor);
	}
}