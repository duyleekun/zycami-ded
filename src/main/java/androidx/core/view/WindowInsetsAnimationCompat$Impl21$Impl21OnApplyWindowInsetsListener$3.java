/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.view.View
 */
package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat;
import androidx.core.view.WindowInsetsAnimationCompat$Impl21;
import androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener;

public class WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$3
implements Runnable {
    public final /* synthetic */ WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener this$0;
    public final /* synthetic */ WindowInsetsAnimationCompat val$anim;
    public final /* synthetic */ WindowInsetsAnimationCompat$BoundsCompat val$animationBounds;
    public final /* synthetic */ ValueAnimator val$animator;
    public final /* synthetic */ View val$v;

    public WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$3(WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener, View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat$BoundsCompat windowInsetsAnimationCompat$BoundsCompat, ValueAnimator valueAnimator) {
        this.this$0 = windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener;
        this.val$v = view;
        this.val$anim = windowInsetsAnimationCompat;
        this.val$animationBounds = windowInsetsAnimationCompat$BoundsCompat;
        this.val$animator = valueAnimator;
    }

    public void run() {
        View view = this.val$v;
        WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.val$anim;
        WindowInsetsAnimationCompat$BoundsCompat windowInsetsAnimationCompat$BoundsCompat = this.val$animationBounds;
        WindowInsetsAnimationCompat$Impl21.dispatchOnStart(view, windowInsetsAnimationCompat, windowInsetsAnimationCompat$BoundsCompat);
        this.val$animator.start();
    }
}

