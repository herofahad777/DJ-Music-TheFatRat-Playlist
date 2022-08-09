package net.mcreator.djmusicthefatratplaylist.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.djmusicthefatratplaylist.gui.GuiThefatratPlaylistGUI;
import net.mcreator.djmusicthefatratplaylist.ElementsDjMusicThefatratPlaylistMod;
import net.mcreator.djmusicthefatratplaylist.DjMusicThefatratPlaylistMod;

import java.util.Map;

@ElementsDjMusicThefatratPlaylistMod.ModElement.Tag
public class ProcedureTheFatRatPlaylistRightClickedInAir extends ElementsDjMusicThefatratPlaylistMod.ModElement {
	public ProcedureTheFatRatPlaylistRightClickedInAir(ElementsDjMusicThefatratPlaylistMod instance) {
		super(instance, 14);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TheFatRatPlaylistRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TheFatRatPlaylistRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TheFatRatPlaylistRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TheFatRatPlaylistRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TheFatRatPlaylistRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).openGui(DjMusicThefatratPlaylistMod.instance, GuiThefatratPlaylistGUI.GUIID, world, x, y, z);
	}
}
