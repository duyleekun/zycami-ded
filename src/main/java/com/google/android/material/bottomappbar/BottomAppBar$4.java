/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

public class BottomAppBar$4
extends AnimatorListenerAdapter {
    public boolean cancelled;
    public final /* synthetic */ BottomAppBar this$0;
    public final /* synthetic */ ActionMenuView val$actionMenuView;
    public final /* synthetic */ boolean val$targetAttached;
    public final /* synthetic */ int val$targetMode;

    public BottomAppBar$4(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int n10, boolean bl2) {
        this.this$0 = bottomAppBar;
        this.val$actionMenuView = actionMenuView;
        this.val$targetMode = n10;
        this.val$targetAttached = bl2;
    }

    public void onAnimationCancel(Animator animator2) {
        this.cancelled = true;
    }

    public void onAnimationEnd(Animator object) {
        boolean bl2 = this.cancelled;
        if (!bl2) {
            object = this.this$0;
            ActionMenuView actionMenuView = this.val$actionMenuView;
            int n10 = this.val$targetMode;
            boolean bl3 = this.val$targetAttached;
            BottomAppBar.access$400((BottomAppBar)object, actionMenuView, n10, bl3);
        }
    }
}

