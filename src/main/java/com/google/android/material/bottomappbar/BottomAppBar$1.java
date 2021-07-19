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
import com.google.android.material.bottomappbar.BottomAppBar;

public class BottomAppBar$1
extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar this$0;

    public BottomAppBar$1(BottomAppBar bottomAppBar) {
        this.this$0 = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator2) {
        BottomAppBar.access$002(this.this$0, null);
    }
}

