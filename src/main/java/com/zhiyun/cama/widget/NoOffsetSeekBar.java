/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;

public class NoOffsetSeekBar
extends AppCompatSeekBar {
    public NoOffsetSeekBar(Context context) {
        super(context);
    }

    public NoOffsetSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setThumbOffset(0);
    }

    public NoOffsetSeekBar(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
    }
}

