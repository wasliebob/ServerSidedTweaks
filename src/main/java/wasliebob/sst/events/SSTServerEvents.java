package wasliebob.sst.events;

import net.minecraft.network.NetHandlerPlayServer;
import wasliebob.sst.network.SSTChannelHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerConnectionFromClientEvent;


public class SSTServerEvents {
	@SubscribeEvent
	public void server(ServerConnectionFromClientEvent e){
		NetHandlerPlayServer ps = (NetHandlerPlayServer)e.handler;
		ps.netManager.channel().pipeline().addAfter("encoder", "soundcheck", new SSTChannelHandler());
	}
}