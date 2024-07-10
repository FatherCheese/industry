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
import sunsetsatellite.catalyst.core.util.IItemIO;

public class MachineUpgradePushing extends MachineUpgradeBase {
    private final IconCoordinate texture = TextureRegistry.getTexture("signalindustries:block/pushing_upgrade");
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
            int otherActiveSlot = externalActiveSlot;

            if (con == Connection.OUTPUT) {
                if (otherTile instanceof IInventory) {
                    IInventory otherInv = (IInventory) otherTile;
                    ItemStack stack = inv.getStackInSlot(activeSlot);

                    if(otherActiveSlot == -1) {
                        for (int i = 0; i < otherInv.getSizeInventory(); i++) {
                            ItemStack otherStackInSlot = otherInv.getStackInSlot(i);

                            if (otherStackInSlot == null && stack != null) {
                                otherActiveSlot = i;
                                break;
                            } else if (stack != null && otherStackInSlot.isItemEqual(stack)) {
                                if (stack.stackSize + otherStackInSlot.stackSize <= otherStackInSlot.getMaxStackSize()) {
                                    otherActiveSlot = i;
                                    break;
                                }
                            }
                        }
                    }
                    if(otherActiveSlot == -1) return;
                    ItemStack otherStack = otherInv.getStackInSlot(otherActiveSlot);

                    for (int i = 0; i < inv.getSizeInventory(); i++) {

                        if (stack != null) {
                            if (otherStack != null &&
                                    otherStack.itemID == stack.itemID &&
                                    otherStack.getMetadata() == stack.getMetadata()) {
                                if (otherStack.stackSize <= otherStack.getMaxStackSize() &&
                                        otherStack.stackSize + 1 <= otherStack.getMaxStackSize()) {

                                    if (wait++ >= 10) {
                                        wait = 0;
                                        ++otherStack.stackSize;
                                        stack.stackSize--;
                                    }

                                    if (stack.stackSize <= 0) inv.setInventorySlotContents(activeSlot, null);
                                }
                            } else if (otherStack == null) {
                                if (wait++ >= 10) {
                                    wait = 0;
                                    otherInv.setInventorySlotContents(otherActiveSlot, new ItemStack(stack.getItem(), 1, stack.getMetadata()));
                                    stack.stackSize--;
                                }

                                if (stack.stackSize <= 0) inv.setInventorySlotContents(activeSlot, null);
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
        return (ItemUpgrade) I2ItemsNew.MACHINE_PUSHING_UPGRADE;
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
