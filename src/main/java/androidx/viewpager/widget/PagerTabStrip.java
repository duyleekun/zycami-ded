/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View$OnClickListener
 *  android.view.ViewConfiguration
 *  android.widget.TextView
 */
package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager.widget.ViewPager;

public class PagerTabStrip
extends PagerTitleStrip {
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        int bl2;
        int n11;
        Object object;
        super();
        this.mTabPaint = attributeSet;
        this.mTempRect = object = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        this.mIndicatorColor = n11 = this.mTextColor;
        attributeSet.setColor(n11);
        attributeSet = context.getResources().getDisplayMetrics();
        float f10 = attributeSet.density;
        float f11 = 3.0f * f10;
        float f12 = 0.5f;
        this.mIndicatorHeight = n11 = (int)(f11 + f12);
        this.mMinPaddingBottom = n11 = (int)(6.0f * f10 + f12);
        this.mMinTextSpacing = n11 = (int)(64.0f * f10);
        this.mTabPadding = n11 = (int)(16.0f * f10 + f12);
        this.mFullUnderlineHeight = n11 = (int)(1.0f * f10 + f12);
        f11 = 32.0f;
        this.mMinStripHeight = bl2 = (int)(f10 * f11 + f12);
        this.mTouchSlop = n10 = ViewConfiguration.get((Context)context).getScaledTouchSlop();
        n10 = this.getPaddingLeft();
        int n12 = this.getPaddingTop();
        n11 = this.getPaddingRight();
        int n13 = this.getPaddingBottom();
        this.setPadding(n10, n12, n11, n13);
        n10 = this.getTextSpacing();
        this.setTextSpacing(n10);
        this.setWillNotDraw(false);
        context = this.mPrevText;
        boolean bl3 = true;
        f10 = Float.MIN_VALUE;
        context.setFocusable(bl3);
        context = this.mPrevText;
        super(this);
        context.setOnClickListener((View.OnClickListener)object);
        this.mNextText.setFocusable(bl3);
        context = this.mNextText;
        super(this);
        context.setOnClickListener((View.OnClickListener)object);
        context = this.getBackground();
        if (context == null) {
            this.mDrawFullUnderline = bl3;
        }
    }

    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }

    public int getMinHeight() {
        int n10 = super.getMinHeight();
        int n11 = this.mMinStripHeight;
        return Math.max(n10, n11);
    }

    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int n10 = this.getHeight();
        TextView textView = this.mCurrText;
        int n11 = textView.getLeft();
        int n12 = this.mTabPadding;
        n11 -= n12;
        TextView textView2 = this.mCurrText;
        n12 = textView2.getRight();
        int n13 = this.mTabPadding;
        n12 += n13;
        n13 = this.mIndicatorHeight;
        n13 = n10 - n13;
        Paint paint = this.mTabPaint;
        int n14 = this.mTabAlpha << 24;
        int n15 = this.mIndicatorColor;
        int n16 = 0xFFFFFF;
        paint.setColor(n14 |= (n15 &= n16));
        float f10 = n11;
        float f11 = n13;
        float f12 = n12;
        float f13 = n10;
        Paint paint2 = this.mTabPaint;
        canvas.drawRect(f10, f11, f12, f13, paint2);
        n11 = (int)(this.mDrawFullUnderline ? 1 : 0);
        if (n11 != 0) {
            textView = this.mTabPaint;
            n13 = this.mIndicatorColor & n16;
            n12 = 0xFF000000 | n13;
            textView.setColor(n12);
            float f14 = this.getPaddingLeft();
            n11 = this.mFullUnderlineHeight;
            float f15 = n10 - n11;
            n10 = this.getWidth();
            n11 = this.getPaddingRight();
            float f16 = n10 -= n11;
            Paint paint3 = this.mTabPaint;
            textView = canvas;
            canvas.drawRect(f14, f15, f16, f13, paint3);
        }
    }

    public boolean onTouchEvent(MotionEvent object) {
        int n10;
        block8: {
            float f10;
            float f11;
            block6: {
                int n11;
                block7: {
                    block9: {
                        boolean bl2;
                        n11 = object.getAction();
                        int n12 = 0;
                        float f12 = 0.0f;
                        if (n11 != 0 && (bl2 = this.mIgnoreTap)) {
                            return false;
                        }
                        f11 = object.getX();
                        f10 = object.getY();
                        n10 = 1;
                        if (n11 == 0) break block6;
                        if (n11 == n10) break block7;
                        n12 = 2;
                        f12 = 2.8E-45f;
                        if (n11 != n12) break block8;
                        float f13 = this.mInitialMotionX;
                        float f14 = (f13 = Math.abs(f11 -= f13)) - (f12 = (float)(n12 = this.mTouchSlop));
                        n11 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
                        if (n11 > 0) break block9;
                        f13 = this.mInitialMotionY;
                        float f15 = (f10 = Math.abs(f10 - f13)) - (f13 = (float)(n11 = this.mTouchSlop));
                        Object object2 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
                        if (object2 <= 0) break block8;
                    }
                    this.mIgnoreTap = n10;
                    break block8;
                }
                object = this.mCurrText;
                int n13 = object.getLeft();
                n11 = this.mTabPadding;
                f10 = n13 - n11;
                float f16 = f11 - f10;
                if ((n13 = (int)(f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1))) < 0) {
                    object = this.mPager;
                    n11 = ((ViewPager)((Object)object)).getCurrentItem() - n10;
                    ((ViewPager)((Object)object)).setCurrentItem(n11);
                } else {
                    object = this.mCurrText;
                    n13 = object.getRight();
                    n11 = this.mTabPadding;
                    f10 = n13 + n11;
                    float f17 = f11 - f10;
                    if ((n13 = (int)(f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1))) > 0) {
                        object = this.mPager;
                        n11 = ((ViewPager)((Object)object)).getCurrentItem() + n10;
                        ((ViewPager)((Object)object)).setCurrentItem(n11);
                    }
                }
                break block8;
            }
            this.mInitialMotionX = f11;
            this.mInitialMotionY = f10;
            this.mIgnoreTap = false;
        }
        return n10 != 0;
    }

    public void setBackgroundColor(int n10) {
        super.setBackgroundColor(n10);
        int n11 = this.mDrawFullUnderlineSet;
        if (n11 == 0) {
            n11 = -16777216;
            n10 = (n10 &= n11) == 0 ? 1 : 0;
            this.mDrawFullUnderline = n10;
        }
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        super.setBackgroundDrawable(drawable2);
        boolean bl2 = this.mDrawFullUnderlineSet;
        if (!bl2) {
            boolean bl3;
            if (drawable2 == null) {
                bl3 = true;
            } else {
                bl3 = false;
                drawable2 = null;
            }
            this.mDrawFullUnderline = bl3;
        }
    }

    public void setBackgroundResource(int n10) {
        super.setBackgroundResource(n10);
        boolean bl2 = this.mDrawFullUnderlineSet;
        if (!bl2) {
            n10 = n10 == 0 ? 1 : 0;
            this.mDrawFullUnderline = n10;
        }
    }

    public void setDrawFullUnderline(boolean bl2) {
        this.mDrawFullUnderline = bl2;
        this.mDrawFullUnderlineSet = true;
        this.invalidate();
    }

    public void setPadding(int n10, int n11, int n12, int n13) {
        int n14 = this.mMinPaddingBottom;
        if (n13 < n14) {
            n13 = n14;
        }
        super.setPadding(n10, n11, n12, n13);
    }

    public void setTabIndicatorColor(int n10) {
        this.mIndicatorColor = n10;
        this.mTabPaint.setColor(n10);
        this.invalidate();
    }

    public void setTabIndicatorColorResource(int n10) {
        n10 = ContextCompat.getColor(this.getContext(), n10);
        this.setTabIndicatorColor(n10);
    }

    public void setTextSpacing(int n10) {
        int n11 = this.mMinTextSpacing;
        if (n10 < n11) {
            n10 = n11;
        }
        super.setTextSpacing(n10);
    }

    public void updateTextPositions(int n10, float f10, boolean bl2) {
        Rect rect = this.mTempRect;
        int n11 = this.getHeight();
        int n12 = this.mCurrText.getLeft();
        int n13 = this.mTabPadding;
        n12 -= n13;
        n13 = this.mCurrText.getRight();
        int n14 = this.mTabPadding;
        n13 += n14;
        n14 = this.mIndicatorHeight;
        n14 = n11 - n14;
        rect.set(n12, n14, n13, n11);
        super.updateTextPositions(n10, f10, bl2);
        this.mTabAlpha = n10 = (int)(Math.abs(f10 - 0.5f) * 2.0f * 255.0f);
        n10 = this.mCurrText.getLeft();
        int n15 = this.mTabPadding;
        n10 -= n15;
        n15 = this.mCurrText.getRight();
        int n16 = this.mTabPadding;
        rect.union(n10, n14, n15 += n16, n11);
        this.invalidate(rect);
    }
}

