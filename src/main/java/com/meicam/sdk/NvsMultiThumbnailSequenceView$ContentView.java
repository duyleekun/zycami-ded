/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 */
package com.meicam.sdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.meicam.sdk.NvsMultiThumbnailSequenceView;

public class NvsMultiThumbnailSequenceView$ContentView
extends ViewGroup {
    public final /* synthetic */ NvsMultiThumbnailSequenceView this$0;

    public NvsMultiThumbnailSequenceView$ContentView(NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView, Context context) {
        this.this$0 = nvsMultiThumbnailSequenceView;
        super(context);
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        this.this$0.updateThumbnails();
    }

    public void onMeasure(int n10, int n11) {
        NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView = this.this$0;
        int n12 = NvsMultiThumbnailSequenceView.access$000(nvsMultiThumbnailSequenceView);
        int n13 = View.MeasureSpec.getMode((int)n11);
        int n14 = View.MeasureSpec.getSize((int)n11);
        int n15 = 0x40000000;
        if (n13 != n15 && n13 != (n15 = -1 << -1)) {
            NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView2 = this.this$0;
            n14 = nvsMultiThumbnailSequenceView2.getHeight();
        }
        n13 = this.getSuggestedMinimumWidth();
        n12 = Math.max(n12, n13);
        n13 = this.getSuggestedMinimumHeight();
        n13 = Math.max(n14, n13);
        n10 = ViewGroup.resolveSizeAndState((int)n12, (int)n10, (int)0);
        n11 = ViewGroup.resolveSizeAndState((int)n13, (int)n11, (int)0);
        this.setMeasuredDimension(n10, n11);
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        if (n11 != n13) {
            NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView = this.this$0;
            NvsMultiThumbnailSequenceView.access$100(nvsMultiThumbnailSequenceView);
        }
        super.onSizeChanged(n10, n11, n12, n13);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

