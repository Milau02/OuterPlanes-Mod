package ml.milau.outerplanes.core.event;

import ml.milau.outerplanes.core.OuterPlanes;
import ml.milau.outerplanes.core.entity.ModEntities;
import ml.milau.outerplanes.core.entity.custom.ShellEntity;
import ml.milau.outerplanes.core.entity.custom.SplitterEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid= OuterPlanes.MOD_ID,bus= Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.SHELL.get(), ShellEntity.createAttributes().build());
        event.put(ModEntities.SPLITTER.get(), SplitterEntity.createAttributes().build());
    }
}
