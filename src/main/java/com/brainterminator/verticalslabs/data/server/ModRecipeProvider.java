package com.brainterminator.verticalslabs.data.server;

import com.brainterminator.verticalslabs.handler.VerticalSlabLoader;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        for(RegistryObject<Block> slab : VerticalSlabLoader.SLABS){
            verticalSlabRecipeBuilder(slab.get(), recipeOutput);
        }
    }

    protected void verticalSlabRecipeBuilder(Block slab, RecipeOutput recipeOutput){
        Block original = VerticalSlabLoader.getVanillaOf(slab);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, slab)
                .requires(original)
                .unlockedBy(getHasName(original),has(original))
                .save(recipeOutput);
    }
}
