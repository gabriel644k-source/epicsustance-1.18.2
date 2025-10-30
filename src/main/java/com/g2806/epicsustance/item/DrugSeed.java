package com.g2806.epicsustance.item;

import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ActionResult;
import com.g2806.epicsustance.init.BlockRegistry;

public class DrugSeed extends AliasedBlockItem {
    
    public DrugSeed(Settings settings) {
        super(BlockRegistry.PLANT_WEED, settings);
    }
    
    public DrugSeed(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    protected boolean canPlace(ItemPlacementContext context, BlockState state) {
        // Keep the default placement checks (space, hit side, etc.) and also accept farmland
        Block blockBelow = context.getWorld().getBlockState(context.getBlockPos().down()).getBlock();
        boolean suitableSoil = blockBelow == BlockRegistry.DRUG_FARMER || blockBelow == Blocks.FARMLAND;
        return super.canPlace(context, state) && suitableSoil;
    }
}