/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;

public class Group
extends ConstraintHelper {
    public Group(Context context) {
        super(context);
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
    }

    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mUseViewMeasure = false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.applyLayoutFeatures();
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        this.applyLayoutFeatures();
    }

    public void setVisibility(int n10) {
        super.setVisibility(n10);
        this.applyLayoutFeatures();
    }

    public void updatePostLayout(ConstraintLayout object) {
        object = (ConstraintLayout$LayoutParams)this.getLayoutParams();
        ((ConstraintLayout$LayoutParams)object).widget.setWidth(0);
        ((ConstraintLayout$LayoutParams)object).widget.setHeight(0);
    }
}

