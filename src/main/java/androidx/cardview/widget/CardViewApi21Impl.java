/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 */
package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.cardview.widget.CardViewDelegate;
import androidx.cardview.widget.CardViewImpl;
import androidx.cardview.widget.RoundRectDrawable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

public class CardViewApi21Impl
implements CardViewImpl {
    private RoundRectDrawable getCardBackground(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable)cardViewDelegate.getCardBackground();
    }

    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        return this.getCardBackground(cardViewDelegate).getColor();
    }

    public float getElevation(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.getCardView().getElevation();
    }

    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return this.getCardBackground(cardViewDelegate).getPadding();
    }

    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return this.getRadius(cardViewDelegate) * 2.0f;
    }

    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return this.getRadius(cardViewDelegate) * 2.0f;
    }

    public float getRadius(CardViewDelegate cardViewDelegate) {
        return this.getCardBackground(cardViewDelegate).getRadius();
    }

    public void initStatic() {
    }

    public void initialize(CardViewDelegate cardViewDelegate, Context object, ColorStateList colorStateList, float f10, float f11, float f12) {
        object = new RoundRectDrawable(colorStateList, f10);
        cardViewDelegate.setCardBackground((Drawable)object);
        object = cardViewDelegate.getCardView();
        object.setClipToOutline(true);
        object.setElevation(f11);
        this.setMaxElevation(cardViewDelegate, f12);
    }

    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
        float f10 = this.getMaxElevation(cardViewDelegate);
        this.setMaxElevation(cardViewDelegate, f10);
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        float f10 = this.getMaxElevation(cardViewDelegate);
        this.setMaxElevation(cardViewDelegate, f10);
    }

    public void setBackgroundColor(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        this.getCardBackground(cardViewDelegate).setColor(colorStateList);
    }

    public void setElevation(CardViewDelegate cardViewDelegate, float f10) {
        cardViewDelegate.getCardView().setElevation(f10);
    }

    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f10) {
        RoundRectDrawable roundRectDrawable = this.getCardBackground(cardViewDelegate);
        boolean bl2 = cardViewDelegate.getUseCompatPadding();
        boolean bl3 = cardViewDelegate.getPreventCornerOverlap();
        roundRectDrawable.setPadding(f10, bl2, bl3);
        this.updatePadding(cardViewDelegate);
    }

    public void setRadius(CardViewDelegate cardViewDelegate, float f10) {
        this.getCardBackground(cardViewDelegate).setRadius(f10);
    }

    public void updatePadding(CardViewDelegate cardViewDelegate) {
        int n10 = cardViewDelegate.getUseCompatPadding();
        if (n10 == 0) {
            cardViewDelegate.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float f10 = this.getMaxElevation(cardViewDelegate);
        float f11 = this.getRadius(cardViewDelegate);
        int n11 = cardViewDelegate.getPreventCornerOverlap();
        n11 = (int)Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(f10, f11, n11 != 0));
        boolean bl2 = cardViewDelegate.getPreventCornerOverlap();
        n10 = (int)Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(f10, f11, bl2));
        cardViewDelegate.setShadowPadding(n11, n10, n11, n10);
    }
}

