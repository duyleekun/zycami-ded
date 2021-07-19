/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$State;

public class DividerItemDecoration
extends RecyclerView$ItemDecoration {
    private static final int[] ATTRS;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "DividerItem";
    public static final int VERTICAL = 1;
    private final Rect mBounds;
    private Drawable mDivider;
    private int mOrientation;

    static {
        int[] nArray = new int[]{16843284};
        ATTRS = nArray;
    }

    public DividerItemDecoration(Context context, int n10) {
        Object object;
        this.mBounds = object = new Rect();
        object = ATTRS;
        context = context.obtainStyledAttributes((int[])object);
        object = context.getDrawable(0);
        this.mDivider = object;
        if (object == null) {
            object = TAG;
            String string2 = "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()";
            Log.w((String)object, (String)string2);
        }
        context.recycle();
        this.setOrientation(n10);
    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int n10;
        int n11;
        int n12;
        int n13;
        canvas.save();
        int n14 = recyclerView.getClipToPadding();
        int n15 = 0;
        if (n14 != 0) {
            n14 = recyclerView.getPaddingTop();
            n13 = recyclerView.getHeight();
            n12 = recyclerView.getPaddingBottom();
            n13 -= n12;
            n12 = recyclerView.getPaddingLeft();
            n11 = recyclerView.getWidth();
            n10 = recyclerView.getPaddingRight();
            canvas.clipRect(n12, n14, n11 -= n10, n13);
        } else {
            n13 = recyclerView.getHeight();
            n14 = 0;
        }
        n12 = recyclerView.getChildCount();
        while (n15 < n12) {
            View view = recyclerView.getChildAt(n15);
            RecyclerView$LayoutManager recyclerView$LayoutManager = recyclerView.getLayoutManager();
            Rect rect = this.mBounds;
            recyclerView$LayoutManager.getDecoratedBoundsWithMargins(view, rect);
            recyclerView$LayoutManager = this.mBounds;
            n10 = ((Rect)recyclerView$LayoutManager).right;
            float f10 = view.getTranslationX();
            n11 = Math.round(f10);
            n10 += n11;
            n11 = this.mDivider.getIntrinsicWidth();
            n11 = n10 - n11;
            rect = this.mDivider;
            rect.setBounds(n11, n14, n10, n13);
            view = this.mDivider;
            view.draw(canvas);
            ++n15;
        }
        canvas.restore();
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int n10;
        int n11;
        int n12;
        int n13;
        canvas.save();
        int n14 = recyclerView.getClipToPadding();
        int n15 = 0;
        if (n14 != 0) {
            n14 = recyclerView.getPaddingLeft();
            n13 = recyclerView.getWidth();
            n12 = recyclerView.getPaddingRight();
            n13 -= n12;
            n12 = recyclerView.getPaddingTop();
            n11 = recyclerView.getHeight();
            n10 = recyclerView.getPaddingBottom();
            canvas.clipRect(n14, n12, n13, n11 -= n10);
        } else {
            n13 = recyclerView.getWidth();
            n14 = 0;
        }
        n12 = recyclerView.getChildCount();
        while (n15 < n12) {
            View view = recyclerView.getChildAt(n15);
            Rect rect = this.mBounds;
            recyclerView.getDecoratedBoundsWithMargins(view, rect);
            rect = this.mBounds;
            n10 = rect.bottom;
            float f10 = view.getTranslationY();
            n11 = Math.round(f10);
            n10 += n11;
            n11 = this.mDivider.getIntrinsicHeight();
            n11 = n10 - n11;
            Drawable drawable2 = this.mDivider;
            drawable2.setBounds(n14, n11, n13, n10);
            view = this.mDivider;
            view.draw(canvas);
            ++n15;
        }
        canvas.restore();
    }

    public Drawable getDrawable() {
        return this.mDivider;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$State recyclerView$State) {
        view = this.mDivider;
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return;
        }
        int n10 = this.mOrientation;
        int n11 = 1;
        if (n10 == n11) {
            int n12 = view.getIntrinsicHeight();
            rect.set(0, 0, 0, n12);
        } else {
            int n13 = view.getIntrinsicWidth();
            rect.set(0, 0, n13, 0);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView$State object) {
        object = recyclerView.getLayoutManager();
        if (object != null && (object = this.mDivider) != null) {
            int n10 = this.mOrientation;
            int n11 = 1;
            if (n10 == n11) {
                this.drawVertical(canvas, recyclerView);
            } else {
                this.drawHorizontal(canvas, recyclerView);
            }
        }
    }

    public void setDrawable(Drawable object) {
        if (object != null) {
            this.mDivider = object;
            return;
        }
        object = new IllegalArgumentException("Drawable cannot be null.");
        throw object;
    }

    public void setOrientation(int n10) {
        int n11;
        if (n10 != 0 && n10 != (n11 = 1)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
            throw illegalArgumentException;
        }
        this.mOrientation = n10;
    }
}

