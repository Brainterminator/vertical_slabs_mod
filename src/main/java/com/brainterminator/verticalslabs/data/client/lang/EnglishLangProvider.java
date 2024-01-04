package com.brainterminator.verticalslabs.data.client.lang;

import com.brainterminator.verticalslabs.VerticalSlabs;
import com.brainterminator.verticalslabs.handler.VerticalSlabLoader;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class EnglishLangProvider extends LanguageProvider {
    public EnglishLangProvider(PackOutput output) {
        super(output, VerticalSlabs.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("creativetab.verticalslabs_tab","Vertical Slabs");
        for(RegistryObject<Block> slab : VerticalSlabLoader.SLABS){
            String key = slab.get().getName().toString().split("'")[1];
            add(key,
                    "Vertical ".concat(I18n.get(VerticalSlabLoader.getVanillaOf(slab.get()).getDescriptionId())));
        }
    }
}
