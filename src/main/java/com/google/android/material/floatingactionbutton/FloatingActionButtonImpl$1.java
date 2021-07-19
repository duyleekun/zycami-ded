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
import com.google.android.material.internal.VisibilityAwareImageButton;

public class FloatingActionButtonImpl$1
extends AnimatorListenerAdapter {
    private boolean cancelled;
    public final /* synthetic */ FloatingActionButtonImpl this$0;
    public final /* synthetic */ boolean val$fromUser;
    public final /* synthetic */ FloatingActionButtonImpl$InternalVisibilityChangedListener val$listener;

    public FloatingActionButtonImpl$1(FloatingActionButtonImpl floatingActionButtonImpl, boolean bl2, FloatingActionButtonImpl$InternalVisibilityChangedListener internalVisibilityChangedListener) {
        this.this$0 = floatingActionButtonImpl;
        this.val$fromUser = bl2;
        this.val$listener = internalVisibilityChangedListener;
    }

    public void onAnimationCancel(Animator animator2) {
        this.cancelled = true;
    }

    public void onAnimationEnd(Animator object) {
        object = this.this$0;
        ((FloatingActionButtonImpl)object).animState = 0;
        ((FloatingActionButtonImpl)object).currentAnimator = null;
        boolean bl2 = this.cancelled;
        if (!bl2) {
            object = ((FloatingActionButtonImpl)object).view;
            bl2 = this.val$fromUser;
            int n10 = bl2 ? 8 : 4;
            ((VisibilityAwareImageButton)((Object)object)).internalSetVisibility(n10, bl2);
            object = this.val$listener;
            if (object != null) {
                object.onHidden();
            }
        }
    }

    public void onAnimationStart(Animator animator2) {
        Object object = this.this$0.view;
        boolean bl2 = this.val$fromUser;
        object.internalSetVisibility(0, bl2);
        object = this.this$0;
        ((FloatingActionButtonImpl)object).animState = 1;
        ((FloatingActionButtonImpl)object).currentAnimator = animator2;
        this.cancelled = false;
    }
}

