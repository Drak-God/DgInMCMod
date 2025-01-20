package top.DrakGod.DgInMC.item;

import java.lang.reflect.Constructor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.Food.Builder;

public class TemplateItems {
    public static Item Create() {
        return new Item(TemplateArgs.Get_Properties());
    }

    public static Item Create(Builder Builder) {
        return new Item(TemplateArgs.Get_Properties().food(Builder.build()));
    }

    @SuppressWarnings({ "rawtypes" })
    public static Item Create(Class<? extends Item> Type, ItemTier Tier) {
        try {
            Constructor Constructor = Type.getDeclaredConstructors()[0];
            Class[] TypeVariables = Constructor.getParameterTypes();

            Float.valueOf("0");
            Class ParameterType = TypeVariables[1];
            if (ParameterType == int.class) {
                return (Item) Constructor.newInstance(Tier, 0, Tier.getSpeed(), TemplateArgs.Get_Properties());
            } else {
                return (Item) Constructor.newInstance(Tier, 0.0F, Tier.getSpeed(), TemplateArgs.Get_Properties());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArmorItem Create(ArmorMaterial Material, EquipmentSlotType Slot) {
        return new ArmorItem(Material, Slot, TemplateArgs.Get_Properties());
    }
}
