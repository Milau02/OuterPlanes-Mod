package ml.milau.outerplanes.core.block;

import ml.milau.outerplanes.core.OuterPlanes;
import ml.milau.outerplanes.core.block.custom.ImbuementAltarBlock;
import ml.milau.outerplanes.core.block.custom.ModRotatedPillarBlock;
import ml.milau.outerplanes.core.item.ModItemGroup;
import ml.milau.outerplanes.core.item.ModItems;
import ml.milau.outerplanes.core.world.feature.tree.AstralTreeGrower;
import ml.milau.outerplanes.core.world.feature.tree.SoultreeTreeGrower;
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
            ()-> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)),optag);
    public static final RegistryObject<Block> SOULTREE_TRAPDOOR = registerBlock("soultree_trapdoor",
            ()-> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)),optag);
    public static final RegistryObject<Block> SOULTREE_LEAVES = registerBlock("soultree_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)),optag);
    public static final RegistryObject<Block> SOULTREE_ROOT = registerBlock("soultree_root",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.ROOTED_DIRT)),optag);
    public static final RegistryObject<Block> SOULTREE_SAPLING = registerBlock("soultree_sapling",
            ()-> new SaplingBlock(new SoultreeTreeGrower(),BlockBehaviour.Properties.copy(Blocks.DARK_OAK_SAPLING)),optag);
    public static final RegistryObject<Block> SOUL_DIRT = registerBlock("soul_dirt",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)),optag);
    public static final RegistryObject<Block> SOUL_GRASS_BLOCK = registerBlock("soul_grass_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)),optag);

    public static final RegistryObject<Block> ASTRAL_LOG = registerBlock("astral_log",
            ()-> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),optag);
    public static final RegistryObject<Block> ASTRAL_WOOD = registerBlock("astral_wood",
            ()-> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),optag);
    public static final RegistryObject<Block> STRIPPED_ASTRAL_LOG = registerBlock("stripped_astral_log",
            ()-> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),optag);
    public static final RegistryObject<Block> STRIPPED_ASTRAL_WOOD = registerBlock("stripped_astral_wood",
            ()-> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),optag);
    public static final RegistryObject<Block> ASTRAL_PLANKS = registerBlock("astral_planks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)),optag);
    public static final RegistryObject<Block> ASTRAL_WOOD_STAIRS =  registerBlock("astral_stairs",
            ()-> new StairBlock(()->ASTRAL_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)),optag);
    public static final RegistryObject<Block> ASTRAL_FENCE = registerBlock("astral_fence",
            ()-> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)),optag);
    public static final RegistryObject<Block> ASTRAL_FENCE_GATE = registerBlock("astral_fence_gate",
            ()-> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)),optag);
    public static final RegistryObject<Block> ASTRAL_SLAB = registerBlock("astral_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)),optag);
    public static final RegistryObject<Block> ASTRAL_DOOR = registerBlock("astral_door",
            ()-> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)),optag);
    public static final RegistryObject<Block> ASTRAL_TRAPDOOR = registerBlock("astral_trapdoor",
            ()-> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)),optag);
    public static final RegistryObject<Block> ASTRAL_LEAVES = registerBlock("astral_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)),optag);
    public static final RegistryObject<Block> ASTRAL_ROOT = registerBlock("astral_root",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.ROOTED_DIRT)),optag);
    public static final RegistryObject<Block> ASTRAL_SAPLING = registerBlock("astral_sapling",
            ()-> new SaplingBlock(new AstralTreeGrower(),BlockBehaviour.Properties.copy(Blocks.DARK_OAK_SAPLING)),optag);


    public static final RegistryObject<Block> IMBUEMENT_ALTAR = registerBlock("imbuement_altar",
            ()-> new ImbuementAltarBlock(BlockBehaviour.Properties.copy(Blocks.BASALT).noOcclusion()),optag);


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
