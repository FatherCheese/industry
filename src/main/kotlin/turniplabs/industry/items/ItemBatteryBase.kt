package turniplabs.industry.items

import net.minecraft.core.item.ItemStack
import sunsetsatellite.energyapi.EnergyAPI
import sunsetsatellite.energyapi.template.items.ItemBattery
import turniplabs.halplibe.helper.TextureHelper
import turniplabs.industry.Industry2

open class ItemBatteryBase(
    i: Int,
    capacity: Int,
    provide: Int,
    receive: Int,
    fullTexture: String,
    midFullTexture: String,
    midTexture: String,
    midEmptyTexture: String,
    emptyTexture: String
) : ItemBattery(i) {
    private var textureCoordinates: Array<IntArray?> = arrayOfNulls(5)

    init {
        baseCapacity = capacity
        baseProvide = provide
        baseReceive = receive
        val modID = Industry2.MOD_ID

        textureCoordinates[0] = TextureHelper.registerItemTexture(modID, fullTexture)
        textureCoordinates[1] = TextureHelper.registerItemTexture(modID, midFullTexture)
        textureCoordinates[2] = TextureHelper.registerItemTexture(modID, midTexture)
        textureCoordinates[3] = TextureHelper.registerItemTexture(modID, midEmptyTexture)
        textureCoordinates[4] = TextureHelper.registerItemTexture(modID, emptyTexture)
    }

    override fun getIconIndex(itemstack: ItemStack?): Int {
        val mapped = EnergyAPI.map(
            (getEnergy(itemstack).toFloat() / getCapacity(itemstack)).toDouble(),
            0.0,
            1.0,
            0.0,
            4.0
        ).toInt()

        setIconCoord(textureCoordinates[mapped]!![0], textureCoordinates[mapped]!![1])
        return iconIndex
    }
}