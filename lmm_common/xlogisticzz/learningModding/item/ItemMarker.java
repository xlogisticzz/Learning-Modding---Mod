package xlogisticzz.learningModding.item;

import net.minecraft.item.ItemBlock;

public class ItemMarker extends ItemBlock {

    public ItemMarker(int par1) {
        super(par1);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int dammage) {
        return dammage;
    }

}
