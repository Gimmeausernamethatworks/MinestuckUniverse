package com.cibernet.minestuckuniverse.items;

import com.cibernet.minestuckuniverse.MinestuckUniverse;
import com.cibernet.minestuckuniverse.TabMinestuckUniverse;
import com.mraof.minestuck.Minestuck;
import com.mraof.minestuck.item.TabMinestuck;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MSUArmorBase extends ItemArmor
{
    private ModelBiped model;

    public MSUArmorBase(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String unlocName, String registryName)
    {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(unlocName);
        setRegistryName(registryName);
        setCreativeTab(registryName.contains(Minestuck.MOD_ID+":") ? TabMinestuck.instance : TabMinestuckUniverse.instance);

    }

    public MSUArmorBase(int maxUses, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String unlocName, String registryName)
    {
        this(materialIn, renderIndexIn, equipmentSlotIn, unlocName, registryName);
        setMaxDamage(maxUses);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        String key = getUnlocalizedName()+".tooltip";
        if(!I18n.translateToLocal(key).equals(key))
            tooltip.add(I18n.translateToLocal(key));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    public void setArmorModel(ModelBiped model) {this.model = model;}

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        return MinestuckUniverse.MODID + ":textures/models/armor/" + getRegistryName().getResourcePath() + ".png";
    }

    @Override
    public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack stack, EntityEquipmentSlot slot,
                                    ModelBiped _default)
    {
        if(model == null) return super.getArmorModel(entity, stack, slot, _default);

        if(!stack.isEmpty())
        {
            if(stack.getItem() instanceof MSUArmorBase)
            {
                ModelBiped model = this.model;

                model.bipedRightLeg.showModel = slot == EntityEquipmentSlot.LEGS || slot == EntityEquipmentSlot.FEET;
                model.bipedLeftLeg.showModel = slot == EntityEquipmentSlot.LEGS || slot == EntityEquipmentSlot.FEET;

                model.bipedBody.showModel = slot == EntityEquipmentSlot.CHEST;
                model.bipedLeftArm.showModel = slot == EntityEquipmentSlot.CHEST;
                model.bipedRightArm.showModel = slot == EntityEquipmentSlot.CHEST;

                model.bipedHead.showModel = slot == EntityEquipmentSlot.HEAD;
                model.bipedHeadwear.showModel = slot == EntityEquipmentSlot.HEAD;


                model.isSneak = _default.isSneak;
                model.isRiding = _default.isRiding;
                model.isChild = _default.isChild;

                model.rightArmPose = _default.rightArmPose;
                model.leftArmPose = _default.leftArmPose;

                return model;
            }
        }

        return null;
    }
}
