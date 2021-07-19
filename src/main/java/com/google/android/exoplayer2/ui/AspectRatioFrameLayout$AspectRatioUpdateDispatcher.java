/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout$1;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout$AspectRatioListener;

public final class AspectRatioFrameLayout$AspectRatioUpdateDispatcher
implements Runnable {
    private boolean aspectRatioMismatch;
    private boolean isScheduled;
    private float naturalAspectRatio;
    private float targetAspectRatio;
    public final /* synthetic */ AspectRatioFrameLayout this$0;

    private AspectRatioFrameLayout$AspectRatioUpdateDispatcher(AspectRatioFrameLayout aspectRatioFrameLayout) {
        this.this$0 = aspectRatioFrameLayout;
    }

    public /* synthetic */ AspectRatioFrameLayout$AspectRatioUpdateDispatcher(AspectRatioFrameLayout aspectRatioFrameLayout, AspectRatioFrameLayout$1 aspectRatioFrameLayout$1) {
        this(aspectRatioFrameLayout);
    }

    public void run() {
        this.isScheduled = false;
        AspectRatioFrameLayout$AspectRatioListener aspectRatioFrameLayout$AspectRatioListener = AspectRatioFrameLayout.access$100(this.this$0);
        if (aspectRatioFrameLayout$AspectRatioListener == null) {
            return;
        }
        aspectRatioFrameLayout$AspectRatioListener = AspectRatioFrameLayout.access$100(this.this$0);
        float f10 = this.targetAspectRatio;
        float f11 = this.naturalAspectRatio;
        boolean bl2 = this.aspectRatioMismatch;
        aspectRatioFrameLayout$AspectRatioListener.onAspectRatioUpdated(f10, f11, bl2);
    }

    public void scheduleUpdate(float f10, float f11, boolean bl2) {
        this.targetAspectRatio = f10;
        this.naturalAspectRatio = f11;
        this.aspectRatioMismatch = bl2;
        boolean bl3 = this.isScheduled;
        if (!bl3) {
            bl3 = true;
            f10 = Float.MIN_VALUE;
            this.isScheduled = bl3;
            AspectRatioFrameLayout aspectRatioFrameLayout = this.this$0;
            aspectRatioFrameLayout.post(this);
        }
    }
}

