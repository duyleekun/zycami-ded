/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package com.google.android.exoplayer2.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager;

public class StyledPlayerControlViewLayoutManager$4
extends AnimatorListenerAdapter {
    public final /* synthetic */ StyledPlayerControlViewLayoutManager this$0;
    public final /* synthetic */ StyledPlayerControlView val$styledPlayerControlView;

    public StyledPlayerControlViewLayoutManager$4(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager, StyledPlayerControlView styledPlayerControlView) {
        this.this$0 = styledPlayerControlViewLayoutManager;
        this.val$styledPlayerControlView = styledPlayerControlView;
    }

    public void onAnimationEnd(Animator object) {
        object = this.this$0;
        int n10 = 2;
        StyledPlayerControlViewLayoutManager.access$400((StyledPlayerControlViewLayoutManager)object, n10);
        object = this.this$0;
        boolean bl2 = StyledPlayerControlViewLayoutManager.access$500((StyledPlayerControlViewLayoutManager)object);
        if (bl2) {
            object = this.val$styledPlayerControlView;
            Runnable runnable = StyledPlayerControlViewLayoutManager.access$600(this.this$0);
            object.post(runnable);
            object = this.this$0;
            n10 = 0;
            runnable = null;
            StyledPlayerControlViewLayoutManager.access$502((StyledPlayerControlViewLayoutManager)object, false);
        }
    }

    public void onAnimationStart(Animator animator2) {
        StyledPlayerControlViewLayoutManager.access$400(this.this$0, 3);
    }
}

