/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 */
package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsAnimationCompat$Impl21;
import androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener;

public class WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$2
extends AnimatorListenerAdapter {
    public final /* synthetic */ WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener this$0;
    public final /* synthetic */ WindowInsetsAnimationCompat val$anim;
    public final /* synthetic */ View val$v;

    public WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$2(WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener, WindowInsetsAnimationCompat windowInsetsAnimationCompat, View view) {
        this.this$0 = windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener;
        this.val$anim = windowInsetsAnimationCompat;
        this.val$v = view;
    }

    public void onAnimationEnd(Animator animator2) {
        this.val$anim.setFraction(1.0f);
        animator2 = this.val$v;
        WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.val$anim;
        WindowInsetsAnimationCompat$Impl21.dispatchOnEnd((View)animator2, windowInsetsAnimationCompat);
    }
}

