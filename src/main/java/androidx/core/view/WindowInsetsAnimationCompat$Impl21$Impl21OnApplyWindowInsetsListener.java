/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.WindowInsets
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 */
package androidx.core.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat;
import androidx.core.view.WindowInsetsAnimationCompat$Callback;
import androidx.core.view.WindowInsetsAnimationCompat$Impl21;
import androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$1;
import androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$2;
import androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$3;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Builder;
import java.util.Objects;

public class WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener
implements View.OnApplyWindowInsetsListener {
    private static final int COMPAT_ANIMATION_DURATION = 160;
    public final WindowInsetsAnimationCompat$Callback mCallback;
    private WindowInsetsCompat mLastInsets;

    public WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener(View object, WindowInsetsAnimationCompat$Callback object2) {
        this.mCallback = object2;
        object = ViewCompat.getRootWindowInsets(object);
        if (object != null) {
            object2 = new WindowInsetsCompat$Builder((WindowInsetsCompat)object);
            object = ((WindowInsetsCompat$Builder)object2).build();
        } else {
            object = null;
        }
        this.mLastInsets = object;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$1 windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$1;
        WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener = this;
        View view2 = view;
        WindowInsets windowInsets2 = windowInsets;
        boolean bl2 = view.isLaidOut();
        if (!bl2) {
            WindowInsetsCompat windowInsetsCompat;
            this.mLastInsets = windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
            return WindowInsetsAnimationCompat$Impl21.forwardToViewIfNeeded(view, windowInsets);
        }
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
        Object object = this.mLastInsets;
        if (object == null) {
            object = ViewCompat.getRootWindowInsets(view);
            this.mLastInsets = object;
        }
        if ((object = windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener.mLastInsets) == null) {
            windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener.mLastInsets = windowInsetsCompat;
            return WindowInsetsAnimationCompat$Impl21.forwardToViewIfNeeded(view, windowInsets);
        }
        object = WindowInsetsAnimationCompat$Impl21.getCallback(view);
        if (object != null && (bl2 = Objects.equals(object = ((WindowInsetsAnimationCompat$Callback)object).mDispachedInsets, windowInsets2))) {
            return WindowInsetsAnimationCompat$Impl21.forwardToViewIfNeeded(view, windowInsets);
        }
        object = windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener.mLastInsets;
        int n10 = WindowInsetsAnimationCompat$Impl21.buildAnimationMask(windowInsetsCompat, (WindowInsetsCompat)object);
        if (n10 == 0) {
            return WindowInsetsAnimationCompat$Impl21.forwardToViewIfNeeded(view, windowInsets);
        }
        Object object2 = windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener.mLastInsets;
        object = new DecelerateInterpolator();
        WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(n10, (Interpolator)object, 160L);
        windowInsetsAnimationCompat.setFraction(0.0f);
        Object object3 = object = (Object)new float[2];
        object3[0] = 0.0f;
        object3[1] = 1.0f;
        object = ValueAnimator.ofFloat((float[])object);
        long l10 = windowInsetsAnimationCompat.getDurationMillis();
        ValueAnimator valueAnimator = object.setDuration(l10);
        WindowInsetsAnimationCompat$BoundsCompat windowInsetsAnimationCompat$BoundsCompat = WindowInsetsAnimationCompat$Impl21.computeAnimationBounds(windowInsetsCompat, (WindowInsetsCompat)object2, n10);
        WindowInsetsAnimationCompat$Impl21.dispatchOnPrepare(view2, windowInsetsAnimationCompat, windowInsets2, false);
        object = windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$1;
        Object object4 = view;
        windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$1 = new WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$1(this, windowInsetsAnimationCompat, windowInsetsCompat, (WindowInsetsCompat)object2, n10, view);
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$1);
        object = new WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$2(this, windowInsetsAnimationCompat, view2);
        valueAnimator.addListener((Animator.AnimatorListener)object);
        object = object4;
        object2 = windowInsetsAnimationCompat$BoundsCompat;
        object4 = new WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$3(this, view, windowInsetsAnimationCompat, windowInsetsAnimationCompat$BoundsCompat, valueAnimator);
        OneShotPreDrawListener.add(view2, (Runnable)object4);
        windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener.mLastInsets = windowInsetsCompat;
        return WindowInsetsAnimationCompat$Impl21.forwardToViewIfNeeded(view, windowInsets);
    }
}

