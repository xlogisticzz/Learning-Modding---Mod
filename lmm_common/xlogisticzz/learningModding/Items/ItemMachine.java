package xlogisticzz.learningModding.Items;

import net.minecraft.item.ItemBlock;

public class ItemMachine extends ItemBlock {

    public ItemMachine(int id) {
        super(id);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int dammage) {
        return dammage;
    }

}
