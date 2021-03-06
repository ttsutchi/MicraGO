package com.example.examplemod;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityBuddyCube extends EntityThrowable {
    public EntityBuddyCube(World worldIn) {
        super(worldIn);
    }

    public EntityBuddyCube(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    public EntityBuddyCube(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    protected void onImpact(RayTraceResult result) {
//        if(worldObj.isRemote){
//            return;
//        }

        if (result.entityHit != null) {
            return;
        }

        if(result.typeOfHit == RayTraceResult.Type.BLOCK){

//            EntitySheep entitySheep = new EntitySheep(this.worldObj);
//            entitySheep.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
//            this.worldObj.spawnEntityInWorld(entitySheep);
        }


        for (int j = 0; j < 8; ++j) {
            this.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}
