## Adding an Item
First we have to create an instance of an item. We will just put it in the initializer class, go ahead and put it in a separate class if you want.
We will also use `QuiltItemSettings()` to configure some item settings like `.group()` and `.maxCount()`. `Item.Settings()` works as well.
Just as a example we use `.maxCount(1)` to make the items stack size to 1.
```java
public class ExampleMod implements ModInitializer {

	// an instance of our new item
	public static final Item QUILT_ITEM = new Item(new QuiltItemSettings().group(ItemGroup.MISC).maxCount(1));

	@Override
	public void onInitialize(ModContainer mod) {

	}
}
```
Fantastic! Now we just have to register it for the tem to actually be in game. We will use vanillas `Registry#register(Registry Type, Identifier, Content)`.

```java
public class ExampleMod implements ModInitializer {

	// an instance of our new item
	public static final Item QUILT_ITEM = new Item(new QuiltItemSettings().group(ItemGroup.MISC).maxCount(1));

	@Override
	public void onInitialize(ModContainer mod) {
		// we have a instance of an item, now we just have to register it
		// "modid" is your mod's id
		Registry.register(Registry.ITEM, new Identifier("examplemod", "quilt_item"), QUILT_ITEM);
	}
}
```
Now we have an item but if we were to launch it we would be greeted with a black-purple square of an item. Let's fix that.
The item still needs a model, a texture and a localization.
The Model will be located in `/resources/assets/examplemod/models/item/quilt_item.json`.<br/>
while the Texture is in `/resources/assets/tutorial/textures/item/quilt_item.png`.<br/>
and you lang-file in `/resources/assets/examplemod/lang/en_us.json`, en_us for standard english.

For your quilt_item.json, it will look something like this. You can change `generated` to things like `handheld` if you want it to display like a tool instead of a regular item
```json
{
  "parent": "item/generated",
  "textures": {
    "layer0": "examplemod:item/quilt_item"
  }
}
```
For your lang file, just add the identifier of your item and the items name will be `A Piece of Quilt` in-game.
```json
{
  "item.examplemod.quilt_item": "A Piece of Quilt"
}
```

That's it! Your first item.
## Adding an Item class
What if we wanted to make an item with a bit more Oumph? Then we better designate a separate class to handle all that. So create a new Class.
```java
 public class SuperCoolQuiltItem extends Item {

    public SuperCoolQuiltItem(Settings settings) {
        super(settings);
    }
}
```
If you do Ctrl+O inside the class you will get a bunch of cool methods we can @Override and/or use! Lets att something basic first.
```java
public class SuperCoolQuiltItem extends Item {
    public SuperCoolQuiltItem(Settings settings) {
        //Super means we send the `settings` to this class's super, witch is Item (extends Item)
        super(settings);
    }

    //This method Overrides its super method, which means whatever Item does in its own `use` method we overrides.
    //This method gets triggered when the player is holding the item and `uses` it
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        //For example, play a sound at playerEntity with a pitch and volume set to 1.0F
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        //super(world, playerEntity, hand); <-- This would make it so the method also calls its super, Item, to also run the `use` method in Item when we run our `use`
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
```
Now we have a cool item class, so how do we use it? Simple! We replace `Item` with `SuperCoolQuiltItem`.
```java
public class ExampleMod implements ModInitializer {

	// an instance of our new item
	public static final Item QUILT_ITEM = new SuperCoolQuiltItem(new QuiltItemSettings().group(ItemGroup.MISC).maxCount(1));

	@Override
	public void onInitialize(ModContainer mod) {
		// we have a instance of an item, now we just have to register it
		// "modid" is your mod's id
		Registry.register(Registry.ITEM, new Identifier("examplemod", "quilt_item"), QUILT_ITEM);
	}
}
```



