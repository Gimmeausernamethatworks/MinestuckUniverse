package com.cibernet.minestuckuniverse.badges.heroAspect;

import com.cibernet.minestuckuniverse.MinestuckUniverse;
import com.cibernet.minestuckuniverse.capabilities.MSUCapabilities;
import com.cibernet.minestuckuniverse.capabilities.badgeEffects.IBadgeEffects;
import com.cibernet.minestuckuniverse.capabilities.keyStates.SkillKeyStates;
import com.cibernet.minestuckuniverse.particles.MSUParticles;
import com.cibernet.minestuckuniverse.util.EnumRole;
import com.cibernet.minestuckuniverse.util.MSUUtils;
import com.mraof.minestuck.util.EnumAspect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BadgePassiveHeart extends BadgeHeroAspect
{
	public static final DamageSource DAMAGE_SOURCE = new DamageSource(MinestuckUniverse.MODID+".fragmentedSoul").setDamageBypassesArmor();

	public BadgePassiveHeart()
	{
		super(EnumAspect.HEART, EnumRole.PASSIVE, EnumAspect.BLOOD);
	}

	@Override
	public boolean onBadgeTick(World world, EntityPlayer player, IBadgeEffects badgeEffects, SkillKeyStates.KeyState state, int time)
	{
		if(!state.equals(SkillKeyStates.KeyState.HELD))
			return false;

		if (time % 10 != 0) // for damage cooldown
			return false;

		EntityLivingBase target = MSUUtils.getTargetEntity(player);
		if (target != null)
		{
			player.attackEntityFrom(DAMAGE_SOURCE, 8);
			if (target.getHealth() >= target.getMaxHealth())
			{
				// Each amplifier increases health by 4
				if (target.isPotionActive(MobEffects.HEALTH_BOOST))
					target.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 12000, target.getActivePotionEffect(MobEffects.HEALTH_BOOST).getAmplifier() + 1));
				else
					target.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 12000));
				target.heal(target.getMaxHealth());
			}
			else
				target.heal(4);

			badgeEffects.startPowerParticles(getClass(), MSUParticles.ParticleType.AURA, EnumAspect.HEART, 4);
			target.getCapability(MSUCapabilities.BADGE_EFFECTS, null).oneshotPowerParticles(MSUParticles.ParticleType.AURA, EnumAspect.HEART, 2);
		}
		else
			badgeEffects.startPowerParticles(getClass(), MSUParticles.ParticleType.AURA, EnumAspect.HEART, 2);

		return true;
	}
}
