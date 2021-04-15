package eliarbogast.evolution.mod.mixins;

import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(SheepEntity.class)
public abstract class ColorTickMixin {

    @Shadow public abstract void setColor(DyeColor color);

    @Inject(method="mobTick", at = @At("HEAD"))

        public void mobTick(CallbackInfo info){
        DyeColor[] colors = {DyeColor.GREEN, DyeColor.BLUE, DyeColor.MAGENTA, DyeColor.LIME};
        Random random = new Random();
        int rand = random.nextInt(3);
        setColor(colors[rand]);
    }

}
