package top.DrakGod.DgInMC.items;

import net.minecraft.util.SoundEvents;

public class TemplateArgs {
    public static ItemTier Tier_Tool = new ItemTier(100, 50.0F, 5.0F, 10, 50, "dg_ingot");
    public static ItemTier Tier_Axe = new ItemTier(40, 50.0F, 30.0F, 10, 50, "dg_ingot");
    public static ItemTier Tier_Sword = new ItemTier(30, 20.0F, 50.0F, 10, 50, "dg_ingot");

    public static ArmorMaterial Armor(String Name) {
        return new ArmorMaterial(Name, 1000, new int[] { 50, 50, 50, 50 }, 50, SoundEvents.ARMOR_EQUIP_IRON, 50.0F,
                50.0F, "dg_ingot");
    }
}