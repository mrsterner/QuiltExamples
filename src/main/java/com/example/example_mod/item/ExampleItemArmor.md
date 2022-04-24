## Adding Armor
To make our cozy armor we first have to make a material for it, ``implements ArmorMaterial``.

```java
import com.example.example_mod.classes.ExampleMod;
import net.minecraft.item.Items;

public class CustomArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[]{1, 2, 3, 1};


    /*
    LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.LEATHER)),
	CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
	IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
	GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
	DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(Items.DIAMOND)),
	TURTLE("turtle", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.SCUTE)),
	NETHERITE("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT));

     */
    //LEATHER = {1, 2, 3, 1}
    //CHAIN = {1, 4, 5, 2}
    //IRON = {2, 5, 6, 2}
    //DIAMOND = {3, 6, 8, 3}
    //GOLD = {1, 3, 5, 2}
    //TURTLE = {2, 5, 6, 2}
    //NETHERITE = {3, 6, 8, 3}

    // In which A is helmet, B chestplate, C leggings and D boots.
    // For reference, Leather uses {1, 2, 3, 1}, and Diamond/Netherite {3, 6, 8, 3}
    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * X;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }


    //LEATHER = 15
    //CHAIN = 12
    //IRON = 9
    //DIAMOND = 10
    //GOLD = 25
    //TURTLE = 9
    //NETHERITE = 15
    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ExampleMod.QUILT_ITEM, Items.WHITE_WOOL);
    }

    @Override
    public String getName() {
        //lowercase name
        return "poncho";
    }

    @Override
    public float getToughness() {
        return 1.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.1F;
    }
}
```
