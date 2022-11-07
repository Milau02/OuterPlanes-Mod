package ml.milau.outerplanes.core.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ShellEntity extends Animal {
    public ShellEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.MOVEMENT_SPEED, 0.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE,1.0D);
    }

    @Override
    protected net.minecraft.sounds.SoundEvent getAmbientSound() {
        return SoundEvents.STONE_BREAK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.TURTLE_EGG_BREAK;
    }

    @Override
    protected float getSoundVolume() {
        return 0.6f;
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class,5.0f));
    }

    @Override
    protected boolean isAffectedByFluids() {
        return false;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    protected boolean isImmobile() {
        return true;
    }

    @Override
    public boolean isPushable() {
        return false;
    }
}
