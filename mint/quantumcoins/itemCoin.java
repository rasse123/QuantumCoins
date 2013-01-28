package mint.quantumcoins;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class itemCoin extends Item
{
	public static String coinname = configHelper.coinName;
	
	public itemCoin(int ID)
	{
		super(ID);
		setHasSubtypes(true);
		setMaxStackSize(64);
		setMaxDamage(0);
		setCreativeTab(CreativeTabs.tabMisc);
		setTextureFile(ClientProxy.itemTex);
	}

    public int getIconFromDamage(int par1)
    {
    	return 0;
    }
    
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemstack, int par2)
    {
    	int color = Integer.parseInt(configHelper.coinColor[itemstack.getItemDamage()], 16);
		return color;
    }
    
    public String getItemDisplayName(ItemStack itemstack)
    {
    	String name = "\u00A7" + configHelper.coinNameColor[itemstack.getItemDamage()] +
    				  configHelper.coinTypeName[itemstack.getItemDamage()] + " " + coinname;
    	return name;
    }
    
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	{
		if (configHelper.coinTypeInfo[itemstack.getItemDamage()].equals("none") == false)
		{list.add(configHelper.coinTypeInfo[itemstack.getItemDamage()]);}
	}
    
    @SideOnly(Side.CLIENT)
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < configHelper.coinNum; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}
