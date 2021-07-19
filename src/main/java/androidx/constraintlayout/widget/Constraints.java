/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints$LayoutParams;

public class Constraints
extends ViewGroup {
    public static final String TAG = "Constraints";
    public ConstraintSet myConstraintSet;

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(attributeSet);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.init(attributeSet);
        super.setVisibility(8);
    }

    private void init(AttributeSet attributeSet) {
        Log.v((String)TAG, (String)" ################# init");
    }

    public Constraints$LayoutParams generateDefaultLayoutParams() {
        int n10 = -2;
        Constraints$LayoutParams constraints$LayoutParams = new Constraints$LayoutParams(n10, n10);
        return constraints$LayoutParams;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = new ConstraintLayout$LayoutParams(layoutParams);
        return constraintLayout$LayoutParams;
    }

    public Constraints$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = this.getContext();
        Constraints$LayoutParams constraints$LayoutParams = new Constraints$LayoutParams(context, attributeSet);
        return constraints$LayoutParams;
    }

    public ConstraintSet getConstraintSet() {
        ConstraintSet constraintSet = this.myConstraintSet;
        if (constraintSet == null) {
            this.myConstraintSet = constraintSet = new ConstraintSet();
        }
        this.myConstraintSet.clone(this);
        return this.myConstraintSet;
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
    }
}

