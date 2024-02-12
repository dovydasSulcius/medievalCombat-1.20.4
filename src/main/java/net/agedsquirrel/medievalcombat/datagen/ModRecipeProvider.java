package net.agedsquirrel.medievalcombat.datagen;

import net.agedsquirrel.medievalcombat.block.ModBlocks;
import net.agedsquirrel.medievalcombat.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }
    private static List<ItemConvertible> STEEL_SMETLING = List.of(ModItems.STEEL_INGOT);
    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, STEEL_SMETLING, RecipeCategory.MISC, ModItems.STEEL_INGOT, 10, 2000, "steel");
        offerBlasting(exporter, STEEL_SMETLING, RecipeCategory.MISC, ModItems.STEEL_INGOT, 10, 2000, "steel");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_INGOT, RecipeCategory.MISC, ModBlocks.STEEL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK, 1)
                .pattern("SSS")
                .pattern("SMS")
                .pattern("SSS")
                .input('S', ModItems.STEEL_INGOT)
                .input('M', Items.END_CRYSTAL)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .criterion(hasItem(Items.END_CRYSTAL), conditionsFromItem(Items.END_CRYSTAL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.STEEL_BLOCK)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOLDEN_SALAD, 1)
                .input(Items.GOLDEN_APPLE)
                .input(Items.GOLDEN_CARROT)
                .input(Items.GLISTERING_MELON_SLICE)
                .group("golden_food")
                .criterion(hasItem(Items.GOLDEN_APPLE), conditionsFromItem(Items.GOLDEN_APPLE))
                .criterion(hasItem(Items.GOLDEN_CARROT), conditionsFromItem(Items.GOLDEN_CARROT))
                .criterion(hasItem(Items.GLISTERING_MELON_SLICE), conditionsFromItem(Items.GLISTERING_MELON_SLICE));
    }
}
