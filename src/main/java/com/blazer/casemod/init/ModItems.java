package com.blazer.casemod.init;

import com.blazer.casemod.CaseMod;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CaseMod.MODID);

    public static final RegistryObject<Item> CASE_BEGGAR = ITEMS.register("case_beggar",
            () -> new CaseItem(List.of(
                    net.minecraft.world.item.Items.WOODEN_SWORD,
                    net.minecraft.world.item.Items.LEATHER_HELMET
            ), SoundEvents.VILLAGER_YES));

    public static final RegistryObject<Item> CASE_BUSINESSMAN = ITEMS.register("case_businessman",
            () -> new CaseItem(List.of(
                    net.minecraft.world.item.Items.GOLDEN_CHESTPLATE,
                    net.minecraft.world.item.Items.GOLDEN_SWORD
            ), SoundEvents.ANVIL_LAND));

    public static final RegistryObject<Item> CASE_DRAGONLORD = ITEMS.register("case_dragonlord",
            () -> new CaseItem(List.of(
                    net.minecraft.world.item.Items.DIAMOND_HELMET,
                    net.minecraft.world.item.Items.DIAMOND_SWORD
            ), SoundEvents.ENDER_DRAGON_GROWL));

    public static final RegistryObject<Item> CASE_TITAN = ITEMS.register("case_titan",
            () -> new CaseItem(List.of(
                    net.minecraft.world.item.Items.NETHERITE_CHESTPLATE,
                    net.minecraft.world.item.Items.NETHERITE_SWORD
            ), SoundEvents.ANVIL_LAND));

    public static final RegistryObject<Item> CASE_CREATOR = ITEMS.register("case_creator",
            () -> new CaseItem(List.of(
                    net.minecraft.world.item.Items.NETHER_STAR,
                    net.minecraft.world.item.Items.DRAGON_EGG
            ), SoundEvents.ENDER_DRAGON_GROWL));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
