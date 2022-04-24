## Adding Tools
### Tool material

Fist we need a tool material witch require some basic properties implemented from ``implements ToolMaterial``.
```java
public class DiggingClawsToolMaterial implements ToolMaterial {


    //This method will define our tools' durability, set it to 100, and it will break in 100 uses
    //WOOD = 59
    //STONE = 131
    //IRON = 250
    //DIAMOND = 1561
    //GOLD = 32
    //NETHERITE = 2031

	@Override
	public int getDurability() {
		return 100;
	}

    //This will be the mining speed.
    //WOOD = 2.0F
    //STONE = 4.0F
    //IRON = 6.0F
    //DIAMOND = 8.0F
    //GOLD = 12.0F
    //NETHERITE = 9.0F
	@Override
	public float getMiningSpeedMultiplier() {
		return 16.0F;
	}

    /*Your tools attack damage will be calculated with materialDamage + toolDamage + 1.
      toolDamage is defined in its constructor, so to save some hassle we just set this one to 0.0F
    */
	@Override
	public float getAttackDamage() {
		return 0;
	}

    //This will be used to determine which block this tool can mine.
    //WOOD = 0
    //STONE = 1
    //IRON = 2
    //DIAMOND = 3
    //GOLD = 0
    //NETHERITE = 4

	@Override
	public int getMiningLevel() {
        return 4;
	}

    //This is for the potential of a tools enchantability, higher value means more often higher level enchants
    //WOOD = 15
    //STONE = 5
    //IRON = 14
    //DIAMOND = 10
    //GOLD = 22
    //NETHERITE = 15

	@Override
	public int getEnchantability() {
        return 22;
	}

    //This is for which item will be able to repair the tools with this material.
	@Override
	public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.STICK);
	}
}
```
There we go, a material for our tools. Now we want to use this on an actual item.

### Create the Tool

If you just want another Shovel or so you can use ``ShovelItem`` to get you were you need. But when it comes to ``PickaxeItem`` ``HoeItem`` ``AxeItem`` you will have to make your own class which ``extends PickaxeItem`` to be able to use it since they have protected constructors.
```java
public class DiggerClawsPickaxeItem extends PickaxeItem {
    public DiggerClawsPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
```
There we go, now we can make our own pickaxe-like item. As you see, the constructor takes ``DiggerClawsPickaxeItem(material, attackDamage, attackSpeed, settings)``. So we put that in and all should be fine.
```java
public static ToolItem DIGGER_CLAWS = new DiggerClawsPickaxeItem(new DiggingClawsToolMaterial(), 1, -1.0F, new Item.Settings().group(ItemGroup.TOOLS));
```

Then just finish it of by registering it:
```java
Registry.register(Registry.ITEM, new Identifier("examplemod", "digger_claws"), DIGGER_CLAWS);
```

TODO quilt tool tags


























