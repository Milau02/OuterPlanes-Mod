package ml.milau.outerplanes.client.event.renderer;

import ml.milau.outerplanes.client.entity.ShellEntityModel;
import ml.milau.outerplanes.core.OuterPlanes;
import ml.milau.outerplanes.core.entity.custom.ShellEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ShellEntityRenderer<Type extends ShellEntity> extends MobRenderer<Type, ShellEntityModel<Type>> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ResourceLocation TEXTURE = new ResourceLocation(OuterPlanes.MOD_ID, "textures/entity/shell.png");

    public ShellEntityRenderer(EntityRendererProvider.Context context) {
        super(context,new ShellEntityModel<>(context.bakeLayer(ShellEntityModel.LAYER_LOCATION)),0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(ShellEntity pEntity) {
        return TEXTURE;
    }
}
