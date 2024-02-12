package net.agedsquirrel.medievalcombat.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent GOLDEN_SALAD = new FoodComponent.Builder().hunger(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200,1), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400,0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 2400,0), 1).alwaysEdible().build();

}