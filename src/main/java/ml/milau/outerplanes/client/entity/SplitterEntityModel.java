package ml.milau.outerplanes.client.entity;

import ml.milau.outerplanes.core.OuterPlanes;
import ml.milau.outerplanes.core.entity.custom.SplitterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SplitterEntityModel extends AnimatedGeoModel<SplitterEntity> {
    @Override
    public ResourceLocation getModelLocation(SplitterEntity object) {
        return new ResourceLocation(OuterPlanes.MOD_ID,"geo/splitter.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SplitterEntity object) {
        return new ResourceLocation(OuterPlanes.MOD_ID,"textures/entity/splitter/splitter.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SplitterEntity animatable) {
        return new ResourceLocation(OuterPlanes.MOD_ID,"animations/splitter.animations.json");
    }
}
