package de.chrissx.mods;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Paths;

import com.google.common.io.Files;

import de.chrissx.Constants;
import de.chrissx.HackedClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public abstract class Mod implements Commandable, Bindable, TickListener, StopListener, RenderedObject {

	protected volatile boolean enabled = false;
	protected final String name;
	protected final Minecraft mc = Minecraft.getMinecraft();
	protected final HackedClient hc = HackedClient.getClient();
	protected final String apiDir;
	
	public Mod(String name) {
		this.name = name;
		apiDir = Paths.get(Constants.modsPath, name).toString();
	}
	
	public void toggle() {
		enabled = !enabled;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	@Override
	public boolean onRender(FontRenderer r, int x, int y) {
		if(enabled)
			r.drawString(name, x, y, Color.WHITE.getRGB());
		return enabled;
	}
	
	@Override
	public void processCommand(String[] args) {
		toggle();
	}
	
	@Override
	public void onHotkey() {
		toggle();
	}
	
	@Override
	public void onStop() {}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void onTick() {}
	
	public void apiUpdate() {}
	
	public String getApiDir()
	{
		return apiDir;
	}
	
	protected File getApiFile(String name)
	{
		return Paths.get(apiDir, name).toFile();
	}
	
	protected void write(File f, byte b)
	{
		try {
			f.createNewFile();
			Files.write(new byte[] {b}, f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void write(File f, byte[] b)
	{
		try {
			f.createNewFile();
			Files.write(b, f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void write(File f, boolean b)
	{
		try {
			f.createNewFile();
			Files.write(new byte[] {(byte) (b ? 1 : 0)}, f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void write(File f, String s, Charset cs)
	{
		try {
			f.createNewFile();
			Files.write(cs.encode(s).array(), f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void write(File f, int i)
	{
		try {
			f.createNewFile();
			Files.write(ByteBuffer.allocate(4).putInt(i).array(), f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void write(File f, long i)
	{
		try {
			f.createNewFile();
			Files.write(ByteBuffer.allocate(8).putLong(i).array(), f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void write(File f, short s)
	{
		try {
			f.createNewFile();
			Files.write(ByteBuffer.allocate(2).putShort(s).array(), f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void write(File f, float s)
	{
		try {
			f.createNewFile();
			Files.write(ByteBuffer.allocate(4).putFloat(s).array(), f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void write(File f, double s)
	{
		try {
			f.createNewFile();
			Files.write(ByteBuffer.allocate(8).putDouble(s).array(), f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}