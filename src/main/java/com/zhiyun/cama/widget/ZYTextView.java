/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;

public class ZYTextView
extends AppCompatTextView {
    public ZYTextView(Context context) {
        this(context, null);
    }

    public ZYTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZYTextView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        context = ResourcesCompat.getFont(this.getContext(), 2131296257);
        this.setTypeface((Typeface)context);
    }
}

