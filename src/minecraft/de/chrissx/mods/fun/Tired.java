package de.chrissx.mods.fun;

import de.chrissx.mods.Mod;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Tired extends Mod {

	public Tired() {
		super("Tired", "tired");
	}

	@Override
	public void onTick()
	{
		if(enabled)
			sendPacket(new C03PacketPlayer.C05PacketPlayerLook(player().rotationYaw, player().ticksExisted % 100, player().onGround));
	}
}
