package eliarbogast.evolution.mod.mixins;

import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import static eliarbogast.evolution.mod.utils.DyeUtils.DyeColors;

@Mixin(SheepEntity.class)
public class SheepColorMixin  {

    @Inject(method = "getChildColor", at = @At("RETURN"), cancellable = true)
    private void modifyChildColor(AnimalEntity firstParent, AnimalEntity secondParent, CallbackInfoReturnable<DyeColor> cir) {
        DyeColor current = cir.getReturnValue();
        //if % chance that a mutation occurs, set dye value to slightly different color
            //define list  of colors in rainbow order, search list for current color and pick adjacent color
        //list of names from dyeColor.java, cir.getName() -> look up in list of names, then grab adjacent then do
        //dyeColor.byName which will give an object that can be set to the return value
        double mutDouble = Math.random();
        boolean mutate;

        //mutate rate
        mutate = mutDouble < 1.0;
        if (mutate) {

            double randDouble = Math.random();
            int randAdd;
            if(randDouble > 0.5){
                randAdd = 1;
            }
            else{
                randAdd = -1;
            }

            for (int i=0; i<DyeColors.length; i++){
                if(DyeColors[i].equals(current.getName())){
                    int newColor = i + randAdd;
                    DyeColor tempColor = DyeColor.byName(DyeColors[newColor], current);
                    cir.setReturnValue(tempColor);
                }
            }

        }
    }

}






