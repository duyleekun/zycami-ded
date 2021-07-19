/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation;

public class ItemTouchHelper$RecoverAnimation$1
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ItemTouchHelper$RecoverAnimation this$0;

    public ItemTouchHelper$RecoverAnimation$1(ItemTouchHelper$RecoverAnimation itemTouchHelper$RecoverAnimation) {
        this.this$0 = itemTouchHelper$RecoverAnimation;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ItemTouchHelper$RecoverAnimation itemTouchHelper$RecoverAnimation = this.this$0;
        float f10 = valueAnimator.getAnimatedFraction();
        itemTouchHelper$RecoverAnimation.setFraction(f10);
    }
}

