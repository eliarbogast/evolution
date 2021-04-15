package eliarbogast.evolution.mod.mixins;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.passive.AnimalEntity;


@Mixin(SheepEntity.class)
public abstract class GrassReproduceMixin extends AnimalEntity{

    private int grassCount;

    protected GrassReproduceMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }


    @Inject(method="onEatingGrass", at = @At("HEAD"))
    public void onEatingGrass(CallbackInfo info) {
        GrassReproduceMixin passiveEntity = (GrassReproduceMixin) (Object) (this);
        this.grassCount++;
        if(grassCount >= 2){
            if (!this.world.isClient) {
                setLoveTicks(600);
            //set love ticks
            //OLD: createChild((ServerWorld) this.world, this);
        }
        }
    }
}
