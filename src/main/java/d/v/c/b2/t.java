/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.view.View
 */
package d.v.c.b2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$State;
import d.v.e.l.h2;
import d.v.e.l.o1;

public class t
extends RecyclerView$ItemDecoration {
    private static final int[] e;
    private Paint a;
    private Drawable b;
    private int c = 2;
    private int d;

    static {
        int[] nArray = new int[]{16843284};
        e = nArray;
    }

    public t(Context object, int n10) {
        int n11 = 1;
        if (n10 != n11 && n10 != 0) {
            super("\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u53c2\u6570\uff01");
            throw object;
        }
        this.d = n10;
        Object object2 = e;
        object = object.obtainStyledAttributes(object2);
        object2 = object.getDrawable(0);
        this.b = (Drawable)object2;
        object.recycle();
    }

    public t(Context context, int n10, int n11) {
        this(context, n10);
        int n12;
        context = o1.m(context, n11);
        this.b = context;
        this.c = n12 = context.getIntrinsicHeight();
    }

    public t(Context context, int n10, int n11, int n12) {
        this(context, n10);
        this.c = n11;
        super(1);
        this.a = context;
        context.setColor(n12);
        context = this.a;
        Paint.Style style2 = Paint.Style.FILL;
        context.setStyle(style2);
    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int n10 = recyclerView.getPaddingLeft();
        int n11 = recyclerView.getMeasuredWidth();
        int n12 = recyclerView.getPaddingRight();
        n11 -= n12;
        n12 = recyclerView.getChildCount();
        for (int i10 = 0; i10 < n12; ++i10) {
            Paint paint;
            View view = recyclerView.getChildAt(i10);
            RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
            int n13 = view.getBottom();
            int n14 = recyclerView$LayoutParams.bottomMargin;
            n13 += n14;
            n14 = this.c + n13;
            Drawable drawable2 = this.b;
            if (drawable2 != null) {
                drawable2.setBounds(n10, n13, n11, n14);
                drawable2 = this.b;
                drawable2.draw(canvas);
            }
            if ((paint = this.a) == null) continue;
            float f10 = n10;
            float f11 = n13;
            float f12 = n11;
            float f13 = n14;
            canvas.drawRect(f10, f11, f12, f13, paint);
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int n10 = recyclerView.getMeasuredHeight() >> 1;
        int n11 = h2.b(1.0f);
        n10 -= n11;
        float f10 = 2.0f;
        n11 = h2.b(f10) + n10;
        int n12 = recyclerView.getChildCount();
        for (int i10 = 0; i10 < n12; ++i10) {
            Paint paint;
            View view = recyclerView.getChildAt(i10);
            RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
            int n13 = view.getRight();
            int n14 = recyclerView$LayoutParams.rightMargin;
            n13 += n14;
            n14 = this.c + n13;
            Drawable drawable2 = this.b;
            if (drawable2 != null) {
                drawable2.setBounds(n13, n10, n14, n11);
                drawable2 = this.b;
                drawable2.draw(canvas);
            }
            if ((paint = this.a) == null) continue;
            float f11 = n13;
            float f12 = n10;
            float f13 = n14;
            float f14 = n11;
            canvas.drawRect(f11, f12, f13, f14, paint);
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$State recyclerView$State) {
        super.getItemOffsets(rect, view, recyclerView, recyclerView$State);
        int n10 = this.c;
        rect.set(0, 0, 0, n10);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView$State recyclerView$State) {
        super.onDraw(canvas, recyclerView, recyclerView$State);
        int n10 = this.d;
        int n11 = 1;
        if (n10 == n11) {
            this.drawVertical(canvas, recyclerView);
        } else {
            this.drawHorizontal(canvas, recyclerView);
        }
    }
}

