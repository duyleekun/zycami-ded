/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 */
package com.google.android.material.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.card.MaterialCardViewHelper;
import com.google.android.material.internal.ThemeEnforcement;

public class MaterialCardView
extends CardView {
    private final MaterialCardViewHelper cardViewHelper;

    public MaterialCardView(Context context) {
        this(context, null);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.materialCardViewStyle;
        this(context, attributeSet, n10);
    }

    public MaterialCardView(Context context, AttributeSet object, int n10) {
        super(context, (AttributeSet)object, n10);
        int[] nArray = R$styleable.MaterialCardView;
        int n11 = R$style.Widget_MaterialComponents_CardView;
        int[] nArray2 = new int[]{};
        context = ThemeEnforcement.obtainStyledAttributes(context, (AttributeSet)object, nArray, n10, n11, nArray2);
        super(this);
        this.cardViewHelper = object;
        ((MaterialCardViewHelper)object).loadFromAttributes((TypedArray)context);
        context.recycle();
    }

    public int getStrokeColor() {
        return this.cardViewHelper.getStrokeColor();
    }

    public int getStrokeWidth() {
        return this.cardViewHelper.getStrokeWidth();
    }

    public void setRadius(float f10) {
        super.setRadius(f10);
        this.cardViewHelper.updateForeground();
    }

    public void setStrokeColor(int n10) {
        this.cardViewHelper.setStrokeColor(n10);
    }

    public void setStrokeWidth(int n10) {
        this.cardViewHelper.setStrokeWidth(n10);
    }
}

