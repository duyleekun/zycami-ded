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

public class StyledPlayerControlViewLayoutManager$7
extends AnimatorListenerAdapter {
    public final /* synthetic */ StyledPlayerControlViewLayoutManager this$0;

    public StyledPlayerControlViewLayoutManager$7(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        this.this$0 = styledPlayerControlViewLayoutManager;
    }

    public void onAnimationEnd(Animator animator2) {
        StyledPlayerControlViewLayoutManager.access$400(this.this$0, 0);
    }

    public void onAnimationStart(Animator animator2) {
        StyledPlayerControlViewLayoutManager.access$400(this.this$0, 4);
    }
}

