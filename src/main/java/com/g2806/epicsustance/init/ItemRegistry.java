package com.g2806.epicsustance.init;

import net.minecraft.item.Item;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;

import com.g2806.epicsustance.Epicsustance;
import com.g2806.epicsustance.item.DrugItem;
import com.g2806.epicsustance.item.DrugFood;
import com.g2806.epicsustance.item.DrugSeed;
import com.g2806.epicsustance.item.DrugHelper;
import com.g2806.epicsustance.item.DrugInjectable;
import com.g2806.epicsustance.item.GrinderItem;

public class ItemRegistry {
    
    public static final Item PESTLE = registerItem("item_pestle", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item MORTAR = registerItem("item_mortar", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item GRINDER = registerItem("item_grinder", 
        new GrinderItem(new Item.Settings().group(Epicsustance.DRUG_TAB).maxCount(1)));

    public static final Item ITEM_EMPTY_SYRINGE = registerItem("item_empty_syringe", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item ITEM_MORPHINE_SYRINGE = registerItem("item_morphine_syringe", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final DrugInjectable ITEM_HEROIN_SYRINGE = registerItem("item_heroin_syringe", 
        new DrugInjectable(new Item.Settings().group(Epicsustance.DRUG_TAB),
        new StatusEffectInstance(StatusEffects.SPEED, 100)));
    
    public static final DrugSeed SEED_WEED = registerItem("seed_weed", 
        new DrugSeed(BlockRegistry.PLANT_WEED, new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final DrugSeed SEED_COCAINE = registerItem("seed_cocaine", 
        new DrugSeed(BlockRegistry.PLANT_COCAINE, new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final DrugSeed SEED_TOBACCO = registerItem("seed_tobacco", 
        new DrugSeed(BlockRegistry.PLANT_TOBACCO, new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final DrugSeed SEED_OPIUM = registerItem("seed_opium", 
        new DrugSeed(BlockRegistry.PLANT_OPIUM, new Item.Settings().group(Epicsustance.DRUG_TAB)));
    
    public static final Item ITEM_WEED = registerItem("item_weed", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item ITEM_COCAINE = registerItem("item_cocaine", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item ITEM_TOBACCO = registerItem("item_tobacco", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    public static final Item ITEM_OPIUM = registerItem("item_opium", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)));
    
    public static final DrugItem DRUG_WEED = registerItem("drug_weed", 
        new DrugItem(new Item.Settings().group(Epicsustance.DRUG_TAB),
        new StatusEffectInstance(StatusEffects.REGENERATION, 100)));
    public static final DrugItem DRUG_COCAINE = registerItem("drug_cocaine", 
        new DrugItem(new Item.Settings().group(Epicsustance.DRUG_TAB),
        new StatusEffectInstance(StatusEffects.SPEED, 100)));
    public static final DrugItem DRUG_TOBACCO = registerItem("drug_tobacco", 
        new DrugItem(new Item.Settings().group(Epicsustance.DRUG_TAB),
        new StatusEffectInstance(StatusEffects.SLOWNESS, 100)));
    public static final DrugItem DRUG_OPIUM = registerItem("drug_opium", 
        new DrugItem(new Item.Settings().group(Epicsustance.DRUG_TAB),
        new StatusEffectInstance(StatusEffects.WEAKNESS, 100)));
    
    public static final Item FOOD_CHOCOLATE_CHIP = registerItem("food_chocolate_chip", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)
        .food(new FoodComponent.Builder().hunger(1).build())));
    public static final Item FOOD_CHOCOLATE_BALL = registerItem("food_chocolate_ball", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)
        .food(new FoodComponent.Builder().hunger(4).build())));
    public static final DrugFood WEED_CHOCOLATE_BALL = registerItem("drug_chocolate_ball", 
        new DrugFood(new Item.Settings().group(Epicsustance.DRUG_TAB)
        .food(new FoodComponent.Builder().hunger(4).build()),
        new StatusEffectInstance(StatusEffects.NAUSEA, 400),
        new StatusEffectInstance(StatusEffects.REGENERATION, 200)));
    
    public static final Item FOOD_MUFFIN = registerItem("food_muffin", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)
        .food(new FoodComponent.Builder().hunger(6).build())));
    public static final DrugFood DRUG_MUFFIN = registerItem("drug_muffin", 
        new DrugFood(new Item.Settings().group(Epicsustance.DRUG_TAB)
        .food(new FoodComponent.Builder().hunger(6).build()),
        new StatusEffectInstance(StatusEffects.NAUSEA, 400),
        new StatusEffectInstance(StatusEffects.REGENERATION, 200)));
    
    public static final Item FOOD_BROWNIE = registerItem("food_brownie", 
        new Item(new Item.Settings().group(Epicsustance.DRUG_TAB)
        .food(new FoodComponent.Builder().hunger(6).build())));
    public static final DrugFood DRUG_BROWNIE = registerItem("drug_brownie", 
        new DrugFood(new Item.Settings().group(Epicsustance.DRUG_TAB)
        .food(new FoodComponent.Builder().hunger(6).build()),
        new StatusEffectInstance(StatusEffects.NAUSEA, 400),
        new StatusEffectInstance(StatusEffects.STRENGTH, 200)));
    
    public static final DrugItem ITEM_JOINT = registerItem("item_joint", 
        new DrugItem(new Item.Settings().group(Epicsustance.DRUG_TAB),
        new StatusEffectInstance(StatusEffects.NAUSEA, 200),
        new StatusEffectInstance(StatusEffects.REGENERATION, 100)));
    public static final DrugItem ITEM_BLUNT = registerItem("item_blunt",
        new DrugItem(new Item.Settings().group(Epicsustance.DRUG_TAB),
        new StatusEffectInstance(StatusEffects.REGENERATION, 100),
        new StatusEffectInstance(StatusEffects.NAUSEA, 200),
        new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 100)));
    public static final DrugItem ITEM_SPLIFF = registerItem("item_spliff", 
        new DrugItem(new Item.Settings().group(Epicsustance.DRUG_TAB), 
        new StatusEffectInstance(StatusEffects.REGENERATION, 100),
        new StatusEffectInstance(StatusEffects.NAUSEA, 200),
        new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 100)));
    public static final DrugItem ITEM_HEROIN_JOINT = registerItem("item_heroin_joint", 
        new DrugItem(new Item.Settings().group(Epicsustance.DRUG_TAB), 
        new StatusEffectInstance(StatusEffects.REGENERATION, 200),
        new StatusEffectInstance(StatusEffects.SPEED, 200),
        new StatusEffectInstance(StatusEffects.NAUSEA, 400)));
    
    public static final DrugHelper ITEM_STRAW = registerItem("item_straw", 
        new DrugHelper(new Item.Settings().group(Epicsustance.DRUG_TAB), 100, false,
        new StatusEffectInstance(StatusEffects.STRENGTH, 100)));
    public static final DrugHelper ITEM_TOBACCO_PIPE = registerItem("item_pipe_tobacco", 
        new DrugHelper(new Item.Settings().group(Epicsustance.DRUG_TAB), 100, true,
        new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 100)));
    public static final DrugHelper ITEM_OPIUM_PIPE = registerItem("item_pipe_opium", 
        new DrugHelper(new Item.Settings().group(Epicsustance.DRUG_TAB), 100, true,
        new StatusEffectInstance(StatusEffects.SLOWNESS, 100)));

    // Armor Material
    public static final ArmorMaterial DOPE_ARMOR_MATERIAL = new DopeArmorMaterial();
    
    // Armor Items
    public static final ArmorItem DOPE_HELMET = registerItem("dope_helmet", 
        new ArmorItem(DOPE_ARMOR_MATERIAL, EquipmentSlot.HEAD, 
        new Item.Settings().group(Epicsustance.DRUG_TAB)));

    private static <T extends Item> T registerItem(String name, T item) {
        return Registry.register(Registry.ITEM, new Identifier(Epicsustance.MOD_ID, name), item);
    }

    public static void registerItems() {
        Epicsustance.LOGGER.info("Registering items for " + Epicsustance.MOD_ID);
        
        // Set required drugs for helper items
        ITEM_STRAW.setRequiredDrug(DRUG_COCAINE);
        ITEM_TOBACCO_PIPE.setRequiredDrug(DRUG_TOBACCO);
        ITEM_OPIUM_PIPE.setRequiredDrug(DRUG_OPIUM);
    }
}