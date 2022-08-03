package ml.milau.outerplanes.core.block.entity;

import ml.milau.outerplanes.core.OuterPlanes;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITIES, OuterPlanes.MOD_ID);

    public static void register(IEventBus eventBus) {BLOCK_ENTITIES.register(eventBus);}
}
