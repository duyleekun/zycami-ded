/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.View
 */
package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R$styleable;

public class MockView
extends View {
    private int mDiagonalsColor;
    private boolean mDrawDiagonals;
    private boolean mDrawLabel;
    private int mMargin;
    private Paint mPaintDiagonals;
    private Paint mPaintText;
    private Paint mPaintTextBackground;
    public String mText;
    private int mTextBackgroundColor;
    private Rect mTextBounds;
    private int mTextColor;

    public MockView(Context context) {
        super(context);
        int n10;
        Rect rect;
        boolean bl2;
        Paint paint;
        this.mPaintDiagonals = paint = new Paint();
        this.mPaintText = paint = new Paint();
        this.mPaintTextBackground = paint = new Paint();
        this.mDrawDiagonals = bl2 = true;
        this.mDrawLabel = bl2;
        this.mText = null;
        this.mTextBounds = rect = new Rect();
        int n11 = 255;
        this.mDiagonalsColor = n10 = Color.argb((int)n11, (int)0, (int)0, (int)0);
        n10 = 200;
        this.mTextColor = n10 = Color.argb((int)n11, (int)n10, (int)n10, (int)n10);
        n10 = 50;
        this.mTextBackgroundColor = n11 = Color.argb((int)n11, (int)n10, (int)n10, (int)n10);
        this.mMargin = 4;
        this.init(context, null);
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        int n11;
        Paint paint;
        this.mPaintDiagonals = paint = new Paint();
        this.mPaintText = paint = new Paint();
        this.mPaintTextBackground = paint = new Paint();
        this.mDrawDiagonals = n11 = 1;
        this.mDrawLabel = n11;
        this.mText = null;
        super();
        this.mTextBounds = paint;
        n11 = 255;
        this.mDiagonalsColor = n10 = Color.argb((int)n11, (int)0, (int)0, (int)0);
        n10 = 200;
        this.mTextColor = n10 = Color.argb((int)n11, (int)n10, (int)n10, (int)n10);
        n10 = 50;
        this.mTextBackgroundColor = n11 = Color.argb((int)n11, (int)n10, (int)n10, (int)n10);
        this.mMargin = 4;
        this.init(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int n11;
        Paint paint;
        this.mPaintDiagonals = paint = new Paint();
        this.mPaintText = paint = new Paint();
        this.mPaintTextBackground = paint = new Paint();
        n10 = 1;
        this.mDrawDiagonals = n10;
        this.mDrawLabel = n10;
        this.mText = null;
        super();
        this.mTextBounds = paint;
        n10 = 255;
        this.mDiagonalsColor = n11 = Color.argb((int)n10, (int)0, (int)0, (int)0);
        n11 = 200;
        this.mTextColor = n11 = Color.argb((int)n10, (int)n11, (int)n11, (int)n11);
        n11 = 50;
        this.mTextBackgroundColor = n10 = Color.argb((int)n10, (int)n11, (int)n11, (int)n11);
        this.mMargin = 4;
        this.init(context, attributeSet);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void init(Context object, AttributeSet object2) {
        int n10;
        int n11;
        String string2;
        int n12;
        void var2_9;
        if (var2_9 != null) {
            int[] nArray = R$styleable.MockView;
            TypedArray typedArray = object.obtainStyledAttributes((AttributeSet)var2_9, nArray);
            n12 = typedArray.getIndexCount();
            for (int i10 = 0; i10 < n12; ++i10) {
                int n13;
                int n14 = typedArray.getIndex(i10);
                if (n14 == (n13 = R$styleable.MockView_mock_label)) {
                    String string3;
                    this.mText = string3 = typedArray.getString(n14);
                    continue;
                }
                n13 = R$styleable.MockView_mock_showDiagonals;
                if (n14 == n13) {
                    n13 = this.mDrawDiagonals ? 1 : 0;
                    n14 = typedArray.getBoolean(n14, n13 != 0) ? 1 : 0;
                    this.mDrawDiagonals = n14;
                    continue;
                }
                n13 = R$styleable.MockView_mock_diagonalsColor;
                if (n14 == n13) {
                    n13 = this.mDiagonalsColor;
                    this.mDiagonalsColor = n14 = typedArray.getColor(n14, n13);
                    continue;
                }
                n13 = R$styleable.MockView_mock_labelBackgroundColor;
                if (n14 == n13) {
                    n13 = this.mTextBackgroundColor;
                    this.mTextBackgroundColor = n14 = typedArray.getColor(n14, n13);
                    continue;
                }
                n13 = R$styleable.MockView_mock_labelColor;
                if (n14 == n13) {
                    n13 = this.mTextColor;
                    this.mTextColor = n14 = typedArray.getColor(n14, n13);
                    continue;
                }
                n13 = R$styleable.MockView_mock_showLabel;
                if (n14 != n13) continue;
                n13 = this.mDrawLabel ? 1 : 0;
                n14 = typedArray.getBoolean(n14, n13 != 0) ? 1 : 0;
                this.mDrawLabel = n14;
            }
            typedArray.recycle();
        }
        if ((string2 = this.mText) == null) {
            try {
                String string4;
                Resources resources = object.getResources();
                n11 = this.getId();
                this.mText = string4 = resources.getResourceEntryName(n11);
            }
            catch (Exception exception) {}
        }
        Paint paint = this.mPaintDiagonals;
        n11 = this.mDiagonalsColor;
        paint.setColor(n11);
        Paint paint2 = this.mPaintDiagonals;
        n11 = 1;
        paint2.setAntiAlias(n11 != 0);
        Paint paint3 = this.mPaintText;
        n12 = this.mTextColor;
        paint3.setColor(n12);
        this.mPaintText.setAntiAlias(n11 != 0);
        Paint paint4 = this.mPaintTextBackground;
        n11 = this.mTextBackgroundColor;
        paint4.setColor(n11);
        float f10 = this.mMargin;
        float f11 = this.getResources().getDisplayMetrics().xdpi / 160.0f;
        this.mMargin = n10 = Math.round(f10 * f11);
    }

    public void onDraw(Canvas canvas) {
        Rect rect;
        int n10;
        int n11;
        String string2;
        int n12;
        Paint paint;
        int n13;
        super.onDraw(canvas);
        int n14 = this.getWidth();
        int n15 = this.getHeight();
        int n16 = this.mDrawDiagonals;
        if (n16 != 0) {
            n13 = 0;
            paint = null;
            n12 = 0;
            float f10 = n14 += -1;
            float f11 = n15 += -1;
            Paint paint2 = this.mPaintDiagonals;
            string2 = canvas;
            canvas.drawLine(0.0f, 0.0f, f10, f11, paint2);
            Paint paint3 = this.mPaintDiagonals;
            canvas.drawLine(0.0f, f11, f10, 0.0f, paint3);
            n11 = 0;
            paint2 = null;
            paint3 = this.mPaintDiagonals;
            canvas.drawLine(0.0f, 0.0f, f10, 0.0f, paint3);
            paint3 = this.mPaintDiagonals;
            canvas.drawLine(f10, 0.0f, f10, f11, paint3);
            paint3 = this.mPaintDiagonals;
            canvas.drawLine(f10, f11, 0.0f, f11, paint3);
            n10 = 0;
            rect = null;
            paint3 = this.mPaintDiagonals;
            canvas.drawLine(0.0f, f11, 0.0f, 0.0f, paint3);
        }
        if ((string2 = this.mText) != null && (n13 = this.mDrawLabel) != 0) {
            paint = this.mPaintText;
            int n17 = string2.length();
            rect = this.mTextBounds;
            paint.getTextBounds(string2, 0, n17, rect);
            n16 = this.mTextBounds.width();
            float f12 = n14 -= n16;
            float f13 = 2.0f;
            f12 /= f13;
            n13 = this.mTextBounds.height();
            float f14 = (float)(n15 -= n13) / f13;
            n16 = this.mTextBounds.height();
            f13 = n16;
            string2 = this.mTextBounds;
            n13 = (int)f12;
            n12 = (int)(f14 += f13);
            string2.offset(n13, n12);
            string2 = this.mTextBounds;
            n13 = ((Rect)string2).left;
            n12 = this.mMargin;
            n17 = ((Rect)string2).top - n12;
            n10 = ((Rect)string2).right + n12;
            n11 = ((Rect)string2).bottom + n12;
            string2.set(n13 -= n12, n17, n10, n11);
            string2 = this.mTextBounds;
            paint = this.mPaintTextBackground;
            canvas.drawRect((Rect)string2, paint);
            string2 = this.mText;
            paint = this.mPaintText;
            canvas.drawText(string2, f12, f14, paint);
        }
    }
}

