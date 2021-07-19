/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Animatable;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionLayout$TransitionListener;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

public class MotionHelper
extends ConstraintHelper
implements Animatable,
MotionLayout$TransitionListener {
    private float mProgress;
    private boolean mUseOnHide = false;
    private boolean mUseOnShow = false;
    public View[] views;

    public MotionHelper(Context context) {
        super(context);
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.init(attributeSet);
    }

    public float getProgress() {
        return this.mProgress;
    }

    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            Context context = this.getContext();
            int[] nArray = R$styleable.MotionHelper;
            attributeSet = context.obtainStyledAttributes(attributeSet, nArray);
            int n10 = attributeSet.getIndexCount();
            nArray = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11;
                int n12 = attributeSet.getIndex(i10);
                if (n12 == (n11 = R$styleable.MotionHelper_onShow)) {
                    n11 = (int)(this.mUseOnShow ? 1 : 0);
                    n12 = (int)(attributeSet.getBoolean(n12, n11 != 0) ? 1 : 0);
                    this.mUseOnShow = n12;
                    continue;
                }
                n11 = R$styleable.MotionHelper_onHide;
                if (n12 != n11) continue;
                n11 = this.mUseOnHide;
                n12 = (int)(attributeSet.getBoolean(n12, n11 != 0) ? 1 : 0);
                this.mUseOnHide = n12;
            }
            attributeSet.recycle();
        }
    }

    public boolean isUseOnHide() {
        return this.mUseOnHide;
    }

    public boolean isUsedOnShow() {
        return this.mUseOnShow;
    }

    public void onTransitionChange(MotionLayout motionLayout, int n10, int n11, float f10) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int n10) {
    }

    public void onTransitionStarted(MotionLayout motionLayout, int n10, int n11) {
    }

    public void onTransitionTrigger(MotionLayout motionLayout, int n10, boolean bl2, float f10) {
    }

    public void setProgress(float f10) {
        int n10;
        this.mProgress = f10;
        int n11 = this.mCount;
        if (n11 > 0) {
            View view = (View)this.getParent();
            view = this.getViews((ConstraintLayout)view);
            this.views = view;
            for (n10 = 0; n10 < (n11 = this.mCount); ++n10) {
                view = this.views[n10];
                this.setProgress(view, f10);
            }
        } else {
            ViewGroup viewGroup = (ViewGroup)this.getParent();
            int n12 = viewGroup.getChildCount();
            while (n10 < n12) {
                View view = viewGroup.getChildAt(n10);
                boolean bl2 = view instanceof MotionHelper;
                if (!bl2) {
                    this.setProgress(view, f10);
                }
                ++n10;
            }
        }
    }

    public void setProgress(View view, float f10) {
    }
}

