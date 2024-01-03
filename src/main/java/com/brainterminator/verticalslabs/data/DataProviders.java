package com.brainterminator.verticalslabs.data;

import com.brainterminator.verticalslabs.VerticalSlabs;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = VerticalSlabs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataProviders {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator provider = event.getGenerator();
        PackOutput packOutput = provider.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        provider.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        provider.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));

        provider.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        provider.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        ModBlockTagProvider blockTagProvider = provider.addProvider(event.includeServer(),
                new ModBlockTagProvider(packOutput,lookupProvider,existingFileHelper));
        provider.addProvider(event.includeServer(), new ModItemTagProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), existingFileHelper));
    }
}
