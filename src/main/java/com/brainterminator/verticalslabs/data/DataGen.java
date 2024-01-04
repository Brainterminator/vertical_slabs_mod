package com.brainterminator.verticalslabs.data;

import com.brainterminator.verticalslabs.VerticalSlabs;
import com.brainterminator.verticalslabs.data.client.lang.EnglishLangProvider;
import com.brainterminator.verticalslabs.data.server.ModBlockTagProvider;
import com.brainterminator.verticalslabs.data.server.ModLootTableProvider;
import com.brainterminator.verticalslabs.data.server.ModRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = VerticalSlabs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator provider = event.getGenerator();
        PackOutput packOutput = provider.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        provider.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        provider.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));

        ModBlockTagProvider blockTagProvider = provider.addProvider(event.includeServer(),
                new ModBlockTagProvider(packOutput,lookupProvider,existingFileHelper));

        provider.addProvider(event.includeClient(), new EnglishLangProvider(packOutput));
        //provider.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
    }
}
