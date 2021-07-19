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

public class StyledPlayerControlViewLayoutManager$2
extends AnimatorListenerAdapter {
    public final /* synthetic */ StyledPlayerControlViewLayoutManager this$0;
    public final /* synthetic */ View val$controlsBackground;

    public StyledPlayerControlViewLayoutManager$2(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager, View view) {
        this.this$0 = styledPlayerControlViewLayoutManager;
        this.val$controlsBackground = view;
    }

    public void onAnimationStart(Animator object) {
        boolean bl2;
        object = this.val$controlsBackground;
        int n10 = 0;
        if (object != null) {
            object.setVisibility(0);
        }
        if ((object = StyledPlayerControlViewLayoutManager.access$200(this.this$0)) != null) {
            object = StyledPlayerControlViewLayoutManager.access$200(this.this$0);
            object.setVisibility(0);
        }
        if ((object = StyledPlayerControlViewLayoutManager.access$300(this.this$0)) != null) {
            object = StyledPlayerControlViewLayoutManager.access$300(this.this$0);
            StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.this$0;
            boolean bl3 = StyledPlayerControlViewLayoutManager.access$100(styledPlayerControlViewLayoutManager);
            if (!bl3) {
                n10 = 4;
            }
            object.setVisibility(n10);
        }
        if ((bl2 = (object = StyledPlayerControlViewLayoutManager.access$000(this.this$0)) instanceof DefaultTimeBar) && !(bl2 = StyledPlayerControlViewLayoutManager.access$100((StyledPlayerControlViewLayoutManager)(object = this.this$0)))) {
            object = (DefaultTimeBar)StyledPlayerControlViewLayoutManager.access$000(this.this$0);
            long l10 = 250L;
            ((DefaultTimeBar)object).showScrubber(l10);
        }
    }
}

