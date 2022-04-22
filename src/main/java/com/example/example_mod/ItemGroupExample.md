## Adding an ItemGroup
Say you want to have your own tab in creative mode. We use ``ItemGroup`` and `QuiltItemGroup.createWithIcon(...);` to create a new item group and have a icon for it.


```java
public class ExampleMod implements ModInitializer {

    public static final ItemGroup ITEM_GROUP = QuiltItemGroup.createWithIcon(new Identifier("examplemod", "allmyfunitems"), () -> new ItemStack(Blocks.COBBLESTONE));
    [...]
}
```
### Adding an Item to our ItemGroup
Lets try it out with our item from the Item tutorial. We just change `.group(ItemGroup.MISC)` to `.group(ITEM_GROUP)` and we just added our first item to our own tab!
```java
public class ExampleMod implements ModInitializer {

    public static final ItemGroup ITEM_GROUP = QuiltItemGroup.createWithIcon(new Identifier("examplemod", "allmyfunitems"), () -> new ItemStack(Blocks.COBBLESTONE));

    public static final Item QUILT_ITEM = new Item(new QuiltItemSettings().group(ITEM_GROUP).maxCount(1));

	@Override
	public void onInitialize(ModContainer mod) {
		Registry.register(Registry.ITEM, new Identifier("examplemod", "quilt_item"), QUILT_ITEM);
	}
}
```
