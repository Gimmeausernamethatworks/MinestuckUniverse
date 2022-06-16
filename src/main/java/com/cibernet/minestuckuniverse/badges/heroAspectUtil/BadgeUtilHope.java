package com.cibernet.minestuckuniverse.badges.heroAspectUtil;

import com.cibernet.minestuckuniverse.capabilities.keyStates.SkillKeyStates;
import com.cibernet.minestuckuniverse.capabilities.badgeEffects.IBadgeEffects;
import com.cibernet.minestuckuniverse.particles.MSUParticles;
import com.cibernet.minestuckuniverse.util.MSUUtils;
import com.mraof.minestuck.util.EnumAspect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class BadgeUtilHope extends BadgeHeroAspectUtil
{
	public BadgeUtilHope()
	{
		super(EnumAspect.HOPE, new ItemStack(Items.MILK_BUCKET, 16));
	}

	protected static final int ENERGY_USE = 4;

	@Override
	public boolean onBadgeTick(World world, EntityPlayer player, IBadgeEffects badgeEffects, SkillKeyStates.KeyState state, int time)
	{
		if(!state.equals(SkillKeyStates.KeyState.PRESS))
			return false;

		if(!player.isCreative() && player.getFoodStats().getFoodLevel() < ENERGY_USE)
		{
			player.sendStatusMessage(new TextComponentTranslation("status.tooExhausted"), true);
			return false;
		}

		EntityLivingBase target = MSUUtils.getTargetEntity(player);

		if(target == null || target.getActivePotionMap().isEmpty())
			target = player;

		if(!target.getActivePotionMap().isEmpty())
		{
			target.clearActivePotions();
			if (!player.isCreative())
				player.getFoodStats().setFoodLevel(player.getFoodStats().getFoodLevel() - ENERGY_USE);

			badgeEffects.startPowerParticles(getClass(), MSUParticles.ParticleType.AURA, EnumAspect.HOPE, target != player ? 14 : 10);
		}

		return true;
	}
}
