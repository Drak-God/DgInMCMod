package top.DrakGod.DgInMC.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

public class ArmorMaterial implements IArmorMaterial {
    private final String Name;
    private final int Durability;
    private final int[] SlotProtections;
    private final int EnchantmentValue;
    private final SoundEvent Sound;
    private final float Toughness;
    private final float KnockbackResistance;
    private final ResourceLocation RepairName;

    public ArmorMaterial(String Name, int Durability, int[] SlotProtections, int EnchantmentValue,
            SoundEvent Sound, float Toughness, float KnockbackResistance, String RepairName) {
        this.Name = Name;
        this.Durability = Durability;
        this.SlotProtections = SlotProtections;
        this.EnchantmentValue = EnchantmentValue;
        this.Sound = Sound;
        this.Toughness = Toughness;
        this.KnockbackResistance = KnockbackResistance / 10;
        this.RepairName = new ResourceLocation(RepairName);
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType Slot) {
        return this.Durability;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType Slot) {
        return this.SlotProtections[Slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.EnchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.Sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ForgeRegistries.ITEMS.getValue(this.RepairName));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.Name;
    }

    @Override
    public float getToughness() {
        return this.Toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.KnockbackResistance;
    }
}
