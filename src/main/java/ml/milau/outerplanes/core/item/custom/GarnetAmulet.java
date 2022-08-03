package ml.milau.outerplanes.core.item.custom;

import ml.milau.outerplanes.core.OuterPlanes;
import ml.milau.outerplanes.core.item.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Mod.EventBusSubscriber(modid = OuterPlanes.MOD_ID)
public class GarnetAmulet extends ArmorItem {


    public GarnetAmulet(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {

        super(pMaterial, pSlot, pProperties);
    }

    @Nullable
    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.CHEST;
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }

    @SubscribeEvent
    public static void onMonsterGaze(LivingEvent.LivingVisibilityEvent event) {
        if (event.getLookingEntity() instanceof Enemy) {
            if (event.getEntity() instanceof ServerPlayer) {
                if (!(event.getEntity() instanceof FakePlayer)) {
                    Iterable<ItemStack> equippedArmor = event.getEntity().getArmorSlots();
                    boolean neutralizer = false;
                    for (ItemStack armorPiece : equippedArmor) {
                        if (armorPiece.is(ModItems.GARNET_AMULET.get())) {
                            neutralizer = true;
                            break;
                        }
                    }
                    if(neutralizer){
                        event.modifyVisibility(0.0D);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onMonsterHit(LivingAttackEvent event){
        if (event.getEntity() instanceof ServerPlayer) {
            if (!(event.getEntity() instanceof FakePlayer)) {
                Entity dSource = event.getSource().getEntity();
                if(dSource instanceof Mob monster){
                    monster.setTarget(null);
                }
            }
        }
    }

    @Override
    @NotNull
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        EquipmentSlot equipmentslot = Mob.getEquipmentSlotForItem(itemstack);
        ItemStack itemstack1 = pPlayer.getItemBySlot(equipmentslot);
        if (itemstack1.isEmpty()) {
            pPlayer.setItemSlot(equipmentslot, itemstack.copy());
            if (!pLevel.isClientSide()) {
                pPlayer.awardStat(Stats.ITEM_USED.get(this));
            }

            itemstack.setCount(0);
            return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
        } else {
            return InteractionResultHolder.fail(itemstack);
        }
    }

    @Nullable
    @Override
    public SoundEvent getEquipSound() {
        return ArmorMaterials.LEATHER.getEquipSound();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "outerplanes:textures/models/armor/garnetamulet_layer_1.png";
    }
}