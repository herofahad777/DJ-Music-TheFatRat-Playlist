
package net.mcreator.djmusicthefatratplaylist.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;

import net.mcreator.djmusicthefatratplaylist.creativetab.TabTheFatRat;
import net.mcreator.djmusicthefatratplaylist.ElementsDjMusicThefatratPlaylistMod;

@ElementsDjMusicThefatratPlaylistMod.ModElement.Tag
public class ItemItemTheFatRat extends ElementsDjMusicThefatratPlaylistMod.ModElement {
	@GameRegistry.ObjectHolder("dj_music_thefatrat_playlist:item_the_fat_rat")
	public static final Item block = null;
	public ItemItemTheFatRat(ElementsDjMusicThefatratPlaylistMod instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("dj_music_thefatrat_playlist:item_the_fat_rat", "inventory"));
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			setMaxDamage(0);
			maxStackSize = 1;
			setUnlocalizedName("item_the_fat_rat");
			setRegistryName("item_the_fat_rat");
			setCreativeTab(TabTheFatRat.tab);
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getMaxItemUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
			return 1F;
		}
	}
}
