//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mynethersdelight.common.block;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.soytutta.mynethersdelight.common.tag.MNDTags;
import com.soytutta.mynethersdelight.common.registry.MNDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.util.TriState;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.MathUtils;

public class ResurgentSoilFarmlandBlock extends FarmBlock {

    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0);
    public ResurgentSoilFarmlandBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    private static boolean hasFireOrLava(LevelReader level, BlockPos pos) {
        Iterator<BlockPos> var2 = BlockPos.betweenClosed(pos.offset(-7, -7, -7), pos.offset(7, 7, 7)).iterator();

        BlockPos nearbyPos;
        do {
            if (!var2.hasNext()) {
                return false;
            }
            nearbyPos = var2.next();
            BlockState state = level.getBlockState(nearbyPos);
            if (state.getFluidState().is(FluidTags.LAVA)) {
                int lightLevel = state.getLightEmission(level, nearbyPos);
                int distance = pos.distManhattan(nearbyPos);
                if (distance <= lightLevel) {
                    return true;
                }
            }
            if (state.is(MNDTags.LETIOS_FLAMES)) {
                if (!state.hasProperty(BlockStateProperties.LIT) || (state.hasProperty(BlockStateProperties.LIT) && state.getValue(BlockStateProperties.LIT))) {
                    int lightLevel = state.getLightEmission(level, nearbyPos);
                    int distance = pos.distManhattan(nearbyPos);
                    if (state.getBlock() instanceof TorchBlock || state.getBlock() instanceof WallTorchBlock) {
                        lightLevel = lightLevel / 2;
                    } else if (state.getBlock() instanceof LanternBlock) {
                        lightLevel = (lightLevel / 2) + 2;
                    } else if (state.getBlock() instanceof MagmaCakeBlock || state.getBlock() instanceof  MagmaBlock) {
                        lightLevel = lightLevel + 3;
                    }
                    if (distance <= lightLevel) {
                        return true;
                    }
                }
            }
        } while(true);
    }

    public static void turnToRichSoil(BlockState state, Level level, BlockPos pos) {
        level.setBlockAndUpdate(pos, pushEntitiesUp(state, MNDBlocks.RESURGENT_SOIL.get().defaultBlockState(), level, pos));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? MNDBlocks.RESURGENT_SOIL.get().defaultBlockState() : super.getStateForPlacement(context);
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState aboveState = level.getBlockState(pos.above());
        return super.canSurvive(state, level, pos) || aboveState.getBlock().equals(Blocks.MELON) || aboveState.getBlock().equals(Blocks.PUMPKIN);
    }

    @Override
    public boolean isFertile(BlockState state, BlockGetter world, BlockPos pos) {
        if (state.is(MNDBlocks.RESURGENT_SOIL_FARMLAND.get())) {
            return state.getValue(MOISTURE) > 0;
        } else {
            return false;
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        if (!state.canSurvive(level, pos)) {
            turnToRichSoil(state, level, pos);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int moisture = state.getValue(MOISTURE);

        BlockPos abovePos = pos.above();
        BlockState aboveState = level.getBlockState(abovePos);
        Block aboveBlock = aboveState.getBlock();

        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);
        Block belowBlock = belowState.getBlock();

        if (!hasFireOrLava(level, pos) || level.isRainingAt(pos.above())) {
            if (moisture > 0) {
                level.setBlock(pos, state.setValue(MOISTURE, moisture - 1), 2);
            }
        } else if (moisture < 7) {
                level.setBlock(pos, state.setValue(MOISTURE, 7), 2);
        } else if (moisture == 7) {
            if (Configuration.RICH_SOIL_BOOST_CHANCE.get() == 0.0) {
                return;
            }

            if (aboveBlock instanceof NetherWartBlock) {
                int age = aboveState.getValue(NetherWartBlock.AGE);
                if (age < NetherWartBlock.MAX_AGE) {
                    aboveState = aboveState.setValue(NetherWartBlock.AGE, age + 1);
                    level.setBlockAndUpdate(abovePos, aboveState);
                    return;
                }
            }

            if (!aboveState.is(MNDTags.NOT_PROPAGATE_PLANT)) {
                if (aboveState.is(MNDTags.ABOVE_PROPAGATE_PLANT)
                        && MathUtils.RAND.nextFloat() <= (Configuration.RICH_SOIL_BOOST_CHANCE.get()) / 6) {
                    propagateAboveIfPossible(aboveBlock, abovePos, level);
                }

                if (aboveBlock instanceof NetherWartBlock) {
                    int age = aboveState.getValue(NetherWartBlock.AGE);
                    if (age < 3) {
                        return;
                    } else if (age == 3) {
                        if (level.random.nextInt(8) == 0){
                            propagateAboveIfPossible(aboveBlock, abovePos, level);
                        }
                    }
                }

                if ((aboveBlock instanceof DoublePlantBlock)
                        && MathUtils.RAND.nextFloat() <= (Configuration.RICH_SOIL_BOOST_CHANCE.get())) {
                    propagateAboveIfPossible(aboveBlock, abovePos, level);
                }
            }

            int BonemealChance = 1;
            if (MathUtils.RAND.nextFloat() <= 0.2f) {
                BonemealChance = 2;
                if (MathUtils.RAND.nextFloat() <= 0.01f) {
                    BonemealChance = 3;
                }
            }

            for (int i = 0; i < MathUtils.RAND.nextInt(BonemealChance) + 1; i++) {
                performBonemealIfPossible(aboveBlock, pos.above(), aboveState, level, 1);
                performBonemealIfPossible(belowBlock, pos.below(), belowState, level, 1);
            }
        }

        if (!belowState.is(MNDTags.NOT_PROPAGATE_PLANT)) {
            if (belowState.is(MNDTags.BELOW_PROPAGATE_PLANT)
                    && MathUtils.RAND.nextFloat() <= (Configuration.RICH_SOIL_BOOST_CHANCE.get()) * 0.8F) {
                propagateBelowIfPossible(belowBlock, belowPos, level);
                return;
            }
        }
    }

    private void performBonemealIfPossible(Block block, BlockPos position, BlockState state, ServerLevel level, int distance) {
        if (state.is(ModTags.UNAFFECTED_BY_RICH_SOIL) || block instanceof TallFlowerBlock) {
            return;
        }

        if (block instanceof BonemealableBlock growable && MathUtils.RAND.nextFloat() <= Configuration.RICH_SOIL_BOOST_CHANCE.get() / distance) {
            if (growable.isValidBonemealTarget(level, position, state) && CommonHooks.canCropGrow(level, position, state, true)) {
                growable.performBonemeal(level, level.random, position, state);
                CommonHooks.fireCropGrowPost(level, position, state);

                for (int i = 0; i < 3; i++) {
                    double d0 = (double) position.getX() + level.getRandom().nextDouble();
                    double d1 = (double) position.getY() + level.getRandom().nextDouble();
                    double d2 = (double) position.getZ() + level.getRandom().nextDouble();
                    level.sendParticles(ParticleTypes.SOUL, d0, d1, d2, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                    level.playSound(null, position, SoundEvents.SOUL_ESCAPE.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
                }
            } else {
                BlockPos checkPos = position.above();
                BlockState checkState = level.getBlockState(checkPos);
                Block checkBlock = checkState.getBlock();
                while (checkBlock == block && distance <= 10) {
                    performBonemealIfPossible(checkBlock, checkPos, checkState, level, distance + 1);
                    distance++;
                    checkPos = checkPos.above();
                    checkState = level.getBlockState(checkPos);
                    checkBlock = checkState.getBlock();
                }

                checkPos = position.below();
                checkState = level.getBlockState(checkPos);
                checkBlock = checkState.getBlock();
                while (checkBlock == block && distance <= 10) {
                    performBonemealIfPossible(checkBlock, checkPos, checkState, level, distance + 1);
                    distance++;
                    checkPos = checkPos.below();
                    checkState = level.getBlockState(checkPos);
                    checkBlock = checkState.getBlock();
                }
            }
        }
    }

    private void propagateAboveIfPossible(Block block, BlockPos position, ServerLevel level) {
        List<BlockPos> validPositions = new ArrayList<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos newPos = position.offset(x, y, z);
                    BlockState newState = level.getBlockState(newPos);

                    if (canAboveBlockSurvive(block, newState, level, newPos)) {
                        validPositions.add(newPos);
                    }
                }
            }
        }

        if (!validPositions.isEmpty()) {
            BlockPos plantPos = validPositions.get(level.random.nextInt(validPositions.size()));
            BlockState targetState = level.getBlockState(plantPos);

            boolean canPropagate = (block instanceof LiquidBlockContainer && targetState.getBlock() == Blocks.WATER)
                    || (!(block instanceof LiquidBlockContainer) && targetState.getBlock() == Blocks.AIR)
                    || ((block instanceof SimpleWaterloggedBlock) && (targetState.getBlock() == Blocks.AIR || targetState.getBlock() == Blocks.WATER));

            if (canPropagate) {
                placeBlock(block, level, plantPos);
            }
        }
    }

    private boolean canAboveBlockSurvive(Block block, BlockState newState, ServerLevel level, BlockPos newPos) {
        BlockState blockBelowState = level.getBlockState(newPos.below());
        if (block instanceof DoublePlantBlock &&
                level.getBlockState(newPos.above()).getBlock() == Blocks.AIR) {
            return blockBelowState.getBlock() == ModBlocks.RICH_SOIL_FARMLAND.get()
                    || blockBelowState.getBlock() == MNDBlocks.RESURGENT_SOIL_FARMLAND.get();
        } else  if (block instanceof NetherWartBlock) {
            return blockBelowState.getBlock() == Blocks.SOUL_SAND
                    || blockBelowState.getBlock() == MNDBlocks.RESURGENT_SOIL.get()
                    || blockBelowState.getBlock() == MNDBlocks.RESURGENT_SOIL_FARMLAND.get();
        } else  if (!(block instanceof DoublePlantBlock)) {
            return blockBelowState.getBlock() == ModBlocks.RICH_SOIL_FARMLAND.get()
                    || blockBelowState.getBlock() == MNDBlocks.RESURGENT_SOIL_FARMLAND.get();
        }
        return false;
    }

    private void propagateBelowIfPossible(Block block, BlockPos position, ServerLevel level) {
        List<BlockPos> validPositions = new ArrayList<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos newPos = position.offset(x, y, z);

                    if (canBelowBlockSurvive(level, newPos)) {
                        validPositions.add(newPos);
                    }
                }
            }
        }

        if (!validPositions.isEmpty()) {
            BlockPos plantPos = validPositions.get(level.random.nextInt(validPositions.size()));
            BlockState targetState = level.getBlockState(plantPos);

            boolean canPropagate = (block instanceof LiquidBlockContainer && targetState.getBlock() == Blocks.WATER)
                    || (!(block instanceof LiquidBlockContainer) && targetState.getBlock() == Blocks.AIR)
                    || ((block instanceof SimpleWaterloggedBlock) && (targetState.getBlock() == Blocks.AIR || targetState.getBlock() == Blocks.WATER));

            if (canPropagate) {
                placeBlock(block, level, plantPos);
            }
        }
    }

    private boolean canBelowBlockSurvive(ServerLevel level, BlockPos newPos) {
        BlockState blockAboveState = level.getBlockState(newPos.above());
        return blockAboveState.getBlock() == ModBlocks.RICH_SOIL.get()
                || blockAboveState.getBlock() == MNDBlocks.RESURGENT_SOIL.get()
                || blockAboveState.getBlock() ==ModBlocks.RICH_SOIL_FARMLAND.get()
                || blockAboveState.getBlock() == MNDBlocks.RESURGENT_SOIL_FARMLAND.get();
    }

    private void placeBlock(Block block, ServerLevel level, BlockPos pos) {
        BlockState state = block.defaultBlockState();
        if (block instanceof SimpleWaterloggedBlock) {
            FluidState fluidState = level.getFluidState(pos);
            if (fluidState.getType() == Fluids.WATER) {
                state = state.setValue(BlockStateProperties.WATERLOGGED, true);
            } else {
                state = state.setValue(BlockStateProperties.WATERLOGGED, false);
            }
        }
        if (block instanceof DoublePlantBlock) {
            DoublePlantBlock.placeAt(level, state, pos, 3);
        } else {
            level.setBlockAndUpdate(pos, state);
        }
        for (int i = 0; i < 3; i++) {
            double d0 = (double) pos.getX() + level.getRandom().nextDouble();
            double d1 = (double) pos.getY() + level.getRandom().nextDouble();
            double d2 = (double) pos.getZ() + level.getRandom().nextDouble();
            level.sendParticles(ParticleTypes.SOUL, d0, d1, d2, 1, 0.0D, 0.0D, 0.0D, 0.0D);
            level.playSound(null, pos, SoundEvents.SOUL_ESCAPE.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }

    @Override
    public TriState canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, BlockState plantState) {
        return TriState.TRUE;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return false;
    }
}