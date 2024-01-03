package com.brainterminator.verticalslabs.data;

import com.brainterminator.verticalslabs.VerticalSlabs;
import com.brainterminator.verticalslabs.handler.VerticalSlabGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        for(RegistryObject<Block> slab : VerticalSlabGenerator.SLABS){
            verticalSlabRecipeBuilder(slab.get(), recipeOutput);
        }
    }

    protected void verticalSlabRecipeBuilder(Block slab, RecipeOutput recipeOutput){
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slab)
                .pattern("X")
                .pattern("X")
                .pattern("X")
                .define('X', VerticalSlabGenerator.getVanillaOf(slab))
                .unlockedBy(getHasName(VerticalSlabGenerator.getVanillaOf(slab)), has(VerticalSlabGenerator.getVanillaOf(slab)))
                .save(recipeOutput);
    }
}
