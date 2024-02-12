package net.agedsquirrel.medievalcombat.item;

import net.agedsquirrel.medievalcombat.MedievalCombat;
import net.agedsquirrel.medievalcombat.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MODED_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MedievalCombat.MOD_ID, "steel_ingot"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.steel_ingot"))
                    .icon(() -> new ItemStack(ModItems.STEEL_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModItems.GOLDEN_SALAD);
                    }).build());
    public static void registerItemGroups() {
        MedievalCombat.LOGGER.info("Registering Item Groups for " + MedievalCombat.MOD_ID);
    }
}
