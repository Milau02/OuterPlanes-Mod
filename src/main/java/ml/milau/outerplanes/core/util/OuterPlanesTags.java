package ml.milau.outerplanes.core.util;

import ml.milau.outerplanes.core.OuterPlanes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class OuterPlanesTags{
    public static class Blocks{

        public static final TagKey<Block> GARNET_ORE = createTag("garnet_ores");

        public static final TagKey<Block> ASTRAL_LOG = createTag("astral_logs");
        public static final TagKey<Block> SOULTREE_LOG = createTag("soultree_logs");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(new ResourceLocation(OuterPlanes.MOD_ID,name));
        }

        private static TagKey<Block> createForgeTag(String name){
            return BlockTags.create(new ResourceLocation("forge",name));
        }

    }

    public static class Items{

        public static final TagKey<Item> GARNET_ORE = createTag("garnet_ores");

        public static final TagKey<Item> ASTRAL_LOG = createTag("astral_logs");
        public static final TagKey<Item> SOULTREE_LOG = createTag("soultree_logs");


        private static TagKey<Item> createTag(String name){
            return ItemTags.create(new ResourceLocation(OuterPlanes.MOD_ID,name));
        }

        private static TagKey<Item> createForgeTag(String name){
            return ItemTags.create(new ResourceLocation("forge",name));
        }

    }
}
