package com.gooroos.stopwatch.client;

import java.text.DecimalFormat;

import net.minecraft.client.Minecraft;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.ForgeSubscribe;

public class Timer
{
	private boolean displayTimer = false;
	private boolean timerRunning = false;
	private long startTime = 0L;
	private long accumulatedTime = 0L;
	
	@ForgeSubscribe
	public void renderOverlay(RenderGameOverlayEvent e)
	{
		if (displayTimer && (e.type == ElementType.HOTBAR)) {
			Minecraft mc = Minecraft.getMinecraft();
			int sec = 0;
			
			if (timerRunning) {
				sec = (int)((accumulatedTime + System.currentTimeMillis() - startTime) / 1000L);
			} else {
				sec = (int)(accumulatedTime / 1000L);
			}
			
			int hour = sec / 3600;
			sec -= hour * 3600;
			int min = sec / 60;
			sec -= min * 60;
			
			DecimalFormat formatter = new DecimalFormat("00");
			String timeStr = formatter.format(hour) + ":" + formatter.format(min) + ":" + formatter.format(sec);
			
			mc.fontRenderer.drawString(timeStr, 2, (mc.displayHeight / 2) - 12, 0xFFFFFFFF);
		}
	}
	
	
	public Timer()
	{
		displayTimer = false;
		timerRunning = false;
		startTime = 0L;
		accumulatedTime = 0L;
	}
	
	public void reset()
	{
		displayTimer = false;
		timerRunning = false;
		startTime = 0L;
		accumulatedTime = 0L;
	}
	
	public void toggleActive()
	{
		timerRunning = !timerRunning;
		
		if (timerRunning) {
			displayTimer = true;
			startTime = System.currentTimeMillis();
		} else {
			accumulatedTime += System.currentTimeMillis() - startTime;
			startTime = 0L;
		}
	}
}