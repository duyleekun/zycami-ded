/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$State;

public abstract class RecyclerView$ItemDecoration {
    public void getItemOffsets(Rect rect, int n10, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$State recyclerView$State) {
        int n10 = ((RecyclerView$LayoutParams)view.getLayoutParams()).getViewLayoutPosition();
        this.getItemOffsets(rect, n10, recyclerView);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView) {
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView$State recyclerView$State) {
        this.onDraw(canvas, recyclerView);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView$State recyclerView$State) {
        this.onDrawOver(canvas, recyclerView);
    }
}

