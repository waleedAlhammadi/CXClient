package de.chrissx.mods.movement;

import de.chrissx.mods.Mod;

public class AutoWalk extends Mod {

	public AutoWalk() {
		super("AutoWalk", "autowalk");
	}

	@Override
	public void onTick()
	{
		if(enabled)
			settings().keyBindForward.pressed = true;
	}
}
