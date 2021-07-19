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
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$styleable;

public class ConstraintSet$PropertySet {
    public float alpha = 1.0f;
    public boolean mApply = false;
    public float mProgress = 0.0f / 0.0f;
    public int mVisibilityMode = 0;
    public int visibility = 0;

    public void copyFrom(ConstraintSet$PropertySet constraintSet$PropertySet) {
        int n10;
        float f10;
        int n11;
        this.mApply = n11 = constraintSet$PropertySet.mApply;
        this.visibility = n11 = constraintSet$PropertySet.visibility;
        this.alpha = f10 = constraintSet$PropertySet.alpha;
        this.mProgress = f10 = constraintSet$PropertySet.mProgress;
        this.mVisibilityMode = n10 = constraintSet$PropertySet.mVisibilityMode;
    }

    public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        int[] nArray = R$styleable.PropertySet;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        this.mApply = true;
        int n10 = context.getIndexCount();
        nArray = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10;
            float f11;
            int n11;
            int n12 = context.getIndex(i10);
            if (n12 == (n11 = R$styleable.PropertySet_android_alpha)) {
                f11 = this.alpha;
                this.alpha = f10 = context.getFloat(n12, f11);
                continue;
            }
            n11 = R$styleable.PropertySet_android_visibility;
            if (n12 == n11) {
                n11 = this.visibility;
                this.visibility = n12 = context.getInt(n12, n11);
                int[] nArray2 = ConstraintSet.access$200();
                n11 = this.visibility;
                this.visibility = n12 = nArray2[n11];
                continue;
            }
            n11 = R$styleable.PropertySet_visibilityMode;
            if (n12 == n11) {
                n11 = this.mVisibilityMode;
                this.mVisibilityMode = n12 = context.getInt(n12, n11);
                continue;
            }
            n11 = R$styleable.PropertySet_motionProgress;
            if (n12 != n11) continue;
            f11 = this.mProgress;
            this.mProgress = f10 = context.getFloat(n12, f11);
        }
        context.recycle();
    }
}

