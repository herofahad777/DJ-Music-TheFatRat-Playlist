
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
public class ItemTFRMayday extends ElementsDjMusicThefatratPlaylistMod.ModElement {
	@GameRegistry.ObjectHolder("dj_music_thefatrat_playlist:tfr_mayday")
	public static final Item block = null;
	public ItemTFRMayday(ElementsDjMusicThefatratPlaylistMod instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("dj_music_thefatrat_playlist:tfr_mayday", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("tfr_mayday", ElementsDjMusicThefatratPlaylistMod.sounds.get(new ResourceLocation("dj_music_thefatrat_playlist:tfr_mayday")));
			setUnlocalizedName("tfr_mayday");
			setRegistryName("tfr_mayday");
			setCreativeTab(TabTheFatRat.tab);
		}
	}
}
