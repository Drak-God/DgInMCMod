package top.DrakGod.DgInMC.items;

import java.lang.reflect.Constructor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.Item.Properties;
import top.DrakGod.DgInMC.DgInMC;

public class TemplateItems {
    public static Properties Get_Properties() {
        return new Properties().tab(DgInMC.DgItemGroup);
    }

    public static Item Create() {
        return new Item(Get_Properties());
    }

    @SuppressWarnings({ "rawtypes" })
    public static Item Create(Class<? extends Item> Type, ItemTier Tier) {
        try {
            Constructor Constructor = Type.getDeclaredConstructors()[0];
            Class[] TypeVariables = Constructor.getParameterTypes();

            Float.valueOf("0");
            Class ParameterType = TypeVariables[1];
            if (ParameterType == int.class) {
                return (Item) Constructor.newInstance(Tier, 0, Tier.getSpeed(), Get_Properties());
            } else {
                return (Item) Constructor.newInstance(Tier, 0.0F, Tier.getSpeed(), Get_Properties());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArmorItem Create(ArmorMaterial Material, EquipmentSlotType Slot) {
        return new ArmorItem(Material, Slot, Get_Properties());
    }
}
