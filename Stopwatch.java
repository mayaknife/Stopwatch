package com.gooroos.Stopwatch;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

import com.gooroos.Stopwatch.client.Timer;

@Mod(modid="Stopwatch", name="Stopwatch", version="0.1.0")
@NetworkMod(clientSideRequired=true)
public class Stopwatch {

        // The instance of your mod that Forge uses.
        @Instance("Stopwatch")
        public static Stopwatch instance;
       
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="com.gooroos.Stopwatch.client.ClientProxy", serverSide="com.gooroos.Stopwatch.CommonProxy")
        public static CommonProxy proxy;
       
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        	Timer timer = new Timer();
        	
        	MinecraftForge.EVENT_BUS.register(timer);
        	proxy.registerKeyBindings(timer);
        }
       
        @EventHandler
        public void load(FMLInitializationEvent event) {
            // Don't really need this yet.
        }
       
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
            // Don't really need this yet.
        }
}
