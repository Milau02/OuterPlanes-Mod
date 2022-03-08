package ml.milau.outerplanes.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModItemGroup {
    public static final CreativeModeTab OUTERPLANES_GROUP = new CreativeModeTab("outerplanesModTab"){
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.GARNET.get());
        }
    };
}
