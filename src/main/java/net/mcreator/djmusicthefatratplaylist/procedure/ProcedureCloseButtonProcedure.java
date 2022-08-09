package net.mcreator.djmusicthefatratplaylist.procedure;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.djmusicthefatratplaylist.ElementsDjMusicThefatratPlaylistMod;

import java.util.Map;

@ElementsDjMusicThefatratPlaylistMod.ModElement.Tag
public class ProcedureCloseButtonProcedure extends ElementsDjMusicThefatratPlaylistMod.ModElement {
	public ProcedureCloseButtonProcedure(ElementsDjMusicThefatratPlaylistMod instance) {
		super(instance, 13);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure CloseButtonProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).closeScreen();
	}
}
