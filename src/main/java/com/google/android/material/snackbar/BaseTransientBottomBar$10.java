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

public class BaseTransientBottomBar$10
extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseTransientBottomBar this$0;
    public final /* synthetic */ int val$event;

    public BaseTransientBottomBar$10(BaseTransientBottomBar baseTransientBottomBar, int n10) {
        this.this$0 = baseTransientBottomBar;
        this.val$event = n10;
    }

    public void onAnimationEnd(Animator object) {
        object = this.this$0;
        int n10 = this.val$event;
        ((BaseTransientBottomBar)object).onViewHidden(n10);
    }

    public void onAnimationStart(Animator animator2) {
        BaseTransientBottomBar.access$100(this.this$0).animateContentOut(0, 180);
    }
}

