/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 */
package com.zhiyun.cama.album;

import android.content.Context;
import android.util.AttributeSet;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class ZYSubsamplingScaleImageView
extends SubsamplingScaleImageView {
    public ZYSubsamplingScaleImageView(Context context) {
        super(context);
    }

    public ZYSubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        if (n13 == n10 && n12 == n11) {
            this.resetScaleAndCenter();
        }
    }
}

