/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package d.v.c.s0;

import android.animation.ValueAnimator;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$g;

public final class d6
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DynamicZoomViewModel$g a;
    public final /* synthetic */ DynamicZoomViewModel$TargetModel b;

    public /* synthetic */ d6(DynamicZoomViewModel$g dynamicZoomViewModel$g, DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel) {
        this.a = dynamicZoomViewModel$g;
        this.b = dynamicZoomViewModel$TargetModel;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        DynamicZoomViewModel$g dynamicZoomViewModel$g = this.a;
        DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel = this.b;
        DynamicZoomViewModel.y(dynamicZoomViewModel$g, dynamicZoomViewModel$TargetModel, valueAnimator);
    }
}

