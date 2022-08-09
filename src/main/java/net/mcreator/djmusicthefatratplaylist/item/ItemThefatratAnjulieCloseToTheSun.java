
package net.mcreator.djmusicthefatratplaylist.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.djmusicthefatratplaylist.creativetab.TabTheFatRat;
import net.mcreator.djmusicthefatratplaylist.ElementsDjMusicThefatratPlaylistMod;

@ElementsDjMusicThefatratPlaylistMod.ModElement.Tag
public class ItemThefatratAnjulieCloseToTheSun extends ElementsDjMusicThefatratPlaylistMod.ModElement {
	@GameRegistry.ObjectHolder("dj_music_thefatrat_playlist:thefatrat_anjulie_close_to_the_sun")
	public static final Item block = null;
	public ItemThefatratAnjulieCloseToTheSun(ElementsDjMusicThefatratPlaylistMod instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0,
				new ModelResourceLocation("dj_music_thefatrat_playlist:thefatrat_anjulie_close_to_the_sun", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("thefatrat_anjulie_close_to_the_sun", ElementsDjMusicThefatratPlaylistMod.sounds
					.get(new ResourceLocation("dj_music_thefatrat_playlist:thefatrat_anjulie_close_to_the_sun")));
			setUnlocalizedName("thefatrat_anjulie_close_to_the_sun");
			setRegistryName("thefatrat_anjulie_close_to_the_sun");
			setCreativeTab(TabTheFatRat.tab);
		}
	}
}
