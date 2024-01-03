package com.brainterminator.verticalslabs.data;

import com.brainterminator.verticalslabs.VerticalSlabs;
import com.brainterminator.verticalslabs.handler.VerticalSlabGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VerticalSlabs.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for(RegistryObject<Block> slab : VerticalSlabGenerator.SLABS){
            basicItem(slab.get().asItem());
        }
    }
}
