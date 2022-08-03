package ml.milau.outerplanes.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;
import ml.milau.outerplanes.core.OuterPlanes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class HesparBEWLR extends BlockEntityWithoutLevelRenderer {

    public HesparBEWLR(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, EntityModelSet pEntityModelSet) {
        super(pBlockEntityRenderDispatcher, pEntityModelSet);
    }

    //private final ResourceLocation TEXTURE = new ResourceLocation(OuterPlanes.MOD_ID,"outerplanes:textures/item/hespar_item.png");

    @Override
    public void renderByItem(ItemStack pStack, ItemTransforms.TransformType pTransformType, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        //Minecraft.getInstance().getTextureManager().bindForSetup(TEXTURE);
        super.renderByItem(pStack, ItemTransforms.TransformType.GUI, pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
    }
}
