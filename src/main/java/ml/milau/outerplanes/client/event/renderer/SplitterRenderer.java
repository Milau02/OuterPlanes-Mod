package ml.milau.outerplanes.client.event.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import ml.milau.outerplanes.client.entity.SplitterEntityModel;
import ml.milau.outerplanes.core.OuterPlanes;
import ml.milau.outerplanes.core.entity.custom.SplitterEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SplitterRenderer extends GeoEntityRenderer<SplitterEntity> {
    public SplitterRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SplitterEntityModel());
        this.shadowRadius = 0.9f;
    }

    @Override
    public ResourceLocation getTextureLocation(SplitterEntity animatable) {
        return new ResourceLocation(OuterPlanes.MOD_ID,"textures/entity/splitter/splitter.png");
    }

    @Override
    public RenderType getRenderType(SplitterEntity animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
        poseStack.scale(1.0f,1.0f,1.0f);
        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
