/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;

public class GridLayoutManager$LayoutParams
extends RecyclerView$LayoutParams {
    public static final int INVALID_SPAN_ID = 255;
    public int mSpanIndex = -1;
    public int mSpanSize = 0;

    public GridLayoutManager$LayoutParams(int n10, int n11) {
        super(n10, n11);
    }

    public GridLayoutManager$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GridLayoutManager$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public GridLayoutManager$LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public GridLayoutManager$LayoutParams(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        super(recyclerView$LayoutParams);
    }

    public int getSpanIndex() {
        return this.mSpanIndex;
    }

    public int getSpanSize() {
        return this.mSpanSize;
    }
}

