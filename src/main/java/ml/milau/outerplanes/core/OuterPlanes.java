package ml.milau.outerplanes.core;

import com.mojang.logging.LogUtils;
import ml.milau.outerplanes.client.event.renderer.SplitterRenderer;
import ml.milau.outerplanes.core.block.ModBlocks;
import ml.milau.outerplanes.core.block.entity.ModBlockEntities;
import ml.milau.outerplanes.core.effect.ModEffects;
import ml.milau.outerplanes.core.entity.ModEntities;
import ml.milau.outerplanes.core.item.ModItems;
import ml.milau.outerplanes.core.item.custom.GarnetAmulet;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OuterPlanes.MOD_ID)
public class OuterPlanes {
    public static final String MOD_ID = "outerplanes";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public OuterPlanes() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModEffects.register(eventBus);
        ModEntities.register(eventBus);
        // Register the setup method for modloading
        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void clientSetup(final FMLCommonSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOULTREE_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOULTREE_TRAPDOOR.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOULTREE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOULTREE_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ASTRAL_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ASTRAL_TRAPDOOR.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ASTRAL_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ASTRAL_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.IMBUEMENT_ALTAR.get(), RenderType.translucent());

        EntityRenderers.register(ModEntities.SPLITTER.get(), SplitterRenderer::new);
    }
    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
