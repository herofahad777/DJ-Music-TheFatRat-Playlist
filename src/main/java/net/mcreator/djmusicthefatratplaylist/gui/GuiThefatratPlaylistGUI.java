
package net.mcreator.djmusicthefatratplaylist.gui;

import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Keyboard;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.GuiButton;

import net.mcreator.djmusicthefatratplaylist.procedure.ProcedureTFRWeWillMeetAgainProcedure;
import net.mcreator.djmusicthefatratplaylist.procedure.ProcedureTFRUnityGiver;
import net.mcreator.djmusicthefatratplaylist.procedure.ProcedureTFRTimeLapseProcedure;
import net.mcreator.djmusicthefatratplaylist.procedure.ProcedureTFRRiseUpGiver;
import net.mcreator.djmusicthefatratplaylist.procedure.ProcedureTFROriginProcedure;
import net.mcreator.djmusicthefatratplaylist.procedure.ProcedureTFRNoNoNoProcedure;
import net.mcreator.djmusicthefatratplaylist.procedure.ProcedureTFRMonodyProcedure;
import net.mcreator.djmusicthefatratplaylist.procedure.ProcedureTFRMaydayProcedure;
import net.mcreator.djmusicthefatratplaylist.procedure.ProcedureTFRFlyAwayProcedure;
import net.mcreator.djmusicthefatratplaylist.procedure.ProcedureTFREnvelopProcedure;
import net.mcreator.djmusicthefatratplaylist.procedure.ProcedureTFRAnjulieCloseToTheSunGiverProcedure;
import net.mcreator.djmusicthefatratplaylist.ElementsDjMusicThefatratPlaylistMod;
import net.mcreator.djmusicthefatratplaylist.DjMusicThefatratPlaylistMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import java.io.IOException;

@ElementsDjMusicThefatratPlaylistMod.ModElement.Tag
public class GuiThefatratPlaylistGUI extends ElementsDjMusicThefatratPlaylistMod.ModElement {
	public static int GUIID = 1;
	public static HashMap guistate = new HashMap();
	public GuiThefatratPlaylistGUI(ElementsDjMusicThefatratPlaylistMod instance) {
		super(instance, 12);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		elements.addNetworkMessage(GUIButtonPressedMessageHandler.class, GUIButtonPressedMessage.class, Side.SERVER);
		elements.addNetworkMessage(GUISlotChangedMessageHandler.class, GUISlotChangedMessage.class, Side.SERVER);
	}
	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		private IInventory internal;
		private World world;
		private EntityPlayer entity;
		private int x, y, z;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		public GuiContainerMod(World world, int x, int y, int z, EntityPlayer player) {
			this.world = world;
			this.entity = player;
			this.x = x;
			this.y = y;
			this.z = z;
			this.internal = new InventoryBasic("", true, 0);
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(EntityPlayer player) {
			return internal.isUsableByPlayer(player);
		}

		@Override
		public void onContainerClosed(EntityPlayer playerIn) {
			super.onContainerClosed(playerIn);
			if ((internal instanceof InventoryBasic) && (playerIn instanceof EntityPlayerMP)) {
				this.clearContainer(playerIn, playerIn.world, internal);
			}
		}

		private void slotChanged(int slotid, int ctype, int meta) {
			if (this.world != null && this.world.isRemote) {
				DjMusicThefatratPlaylistMod.PACKET_HANDLER.sendToServer(new GUISlotChangedMessage(slotid, x, y, z, ctype, meta));
				handleSlotAction(entity, slotid, ctype, meta, x, y, z);
			}
		}
	}

	public static class GuiWindow extends GuiContainer {
		private World world;
		private int x, y, z;
		private EntityPlayer entity;
		public GuiWindow(World world, int x, int y, int z, EntityPlayer entity) {
			super(new GuiContainerMod(world, x, y, z, entity));
			this.world = world;
			this.x = x;
			this.y = y;
			this.z = z;
			this.entity = entity;
			this.xSize = 425;
			this.ySize = 240;
		}

		@Override
		public void drawScreen(int mouseX, int mouseY, float partialTicks) {
			this.drawDefaultBackground();
			super.drawScreen(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1, 1, 1, 1);
			zLevel = 100.0F;
		}

		@Override
		public void updateScreen() {
			super.updateScreen();
		}

		@Override
		protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
			super.mouseClicked(mouseX, mouseY, mouseButton);
		}

		@Override
		protected void keyTyped(char typedChar, int keyCode) throws IOException {
			super.keyTyped(typedChar, keyCode);
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int par1, int par2) {
			this.fontRenderer.drawString("Thefatrat Songs Playlist", 152, 5, -1);
		}

		@Override
		public void onGuiClosed() {
			super.onGuiClosed();
			Keyboard.enableRepeatEvents(false);
		}

