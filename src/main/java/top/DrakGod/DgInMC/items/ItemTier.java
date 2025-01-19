package top.DrakGod.DgInMC.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemTier implements IItemTier {
    private final int Uses;
    private final float Speed;
    private final float AttackDamageBonus;
    private final int Level;
    private final int EnchantmentValue;
    private final ResourceLocation RepairName;

    public ItemTier(int Uses, float Speed, float AttackDamageBonus, int Level, int EnchantmentValue,
            String RepairName) {
        this.Uses = Uses;
        this.Speed = Speed - 4;
        this.AttackDamageBonus = AttackDamageBonus - 1;
        this.Level = Level;
        this.EnchantmentValue = EnchantmentValue;
        this.RepairName = new ResourceLocation(RepairName);
    }

    @Override
    public int getUses() {
        return this.Uses;
    }

    @Override
    public float getSpeed() {
        return this.Speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.AttackDamageBonus;
    }

    @Override
    public int getLevel() {
        return this.Level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.EnchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ForgeRegistries.ITEMS.getValue(RepairName));
    }
}