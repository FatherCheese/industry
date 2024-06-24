package cookie.industry.core;

import net.minecraft.core.block.Block;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.item.Item;

public abstract class I2Tags {
    public static final Tag<Item> PREVENT_ITEM_RECYCLING = Tag.of("prevent_item_recycling");
    public static final Tag<Item> PREVENT_FABRICATING = Tag.of("prevent_fabricating");
    public static final Tag<Block> MINEABLE_BY_WRENCH = Tag.of("requires_wrench");
    public static final Tag<Block> MINEABLE_BY_CUTTERS = Tag.of("requires_cutters");
}
