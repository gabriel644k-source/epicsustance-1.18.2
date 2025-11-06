package com.g2806.epicsustance.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GrinderItem extends Item {
    public GrinderItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        return new ItemStack(this);
    }
}

