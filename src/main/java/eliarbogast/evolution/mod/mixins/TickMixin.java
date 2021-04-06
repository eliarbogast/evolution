package eliarbogast.evolution.mod.mixins;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class TickMixin {
    @Inject(method={"tick"}, at = @At("TAIL"))
    public void onTick(CallbackInfo callbackInfo){

        if(MinecraftClient.getInstance().world != null){

        }
    }
}
