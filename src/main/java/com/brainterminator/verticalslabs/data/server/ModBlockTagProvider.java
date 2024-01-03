package com.brainterminator.verticalslabs.data.server;

import com.brainterminator.verticalslabs.VerticalSlabs;
import com.brainterminator.verticalslabs.handler.VerticalSlabGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VerticalSlabs.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //this.tag(BlockTags.MINEABLE_WITH_AXE).add(VerticalSlabGenerator.OAK_VERTICAL_SLAB.get());
    }
}
