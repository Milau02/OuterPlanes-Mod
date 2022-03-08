package ml.milau.outerplanes.block;

import ml.milau.outerplanes.OuterPlanes;
import ml.milau.outerplanes.item.ModItemGroup;
import ml.milau.outerplanes.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, OuterPlanes.MOD_ID);
    public static final RegistryObject<Block> GARNET_ORE = registerBlock("garnet_ore",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f,3f).requiresCorrectToolForDrops()),ModItemGroup.OUTERPLANES_GROUP);
    public static final RegistryObject<Block>  GARNET_CLUSTER = registerBlock("garnet_cluster",
            ()-> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3f,3f).requiresCorrectToolForDrops()),ModItemGroup.OUTERPLANES_GROUP);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);}
}
