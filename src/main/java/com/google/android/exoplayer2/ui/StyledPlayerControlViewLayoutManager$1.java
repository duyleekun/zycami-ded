/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 */
package com.google.android.exoplayer2.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager;

public class StyledPlayerControlViewLayoutManager$1
extends AnimatorListenerAdapter {
    public final /* synthetic */ StyledPlayerControlViewLayoutManager this$0;
    public final /* synthetic */ View val$controlsBackground;

    public StyledPlayerControlViewLayoutManager$1(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager, View view) {
        this.this$0 = styledPlayerControlViewLayoutManager;
        this.val$controlsBackground = view;
    }

    public void onAnimationEnd(Animator animator2) {
        animator2 = this.val$controlsBackground;
        int n10 = 4;
        if (animator2 != null) {
            animator2.setVisibility(n10);
        }
        if ((animator2 = StyledPlayerControlViewLayoutManager.access$200(this.this$0)) != null) {
            animator2 = StyledPlayerControlViewLayoutManager.access$200(this.this$0);
            animator2.setVisibility(n10);
        }
        if ((animator2 = StyledPlayerControlViewLayoutManager.access$300(this.this$0)) != null) {
            animator2 = StyledPlayerControlViewLayoutManager.access$300(this.this$0);
            animator2.setVisibility(n10);
        }
    }

    public void onAnimationStart(Animator object) {
        object = StyledPlayerControlViewLayoutManager.access$000(this.this$0);
        boolean bl2 = object instanceof DefaultTimeBar;
        if (bl2 && !(bl2 = StyledPlayerControlViewLayoutManager.access$100((StyledPlayerControlViewLayoutManager)(object = this.this$0)))) {
            object = (DefaultTimeBar)StyledPlayerControlViewLayoutManager.access$000(this.this$0);
            long l10 = 250L;
            ((DefaultTimeBar)object).hideScrubber(l10);
        }
    }
}

