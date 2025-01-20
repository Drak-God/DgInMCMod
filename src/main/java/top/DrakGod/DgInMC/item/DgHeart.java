package top.DrakGod.DgInMC.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food.Builder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import top.DrakGod.DgInMC.DgInMC;
import top.DrakGod.DgInMC.util.ScheduledTask;

public class DgHeart extends Item {
    public DgHeart() {
        super(TemplateArgs.Get_Properties().food(new Builder().alwaysEat()
                .effect(TemplateArgs.Get_Supplier(
                        TemplateArgs.Get_EffectInstance(Effects.ABSORPTION, 60, 10)),
                        1.0F)
                .effect(TemplateArgs.Get_Supplier(
                        TemplateArgs.Get_EffectInstance(Effects.DAMAGE_BOOST, 60, 10)),
                        1.0F)
                .effect(TemplateArgs.Get_Supplier(
                        TemplateArgs.Get_EffectInstance(Effects.DAMAGE_RESISTANCE, 60, 10)),
                        1.0F)
                .effect(TemplateArgs.Get_Supplier(
                        TemplateArgs.Get_EffectInstance(Effects.DIG_SPEED, 60, 10)), 1.0F)
                .effect(TemplateArgs.Get_Supplier(
                        TemplateArgs.Get_EffectInstance(Effects.FIRE_RESISTANCE, 60, 10)),
                        1.0F)
                .effect(TemplateArgs.Get_Supplier(
                        TemplateArgs.Get_EffectInstance(Effects.HEAL, 60, 20)), 1.0F)
                .effect(TemplateArgs.Get_Supplier(
                        TemplateArgs.Get_EffectInstance(Effects.HEALTH_BOOST, 60, 10)),
                        1.0F)
                .effect(TemplateArgs.Get_Supplier(
                        TemplateArgs.Get_EffectInstance(Effects.MOVEMENT_SPEED, 60, 5)),
                        1.0F)
                .effect(TemplateArgs.Get_Supplier(
                        TemplateArgs.Get_EffectInstance(Effects.NIGHT_VISION, 60, 10)),
                        1.0F)
                .effect(TemplateArgs.Get_Supplier(
                        TemplateArgs.Get_EffectInstance(Effects.REGENERATION, 60, 20)),
                        1.0F)
                .effect(TemplateArgs.Get_Supplier(
                        TemplateArgs.Get_EffectInstance(Effects.SATURATION, 60, 10)),
                        1.0F)
                .effect(TemplateArgs.Get_Supplier(
                        TemplateArgs.Get_EffectInstance(Effects.WATER_BREATHING, 60, 10)),
                        1.0F)
                .nutrition(10).saturationMod(20.0F).build()));
    }

    @Override
    public ActionResult<ItemStack> use(World World, PlayerEntity Player, Hand Hand) {
        World.playSound(Player, Player, new SoundEvent(new ResourceLocation(DgInMC.Mod_ID, "nzdj")),
                SoundCategory.PLAYERS, 1.0F, 1.0F);
        return super.use(World, Player, Hand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack ItemStack, World World, LivingEntity LivingEntity) {
        PlayerEntity Player = (PlayerEntity) LivingEntity;
        World.playSound(Player, Player, new SoundEvent(new ResourceLocation(DgInMC.Mod_ID, "k")),
                SoundCategory.PLAYERS, 1.0F, 1.0F);

        Player.abilities.mayfly = true;
        Player.onUpdateAbilities();
        new ScheduledTask(World, () -> {
            Player.abilities.mayfly = false;
            Player.onUpdateAbilities();
        }, 60L);

        return super.finishUsingItem(ItemStack, World, LivingEntity);
    }
}
