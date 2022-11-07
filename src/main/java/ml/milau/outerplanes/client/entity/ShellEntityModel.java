package ml.milau.outerplanes.client.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import ml.milau.outerplanes.core.OuterPlanes;
import ml.milau.outerplanes.core.entity.custom.ShellEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ShellEntityModel<Type extends ShellEntity> extends EntityModel<Type> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(OuterPlanes.MOD_ID, "shell"), "main");
    private final ModelPart bb_main;

    public ShellEntityModel(ModelPart root) {
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -18.25F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.75F, -2.5F, 0.829F, 0.0F, 0.0F));

        PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 48).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -11.5F, 1.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -6.3533F, -3.5031F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -4.1106F, 2.0087F, 1.1781F, 0.0F, 0.0F));

        PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -15.85F, -2.4F, -1.0391F, -0.4545F, -0.0825F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(ShellEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}

