package ml.milau.outerplanes.block;

import ml.milau.outerplanes.OuterPlanes;
import ml.milau.outerplanes.block.custom.ModRotatedPillarBlock;
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
    private static final CreativeModeTab optag = ModItemGroup.OUTERPLANES_GROUP;
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, OuterPlanes.MOD_ID);

    public static final RegistryObject<Block> GARNET_ORE = registerBlock("garnet_ore",
            ()-> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f,3f).requiresCorrectToolForDrops()),optag);
    public static final RegistryObject<Block> DEEPSLATE_GARNET_ORE = registerBlock("deepslate_garnet_ore",
            ()-> new OreBlock(BlockBehaviour.Properties.copy(ModBlocks.GARNET_ORE.get()).strength(4.5f,3f).sound(SoundType.DEEPSLATE)),optag);
    public static final RegistryObject<Block> GARNET_CLUSTER = registerBlock("garnet_cluster",
            ()-> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3f,3f).requiresCorrectToolForDrops()),optag);

    public static final RegistryObject<Block> SOULTREE_LOG = registerBlock("soultree_log",
            ()-> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),optag);
    public static final RegistryObject<Block> SOULTREE_WOOD = registerBlock("soultree_wood",
            ()-> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),optag);
    public static final RegistryObject<Block> STRIPPED_SOULTREE_LOG = registerBlock("stripped_soultree_log",
            ()-> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),optag);
    public static final RegistryObject<Block> STRIPPED_SOULTREE_WOOD = registerBlock("stripped_soultree_wood",
            ()-> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),optag);
    public static final RegistryObject<Block> SOULTREE_PLANKS = registerBlock("soultree_planks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)),optag);

    public static final RegistryObject<Block> SOULTREE_WOOD_STAIRS =  registerBlock("soultree_stairs",
            ()-> new StairBlock(()->SOULTREE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)),optag);
    public static final RegistryObject<Block> SOULTREE_FENCE = registerBlock("soultree_fence",
            ()-> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)),optag);
    public static final RegistryObject<Block> SOULTREE_FENCE_GATE = registerBlock("soultree_fence_gate",
            ()-> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)),optag);
    public static final RegistryObject<Block> SOULTREE_SLAB = registerBlock("soultree_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)),optag);
    public static final RegistryObject<Block> SOULTREE_DOOR = registerBlock("soultree_door",
            ()-> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()),optag);
    public static final RegistryObject<Block> SOULTREE_TRAPDOOR = registerBlock("soultree_trapdoor",
            ()-> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()),optag);

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
