/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class BaseTransientBottomBar$8
extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseTransientBottomBar this$0;

    public BaseTransientBottomBar$8(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
    }

    public void onAnimationEnd(Animator animator2) {
        this.this$0.onViewShown();
    }

    public void onAnimationStart(Animator animator2) {
        BaseTransientBottomBar.access$100(this.this$0).animateContentIn(70, 180);
    }
}

