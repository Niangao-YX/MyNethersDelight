package com.soytutta.mynethersdelight.common.utility;

import com.soytutta.mynethersdelight.common.registry.MNDEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class MNDFoodValues 
    {
        // STRIDER
        public static final FoodProperties STRIDER_EGG = (new FoodProperties.Builder())
                .nutrition(3).saturationMod(0.3F)
                .alwaysEat().build();
        public static final FoodProperties ENCHANTED_GOLDEN_EGG = (new FoodProperties.Builder())
                .nutrition(4).saturationMod(1.0F)
                .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), 1.0F)
                .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F)
                .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600, 3), 1.0F)
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 2), 1.0F)
                .alwaysEat().fast().build();
        public static final FoodProperties GOLDEN_EGG = (new FoodProperties.Builder())
                .nutrition(4).saturationMod(1.0F)
                .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1.0F)
                .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600, 0), 1.0F)
                .alwaysEat().fast().build();
        public static final FoodProperties BOILED_EGG = (new FoodProperties.Builder())
                .nutrition(4).saturationMod(0.7F)
                .alwaysEat().fast().build();
        public static final FoodProperties DEVILED_EGG = (new FoodProperties.Builder())
                .nutrition(5).saturationMod(0.7F)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 200, 0), 1.0F)
                .alwaysEat().fast().build();
        public static final FoodProperties SCOTCH_EGGS = (new FoodProperties.Builder())
                .nutrition(12).saturationMod(0.8F)
                .effect(() ->  new MobEffectInstance(ModEffects.NOURISHMENT.get(), 2400, 0, false, false), 1.0F)
                .build();
        public static final FoodProperties EGG_SOUP = (new FoodProperties.Builder())
                .nutrition(10).saturationMod(0.7F)
                .effect(() ->  new MobEffectInstance(ModEffects.COMFORT.get(), 1200, 0, false, false), 1.0F)
                .build();
    
        public static final FoodProperties STRIDER_SLICE = (new FoodProperties.Builder())
                .nutrition(4).saturationMod(0.7f)
                .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 0), 0.15F)
                .build();
        public static final FoodProperties MINCED_STRIDER = (new FoodProperties.Builder())
                .nutrition(2).saturationMod(0.75f)
                .meat().build();
        public static final FoodProperties BLEEDING_TARTAR = (new FoodProperties.Builder())
                .nutrition(6).saturationMod(0.75f)
                .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1200, 0, false, false), 1.0F)
                .build();
        public static final FoodProperties STRIDER_AND_GRILLED_FUNGUS = (new FoodProperties.Builder())
                .nutrition(10).saturationMod(0.9f)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1200, 0, false, false), 1.0F)
                .build();
        public static final FoodProperties STRIDER_STEW = (new FoodProperties.Builder())
                .nutrition(8).saturationMod(0.6f)
                .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 1200, 0, false, false), 1.0F)
                .build();
        public static final FoodProperties CRIMSON_STROGANOFF = (new FoodProperties.Builder())
                .nutrition(11).saturationMod(0.75f)
                .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 2400, 0, false, false), 1.0F)
                .build();
        public static final FoodProperties STRIDERLOAF = (new FoodProperties.Builder())
                .nutrition(5).saturationMod(1.25f)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1200, 0, false, false), 1.0F)
                .build();
        public static final FoodProperties COLD_STRIDERLOAF = (new FoodProperties.Builder())
                .nutrition(11).saturationMod(0.1f)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 800, 0, false, false), 1.0F)
                .build();
        // HOGLIN
        public static final FoodProperties HOGLIN_LOIN = (new FoodProperties.Builder())
                .nutrition(4).saturationMod(0.35f)
                .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 0), 0.4F)
                .meat().build();
        // HOGLIN-Sausage
        public static final FoodProperties HOGLIN_SAUSAGE = (new FoodProperties.Builder())
                .nutrition(2).saturationMod(0.25f)
                .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 0), 0.4F)
                .fast().meat().build();
        public static final FoodProperties ROASTED_SAUSAGE = (new FoodProperties.Builder())
                .nutrition(4).saturationMod(0.35f)
                .fast().meat().build();
        public static final FoodProperties HOTDOG = (new FoodProperties.Builder())
                .nutrition(8).saturationMod(0.45f)
                .meat().build();
        public static final FoodProperties HOTDOG_WITH_MIXED_SALAD = (new FoodProperties.Builder())
                .nutrition(10).saturationMod(0.5f)
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F)
                .build();
        public static final FoodProperties HOTDOG_WITH_NETHER_SALAD = (new FoodProperties.Builder())
                .nutrition(10).saturationMod(0.5f)
                .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 240, 0), 0.3F)
                .build();
        public static final FoodProperties CHILIDOG = (new FoodProperties.Builder())
                .nutrition(11).saturationMod(0.5f)
                .effect(() -> new MobEffectInstance(MNDEffects.GPUNGENT.get(), 600, 0), 1.0F)
                .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0), 1.0F)
                .build();
        public static final FoodProperties SAUSAGE_AND_POTATOES = (new FoodProperties.Builder())
                .nutrition(11).saturationMod(0.55f)
                .build();
        public static final FoodProperties BREAKFAST_SAMPLER = (new FoodProperties.Builder())
                .nutrition(15).saturationMod(0.75f)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 2400, 0, false, false), 1.0F)
                .build();
        // HOGLIN-Loin
        public static final FoodProperties COOKED_LOIN = (new FoodProperties.Builder())
                .nutrition(7).saturationMod(0.75f)
                .meat().build();
        public static final FoodProperties NETHER_BURGER = (new FoodProperties.Builder())
                .nutrition(12).saturationMod(0.75f)
                .build();
        public static final FoodProperties BLUE_TENDERLOIN_STEAK = (new FoodProperties.Builder())
                .nutrition(9).saturationMod(0.8f)
                .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 0), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1200, 0, false, false), 1.0F)
                .build();
        public static final FoodProperties RED_LOIN_STICK = (new FoodProperties.Builder())
                .nutrition(10).saturationMod(0.7F)
                .build();
        public static final FoodProperties BACON_WRAPPED_SAUSAGE_STICK = (new FoodProperties.Builder())
                .nutrition(10).saturationMod(0.6F)
                .build();
        public static final FoodProperties FRIED_HOGLIN_CHOP = (new FoodProperties.Builder())
                .nutrition(12).saturationMod(0.9f)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 1200, 0), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 2400, 0, false, false), 1.0F)
                .build();
        // GHASTA
        public static final FoodProperties GHASTA = (new FoodProperties.Builder())
                .nutrition(3).saturationMod(1.0F)
                .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F)
                .build();
        public static final FoodProperties TWISTED_GHASTA = (new FoodProperties.Builder())
                .nutrition(10).saturationMod(0.65F)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 2400, 0, false, false), 1.0F)
                .build();
        public static final FoodProperties GIANT_TAKOYAKI = (new FoodProperties.Builder())
                .nutrition(12).saturationMod(0.75F)
                .build();
        public static final FoodProperties FRIES_GHASTA = (new FoodProperties.Builder())
                .nutrition(8).saturationMod(0.6F)
                .alwaysEat().fast().build();
        public static final FoodProperties GHAST_SALAD = (new FoodProperties.Builder())
                .nutrition(8).saturationMod(0.85F)
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300, 0), 1.0F)
                .build();
        public static final FoodProperties DRIED_GHAST_WITH_MILK = (new FoodProperties.Builder())
                .nutrition(6).saturationMod(0.45F)
                .alwaysEat().fast().build();
        public static final FoodProperties SIZZLING_PUDDING = (new FoodProperties.Builder())
                .nutrition(9).saturationMod(0.65F)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 100, 0), 1.0F)
                .build();
        public static final FoodProperties TEAR_POPSICLE = (new FoodProperties.Builder())
                .nutrition(3).saturationMod(0.2F)
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1, false, false), 1.0F)
                .alwaysEat().fast().build();
        public static final FoodProperties SPICY_NOODLE_SOUP = (new FoodProperties.Builder())
                .nutrition(16).saturationMod(0.65F)
                .effect(() ->  new MobEffectInstance(ModEffects.COMFORT.get(), 6000, 0, false, false), 1.0F)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 1200, 1), 1.0F)
                .build();
        public static final FoodProperties SPICY_COTTON = (new FoodProperties.Builder())
                .nutrition(3).saturationMod(2.25F)
                .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0), 1.0F)
                .alwaysEat().build();
        public static final FoodProperties GHASTA_WITH_CREAM = (new FoodProperties.Builder())
                .nutrition(8).saturationMod(0.9F)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 600, 0), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1200, 0, false, false), 1.0F)
                .build();
        public static final FoodProperties SLICES_OF_BREAD = (new FoodProperties.Builder())
                .nutrition(5).saturationMod(0.6F)
                .build();
        public static final FoodProperties TOASTS = (new FoodProperties.Builder())
                .nutrition(7).saturationMod(0.6F)
                .build();
        // SPICY
        public static final FoodProperties BULLET_PEPPER = (new FoodProperties.Builder())
                .nutrition(2).saturationMod(0.5f)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 100, 2), 1.0F)
                .alwaysEat().build();
        public static final FoodProperties STUFFED_PEPPER = (new FoodProperties.Builder())
                .nutrition(8).saturationMod(0.8f)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 100, 2), 1.0F)
                .alwaysEat().build();
        public static final FoodProperties SPICY_SKEWER = (new FoodProperties.Builder())
                .nutrition(7).saturationMod(0.9f)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 1200, 0), 1.0F)
                .build();
        public static final FoodProperties SPICY_HOGLIN_STEW = (new FoodProperties.Builder())
                .nutrition(12).saturationMod(0.8f)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 1200, 1), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 2400, 0, false, false), 1.0F)
                .build();
        public static final FoodProperties HOT_WINGS = (new FoodProperties.Builder())
                .nutrition(6).saturationMod(0.45f)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 1200, 0), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1200, 0, false, false), 1.0F)
                .alwaysEat().fast().build();
        public static final FoodProperties HOT_WINGS_BUCKET = (new FoodProperties.Builder())
                .nutrition(18).saturationMod(0.45f)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 3600, 0), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 2400, 0, false, false), 1.0F)
                .alwaysEat().build();
        public static final FoodProperties SPICY_CURRY = (new FoodProperties.Builder())
                .nutrition(15).saturationMod(0.65f)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 6000, 1), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0, false, false), 1.0F)
                .build();
        // MAGMA CUBE
        public static final FoodProperties ROCK_SOUP = (new FoodProperties.Builder())
                .nutrition(7).saturationMod(0.75f)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 1200, 2), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0, false, false), 1.0F)
                .build();
        public static final FoodProperties BURNT_ROLL = (new FoodProperties.Builder())
                .nutrition(10).saturationMod(0.6f)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 600, 1), 1.0F)
                .alwaysEat().build();
        public static final FoodProperties MAGMA_CAKE_SLICE = (new FoodProperties.Builder())
                .nutrition(2).saturationMod(1.0f)
                .effect(() -> new MobEffectInstance(MNDEffects.GPUNGENT.get(), 400, 2), 1.0F)
                .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0, false, false), 1.0F)
                .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false), 1.0F)
                .alwaysEat().fast().build();

        // STUFFED HOGLIN
        public static final FoodProperties ROAST_EAR = (new FoodProperties.Builder())
                .nutrition(2).saturationMod(0.5f)
                .alwaysEat().fast().build();
        public static final FoodProperties PLATE_OF_STUFFED_HOGLIN_SNOUT = (new FoodProperties.Builder())
                .nutrition(14).saturationMod(0.9f)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 0, false, false), 1.0F)
                .build();
        public static final FoodProperties PLATE_OF_STUFFED_HOGLIN_HAM = (new FoodProperties.Builder())
                .nutrition(12).saturationMod(0.75f)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0, false, false), 1.0F)
                .build();
        public static final FoodProperties PLATE_OF_STUFFED_HOGLIN = (new FoodProperties.Builder())
                .nutrition(8).saturationMod(0.6f)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 2400, 0, false, false), 1.0F)
                .build();

        // LAVA
        public static final FoodProperties HOT_CREAM_CONE = (new FoodProperties.Builder())
                .nutrition(4).saturationMod(1.0f)
                .effect(() -> new MobEffectInstance(MNDEffects.GPUNGENT.get(), 200, 0), 1.0F)
                .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0F)
                .alwaysEat().build();
        public static final FoodProperties HOT_CREAM = (new FoodProperties.Builder())
                .nutrition(1).saturationMod(8.0f)
                .effect(() -> new MobEffectInstance(MNDEffects.GPUNGENT.get(), 600, 2), 1.0F)
                .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0), 1.0F)
                .alwaysEat().build();
        // MD-CUPS
        public static final FoodProperties STRIDER_STEW_CUP = (new FoodProperties.Builder())
                .nutrition(4).saturationMod(0.6f)
                .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 600, 0, false, false), 1.0F)
                .fast().build();
        public static final FoodProperties SPICY_NOODLE_SOUP_CUP = (new FoodProperties.Builder())
                .nutrition(8).saturationMod(0.65F)
                .effect(() ->  new MobEffectInstance(ModEffects.COMFORT.get(), 3000, 0, false, false), 1.0F)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 600, 1), 1.0F)
                .fast().build();
        public static final FoodProperties SPICY_HOGLIN_STEW_CUP = (new FoodProperties.Builder())
                .nutrition(6).saturationMod(0.8f)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 600, 1), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 1200, 0, false, false), 1.0F)
                .fast().build();
        public static final FoodProperties ROCK_SOUP_CUP = (new FoodProperties.Builder())
                .nutrition(3).saturationMod(0.75f)
                .effect(() -> new MobEffectInstance(MNDEffects.BPUNGENT.get(), 600, 2), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 1800, 0, false, false), 1.0F)
                .fast().build();
        public static final FoodProperties EGG_SOUP_CUP = (new FoodProperties.Builder())
                .nutrition(5).saturationMod(0.7F)
                .effect(() ->  new MobEffectInstance(ModEffects.COMFORT.get(), 600, 0, false, false), 1.0F)
                .fast().build();
    }