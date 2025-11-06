package com.g2806.epicsustance.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.BlockHitResult;
import java.util.Random;
import com.g2806.epicsustance.init.BlockRegistry;
import net.minecraft.world.level.block.Blocks;

public class DrugPlant extends CropBlock {
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
        Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
        Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
        Block.box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
        Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
        Block.box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
        Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),
        Block.box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
        Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)
    };
    
    private final ItemLike seedsItem;
    private final ItemLike cropItem;

    public DrugPlant(ItemLike seedsItem, ItemLike cropItem) {
        super(Properties.copy(net.minecraft.world.level.block.Blocks.WHEAT));
        this.seedsItem = seedsItem;
        this.cropItem = cropItem;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return seedsItem;
    }

    protected ItemLike getCropItem() {
        return cropItem;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return AGE_TO_SHAPE[state.getValue(this.getAgeProperty())];
    }

    @Override
    protected boolean mayPlaceOn(BlockState floor, BlockGetter world, BlockPos pos) {
        // Allow planting on the custom DRUG_FARMER block or on vanilla farmland
        return floor.is(BlockRegistry.DRUG_FARMER.get()) || floor.is(Blocks.FARMLAND);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.below();
        return this.mayPlaceOn(world.getBlockState(blockPos), world, blockPos);
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        // Only react to neighbor changes if the block below changed; ignore other neighbor updates
        if (fromPos.equals(pos.below())) {
            if (!this.canSurvive(state, world, pos)) {
                // If cannot survive because soil changed, break the plant and drop items
                world.destroyBlock(pos, true);
            }
        }
        // otherwise ignore neighbor changes so adjacent blocks won't break this plant
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        int age = state.getValue(this.getAgeProperty());
        boolean isMaxAge = age == this.getMaxAge();
        
        if (isMaxAge) {
            if (!world.isClientSide) {
                // Drop 1-3 crop items
                int cropCount = 1 + world.random.nextInt(3);
                for (int i = 0; i < cropCount; i++) {
                    popResource(world, pos, new ItemStack(getCropItem()));
                }
                
                // Drop 0-2 seeds
                int seedCount = world.random.nextInt(3);
                for (int i = 0; i < seedCount; i++) {
                    popResource(world, pos, new ItemStack(getBaseSeedId()));
                }
                
                // Reset plant to age 0
                world.setBlock(pos, state.setValue(this.getAgeProperty(), 0), 2);
            }
            return InteractionResult.SUCCESS;
        }
        
        return super.use(state, world, pos, player, hand, hit);
    }
}