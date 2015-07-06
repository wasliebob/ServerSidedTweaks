package wasliebob.sst;

import wasliebob.sst.events.SSTServerEvents;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = SST.MODID, version = SST.VERSION, acceptableRemoteVersions = "*")
public class SST{    
    public static final String MODID = "ServerSidedTweaks";
    public static final String VERSION = "1.0";
    public static FMLEventChannel net;
        
    @EventHandler
	public void preInit(FMLPreInitializationEvent event) {
    	
	}

    @EventHandler
	public void init(FMLInitializationEvent event) {
    	if(event.getSide() == Side.SERVER)
    		FMLCommonHandler.instance().bus().register(new SSTServerEvents());
	}

    @EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		
	}
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event){

    }
}