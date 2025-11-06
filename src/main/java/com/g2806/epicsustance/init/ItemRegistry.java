package com.g2806.epicsustance.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

import com.g2806.epicsustance.Epicsustance;
import com.g2806.epicsustance.item.DrugItem;
import com.g2806.epicsustance.item.DrugFood;
import com.g2806.epicsustance.item.DrugSeed;
import com.g2806.epicsustance.item.DrugHelper;
import com.g2806.epicsustance.item.DrugInjectable;

import java.util.function.Supplier;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, Epicsustance.MOD_ID);
    
    // Tools
    public static final RegistryObject<Item> PESTLE = ITEMS.register("item_pestle", 
        () -> new Item(new Item.Properties().tab(Epicsustance.DRUG_TAB)));
    public static final RegistryObject<Item> MORTAR = ITEMS.register("item_mortar", 
        () -> new Item(new Item.Properties().tab(Epicsustance.DRUG_TAB)));
    // The grinder should not be consumed by crafting recipes: override container behaviour
    public static final RegistryObject<Item> GRINDER = ITEMS.register("item_grinder",
        () -> new Item(new Item.Properties().tab(Epicsustance.DRUG_TAB).stacksTo(1)) {
            @Override
            public boolean hasContainerItem(ItemStack stack) {
                return true;
            }

            @Override
            public ItemStack getContainerItem(ItemStack stack) {
                // Return the same item back to the crafting grid (not consumed)
                return stack.copy();
            }
        });

    // Syringes
    public static final RegistryObject<Item> ITEM_EMPTY_SYRINGE = ITEMS.register("item_empty_syringe", 
        () -> new Item(new Item.Properties().tab(Epicsustance.DRUG_TAB)));
    public static final RegistryObject<Item> ITEM_MORPHINE_SYRINGE = ITEMS.register("item_morphine_syringe", 
        () -> new Item(new Item.Properties().tab(Epicsustance.DRUG_TAB)));
    public static final RegistryObject<DrugInjectable> ITEM_HEROIN_SYRINGE = ITEMS.register("item_heroin_syringe", 
        () -> new DrugInjectable(new Item.Properties().tab(Epicsustance.DRUG_TAB),
        new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100)));
    
    // Seeds
    public static final RegistryObject<DrugSeed> SEED_WEED = ITEMS.register("seed_weed", 
        () -> new DrugSeed(BlockRegistry.PLANT_WEED.get(), new Item.Properties().tab(Epicsustance.DRUG_TAB)));
    public static final RegistryObject<DrugSeed> SEED_COCAINE = ITEMS.register("seed_cocaine", 
        () -> new DrugSeed(BlockRegistry.PLANT_COCAINE.get(), new Item.Properties().tab(Epicsustance.DRUG_TAB)));
    public static final RegistryObject<DrugSeed> SEED_TOBACCO = ITEMS.register("seed_tobacco", 
        () -> new DrugSeed(BlockRegistry.PLANT_TOBACCO.get(), new Item.Properties().tab(Epicsustance.DRUG_TAB)));
    public static final RegistryObject<DrugSeed> SEED_OPIUM = ITEMS.register("seed_opium", 
        () -> new DrugSeed(BlockRegistry.PLANT_OPIUM.get(), new Item.Properties().tab(Epicsustance.DRUG_TAB)));
    
    // Raw Items
    public static final RegistryObject<Item> ITEM_WEED = ITEMS.register("item_weed", 
        () -> new Item(new Item.Properties().tab(Epicsustance.DRUG_TAB)));
    public static final RegistryObject<Item> ITEM_COCAINE = ITEMS.register("item_cocaine", 
        () -> new Item(new Item.Properties().tab(Epicsustance.DRUG_TAB)));
    public static final RegistryObject<Item> ITEM_TOBACCO = ITEMS.register("item_tobacco", 
        () -> new Item(new Item.Properties().tab(Epicsustance.DRUG_TAB)));
    public static final RegistryObject<Item> ITEM_OPIUM = ITEMS.register("item_opium", 
        () -> new Item(new Item.Properties().tab(Epicsustance.DRUG_TAB)));
    
    // Drugs
    public static final RegistryObject<DrugItem> DRUG_WEED = ITEMS.register("drug_weed", 
        () -> new DrugItem(new Item.Properties().tab(Epicsustance.DRUG_TAB),
        new MobEffectInstance(MobEffects.REGENERATION, 100)));
    public static final RegistryObject<DrugItem> DRUG_COCAINE = ITEMS.register("drug_cocaine", 
        () -> new DrugItem(new Item.Properties().tab(Epicsustance.DRUG_TAB),
        new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100)));
    public static final RegistryObject<DrugItem> DRUG_TOBACCO = ITEMS.register("drug_tobacco", 
        () -> new DrugItem(new Item.Properties().tab(Epicsustance.DRUG_TAB),
        new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100)));
    public static final RegistryObject<DrugItem> DRUG_OPIUM = ITEMS.register("drug_opium", 
        () -> new DrugItem(new Item.Properties().tab(Epicsustance.DRUG_TAB),
        new MobEffectInstance(MobEffects.WEAKNESS, 100)));
    
    // Food Items
    public static final RegistryObject<Item> FOOD_CHOCOLATE_CHIP = ITEMS.register("food_chocolate_chip", 
        () -> new Item(new Item.Properties().tab(Epicsustance.DRUG_TAB)
        .food(new FoodProperties.Builder().nutrition(1).build())));
    public static final RegistryObject<Item> FOOD_CHOCOLATE_BALL = ITEMS.register("food_chocolate_ball", 
        () -> new Item(new Item.Properties().tab(Epicsustance.DRUG_TAB)
        .food(new FoodProperties.Builder().nutrition(4).build())));
    public static final RegistryObject<DrugFood> WEED_CHOCOLATE_BALL = ITEMS.register("drug_chocolate_ball", 
        () -> new DrugFood(new Item.Properties().tab(Epicsustance.DRUG_TAB)
        .food(new FoodProperties.Builder().nutrition(4).build()),
        new MobEffectInstance(MobEffects.CONFUSION, 400),
        new MobEffectInstance(MobEffects.REGENERATION, 200)));
    
    public static final RegistryObject<Item> FOOD_MUFFIN = ITEMS.register("food_muffin", 
        () -> new Item(new Item.Properties().tab(Epicsustance.DRUG_TAB)
        .food(new FoodProperties.Builder().nutrition(6).build())));
    public static final RegistryObject<DrugFood> DRUG_MUFFIN = ITEMS.register("drug_muffin", 
        () -> new DrugFood(new Item.Properties().tab(Epicsustance.DRUG_TAB)
        .food(new FoodProperties.Builder().nutrition(6).build()),
        new MobEffectInstance(MobEffects.CONFUSION, 400),
        new MobEffectInstance(MobEffects.REGENERATION, 200)));
    
    public static final RegistryObject<Item> FOOD_BROWNIE = ITEMS.register("food_brownie", 
        () -> new Item(new Item.Properties().tab(Epicsustance.DRUG_TAB)
        .food(new FoodProperties.Builder().nutrition(6).build())));
    public static final RegistryObject<DrugFood> DRUG_BROWNIE = ITEMS.register("drug_brownie", 
        () -> new DrugFood(new Item.Properties().tab(Epicsustance.DRUG_TAB)
        .food(new FoodProperties.Builder().nutrition(6).build()),
        new MobEffectInstance(MobEffects.CONFUSION, 400),
        new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200)));
    
    // Smokables
    public static final RegistryObject<DrugItem> ITEM_JOINT = ITEMS.register("item_joint", 
        () -> new DrugItem(new Item.Properties().tab(Epicsustance.DRUG_TAB),
        new MobEffectInstance(MobEffects.CONFUSION, 200),
        new MobEffectInstance(MobEffects.REGENERATION, 100)));
    public static final RegistryObject<DrugItem> ITEM_BLUNT = ITEMS.register("item_blunt",
        () -> new DrugItem(new Item.Properties().tab(Epicsustance.DRUG_TAB),
        new MobEffectInstance(MobEffects.REGENERATION, 100),
        new MobEffectInstance(MobEffects.CONFUSION, 200),
        new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100)));
    public static final RegistryObject<DrugItem> ITEM_SPLIFF = ITEMS.register("item_spliff", 
        () -> new DrugItem(new Item.Properties().tab(Epicsustance.DRUG_TAB), 
        new MobEffectInstance(MobEffects.REGENERATION, 100),
        new MobEffectInstance(MobEffects.CONFUSION, 200),
        new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100)));
    public static final RegistryObject<DrugItem> ITEM_HEROIN_JOINT = ITEMS.register("item_heroin_joint", 
        () -> new DrugItem(new Item.Properties().tab(Epicsustance.DRUG_TAB), 
        new MobEffectInstance(MobEffects.REGENERATION, 200),
        new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200),
        new MobEffectInstance(MobEffects.CONFUSION, 400)));
    
    // Drug Helper Items
    public static final RegistryObject<DrugHelper> ITEM_STRAW = ITEMS.register("item_straw", 
        () -> new DrugHelper(new Item.Properties().tab(Epicsustance.DRUG_TAB), 100, false,
        new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100)));
    public static final RegistryObject<DrugHelper> ITEM_TOBACCO_PIPE = ITEMS.register("item_pipe_tobacco", 
        () -> new DrugHelper(new Item.Properties().tab(Epicsustance.DRUG_TAB), 100, true,
        new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100)));
    public static final RegistryObject<DrugHelper> ITEM_OPIUM_PIPE = ITEMS.register("item_pipe_opium", 
        () -> new DrugHelper(new Item.Properties().tab(Epicsustance.DRUG_TAB), 100, true,
        new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100)));

    // Armor Material
    public static final DopeArmorMaterial DOPE_ARMOR_MATERIAL = new DopeArmorMaterial();
    
    // Armor Items
    public static final RegistryObject<ArmorItem> DOPE_HELMET = ITEMS.register("dope_helmet", 
        () -> new ArmorItem(DOPE_ARMOR_MATERIAL, EquipmentSlot.HEAD, 
        new Item.Properties().tab(Epicsustance.DRUG_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    
    public static void setupDrugHelpers() {
        // Set required drugs for helper items - called after registration is complete
        ITEM_STRAW.get().setRequiredDrug(DRUG_COCAINE.get());
        ITEM_TOBACCO_PIPE.get().setRequiredDrug(DRUG_TOBACCO.get());
        ITEM_OPIUM_PIPE.get().setRequiredDrug(DRUG_OPIUM.get());
    }
}