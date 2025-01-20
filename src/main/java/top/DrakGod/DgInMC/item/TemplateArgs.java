package top.DrakGod.DgInMC.item;

import java.util.function.Supplier;

import net.minecraft.item.Item.Properties;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundEvents;
import top.DrakGod.DgInMC.DgInMC;

public class TemplateArgs {
    public static Properties Get_Properties() {
        return new Properties().tab(DgInMC.DgItemGroup);
    }

    public static EffectInstance Get_EffectInstance(Effect Effect, int Duration, int Amplifier) {
        return new EffectInstance(Effect, Duration * 20, Amplifier - 1, true, true);
    }

    public static <T> Supplier<T> Get_Supplier(T T) {
        return () -> T;
    }

    public static ItemTier Tier_Tool = new ItemTier(100, 50.0F, 5.0F, 10, 50, DgInMC.Mod_ID + ":dg_ingot");
    public static ItemTier Tier_Axe = new ItemTier(40, 50.0F, 30.0F, 10, 50, DgInMC.Mod_ID + ":dg_ingot");
    public static ItemTier Tier_Sword = new ItemTier(30, 20.0F, 50.0F, 10, 50, DgInMC.Mod_ID + ":dg_ingot");

    public static ArmorMaterial Armor(String Name) {
        return new ArmorMaterial(Name, 1000, new int[] { 50, 50, 50, 50 }, 50, SoundEvents.ARMOR_EQUIP_IRON, 50.0F,
                50.0F, DgInMC.Mod_ID + ":dg_ingot");
    }
}