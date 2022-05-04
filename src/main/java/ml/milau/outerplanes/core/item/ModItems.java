package ml.milau.outerplanes.core.item;

import ml.milau.outerplanes.core.OuterPlanes;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OuterPlanes.MOD_ID);
    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet",
            () -> new Item(new Item.Properties().tab(ModItemGroup.OUTERPLANES_GROUP)));
    //Register method for ModItems and deferred register will be registered in our event bus, in Laumi class
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
