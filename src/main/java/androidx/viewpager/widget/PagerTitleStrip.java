/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.DataSetObserver
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils$TruncateAt
 *  android.text.method.TransformationMethod
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package androidx.viewpager.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.PagerTitleStrip$PageListener;
import androidx.viewpager.widget.PagerTitleStrip$SingleLineAllCapsTransform;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class PagerTitleStrip
extends ViewGroup {
    private static final int[] ATTRS;
    private static final float SIDE_ALPHA = 0.6f;
    private static final int[] TEXT_ATTRS;
    private static final int TEXT_SPACING = 16;
    public TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage = -1;
    public float mLastKnownPositionOffset = -1.0f;
    public TextView mNextText;
    private int mNonPrimaryAlpha;
    private final PagerTitleStrip$PageListener mPageListener;
    public ViewPager mPager;
    public TextView mPrevText;
    private int mScaledTextSpacing;
    public int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private WeakReference mWatchingAdapter;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[4];
        int[] nArray3 = nArray;
        nArray2[0] = 16842804;
        nArray3[1] = 16842901;
        nArray2[2] = 16842904;
        nArray3[3] = 16842927;
        ATTRS = nArray;
        nArray = new int[]{16843660};
        TEXT_ATTRS = nArray;
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    public PagerTitleStrip(Context context, AttributeSet object) {
        super(context, object);
        int n10;
        int n11;
        TextView textView;
        Object object2 = new PagerTitleStrip$PageListener(this);
        this.mPageListener = object2;
        super(context);
        this.mPrevText = object2;
        this.addView((View)object2);
        super(context);
        this.mCurrText = object2;
        this.addView((View)object2);
        super(context);
        this.mNextText = object2;
        this.addView((View)object2);
        object2 = ATTRS;
        object = context.obtainStyledAttributes(object, (int[])object2);
        boolean bl2 = false;
        object2 = null;
        int n12 = object.getResourceId(0, 0);
        if (n12 != 0) {
            TextViewCompat.setTextAppearance(this.mPrevText, n12);
            TextViewCompat.setTextAppearance(this.mCurrText, n12);
            textView = this.mNextText;
            TextViewCompat.setTextAppearance(textView, n12);
        }
        float f10 = Float.MIN_VALUE;
        int n13 = object.getDimensionPixelSize(1, 0);
        if (n13 != 0) {
            f10 = n13;
            this.setTextSize(0, f10);
        }
        n13 = 2;
        f10 = 2.8E-45f;
        int n14 = object.hasValue(n13);
        if (n14 != 0) {
            n13 = object.getColor(n13, 0);
            this.mPrevText.setTextColor(n13);
            this.mCurrText.setTextColor(n13);
            TextView textView2 = this.mNextText;
            textView2.setTextColor(n13);
        }
        f10 = 4.2E-45f;
        n14 = 80;
        this.mGravity = n13 = object.getInteger(3, n14);
        object.recycle();
        this.mTextColor = n11 = this.mCurrText.getTextColors().getDefaultColor();
        n11 = 1058642330;
        float f11 = 0.6f;
        this.setNonPrimaryAlpha(f11);
        object = this.mPrevText;
        textView = TextUtils.TruncateAt.END;
        object.setEllipsize((TextUtils.TruncateAt)textView);
        object = this.mCurrText;
        textView = TextUtils.TruncateAt.END;
        object.setEllipsize((TextUtils.TruncateAt)textView);
        object = this.mNextText;
        textView = TextUtils.TruncateAt.END;
        object.setEllipsize((TextUtils.TruncateAt)textView);
        if (n12 != 0) {
            object = TEXT_ATTRS;
            object = context.obtainStyledAttributes(n12, (int[])object);
            bl2 = object.getBoolean(0, false);
            object.recycle();
        }
        if (bl2) {
            PagerTitleStrip.setSingleLineAllCaps(this.mPrevText);
            PagerTitleStrip.setSingleLineAllCaps(this.mCurrText);
            object = this.mNextText;
            PagerTitleStrip.setSingleLineAllCaps((TextView)object);
        } else {
            this.mPrevText.setSingleLine();
            this.mCurrText.setSingleLine();
            object = this.mNextText;
            object.setSingleLine();
        }
        this.mScaledTextSpacing = n10 = (int)(context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        Context context = textView.getContext();
        PagerTitleStrip$SingleLineAllCapsTransform pagerTitleStrip$SingleLineAllCapsTransform = new PagerTitleStrip$SingleLineAllCapsTransform(context);
        textView.setTransformationMethod((TransformationMethod)pagerTitleStrip$SingleLineAllCapsTransform);
    }

    public int getMinHeight() {
        int n10;
        Drawable drawable2 = this.getBackground();
        if (drawable2 != null) {
            n10 = drawable2.getIntrinsicHeight();
        } else {
            n10 = 0;
            drawable2 = null;
        }
        return n10;
    }

    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object object = this.getParent();
        boolean bl2 = object instanceof ViewPager;
        if (bl2) {
            object = (ViewPager)((Object)object);
            PagerAdapter pagerAdapter = ((ViewPager)((Object)object)).getAdapter();
            PagerTitleStrip$PageListener pagerTitleStrip$PageListener = this.mPageListener;
            ((ViewPager)((Object)object)).setInternalPageChangeListener(pagerTitleStrip$PageListener);
            pagerTitleStrip$PageListener = this.mPageListener;
            ((ViewPager)((Object)object)).addOnAdapterChangeListener(pagerTitleStrip$PageListener);
            this.mPager = object;
            object = this.mWatchingAdapter;
            object = object != null ? (PagerAdapter)((Reference)object).get() : null;
            this.updateAdapter((PagerAdapter)object, pagerAdapter);
            return;
        }
        object = new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        throw object;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Object object = this.mPager;
        if (object != null) {
            object = ((ViewPager)((Object)object)).getAdapter();
            this.updateAdapter((PagerAdapter)object, null);
            this.mPager.setInternalPageChangeListener(null);
            object = this.mPager;
            PagerTitleStrip$PageListener pagerTitleStrip$PageListener = this.mPageListener;
            ((ViewPager)((Object)object)).removeOnAdapterChangeListener(pagerTitleStrip$PageListener);
            this.mPager = null;
        }
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            float f10 = this.mLastKnownPositionOffset;
            n10 = 0;
            float f11 = f10 - 0.0f;
            n11 = (int)(f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1));
            if (n11 < 0) {
                viewPager = null;
                f10 = 0.0f;
            }
            n10 = this.mLastKnownCurrentPage;
            n11 = 1;
            this.updateTextPositions(n10, f10, n11 != 0);
        }
    }

    public void onMeasure(int n10, int n11) {
        int n12;
        int n13 = View.MeasureSpec.getMode((int)n10);
        if (n13 == (n12 = 0x40000000)) {
            n13 = this.getPaddingTop();
            int n14 = this.getPaddingBottom();
            n13 += n14;
            n14 = -2;
            int n15 = ViewGroup.getChildMeasureSpec((int)n11, (int)n13, (int)n14);
            int n16 = View.MeasureSpec.getSize((int)n10);
            float f10 = n16;
            float f11 = 0.2f;
            int n17 = (int)(f10 *= f11);
            n10 = ViewGroup.getChildMeasureSpec((int)n10, (int)n17, (int)n14);
            this.mPrevText.measure(n10, n15);
            this.mCurrText.measure(n10, n15);
            TextView textView = this.mNextText;
            textView.measure(n10, n15);
            n10 = View.MeasureSpec.getMode((int)n11);
            if (n10 == n12) {
                n10 = View.MeasureSpec.getSize((int)n11);
            } else {
                TextView textView2 = this.mCurrText;
                n10 = textView2.getMeasuredHeight();
                n12 = this.getMinHeight();
                n10 += n13;
                n10 = Math.max(n12, n10);
            }
            n13 = this.mCurrText.getMeasuredState() << 16;
            n10 = View.resolveSizeAndState((int)n10, (int)n11, (int)n13);
            this.setMeasuredDimension(n16, n10);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Must measure with an exact width");
        throw illegalStateException;
    }

    public void requestLayout() {
        boolean bl2 = this.mUpdatingText;
        if (!bl2) {
            super.requestLayout();
        }
    }

    public void setGravity(int n10) {
        this.mGravity = n10;
        this.requestLayout();
    }

    public void setNonPrimaryAlpha(float f10) {
        int n10;
        this.mNonPrimaryAlpha = n10 = (int)(f10 * 255.0f) & 0xFF;
        n10 <<= 24;
        int n11 = this.mTextColor & 0xFFFFFF;
        this.mPrevText.setTextColor(n10 |= n11);
        this.mNextText.setTextColor(n10);
    }

    public void setTextColor(int n10) {
        this.mTextColor = n10;
        this.mCurrText.setTextColor(n10);
        n10 = this.mNonPrimaryAlpha << 24;
        int n11 = this.mTextColor & 0xFFFFFF;
        this.mPrevText.setTextColor(n10 |= n11);
        this.mNextText.setTextColor(n10);
    }

    public void setTextSize(int n10, float f10) {
        this.mPrevText.setTextSize(n10, f10);
        this.mCurrText.setTextSize(n10, f10);
        this.mNextText.setTextSize(n10, f10);
    }

    public void setTextSpacing(int n10) {
        this.mScaledTextSpacing = n10;
        this.requestLayout();
    }

    public void updateAdapter(PagerAdapter object, PagerAdapter pagerAdapter) {
        int n10;
        if (object != null) {
            PagerTitleStrip$PageListener pagerTitleStrip$PageListener = this.mPageListener;
            ((PagerAdapter)object).unregisterDataSetObserver(pagerTitleStrip$PageListener);
            n10 = 0;
            object = null;
            this.mWatchingAdapter = null;
        }
        if (pagerAdapter != null) {
            object = this.mPageListener;
            pagerAdapter.registerDataSetObserver((DataSetObserver)object);
            object = new WeakReference(pagerAdapter);
            this.mWatchingAdapter = object;
        }
        if ((object = this.mPager) != null) {
            float f10;
            this.mLastKnownCurrentPage = -1;
            this.mLastKnownPositionOffset = f10 = -1.0f;
            n10 = ((ViewPager)((Object)object)).getCurrentItem();
            this.updateText(n10, pagerAdapter);
            this.requestLayout();
        }
    }

    public void updateText(int n10, PagerAdapter pagerAdapter) {
        CharSequence charSequence;
        int n11;
        int n12 = pagerAdapter != null ? pagerAdapter.getCount() : 0;
        this.mUpdatingText = n11 = 1;
        int n13 = 0;
        CharSequence charSequence2 = null;
        if (n10 >= n11 && pagerAdapter != null) {
            n11 = n10 + -1;
            charSequence = pagerAdapter.getPageTitle(n11);
        } else {
            n11 = 0;
            charSequence = null;
        }
        Object object = this.mPrevText;
        object.setText(charSequence);
        charSequence = this.mCurrText;
        object = pagerAdapter != null && n10 < n12 ? pagerAdapter.getPageTitle(n10) : null;
        charSequence.setText((CharSequence)object);
        n11 = n10 + 1;
        if (n11 < n12 && pagerAdapter != null) {
            charSequence2 = pagerAdapter.getPageTitle(n11);
        }
        pagerAdapter = this.mNextText;
        pagerAdapter.setText(charSequence2);
        int n14 = this.getWidth();
        n12 = this.getPaddingLeft();
        n14 -= n12;
        n12 = this.getPaddingRight();
        float f10 = (float)(n14 - n12) * 0.8f;
        n14 = (int)f10;
        n14 = Math.max(0, n14);
        n12 = -1 << -1;
        n14 = View.MeasureSpec.makeMeasureSpec((int)n14, (int)n12);
        n11 = this.getHeight();
        n13 = this.getPaddingTop();
        n11 -= n13;
        n13 = this.getPaddingBottom();
        n11 -= n13;
        n11 = Math.max(0, n11);
        n12 = View.MeasureSpec.makeMeasureSpec((int)n11, (int)n12);
        this.mPrevText.measure(n14, n12);
        this.mCurrText.measure(n14, n12);
        charSequence = this.mNextText;
        charSequence.measure(n14, n12);
        this.mLastKnownCurrentPage = n10;
        n14 = (int)(this.mUpdatingPositions ? 1 : 0);
        if (n14 == 0) {
            f10 = this.mLastKnownPositionOffset;
            this.updateTextPositions(n10, f10, false);
        }
        this.mUpdatingText = false;
    }

    public void updateTextPositions(int n10, float f10, boolean bl2) {
        int n11;
        TextView textView;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        int n17;
        int n18;
        int n19;
        int n20;
        TextView textView2;
        float f11;
        int n21;
        int n22;
        PagerTitleStrip pagerTitleStrip;
        block6: {
            int n23;
            block7: {
                int n24;
                block4: {
                    block5: {
                        float f12;
                        PagerAdapter pagerAdapter;
                        pagerTitleStrip = this;
                        n22 = n10;
                        float f13 = f10;
                        n21 = this.mLastKnownCurrentPage;
                        if (n10 != n21) {
                            pagerAdapter = this.mPager.getAdapter();
                            this.updateText(n10, pagerAdapter);
                        } else if (!bl2 && (n22 = (int)((f12 = f10 - (f11 = this.mLastKnownPositionOffset)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) == 0) {
                            return;
                        }
                        f11 = Float.MIN_VALUE;
                        pagerTitleStrip.mUpdatingPositions = true;
                        TextView textView3 = pagerTitleStrip.mPrevText;
                        n22 = textView3.getMeasuredWidth();
                        pagerAdapter = pagerTitleStrip.mCurrText;
                        n21 = pagerAdapter.getMeasuredWidth();
                        textView2 = pagerTitleStrip.mNextText;
                        n20 = textView2.getMeasuredWidth();
                        n19 = n21 / 2;
                        n18 = this.getWidth();
                        n17 = this.getHeight();
                        n16 = this.getPaddingLeft();
                        n15 = this.getPaddingRight();
                        n14 = this.getPaddingTop();
                        n24 = this.getPaddingBottom();
                        n13 = n16 + n19;
                        n12 = n15 + n19;
                        n13 = n18 - n13 - n12;
                        int n25 = 0x3F000000;
                        float f14 = 0.5f + f13;
                        n23 = 1065353216;
                        float f15 = 1.0f;
                        float f16 = f14 == f15 ? 0 : (f14 > f15 ? 1 : -1);
                        if (f16 > 0) {
                            f14 -= f15;
                        }
                        n12 = n18 - n12;
                        float f17 = (float)n13 * f14;
                        n13 = (int)f17;
                        n12 = n12 - n13 - n19;
                        n21 += n12;
                        TextView textView4 = pagerTitleStrip.mPrevText;
                        n19 = textView4.getBaseline();
                        TextView textView5 = pagerTitleStrip.mCurrText;
                        n13 = textView5.getBaseline();
                        n25 = pagerTitleStrip.mNextText.getBaseline();
                        n23 = Math.max(Math.max(n19, n13), n25);
                        n19 = n23 - n19;
                        n13 = n23 - n13;
                        n23 -= n25;
                        TextView textView6 = pagerTitleStrip.mPrevText;
                        n25 = textView6.getMeasuredHeight() + n19;
                        textView = pagerTitleStrip.mCurrText;
                        n11 = textView.getMeasuredHeight() + n13;
                        n10 = n20;
                        textView2 = pagerTitleStrip.mNextText;
                        n20 = textView2.getMeasuredHeight() + n23;
                        n11 = Math.max(Math.max(n25, n11), n20);
                        n20 = pagerTitleStrip.mGravity & 0x70;
                        n25 = 16;
                        f14 = 2.24E-44f;
                        if (n20 == n25) break block4;
                        n25 = 80;
                        f14 = 1.12E-43f;
                        if (n20 == n25) break block5;
                        n19 += n14;
                        n13 += n14;
                        n14 += n23;
                        break block6;
                    }
                    n17 = n17 - n24 - n11;
                    break block7;
                }
                n17 = (n17 - n14 - n24 - n11) / 2;
            }
            n19 += n17;
            n13 += n17;
            n14 = n17 + n23;
        }
        textView = pagerTitleStrip.mCurrText;
        n20 = textView.getMeasuredHeight() + n13;
        textView.layout(n12, n13, n21, n20);
        n11 = pagerTitleStrip.mScaledTextSpacing;
        n12 = n12 - n11 - n22;
        n11 = Math.min(n16, n12);
        textView2 = pagerTitleStrip.mPrevText;
        n17 = textView2.getMeasuredHeight() + n19;
        textView2.layout(n11, n19, n22 += n11, n17);
        n18 = n18 - n15 - n10;
        n22 = pagerTitleStrip.mScaledTextSpacing;
        n21 += n22;
        n22 = Math.max(n18, n21);
        textView = pagerTitleStrip.mNextText;
        n20 = n22 + n10;
        n21 = textView.getMeasuredHeight() + n14;
        textView.layout(n22, n14, n20, n21);
        f11 = f10;
        pagerTitleStrip.mLastKnownPositionOffset = f10;
        pagerTitleStrip.mUpdatingPositions = false;
    }
}

