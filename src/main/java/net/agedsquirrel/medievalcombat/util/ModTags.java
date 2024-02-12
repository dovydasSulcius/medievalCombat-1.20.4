package net.agedsquirrel.medievalcombat.util;

import net.agedsquirrel.medievalcombat.MedievalCombat;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
	public static class Blocks {
		public static final TagKey<Block> BREAKABLE_BLOCKS = createTag("breakable_blocks");
		private static TagKey<Block> createTag(String name) {
			return TagKey.of(RegistryKeys.BLOCK, new Identifier(MedievalCombat.MOD_ID, name));
		}
	}

	public static class Items {
		private static TagKey<Item> createTag(String name) {
			return TagKey.of(RegistryKeys.ITEM, new Identifier(MedievalCombat.MOD_ID, name));
		}
	}
}