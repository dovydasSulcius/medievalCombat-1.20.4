package net.agedsquirrel.medievalcombat.item;

import net.agedsquirrel.medievalcombat.MedievalCombat;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new FabricItemSettings()));
    public static final Item KINGS_SWORD = registerItem("kings_sword", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item GOLDEN_SALAD = registerItem("golden_salad", new Item(new FabricItemSettings().food(ModFoodComponents.GOLDEN_SALAD)));




    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(STEEL_INGOT);
    }
    private static void addItemsToBuildingBlocksItemGroup(FabricItemGroupEntries entries) {

    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MedievalCombat.MOD_ID, name), item);
    }
    public static void registerModItems() {
        MedievalCombat.LOGGER.info("Registering mod items for " + MedievalCombat.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemsToBuildingBlocksItemGroup);
    }
}
