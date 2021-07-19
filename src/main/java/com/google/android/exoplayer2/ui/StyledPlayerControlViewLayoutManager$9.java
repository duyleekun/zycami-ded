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
import com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager;

public class StyledPlayerControlViewLayoutManager$9
extends AnimatorListenerAdapter {
    public final /* synthetic */ StyledPlayerControlViewLayoutManager this$0;

    public StyledPlayerControlViewLayoutManager$9(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        this.this$0 = styledPlayerControlViewLayoutManager;
    }

    public void onAnimationEnd(Animator animator2) {
        animator2 = StyledPlayerControlViewLayoutManager.access$700(this.this$0);
        if (animator2 != null) {
            animator2 = StyledPlayerControlViewLayoutManager.access$700(this.this$0);
            int n10 = 4;
            animator2.setVisibility(n10);
        }
    }

    public void onAnimationStart(Animator animator2) {
        animator2 = StyledPlayerControlViewLayoutManager.access$800(this.this$0);
        if (animator2 != null) {
            animator2 = StyledPlayerControlViewLayoutManager.access$800(this.this$0);
            animator2.setVisibility(0);
        }
    }
}

