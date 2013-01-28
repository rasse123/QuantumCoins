package mint.quantumcoins;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
    public static final String itemTex = "/mint/quantumcoins/items.png";
    
	@Override
    public void registerRenderThings()
    {
    	MinecraftForgeClient.preloadTexture(itemTex);
    }
   
}
