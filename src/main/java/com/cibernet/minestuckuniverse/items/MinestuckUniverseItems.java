package com.cibernet.minestuckuniverse.items;

import com.cibernet.minestuckuniverse.blocks.BlockCustomTransportalizer;
import com.cibernet.minestuckuniverse.util.MSUModelManager;
import com.cibernet.minestuckuniverse.MinestuckUniverse;
import com.cibernet.minestuckuniverse.entity.models.armor.ModelDiverHelmet;
import com.cibernet.minestuckuniverse.util.MSUSoundHandler;
import com.mraof.minestuck.Minestuck;
import com.mraof.minestuck.block.BlockTransportalizer;
import com.mraof.minestuck.block.MinestuckBlocks;
import com.mraof.minestuck.item.MinestuckItems;
import com.mraof.minestuck.item.block.ItemTransportalizer;
import com.mraof.minestuck.item.weapon.ItemWeapon;
import com.mraof.minestuck.util.EnumAspect;
import com.mraof.minestuck.util.EnumClass;
import javafx.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MinestuckUniverseItems
{
    public static ArrayList<Block> itemBlocks = new ArrayList<>();

    private static final EnumClass[] classes = EnumClass.values();
    private static final EnumAspect[] aspects = EnumAspect.values();
    //Armor Materials
    public static ItemArmor.ArmorMaterial materialDiverHelmet = EnumHelper.addArmorMaterial("DIVER_HELMET", MinestuckUniverse.MODID+":diver_helmet", 50, new int[] {0, 0, 0, 3}, 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

    //GT Armor
    public static ItemArmor.ArmorMaterial[][] GTArmorMaterial = new ItemArmor.ArmorMaterial[classes.length][aspects.length];
    public static Item[][][] GTArmor = new Item[classes.length][aspects.length][4];

    public static MSUToolClass toolSword = new MSUToolClass(Material.WEB).addEnchantments(EnumEnchantmentType.WEAPON);
    public static MSUToolClass toolGauntlet = new MSUToolClass(Material.GLASS, Material.ICE, Material.PACKED_ICE);

    //Items
    public static Item spaceSalt = new ItemSpaceSalt();
    public static Item moonstone = new MSUItemBase("moonstone");
    public static Item moonstoneChisel = new ItemChisel("moonstone", 31);
    public static Item zillystoneShard = new MSUItemBase("zillystone_shard", "zillystoneShard");
    public static Item dungeonKey = new MSUItemBase("dungeon_key", "dungeonKey");

    //Ghost Items
    public static Item returnNode = new ItemGhostBlock("return_node_ghost_item", MinestuckBlocks.returnNode);
    public static Item travelGate = new ItemGhostBlock("travel_gate_ghost_item", MinestuckBlocks.gate);
    public static Item netherPortal = new ItemGhostBlock("nether_portal_ghost_item", Blocks.PORTAL);
    public static Item endPortal = new ItemGhostBlock("end_portal_ghost_item", Blocks.END_PORTAL);
    public static Item endGateway = new ItemGhostBlock("end_gateway_ghost_item", Blocks.END_GATEWAY);

    public static Item returnMedallion = new ItemWarpMedallion("returnMedallion", "return_medallion", ItemWarpMedallion.EnumTeleportType.RETURN, 80);
    public static Item teleportMedallion = new ItemWarpMedallion("teleportMedallion", "teleport_medallion", ItemWarpMedallion.EnumTeleportType.TRANSPORTALIZER, 80);
    public static Item skaianMedallion = new ItemWarpMedallion("skaianMedallion", "skaian_medallion", ItemWarpMedallion.EnumTeleportType.SKAIA, 80);

    //Weapons
    public static Item trueUnbreakableKatana = (new MSUWeaponBase(-1, 7.0D, -2.35D, 20, "true_unbreakable_katana", "unbreakableKatana")).setTool(toolSword, 0, 15.0F);
    public static Item battery = new MSUItemBase("battery", "battery");
    public static ItemBeamBlade batteryBeamBlade = new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade", "batteryBeamBlade").setTool(toolSword, 0, 15.0F);
    public static ItemBeamBlade[] dyedBeamBlade = new ItemBeamBlade[] {
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_white", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.WHITE),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_orange", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.ORANGE),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_magenta", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.MAGENTA),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_light_blue", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.LIGHT_BLUE),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_yellow", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.YELLOW),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_lime", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.LIME),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_pink", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.PINK),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_gray", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.GRAY),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_silver", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.SILVER),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_cyan", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.CYAN),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_purple", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.PURPLE),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_blue", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.BLUE),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_brown", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.BROWN),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_green", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.GREEN),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_red", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.RED),
            new ItemBeamBlade(345, 5, -2.3, 20, "battery_beam_blade_black", "batteryBeamBlade").setTool(toolSword, 0, 15.0F).setColor(EnumDyeColor.BLACK)};

    public static Item fancyGlove = new MSUWeaponBase(50, 0D, 0, 5, "fancy_glove", "fancyGlove").setTool(toolGauntlet, 0, 0);
    public static Item spikedGlove = new MSUWeaponBase(95, 3.5D, 0.25D, 8, "spiked_glove", "spikedGlove").setTool(toolGauntlet, 0, 0.5F);
    public static Item cobbleBasher = new MSUWeaponBase(175, 4D, -1.8D, 4, "cobble_basher","cobbleBasher").setTool(toolGauntlet, 0, 1.2F);
    public static Item fluoriteGauntlet = new ItemRandomWeapon(980, 7D, -0.3D,  8, "fluorite_gauntlet", "fluoriteGauntlet").setTool(toolGauntlet, 0, 2.4F);
    public static Item goldenGenesisGauntlet = new MSUWeaponBase(1256, 11D, -0.25D, 15, "golden_genesis_gauntlet","goldenGenesisGauntlet").setTool(toolGauntlet, 0, 3F);
    public static Item pogoFist = new ItemPogoWeapon(700, 7.0D, -0.3, 8, "pogo_fist", "pogoFist", 0.55D).setTool(toolGauntlet, 0, 1.4F);
    public static Item rocketFist = new MSUWeaponBase(124, 3D, 0.4D, 6, "rocket_powered_fist", "rocketFist").setTool(toolGauntlet, 0, 0.5F);

    //Armor
    public static MSUArmorBase diverHelmet = new ItemDiverHelmet(materialDiverHelmet,0,EntityEquipmentSlot.HEAD,"diverHelmet", "diver_helmet");

    //Overrides
    public static Item unbreakableKatana = new ItemWeapon(2200, 7, -2.4D, 20, "katana").setTool("sword", 0, 15.0F).setRegistryName(Minestuck.MOD_ID, "unbreakable_katana");
    public static Item captcharoidCamera = new ItemCaptcharoidOverride().setRegistryName(Minestuck.MOD_ID, "captcharoid_camera");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();

        registerItem(registry, spaceSalt);
        registerItem(registry, moonstone);
        registerItem(registry, moonstoneChisel);
        registerItem(registry, zillystoneShard);
        registerItem(registry, returnNode);
        registerItem(registry, travelGate);
        registerItem(registry, endPortal);
        registerItem(registry, netherPortal);
        registerItem(registry, endGateway);

        registerItem(registry, returnMedallion);
        registerItem(registry, teleportMedallion);
        registerItem(registry, skaianMedallion);

        registerItem(registry, trueUnbreakableKatana);

        registerItem(registry, diverHelmet);

        registry.register(unbreakableKatana);
        registerItem(registry, captcharoidCamera);

        registerItem(registry, fancyGlove);
        registerItem(registry, spikedGlove);
        registerItem(registry, cobbleBasher);
        registerItem(registry, fluoriteGauntlet);
        registerItem(registry, goldenGenesisGauntlet);
        registerItem(registry, pogoFist);
        registerItem(registry, rocketFist);

        registerItem(registry, battery);
        for(ItemBeamBlade blade : dyedBeamBlade)
            registerCustomRenderedItem(registry, blade);
        registerCustomRenderedItem(registry, batteryBeamBlade);
        //registerGTArmor(registry);

        registerItem(registry, dungeonKey);

        //Blocks
        registerItemBlocks(registry);

        //Item Mods


    }

    @SideOnly(Side.CLIENT)
    public static void setClientsideVariables()
    {
        diverHelmet.setArmorModel(new ModelDiverHelmet());
        for(ItemBeamBlade blade : dyedBeamBlade)
            registerItemCustomRender(blade, new MSUModelManager.DualWeaponDefinition("dyed_battery_beam_blade", "dyed_battery_beam_blade_off"));
        registerItemCustomRender(batteryBeamBlade, new MSUModelManager.DualWeaponDefinition("battery_beam_blade", "battery_beam_blade_off"));
    }



    public static void registerGTArmor(IForgeRegistry<Item> registry)
    {
        /*
        ModelBiped[] models = new ModelBiped[] {new ModelGTKnight()};
        EntityEquipmentSlot[] slots = new EntityEquipmentSlot[] {EntityEquipmentSlot.FEET, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.HEAD};
        for(int cls = 0; cls < classes.length; cls++)
            for(int asp = 0; asp < aspects.length; asp++)
            {
                String name = classes[cls].toString()+"_"+aspects[asp].toString();
                String unlocName = classes[cls].toString() + "." + aspects[asp].toString();
                GTArmorMaterial[cls][asp] = EnumHelper.addArmorMaterial(name.toUpperCase(), MinestuckUniverse.MODID + ":godtier/" + name, 1,
                        new int[] {4,4,4,4}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f);
                for(int piece = 0; piece < 4; piece++)
                {
                    EntityEquipmentSlot slot = slots[piece];
                    GTArmor[cls][asp][piece] = new MSUArmorBase(GTArmorMaterial[cls][asp],0,
                            slot, unlocName + "." + slot.toString().toLowerCase(),"gt_" + name  + "_" + slot.toString().toLowerCase()
                            );//.setCreativeTab(TabMinestuckUniverse.GTArmor);
                    registerItem(registry, GTArmor[cls][asp][piece]);
                }
            }
            */
    }

    private static Item registerItem(IForgeRegistry<Item> registry, Item item)
    {
        registry.register(item);
        MSUModelManager.items.add(item);
        return item;
    }

    private static Item registerCustomRenderedItem(IForgeRegistry<Item> registry, Item item)
    {
        registry.register(item);
        return item;
    }

    @SideOnly(Side.CLIENT)
    private static Item registerItemCustomRender(Item item, MSUModelManager.CustomItemMeshDefinition customMesh)
    {
        MSUModelManager.customItemModels.add(new Pair<>(item, customMesh));
        return item;
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry)
    {
        for(Block block : itemBlocks)
        {
            ItemBlock item = (block instanceof BlockCustomTransportalizer || block instanceof BlockTransportalizer)
                    ? new ItemTransportalizer(block) : new ItemBlock(block);
            registerItem(registry, item.setRegistryName(item.getBlock().getRegistryName()));
        }
    }
}
