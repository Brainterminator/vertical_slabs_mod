package com.brainterminator.verticalslabs.data.server.loot;

import com.brainterminator.verticalslabs.handler.VerticalSlabGenerator;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        for(RegistryObject<Block> slab : VerticalSlabGenerator.SLABS){
            this.dropSelf(slab.get());
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return VerticalSlabGenerator.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
