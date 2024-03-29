package ml.milau.outerplanes.core.entity;

import ml.milau.outerplanes.core.OuterPlanes;
import ml.milau.outerplanes.core.entity.custom.ShellEntity;
import ml.milau.outerplanes.core.entity.custom.SplitterEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, OuterPlanes.MOD_ID);

    public static final RegistryObject<EntityType<ShellEntity>> SHELL =
            ENTITY_TYPES.register("shell",
                    ()-> EntityType.Builder.of(ShellEntity::new, MobCategory.CREATURE).sized(1.0f,1.70f).build(new ResourceLocation(OuterPlanes.MOD_ID,"shell").toString()));
    public static final RegistryObject<EntityType<SplitterEntity>> SPLITTER =
            ENTITY_TYPES.register("splitter",
                    ()-> EntityType.Builder.of(SplitterEntity::new,MobCategory.MONSTER).sized(1.5f,1.5f).build(new ResourceLocation(OuterPlanes.MOD_ID,"splitter").toString()));


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
