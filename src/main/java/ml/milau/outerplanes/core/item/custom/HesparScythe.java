package ml.milau.outerplanes.core.item.custom;

import ml.milau.outerplanes.client.renderer.item.HesparBEWLR;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.client.IItemRenderProperties;

import java.util.function.Consumer;

public class HesparScythe extends SwordItem {


    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            private final BlockEntityWithoutLevelRenderer myRenderer = new HesparBEWLR(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
            @Override
            public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                return myRenderer;
            }
        });
    }

    public HesparScythe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

}
