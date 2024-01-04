package com.brainterminator.verticalslabs.data.client;

import com.brainterminator.verticalslabs.VerticalSlabs;
import com.brainterminator.verticalslabs.handler.VerticalSlabLoader;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VerticalSlabs.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(RegistryObject<Block> block : VerticalSlabLoader.SLABS){
            registerVerticalSlab(block.get());
        }
    }

    private String getTextureName(Block block){
        return VerticalSlabLoader.getVanillaOf(block).toString().split("'")[1];
    }

    private void registerVerticalSlab(Block block) {
        /*getVariantBuilder(block)
                .partialState()
                .with(BlockStateProperties.FACING, Direction.EAST)
                .with(BlockStateProperties.HALF, Half.BOTTOM)
                .with(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)
                .addModels(ConfiguredModel.builder().build())
                .*/
    }

    private void createDimensionalCellModel(Block block, BlockModelBuilder verticalSlab, BlockModelBuilder verticalSlabInner, BlockModelBuilder verticalSlabOuter) {

        MultiPartBlockStateBuilder bld = getMultipartBuilder(block);

        //bld.part().modelFile(verticalSlab).addModel();
    }


}
