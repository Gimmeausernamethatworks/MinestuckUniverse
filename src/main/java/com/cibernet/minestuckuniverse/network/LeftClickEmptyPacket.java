package com.cibernet.minestuckuniverse.network;

import com.cibernet.minestuckuniverse.items.IPropertyWeapon;
import com.cibernet.minestuckuniverse.items.properties.WeaponProperty;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;

import java.util.EnumSet;
import java.util.List;

public class LeftClickEmptyPacket extends MSUPacket
{
	@Override
	public MSUPacket generatePacket(Object... args)
	{
		return this;
	}

	@Override
	public MSUPacket consumePacket(ByteBuf data)
	{
		return this;
	}

	@Override
	public void execute(EntityPlayer player)
	{
		ItemStack stack = player.getHeldItemMainhand();

		if(stack.getItem() instanceof IPropertyWeapon)
		{
			List<WeaponProperty> propertyList = ((IPropertyWeapon) stack.getItem()).getProperties(stack);
			for(WeaponProperty p : propertyList)
				p.onEmptyHit(stack, player);
		}
	}

	@Override
	public EnumSet<Side> getSenderSide() {
		return EnumSet.of(Side.CLIENT);
	}
}