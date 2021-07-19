/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 */
package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.cardview.widget.CardViewBaseImpl$1;
import androidx.cardview.widget.CardViewDelegate;
import androidx.cardview.widget.CardViewImpl;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

public class CardViewBaseImpl
implements CardViewImpl {
    public final RectF mCornerRect;

    public CardViewBaseImpl() {
        RectF rectF;
        this.mCornerRect = rectF = new RectF();
    }

    private RoundRectDrawableWithShadow createBackground(Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        Resources resources = context.getResources();
        RoundRectDrawableWithShadow roundRectDrawableWithShadow = new RoundRectDrawableWithShadow(resources, colorStateList, f10, f11, f12);
        return roundRectDrawableWithShadow;
    }

    private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow)cardViewDelegate.getCardBackground();
    }

    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        return this.getShadowBackground(cardViewDelegate).getColor();
    }

    public float getElevation(CardViewDelegate cardViewDelegate) {
        return this.getShadowBackground(cardViewDelegate).getShadowSize();
    }

    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return this.getShadowBackground(cardViewDelegate).getMaxShadowSize();
    }

    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return this.getShadowBackground(cardViewDelegate).getMinHeight();
    }

    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return this.getShadowBackground(cardViewDelegate).getMinWidth();
    }

    public float getRadius(CardViewDelegate cardViewDelegate) {
        return this.getShadowBackground(cardViewDelegate).getCornerRadius();
    }

    public void initStatic() {
        CardViewBaseImpl$1 cardViewBaseImpl$1 = new CardViewBaseImpl$1(this);
        RoundRectDrawableWithShadow.sRoundRectHelper = cardViewBaseImpl$1;
    }

    public void initialize(CardViewDelegate cardViewDelegate, Context object, ColorStateList colorStateList, float f10, float f11, float f12) {
        object = this.createBackground((Context)object, colorStateList, f10, f11, f12);
        boolean bl2 = cardViewDelegate.getPreventCornerOverlap();
        ((RoundRectDrawableWithShadow)((Object)object)).setAddPaddingForCorners(bl2);
        cardViewDelegate.setCardBackground((Drawable)object);
        this.updatePadding(cardViewDelegate);
    }

    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        RoundRectDrawableWithShadow roundRectDrawableWithShadow = this.getShadowBackground(cardViewDelegate);
        boolean bl2 = cardViewDelegate.getPreventCornerOverlap();
        roundRectDrawableWithShadow.setAddPaddingForCorners(bl2);
        this.updatePadding(cardViewDelegate);
    }

    public void setBackgroundColor(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        this.getShadowBackground(cardViewDelegate).setColor(colorStateList);
    }

    public void setElevation(CardViewDelegate cardViewDelegate, float f10) {
        this.getShadowBackground(cardViewDelegate).setShadowSize(f10);
    }

    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f10) {
        this.getShadowBackground(cardViewDelegate).setMaxShadowSize(f10);
        this.updatePadding(cardViewDelegate);
    }

    public void setRadius(CardViewDelegate cardViewDelegate, float f10) {
        this.getShadowBackground(cardViewDelegate).setCornerRadius(f10);
        this.updatePadding(cardViewDelegate);
    }

    public void updatePadding(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        this.getShadowBackground(cardViewDelegate).getMaxShadowAndCornerPadding(rect);
        int n10 = (int)Math.ceil(this.getMinWidth(cardViewDelegate));
        int n11 = (int)Math.ceil(this.getMinHeight(cardViewDelegate));
        cardViewDelegate.setMinWidthHeightInternal(n10, n11);
        n10 = rect.left;
        n11 = rect.top;
        int n12 = rect.right;
        int n13 = rect.bottom;
        cardViewDelegate.setShadowPadding(n10, n11, n12, n13);
    }
}

