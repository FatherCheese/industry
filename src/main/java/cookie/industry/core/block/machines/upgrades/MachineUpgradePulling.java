package cookie.industry.core.block.machines.upgrades;

import cookie.industry.core.block.machines.entities.TileEntityMachineBase;
import cookie.industry.core.I2ItemsNew;
import cookie.industry.core.item.ItemUpgrade;
import cookie.industry.extra.IAcceptsUpgrades;
import net.minecraft.client.render.stitcher.IconCoordinate;
import net.minecraft.client.render.stitcher.TextureRegistry;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.lang.I18n;
import net.minecraft.core.player.inventory.IInventory;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;

public class MachineUpgradePulling extends MachineUpgradeBase {
    private final IconCoordinate texture = TextureRegistry.getTexture("signalindustries:item/machine_pulling_upgrade");
    private final I18n i18n = I18n.getInstance();
    private int wait = 0;

    public int externalActiveSlot = -1;

    @Override
    public void tick() {
        if (machine instanceof TileEntityMachineBase) {
            TileEntityMachineBase tile = (TileEntityMachineBase) machine;
            Connection con = tile.getItemIOForSide(direction);
            int activeSlot = tile.getActiveItemSlotForSide(direction);
            IInventory inv = (IInventory) tile;

            if (activeSlot == -1 || con == Connection.NONE) return;

            TileEntity otherTile = direction.getTileEntity(tile.worldObj, tile);

            if (con == Connection.INPUT) {
                if (otherTile instanceof IInventory) {
                    IInventory otherInv = (IInventory) otherTile;

                    for (int i = 0; i < inv.getSizeInventory(); i++) {
                        for (int j = 0; j < otherInv.getSizeInventory(); j++) {

                            ItemStack stack = inv.getStackInSlot(activeSlot);
                            ItemStack otherStack = otherInv.getStackInSlot(j);

                            if (otherStack != null) {
                                if (stack != null && stack.itemID == otherStack.itemID) {
                                    if (stack.stackSize <= stack.getMaxStackSize() &&
                                            stack.stackSize + 1 <= stack.getMaxStackSize() &&
                                            stack.getMetadata() == otherStack.getMetadata()) {
                                        if (wait++ >= 10) {
                                            wait = 0;
                                            stack.stackSize++;
                                            otherStack.stackSize--;
                                        }
                                        if (otherStack.stackSize <= 0) otherInv.setInventorySlotContents(j, null);
                                    }
                                } else if (stack == null) {
                                    if (wait++ >= 10) {
                                        wait = 0;
                                        inv.setInventorySlotContents(activeSlot, new ItemStack(otherStack.getItem(), 1, otherStack.getMetadata()));
                                        otherStack.stackSize--;
                                    }

                                    if (otherStack.stackSize <= 0) otherInv.setInventorySlotContents(j, null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public IconCoordinate getTexture() {
        return texture;
    }

    @Override
    public ItemUpgrade getItem() {
        return (ItemUpgrade) I2ItemsNew.MACHINE_PULLING_UPGRADE;
    }

    @Override
    public void onInstall(Direction dir, IAcceptsUpgrades machine, EntityPlayer player) {
        player.sendMessage(i18n.translateKey("upgrade.installed"));
        super.onInstall(dir, machine, player);
    }

    @Override
    public void onRemove(EntityPlayer player) {
        player.sendMessage(i18n.translateKey("upgrade.removed"));
        super.onRemove(player);
    }
}
