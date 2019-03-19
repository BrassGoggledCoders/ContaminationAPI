package xyz.brassgoggledcoders.contamination.modules.fertilizer;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import xyz.brassgoggledcoders.contamination.ContaminationMod;
import xyz.brassgoggledcoders.contamination.api.IContaminationHolder;

public class EntityFertilizerCreeper extends EntityCreeper {
	
	public EntityFertilizerCreeper(World worldIn) {
		super(worldIn);
	}
	
	@Override
	public void onDeath(DamageSource cause)
    {
		ItemDye.applyBonemeal(new ItemStack(Items.DYE), this.getEntityWorld(), this.getPosition());
		IContaminationHolder holder = this.getEntityWorld().getChunk(this.getPosition()).getCapability(ContaminationMod.CONTAMINATION_HOLDER_CAPABILITY, null);
		holder.set(ModuleFertilizer.fertilizer, holder.get(ModuleFertilizer.fertilizer) + 10, true);
		super.onDeath(cause);
    }

}