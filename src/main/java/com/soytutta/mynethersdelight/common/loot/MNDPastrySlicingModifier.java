package com.soytutta.mynethersdelight.common.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.soytutta.mynethersdelight.common.block.BreadLoafBlock;
import com.soytutta.mynethersdelight.common.block.MagmaCakeBlock;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.loot.modifier.PastrySlicingModifier;

import java.util.function.Supplier;

public class MNDPastrySlicingModifier extends PastrySlicingModifier {
    public static final Supplier<Codec<MNDPastrySlicingModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst ->
                    codecStart(inst)
                            .and(ForgeRegistries.ITEMS.getCodec().fieldOf("slice").forGetter(m -> m.pastrySlice))
                            .apply(inst, MNDPastrySlicingModifier::new)));

    private final Item pastrySlice;

    protected MNDPastrySlicingModifier(LootItemCondition[] conditionsIn, Item pastrySliceIn) {
        super(conditionsIn, pastrySliceIn);
        this.pastrySlice = pastrySliceIn;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        BlockState state = context.getParamOrNull(LootContextParams.BLOCK_STATE);
        if (state != null && state.getBlock() instanceof MagmaCakeBlock) {
            int bites = state.getValue(MagmaCakeBlock.BITES);
            int count = state.getValue(MagmaCakeBlock.SECOND_CAKE) ? 14 - bites : 7 - bites;
            generatedLoot.add(new ItemStack(this.pastrySlice, count));
        } else if (state != null && state.getBlock() instanceof BreadLoafBlock) {
            int bites = state.getValue(BreadLoafBlock.BITES);
            generatedLoot.add(new ItemStack(this.pastrySlice, 5 - bites));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}