package mint.quantumcoins;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
    public static final String itemTex = "/mint/quantumcoins/items.png";
    
	@Override
    public void registerRenderThings()
    {
    	MinecraftForgeClient.preloadTexture(itemTex);
    }
	
	public void registerSoundHandler()
	{
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
	}
   
}
