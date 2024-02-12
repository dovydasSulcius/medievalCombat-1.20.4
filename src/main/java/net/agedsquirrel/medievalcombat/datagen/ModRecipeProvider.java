package net.agedsquirrel.medievalcombat.datagen;

import net.agedsquirrel.medievalcombat.block.ModBlocks;
import net.agedsquirrel.medievalcombat.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }
    private static List<ItemConvertible> STEEL_SMETLING = List.of(ModItems.STEEL_INGOT,
            ModItems.STEEL_INGOT);
    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, STEEL_SMETLING, RecipeCategory.MISC, ModItems.STEEL_INGOT, 10, 2000, "steel");
        offerBlasting(exporter, STEEL_SMETLING, RecipeCategory.MISC, ModItems.STEEL_INGOT, 10, 2000, "steel");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_INGOT, RecipeCategory.MISC, ModBlocks.STEEL_BLOCK);
    }
}
