package net.agedsquirrel.medievalcombat.datagen;

import net.agedsquirrel.medievalcombat.block.ModBlocks;
import net.agedsquirrel.medievalcombat.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    protected ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override

    public void generate() {
        addDrop(ModBlocks.STEEL_BLOCK);

        // addDrop(ModBlocks.STEEL_BLOCK, copperLikeOreDrops(ModBlocks.STEEL_BLOCK, ModItems.STEEL_INGOT));
    }
    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop,
                (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                        ((LeafEntry.Builder) ItemEntry.builder(Items.RAW_COPPER)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider
                                        .create(2.0f, 5.0f))))
                                .apply(ApplyBonusLootFunction
                                        .oreDrops(Enchantments.FORTUNE))));
    }
}
