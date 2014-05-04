package com.gooroos.Stopwatch.client;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.KeyBindingRegistry;

import com.gooroos.Stopwatch.CommonProxy;


public class ClientProxy extends CommonProxy {
	public void registerKeyBindings(Timer timer)
	{
		KeyBinding[] bindings = { new KeyBinding("Toggle Stopwatch", Keyboard.KEY_APOSTROPHE),
								  new KeyBinding("Reset Stopwatch", Keyboard.KEY_SEMICOLON)
								};
		boolean[] repeats = { false, false };
		
		KeyBindingRegistry.registerKeyBinding(new StopwatchKeyHandler(bindings, repeats, timer));
	}
}
