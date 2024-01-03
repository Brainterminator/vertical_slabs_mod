package com.brainterminator.verticalslabs.data;

import com.brainterminator.verticalslabs.VerticalSlabs;
import com.brainterminator.verticalslabs.handler.VerticalSlabGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VerticalSlabs.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(RegistryObject<Block> slab : VerticalSlabGenerator.SLABS){
            simpleBlockWithItem(slab.get(), cubeAll(slab.get()));
        }
    }
}
