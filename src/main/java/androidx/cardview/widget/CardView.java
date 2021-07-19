/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Color
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View$MeasureSpec
 *  android.widget.FrameLayout
 */
package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;
import androidx.cardview.widget.CardView$1;
import androidx.cardview.widget.CardViewApi17Impl;
import androidx.cardview.widget.CardViewApi21Impl;
import androidx.cardview.widget.CardViewBaseImpl;
import androidx.cardview.widget.CardViewDelegate;
import androidx.cardview.widget.CardViewImpl;

public class CardView
extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR;
    private static final CardViewImpl IMPL;
    private final CardViewDelegate mCardViewDelegate;
    private boolean mCompatPadding;
    public final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    public final Rect mShadowBounds;
    public int mUserSetMinHeight;
    public int mUserSetMinWidth;

    static {
        int n10 = 0x1010031;
        Object object = new int[]{n10};
        COLOR_BACKGROUND_ATTR = object;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            object = new CardViewApi21Impl;
            object();
            IMPL = object;
        } else {
            n12 = 17;
            if (n11 >= n12) {
                object = new CardViewApi17Impl;
                object();
                IMPL = object;
            } else {
                object = new CardViewBaseImpl;
                object();
                IMPL = object;
            }
        }
        IMPL.initStatic();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.cardViewStyle;
        this(context, attributeSet, n10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public CardView(Context context, AttributeSet attributeSet, int object) {
        super(context, attributeSet, object);
        int n10;
        int n11;
        void var9_25;
        float f10;
        float f11;
        Rect rect;
        Rect rect2;
        this.mContentPadding = rect2 = new Rect();
        this.mShadowBounds = rect = new Rect();
        CardView$1 cardView$1 = new CardView$1(this);
        this.mCardViewDelegate = cardView$1;
        int[] nArray = R$styleable.CardView;
        int n12 = R$style.CardView;
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray, object, n12);
        int n13 = R$styleable.CardView_cardBackgroundColor;
        int n14 = attributeSet.hasValue(n13);
        n12 = 0;
        if (n14 != 0) {
            ColorStateList colorStateList = attributeSet.getColorStateList(n13);
        } else {
            void var3_5;
            Context context2 = this.getContext();
            int[] nArray2 = COLOR_BACKGROUND_ATTR;
            TypedArray typedArray = context2.obtainStyledAttributes(nArray2);
            n14 = typedArray.getColor(0, 0);
            typedArray.recycle();
            float[] fArray = new float[3];
            Color.colorToHSV((int)n14, (float[])fArray);
            f11 = fArray[2];
            n14 = 0x3F000000;
            f10 = 0.5f;
            float f12 = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
            if (f12 > 0) {
                Resources resources = this.getResources();
                n14 = R$color.cardview_light_background;
                int n15 = resources.getColor(n14);
            } else {
                Resources resources = this.getResources();
                n14 = R$color.cardview_dark_background;
                int n16 = resources.getColor(n14);
            }
            ColorStateList colorStateList = ColorStateList.valueOf((int)var3_5);
        }
        void var10_35 = var9_25;
        int n17 = R$styleable.CardView_cardCornerRadius;
        f10 = 0.0f;
        Object var5_20 = null;
        float f13 = attributeSet.getDimension(n17, 0.0f);
        int n18 = R$styleable.CardView_cardElevation;
        float f14 = attributeSet.getDimension(n18, 0.0f);
        int n19 = R$styleable.CardView_cardMaxElevation;
        f11 = attributeSet.getDimension(n19, 0.0f);
        n14 = R$styleable.CardView_cardUseCompatPadding;
        n14 = attributeSet.getBoolean(n14, false) ? 1 : 0;
        this.mCompatPadding = n14;
        n14 = R$styleable.CardView_cardPreventCornerOverlap;
        n14 = attributeSet.getBoolean(n14, true) ? 1 : 0;
        this.mPreventCornerOverlap = n14;
        n14 = R$styleable.CardView_contentPadding;
        n14 = attributeSet.getDimensionPixelSize(n14, 0);
        int n20 = R$styleable.CardView_contentPaddingLeft;
        rect2.left = n20 = attributeSet.getDimensionPixelSize(n20, n14);
        n20 = R$styleable.CardView_contentPaddingTop;
        rect2.top = n20 = attributeSet.getDimensionPixelSize(n20, n14);
        n20 = R$styleable.CardView_contentPaddingRight;
        rect2.right = n20 = attributeSet.getDimensionPixelSize(n20, n14);
        n20 = R$styleable.CardView_contentPaddingBottom;
        rect2.bottom = n14 = attributeSet.getDimensionPixelSize(n20, n14);
        float f15 = f14 == f11 ? 0 : (f14 > f11 ? 1 : -1);
        float f16 = f15 > 0 ? f14 : f11;
        int n21 = R$styleable.CardView_android_minWidth;
        this.mUserSetMinWidth = n11 = attributeSet.getDimensionPixelSize(n21, 0);
        int n22 = R$styleable.CardView_android_minHeight;
        this.mUserSetMinHeight = n10 = attributeSet.getDimensionPixelSize(n22, 0);
        attributeSet.recycle();
        IMPL.initialize(cardView$1, context, (ColorStateList)var10_35, f13, f14, f16);
    }

    public static /* synthetic */ void access$001(CardView cardView, int n10, int n11, int n12, int n13) {
        super.setPadding(n10, n11, n12, n13);
    }

    public static /* synthetic */ void access$101(CardView cardView, int n10) {
        super.setMinimumWidth(n10);
    }

    public static /* synthetic */ void access$201(CardView cardView, int n10) {
        super.setMinimumHeight(n10);
    }

    public ColorStateList getCardBackgroundColor() {
        CardViewImpl cardViewImpl = IMPL;
        CardViewDelegate cardViewDelegate = this.mCardViewDelegate;
        return cardViewImpl.getBackgroundColor(cardViewDelegate);
    }

    public float getCardElevation() {
        CardViewImpl cardViewImpl = IMPL;
        CardViewDelegate cardViewDelegate = this.mCardViewDelegate;
        return cardViewImpl.getElevation(cardViewDelegate);
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        CardViewImpl cardViewImpl = IMPL;
        CardViewDelegate cardViewDelegate = this.mCardViewDelegate;
        return cardViewImpl.getMaxElevation(cardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        CardViewImpl cardViewImpl = IMPL;
        CardViewDelegate cardViewDelegate = this.mCardViewDelegate;
        return cardViewImpl.getRadius(cardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public void onMeasure(int n10, int n11) {
        CardViewImpl cardViewImpl = IMPL;
        int n12 = cardViewImpl instanceof CardViewApi21Impl;
        if (n12 == 0) {
            n12 = View.MeasureSpec.getMode((int)n10);
            int n13 = 0x40000000;
            int n14 = -1 << -1;
            if (n12 == n14 || n12 == n13) {
                CardViewDelegate cardViewDelegate = this.mCardViewDelegate;
                float f10 = cardViewImpl.getMinWidth(cardViewDelegate);
                double d10 = Math.ceil(f10);
                int n15 = (int)d10;
                n10 = View.MeasureSpec.getSize((int)n10);
                n10 = View.MeasureSpec.makeMeasureSpec((int)Math.max(n15, n10), (int)n12);
            }
            n12 = View.MeasureSpec.getMode((int)n11);
            if (n12 == n14 || n12 == n13) {
                CardViewDelegate cardViewDelegate = this.mCardViewDelegate;
                float f11 = cardViewImpl.getMinHeight(cardViewDelegate);
                double d11 = Math.ceil(f11);
                int n16 = (int)d11;
                n11 = View.MeasureSpec.getSize((int)n11);
                n11 = View.MeasureSpec.makeMeasureSpec((int)Math.max(n16, n11), (int)n12);
            }
            super.onMeasure(n10, n11);
        } else {
            super.onMeasure(n10, n11);
        }
    }

    public void setCardBackgroundColor(int n10) {
        CardViewImpl cardViewImpl = IMPL;
        CardViewDelegate cardViewDelegate = this.mCardViewDelegate;
        ColorStateList colorStateList = ColorStateList.valueOf((int)n10);
        cardViewImpl.setBackgroundColor(cardViewDelegate, colorStateList);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        CardViewImpl cardViewImpl = IMPL;
        CardViewDelegate cardViewDelegate = this.mCardViewDelegate;
        cardViewImpl.setBackgroundColor(cardViewDelegate, colorStateList);
    }

    public void setCardElevation(float f10) {
        CardViewImpl cardViewImpl = IMPL;
        CardViewDelegate cardViewDelegate = this.mCardViewDelegate;
        cardViewImpl.setElevation(cardViewDelegate, f10);
    }

    public void setContentPadding(int n10, int n11, int n12, int n13) {
        this.mContentPadding.set(n10, n11, n12, n13);
        CardViewImpl cardViewImpl = IMPL;
        CardViewDelegate cardViewDelegate = this.mCardViewDelegate;
        cardViewImpl.updatePadding(cardViewDelegate);
    }

    public void setMaxCardElevation(float f10) {
        CardViewImpl cardViewImpl = IMPL;
        CardViewDelegate cardViewDelegate = this.mCardViewDelegate;
        cardViewImpl.setMaxElevation(cardViewDelegate, f10);
    }

    public void setMinimumHeight(int n10) {
        this.mUserSetMinHeight = n10;
        super.setMinimumHeight(n10);
    }

    public void setMinimumWidth(int n10) {
        this.mUserSetMinWidth = n10;
        super.setMinimumWidth(n10);
    }

    public void setPadding(int n10, int n11, int n12, int n13) {
    }

    public void setPaddingRelative(int n10, int n11, int n12, int n13) {
    }

    public void setPreventCornerOverlap(boolean bl2) {
        boolean bl3 = this.mPreventCornerOverlap;
        if (bl2 != bl3) {
            this.mPreventCornerOverlap = bl2;
            CardViewImpl cardViewImpl = IMPL;
            CardViewDelegate cardViewDelegate = this.mCardViewDelegate;
            cardViewImpl.onPreventCornerOverlapChanged(cardViewDelegate);
        }
    }

    public void setRadius(float f10) {
        CardViewImpl cardViewImpl = IMPL;
        CardViewDelegate cardViewDelegate = this.mCardViewDelegate;
        cardViewImpl.setRadius(cardViewDelegate, f10);
    }

    public void setUseCompatPadding(boolean bl2) {
        boolean bl3 = this.mCompatPadding;
        if (bl3 != bl2) {
            this.mCompatPadding = bl2;
            CardViewImpl cardViewImpl = IMPL;
            CardViewDelegate cardViewDelegate = this.mCardViewDelegate;
            cardViewImpl.onCompatPaddingChanged(cardViewDelegate);
        }
    }
}

