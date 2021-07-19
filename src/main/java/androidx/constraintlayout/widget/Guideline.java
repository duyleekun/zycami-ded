/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;

public class Guideline
extends View {
    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10);
        super.setVisibility(8);
    }

    public void draw(Canvas canvas) {
    }

    public void onMeasure(int n10, int n11) {
        this.setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int n10) {
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams)this.getLayoutParams();
        constraintLayout$LayoutParams.guideBegin = n10;
        this.setLayoutParams((ViewGroup.LayoutParams)constraintLayout$LayoutParams);
    }

    public void setGuidelineEnd(int n10) {
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams)this.getLayoutParams();
        constraintLayout$LayoutParams.guideEnd = n10;
        this.setLayoutParams((ViewGroup.LayoutParams)constraintLayout$LayoutParams);
    }

    public void setGuidelinePercent(float f10) {
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams)this.getLayoutParams();
        constraintLayout$LayoutParams.guidePercent = f10;
        this.setLayoutParams((ViewGroup.LayoutParams)constraintLayout$LayoutParams);
    }

    public void setVisibility(int n10) {
    }
}

