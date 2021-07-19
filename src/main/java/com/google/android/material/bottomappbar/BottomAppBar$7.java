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

public class BottomAppBar$7
extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar this$0;

    public BottomAppBar$7(BottomAppBar bottomAppBar) {
        this.this$0 = bottomAppBar;
    }

    public void onAnimationStart(Animator object) {
        object = this.this$0;
        int n10 = BottomAppBar.access$600((BottomAppBar)object);
        BottomAppBar.access$700((BottomAppBar)object, n10 != 0);
        object = this.this$0;
        n10 = BottomAppBar.access$800((BottomAppBar)object);
        boolean bl2 = BottomAppBar.access$600(this.this$0);
        BottomAppBar.access$900((BottomAppBar)object, n10, bl2);
    }
}

