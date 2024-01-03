package com.brainterminator.verticalslabs.handler;

import com.brainterminator.verticalslabs.VerticalSlabs;
import com.brainterminator.verticalslabs.blocks.VerticalSlabBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class VerticalSlabGenerator {

    private static ArrayList<RegistryObject<Block>> SLABS = new ArrayList<>();
    private static ArrayList<RegistryObject<Item>> SLAB_ITEMS = new ArrayList<>();

    // Create a Deferred Register to hold Blocks which will all be registered under the "verticalslabs" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VerticalSlabs.MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "verticalslabs" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VerticalSlabs.MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "verticalslabs" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VerticalSlabs.MODID);


    //ADD BLOCKS:

    static {
        //LOAD SLABS FROM VANILLA MINECRAFT
        Class<?> blocks = Blocks.class;
        ArrayList<Block> slabs = new ArrayList<>();
        Field[] fields = blocks.getFields();
        for (Field field : fields) {
            if (field.getName().contains("_SLAB")) {
                try {
                    slabs.add((Block) field.get(null));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //GENERATE ACCORDING SLAB BLOCKS
        for (Block slab : slabs) {
            SLABS.add(registerWall(slab));
        }
    }


    // Registers the creative tab and adds all items
    public static final RegistryObject<CreativeModeTab> VERTICAL_SLABS_TAB = CREATIVE_MODE_TABS.register("verticalslabs_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.NAME_TAG))
                    .title(Component.translatable("creativetab.verticalslabs_tab"))
                    .icon(()-> new ItemStack(SLAB_ITEMS.get(3).get()))
                    .displayItems((parameters, output) -> {
                        for (RegistryObject<Item> item : ITEMS.getEntries()) {
                            output.accept(item.get());
                        }
                    }).build());

    // Creates and registers a vertical slab from an existing Block
    private static RegistryObject<Block> registerWall(Block block) {
        String name = block.getName().toString();
        name = name.split("'")[1].replace("_slab", "_vertical_slab").replace("block.minecraft.", "");
        System.out.println(name);
        RegistryObject<Block> toReturn = BLOCKS.register(name,
                () -> new VerticalSlabBlock(() -> block.defaultBlockState(),
                        BlockBehaviour.Properties.copy(block)));
        SLAB_ITEMS.add(ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties())));
        return toReturn;
    }
}