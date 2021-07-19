/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 */
package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsAnimationCompat$Impl21;
import androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import java.util.Collections;
import java.util.List;

public class WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$1
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WindowInsetsAnimationCompat$Impl21.Impl21OnApplyWindowInsetsListener this$0;
    public final /* synthetic */ WindowInsetsAnimationCompat val$anim;
    public final /* synthetic */ int val$animationMask;
    public final /* synthetic */ WindowInsetsCompat val$startingInsets;
    public final /* synthetic */ WindowInsetsCompat val$targetInsets;
    public final /* synthetic */ View val$v;

    public WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$1(WindowInsetsAnimationCompat$Impl21.Impl21OnApplyWindowInsetsListener impl21OnApplyWindowInsetsListener, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int n10, View view) {
        this.this$0 = impl21OnApplyWindowInsetsListener;
        this.val$anim = windowInsetsAnimationCompat;
        this.val$targetInsets = windowInsetsCompat;
        this.val$startingInsets = windowInsetsCompat2;
        this.val$animationMask = n10;
        this.val$v = view;
    }

    public void onAnimationUpdate(ValueAnimator object) {
        List<WindowInsetsAnimationCompat> list = this.val$anim;
        float f10 = object.getAnimatedFraction();
        ((WindowInsetsAnimationCompat)((Object)list)).setFraction(f10);
        object = this.val$targetInsets;
        list = this.val$startingInsets;
        float f11 = this.val$anim.getInterpolatedFraction();
        int n10 = this.val$animationMask;
        object = WindowInsetsAnimationCompat$Impl21.interpolateInsets((WindowInsetsCompat)object, (WindowInsetsCompat)((Object)list), f11, n10);
        list = Collections.singletonList(this.val$anim);
        WindowInsetsAnimationCompat$Impl21.dispatchOnProgress(this.val$v, (WindowInsetsCompat)object, list);
    }
}

