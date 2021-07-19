/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 */
package com.google.android.material.card;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.google.android.material.R$styleable;
import com.google.android.material.card.MaterialCardView;

public class MaterialCardViewHelper {
    private static final int DEFAULT_STROKE_VALUE = 255;
    private final MaterialCardView materialCardView;
    private int strokeColor;
    private int strokeWidth;

    public MaterialCardViewHelper(MaterialCardView materialCardView) {
        this.materialCardView = materialCardView;
    }

    private void adjustContentPadding() {
        int n10 = this.materialCardView.getContentPaddingLeft();
        int n11 = this.strokeWidth;
        n10 += n11;
        n11 = this.materialCardView.getContentPaddingTop();
        int n12 = this.strokeWidth;
        n11 += n12;
        n12 = this.materialCardView.getContentPaddingRight();
        int n13 = this.strokeWidth;
        n12 += n13;
        n13 = this.materialCardView.getContentPaddingBottom();
        int n14 = this.strokeWidth;
        this.materialCardView.setContentPadding(n10, n11, n12, n13 += n14);
    }

    private Drawable createForegroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        MaterialCardView materialCardView = this.materialCardView;
        float f10 = materialCardView.getRadius();
        gradientDrawable.setCornerRadius(f10);
        int n10 = this.strokeColor;
        int n11 = -1;
        if (n10 != n11) {
            n11 = this.strokeWidth;
            gradientDrawable.setStroke(n11, n10);
        }
        return gradientDrawable;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public void loadFromAttributes(TypedArray typedArray) {
        int n10;
        int n11 = R$styleable.MaterialCardView_strokeColor;
        this.strokeColor = n11 = typedArray.getColor(n11, -1);
        n11 = R$styleable.MaterialCardView_strokeWidth;
        this.strokeWidth = n10 = typedArray.getDimensionPixelSize(n11, 0);
        this.updateForeground();
        this.adjustContentPadding();
    }

    public void setStrokeColor(int n10) {
        this.strokeColor = n10;
        this.updateForeground();
    }

    public void setStrokeWidth(int n10) {
        this.strokeWidth = n10;
        this.updateForeground();
        this.adjustContentPadding();
    }

    public void updateForeground() {
        MaterialCardView materialCardView = this.materialCardView;
        Drawable drawable2 = this.createForegroundDrawable();
        materialCardView.setForeground(drawable2);
    }
}

