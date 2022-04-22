package com.example.example_mod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {

	// an instance of our new item
	public static final Item QUILT_ITEM = new Item(new QuiltItemSettings().group(ItemGroup.MISC).maxCount(1));

	@Override
	public void onInitialize(ModContainer mod) {
		// we have a instance of an item, now we just have to register it
		// "modid" is your mod's id
		Registry.register(Registry.ITEM, new Identifier("modid", "quilt_item"), QUILT_ITEM);
	}
	public class SuperCoolQuiltItem extends Item {

		public SuperCoolQuiltItem(Settings settings) {
			super(settings);
		}

		@Override
		public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
			playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
			return TypedActionResult.success(playerEntity.getStackInHand(hand));
		}
	}
}
