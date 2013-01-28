package mint.quantumcoins;

import java.util.logging.Level;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;



@Mod(modid = "qcoins", name = "Quantum Coins", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class quantumCoins
{	
	public static Item coin;
	
	@SidedProxy(clientSide = "mint.quantumCoins.ClientProxy", serverSide = "mint.quantumCoins.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance("Coins")
	public static quantumCoins instance;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		configHelper.init(event.getSuggestedConfigurationFile());
	}

	@Init
	public void init(FMLInitializationEvent event)
	{
		coin = new itemCoin(configHelper.coinID);
		GameRegistry.registerItem(coin, "coin");
		
		proxy.registerRenderThings();
	}

	@PostInit
	public static void postInit(FMLPostInitializationEvent event)
	{
		FMLLog.info("Quantum Coins: Looks like everything ran correctly!");
	}
}