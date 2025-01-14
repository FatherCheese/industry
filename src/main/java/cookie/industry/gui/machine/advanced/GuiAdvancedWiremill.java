package cookie.industry.gui.machine.advanced;

import cookie.industry.block.machines.advanced.entity.TileEntityAdvancedBase;
import cookie.industry.recipe.RecipesWiremill;
import cookie.industry.recipe.fuel.AdvancedRedstoneFuel;
import net.minecraft.core.InventoryAction;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.lang.I18n;
import net.minecraft.core.player.inventory.InventoryPlayer;
import net.minecraft.core.player.inventory.slot.Slot;
import net.minecraft.core.player.inventory.slot.SlotCrafting;
import org.lwjgl.input.Keyboard;
import sunsetsatellite.catalyst.energy.impl.ItemEnergyContainer;

public class GuiAdvancedWiremill extends GuiAdvancedBase {

    public GuiAdvancedWiremill(InventoryPlayer inventory, TileEntityAdvancedBase tileEntity) {
        super(inventory, tileEntity);
    }

    @Override
    protected void drawGuiContainerForegroundLayer() {
        super.drawGuiContainerForegroundLayer();
        int scrnX = xSize / 2 - 16;
        I18n i18n = I18n.getInstance();
        drawStringCenteredNoShadow(fontRenderer, i18n.translateKey("gui.industry.t2.wiremill"), scrnX, 6, 4210752);
        fontRenderer.drawString(i18n.translateKey("gui.industry.inventory"), 8, (ySize - 96) + 2, 4210752);
    }


    private int getSlotID(int x, int y) {
        Slot slot = getSlotAtPosition(x, y);
        int scrnX = (width - xSize) / 2;
        int scrnY = (height - ySize) / 2;
        boolean isInvalidSlot = x < scrnX || y < scrnY || x > scrnX + xSize || y > scrnY + ySize;
        int slotID = -1;

        if (slot != null)
            slotID = slot.id;

        if (isInvalidSlot)
            slotID = -999;

        return slotID;
    }

    // This is copied from "BTBTA", so shout out to them for figuring this out.
    @Override
    public void clickInventory(int x, int y, int mouseButton) {
        int slotId = this.getSlotID(x, y);
        if (slotId == -1) {
            return;
        }
        if (slotId == -999) {
            InventoryAction action = InventoryAction.DROP_HELD_STACK;
            if (mouseButton == 1)
                action = InventoryAction.DROP_HELD_SINGLE;

            this.mc.playerController.handleInventoryMouseClick(this.inventorySlots.windowId, action, null, this.mc.thePlayer);
            return;
        }
        if (!this.mc.thePlayer.getGamemode().consumeBlocks() && mouseButton == 2) {
            this.mc.playerController.handleInventoryMouseClick(this.inventorySlots.windowId, InventoryAction.CREATIVE_GRAB, new int[]{slotId, 64}, this.mc.thePlayer);
            return;
        }

        InventoryAction action = InventoryAction.CLICK_LEFT;
        boolean shiftPressed = Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
        boolean ctrlPressed = Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
        boolean altPressed = Keyboard.isKeyDown(56) || Keyboard.isKeyDown(184);
        boolean spacePressed = Keyboard.isKeyDown(57);
        if (mouseButton == 10) {
            shiftPressed = true;
            mouseButton = 0;
        }

        int target = 0;
        Slot slot = this.inventorySlots.getSlot(slotId);
        ItemStack stackInSlot = slot != null ? slot.getStack() : null;
        int clickedItemId = stackInSlot != null ? stackInSlot.getItem().id : 0;
        if (mouseButton == 1) {
            action = InventoryAction.CLICK_RIGHT;
        }

        if (slot instanceof SlotCrafting) {
            if (this.mc.gameSettings.swapCraftingButtons.value) {
                if (shiftPressed && ctrlPressed)
                    action = InventoryAction.MOVE_SIMILAR;
                else if (shiftPressed)
                    action = InventoryAction.MOVE_SINGLE_ITEM;
                else if (ctrlPressed)
                    action = InventoryAction.MOVE_STACK;
            } else if (shiftPressed && ctrlPressed)
                action = InventoryAction.MOVE_SIMILAR;
            else if (shiftPressed)
                action = InventoryAction.MOVE_STACK;
            else if (ctrlPressed)
                action = InventoryAction.MOVE_SINGLE_ITEM;
        } else if (spacePressed)
            action = InventoryAction.MOVE_ALL;
        else if (shiftPressed && ctrlPressed)
            action = InventoryAction.MOVE_SIMILAR;
        else if (shiftPressed || altPressed)
            action = InventoryAction.MOVE_STACK;
        else if (ctrlPressed)
            action = InventoryAction.MOVE_SINGLE_ITEM;

        if (this.inventorySlots instanceof ContainerAdvancedBase) { // This is the only section that actually really matters
            boolean recipes = new RecipesWiremill().getRecipeList().containsKey(clickedItemId);
            boolean redstone = new AdvancedRedstoneFuel().getRedstoneList().containsKey(clickedItemId);

            if (Item.itemsList[clickedItemId] instanceof ItemEnergyContainer)
                target = 1;
            else if (recipes)
                target = 2;
            else if (redstone)
                target = 3;
        }

        if (slot != null && stackInSlot != null && slot.allowItemInteraction() && stackInSlot.getItem().hasInventoryInteraction() && mouseButton == 1) {
            this.mc.playerController.handleInventoryMouseClick(this.inventorySlots.windowId, InventoryAction.INTERACT_SLOT, new int[]{slot.id}, this.mc.thePlayer);
            return;
        }

        int[] args = new int[]{slotId, target};
        this.mc.playerController.handleInventoryMouseClick(this.inventorySlots.windowId, action, args, this.mc.thePlayer);
    }
}
