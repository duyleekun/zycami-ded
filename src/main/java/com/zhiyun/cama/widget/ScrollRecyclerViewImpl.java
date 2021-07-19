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
import d.v.c.b2.u;

public class ScrollRecyclerViewImpl
extends u {
    public ScrollRecyclerViewImpl(Context context) {
        super(context);
    }

    public ScrollRecyclerViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScrollRecyclerViewImpl(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
    }

    public int getFooterLayoutCount() {
        return 1;
    }

    public int getHeaderLayoutCount() {
        return 1;
    }
}

