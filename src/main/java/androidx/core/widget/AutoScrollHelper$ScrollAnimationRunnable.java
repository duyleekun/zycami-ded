/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.widget;

import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoScrollHelper;
import androidx.core.widget.AutoScrollHelper$ClampedScroller;

public class AutoScrollHelper$ScrollAnimationRunnable
implements Runnable {
    public final /* synthetic */ AutoScrollHelper this$0;

    public AutoScrollHelper$ScrollAnimationRunnable(AutoScrollHelper autoScrollHelper) {
        this.this$0 = autoScrollHelper;
    }

    public void run() {
        AutoScrollHelper autoScrollHelper;
        Object object = this.this$0;
        int n10 = ((AutoScrollHelper)object).mAnimating;
        if (n10 == 0) {
            return;
        }
        n10 = ((AutoScrollHelper)object).mNeedsReset;
        if (n10 != 0) {
            ((AutoScrollHelper)object).mNeedsReset = false;
            object = ((AutoScrollHelper)object).mScroller;
            ((AutoScrollHelper$ClampedScroller)object).start();
        }
        if ((n10 = ((AutoScrollHelper$ClampedScroller)(object = this.this$0.mScroller)).isFinished()) == 0 && (n10 = (autoScrollHelper = this.this$0).shouldAnimate()) != 0) {
            autoScrollHelper = this.this$0;
            boolean bl2 = autoScrollHelper.mNeedsCancel;
            if (bl2) {
                autoScrollHelper.mNeedsCancel = false;
                autoScrollHelper.cancelTargetTouch();
            }
            ((AutoScrollHelper$ClampedScroller)object).computeScrollDelta();
            n10 = ((AutoScrollHelper$ClampedScroller)object).getDeltaX();
            int n11 = ((AutoScrollHelper$ClampedScroller)object).getDeltaY();
            this.this$0.scrollTargetBy(n10, n11);
            ViewCompat.postOnAnimation(this.this$0.mTarget, this);
            return;
        }
        this.this$0.mAnimating = false;
    }
}

