package ml.milau.outerplanes.core.item;

import ml.milau.outerplanes.core.OuterPlanes;
import ml.milau.outerplanes.core.item.custom.*;
import ml.milau.outerplanes.core.util.ModArmorMaterials;
import ml.milau.outerplanes.core.util.OuterPlanesTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.lwjgl.system.CallbackI;

import java.util.function.Supplier;

public class ModItems {
    private static final CreativeModeTab optag = ModItemGroup.OUTERPLANES_GROUP;
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OuterPlanes.MOD_ID);
    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet",
            () -> new Item(new Item.Properties().tab(optag)));
    public static final RegistryObject<ArmorItem> GARNET_AMULET = ITEMS.register("garnet_amulet",
            ()-> new GarnetAmulet(ModArmorMaterials.JEWERLY, EquipmentSlot.CHEST,new Item.Properties().stacksTo(1).tab(optag)));
    public static final RegistryObject<Item> GARNET_RING = ITEMS.register("garnet_ring",
            () -> new GarnetRing(new Item.Properties().stacksTo(1).tab(optag)));
    public static final RegistryObject<Item> UNHOLY_BOOK = ITEMS.register("unholy_book",
            () -> new UnholyBook(new Item.Properties().stacksTo(1).tab(optag)));
    public static final RegistryObject<Item> SOUL_JAR = ITEMS.register("soul_jar",
            () -> new SoulJar(new Item.Properties().stacksTo(1).tab(optag)));


    public static final RegistryObject<SwordItem> HESPAR = ITEMS.register("hespar",
            ()-> new HesparScythe(Tiers.NETHERITE,5,-2.4F,new Item.Properties().tab(optag).fireResistant()));
    //Register method for ModItems and deferred register will be registered in our event bus, in Outerplanes class
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
