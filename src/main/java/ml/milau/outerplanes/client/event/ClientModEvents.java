package ml.milau.outerplanes.client.event;

import ml.milau.outerplanes.client.entity.ShellEntityModel;
import ml.milau.outerplanes.client.event.renderer.ShellEntityRenderer;
import ml.milau.outerplanes.core.OuterPlanes;
import ml.milau.outerplanes.core.entity.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OuterPlanes.MOD_ID,bus= Mod.EventBusSubscriber.Bus.MOD,value= Dist.CLIENT)
public class ClientModEvents {
    private ClientModEvents(){

    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ShellEntityModel.LAYER_LOCATION,ShellEntityModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntities.SHELL.get(), ShellEntityRenderer::new);
    }

}
