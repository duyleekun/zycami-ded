/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$InternalVisibilityChangedListener;

public class FloatingActionButtonImpl$2
extends AnimatorListenerAdapter {
    public final /* synthetic */ FloatingActionButtonImpl this$0;
    public final /* synthetic */ boolean val$fromUser;
    public final /* synthetic */ FloatingActionButtonImpl$InternalVisibilityChangedListener val$listener;

    public FloatingActionButtonImpl$2(FloatingActionButtonImpl floatingActionButtonImpl, boolean bl2, FloatingActionButtonImpl$InternalVisibilityChangedListener floatingActionButtonImpl$InternalVisibilityChangedListener) {
        this.this$0 = floatingActionButtonImpl;
        this.val$fromUser = bl2;
        this.val$listener = floatingActionButtonImpl$InternalVisibilityChangedListener;
    }

    public void onAnimationEnd(Animator object) {
        object = this.this$0;
        ((FloatingActionButtonImpl)object).animState = 0;
        ((FloatingActionButtonImpl)object).currentAnimator = null;
        object = this.val$listener;
        if (object != null) {
            object.onShown();
        }
    }

    public void onAnimationStart(Animator animator2) {
        Object object = this.this$0.view;
        boolean bl2 = this.val$fromUser;
        object.internalSetVisibility(0, bl2);
        object = this.this$0;
        ((FloatingActionButtonImpl)object).animState = 2;
        ((FloatingActionButtonImpl)object).currentAnimator = animator2;
    }
}

