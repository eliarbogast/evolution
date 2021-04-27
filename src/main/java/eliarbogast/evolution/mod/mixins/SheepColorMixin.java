package eliarbogast.evolution.mod.mixins;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.SheepWoolFeatureRenderer;
import net.minecraft.client.render.entity.model.SheepEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

@Mixin(SheepWoolFeatureRenderer.class)
public class SheepColorMixin extends SheepWoolFeatureRenderer {
    @Unique
    private final int dummyField = 1;
    public SheepColorMixin(FeatureRendererContext<SheepEntity, SheepEntityModel<SheepEntity>> featureRendererContext) {
        super(featureRendererContext);
    }
    /**
     * @author eliarbogast
     */
    @Overwrite
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i,
                       SheepEntity sheepEntity, float f, float g, float h, float j, float k, float l) {
        if (!sheepEntity.isSheared() && !sheepEntity.isInvisible()) {
            float v;
            float w;
            float x;
            if (sheepEntity.hasCustomName() && "jeb_".equals(sheepEntity.getName().asString())) {
                boolean m = true;
                int n = sheepEntity.age / 25 + sheepEntity.getEntityId();
                int o = DyeColor.values().length;
                int p = n % o;
                int q = (n + 1) % o;
                float r = ((float)(sheepEntity.age % 25) + h) / 25.0F;
                float[] fs = SheepEntity.getRgbColor(DyeColor.byId(p));
                float[] gs = SheepEntity.getRgbColor(DyeColor.byId(q));
                v = fs[0] * (1.0F - r) + gs[0] * r;
                w = fs[1] * (1.0F - r) + gs[1] * r;
                x = fs[2] * (1.0F - r) + gs[2] * r;
            } else {
                float[] hs = SheepEntity.getRgbColor(sheepEntity.getColor());
                v = hs[0];
                w = hs[1];
                x = hs[2];
            }

            render(this.getContextModel(), this.model, SKIN, matrixStack, vertexConsumerProvider, i, sheepEntity, f, g, j, k, l, h, v, w, x);
        }System.out.println(dummyField);
    }


}