		@Override
		public void initGui() {
			super.initGui();
			this.guiLeft = (this.width - 425) / 2;
			this.guiTop = (this.height - 240) / 2;
			Keyboard.enableRepeatEvents(true);
			this.buttonList.clear();
			this.buttonList.add(new GuiButton(0, this.guiLeft + 5, this.guiTop + 3, 50, 20, "Close"));
			this.buttonList.add(new GuiButton(1, this.guiLeft + 360, this.guiTop + 5, 60, 20, "Next>>>"));
			this.buttonList.add(new GuiButton(2, this.guiLeft + 3, this.guiTop + 38, 50, 20, "Unity"));
			this.buttonList.add(new GuiButton(3, this.guiLeft + 52, this.guiTop + 38, 60, 20, "Rise Up"));
			this.buttonList.add(new GuiButton(4, this.guiLeft + 111, this.guiTop + 38, 105, 20, "Close To The Sun"));
			this.buttonList.add(new GuiButton(5, this.guiLeft + 333, this.guiTop + 38, 60, 20, "Envelop"));
			this.buttonList.add(new GuiButton(6, this.guiLeft + 215, this.guiTop + 38, 65, 20, "Fly Away"));
			this.buttonList.add(new GuiButton(7, this.guiLeft + 279, this.guiTop + 38, 55, 20, "Monody"));
			this.buttonList.add(new GuiButton(8, this.guiLeft + 3, this.guiTop + 61, 55, 20, "Origin"));
			this.buttonList.add(new GuiButton(9, this.guiLeft + 57, this.guiTop + 61, 110, 20, "We'ill meet again"));
			this.buttonList.add(new GuiButton(10, this.guiLeft + 166, this.guiTop + 61, 75, 20, "Time Lapse"));
			this.buttonList.add(new GuiButton(11, this.guiLeft + 240, this.guiTop + 61, 65, 20, "No No No"));
			this.buttonList.add(new GuiButton(12, this.guiLeft + 304, this.guiTop + 61, 55, 20, "MAYDAY"));
		}

		@Override
		protected void actionPerformed(GuiButton button) {
			DjMusicThefatratPlaylistMod.PACKET_HANDLER.sendToServer(new GUIButtonPressedMessage(button.id, x, y, z));
			handleButtonAction(entity, button.id, x, y, z);
		}

		@Override
		public boolean doesGuiPauseGame() {
			return false;
		}
	}

	public static class GUIButtonPressedMessageHandler implements IMessageHandler<GUIButtonPressedMessage, IMessage> {
		@Override
		public IMessage onMessage(GUIButtonPressedMessage message, MessageContext context) {
			EntityPlayerMP entity = context.getServerHandler().player;
			entity.getServerWorld().addScheduledTask(() -> {
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			return null;
		}
	}

	public static class GUISlotChangedMessageHandler implements IMessageHandler<GUISlotChangedMessage, IMessage> {
		@Override
		public IMessage onMessage(GUISlotChangedMessage message, MessageContext context) {
			EntityPlayerMP entity = context.getServerHandler().player;
			entity.getServerWorld().addScheduledTask(() -> {
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			return null;
		}
	}

	public static class GUIButtonPressedMessage implements IMessage {
		int buttonID, x, y, z;
		public GUIButtonPressedMessage() {
		}

		public GUIButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public void toBytes(io.netty.buffer.ByteBuf buf) {
			buf.writeInt(buttonID);
			buf.writeInt(x);
			buf.writeInt(y);
			buf.writeInt(z);
		}

		@Override
		public void fromBytes(io.netty.buffer.ByteBuf buf) {
			buttonID = buf.readInt();
			x = buf.readInt();
			y = buf.readInt();
			z = buf.readInt();
		}
	}

	public static class GUISlotChangedMessage implements IMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage() {
		}

		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		@Override
		public void toBytes(io.netty.buffer.ByteBuf buf) {
			buf.writeInt(slotID);
			buf.writeInt(x);
			buf.writeInt(y);
			buf.writeInt(z);
			buf.writeInt(changeType);
			buf.writeInt(meta);
		}

		@Override
		public void fromBytes(io.netty.buffer.ByteBuf buf) {
			slotID = buf.readInt();
			x = buf.readInt();
			y = buf.readInt();
			z = buf.readInt();
			changeType = buf.readInt();
			meta = buf.readInt();
		}
	}
	private static void handleButtonAction(EntityPlayer entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
		if (buttonID == 2) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureTFRUnityGiver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 3) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureTFRRiseUpGiver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 4) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureTFRAnjulieCloseToTheSunGiverProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 5) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureTFREnvelopProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 6) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureTFRFlyAwayProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 7) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureTFRMonodyProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 8) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureTFROriginProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 9) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureTFRWeWillMeetAgainProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 10) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureTFRTimeLapseProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 11) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureTFRNoNoNoProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 12) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureTFRMaydayProcedure.executeProcedure($_dependencies);
			}
		}
	}

	private static void handleSlotAction(EntityPlayer entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}
}
