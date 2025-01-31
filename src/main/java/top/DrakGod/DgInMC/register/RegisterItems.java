package top.DrakGod.DgInMC.register;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.*;
import top.DrakGod.DgInMC.DgInMC;
import top.DrakGod.DgInMC.item.*;

public class RegisterItems extends TemplateArgs {
        public static ItemGroup DgItemGroup = new ItemGroup("dg_itemgroup") {
                @Override
                public ItemStack makeIcon() {
                        return new ItemStack(DgInMC.Items.Dg_Ingot.get());
                }
        };
        public DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, DgInMC.Mod_ID);

        public RegistryObject<Item> RegisterItem(String Name, Item Item) {
                RegistryObject<Item> Registry_Item = Items.register(Name, () -> Item);
                return Registry_Item;
        }

        public RegistryObject<Item> Dg_Ingot = RegisterItem("dg_ingot", TemplateItems.Create());
        public RegistryObject<Item> Iron_Stick = RegisterItem("iron_stick", TemplateItems.Create());

        public RegistryObject<Item> Dg_Axe = RegisterItem("dg_axe",
                        TemplateItems.Create(AxeItem.class, Tier_Axe));
        public RegistryObject<Item> Dg_Hoe = RegisterItem("dg_hoe",
                        TemplateItems.Create(HoeItem.class, Tier_Tool));
        public RegistryObject<Item> Dg_Pickaxe = RegisterItem("dg_pickaxe",
                        TemplateItems.Create(PickaxeItem.class, Tier_Tool));
        public RegistryObject<Item> Dg_Shovel = RegisterItem("dg_shovel",
                        TemplateItems.Create(ShovelItem.class, Tier_Tool));
        public RegistryObject<Item> Dg_Sword = RegisterItem("dg_sword",
                        TemplateItems.Create(SwordItem.class, Tier_Sword));

        public RegistryObject<Item> Dg_Helmet = RegisterItem("dg_helmet",
                        TemplateItems.Create(Armor(DgInMC.Mod_ID + ":dg_armor"), EquipmentSlotType.HEAD));
        public RegistryObject<Item> Dg_Chestplate = RegisterItem("dg_chestplate",
                        TemplateItems.Create(Armor(DgInMC.Mod_ID + ":dg_armor"), EquipmentSlotType.CHEST));
        public RegistryObject<Item> Dg_Leggings = RegisterItem("dg_leggings",
                        TemplateItems.Create(Armor(DgInMC.Mod_ID + ":dg_armor"), EquipmentSlotType.LEGS));
        public RegistryObject<Item> Dg_Boots = RegisterItem("dg_boots",
                        TemplateItems.Create(Armor(DgInMC.Mod_ID + ":dg_armor"), EquipmentSlotType.FEET));

        public RegistryObject<Item> Dg_Heart = RegisterItem("dg_heart", new DgHeart());
}
