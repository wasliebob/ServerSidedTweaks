package wasliebob.sst.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.lang.reflect.Field;

import net.minecraft.network.play.server.S28PacketEffect;

public class SSTChannelHandler extends ChannelOutboundHandlerAdapter {
	static final Field f;
	static {
		try {
			f = S28PacketEffect.class.getDeclaredField("field_149251_a");
			f.setAccessible(true);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException();
		} catch (SecurityException e) {
			throw new RuntimeException();
		}		
	}
	
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
    	if(msg != null && msg instanceof S28PacketEffect){
    		S28PacketEffect packet = (S28PacketEffect)msg;
    		int id = Integer.parseInt(f.get(packet).toString());
    		
    		if(id != 1018)
        		ctx.write(msg, promise);
    	}else{
    		ctx.write(msg, promise);
    	}
    }
}