/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

public abstract class VirtualLayout
extends ConstraintHelper {
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;

    public VirtualLayout(Context context) {
        super(context);
    }

    public VirtualLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VirtualLayout(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
    }

    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            Context context = this.getContext();
            int[] nArray = R$styleable.ConstraintLayout_Layout;
            attributeSet = context.obtainStyledAttributes(attributeSet, nArray);
            int n10 = attributeSet.getIndexCount();
            nArray = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11 = attributeSet.getIndex(i10);
                int n12 = R$styleable.ConstraintLayout_Layout_android_visibility;
                boolean bl2 = true;
                if (n11 == n12) {
                    this.mApplyVisibilityOnAttach = bl2;
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_android_elevation;
                if (n11 != n12) continue;
                this.mApplyElevationOnAttach = bl2;
            }
            attributeSet.recycle();
        }
    }

    public void onAttachedToWindow() {
        int n10;
        Object object;
        int n11 = Build.VERSION.SDK_INT;
        super.onAttachedToWindow();
        boolean bl2 = this.mApplyVisibilityOnAttach;
        if ((bl2 || (bl2 = this.mApplyElevationOnAttach)) && (object = this.getParent()) != null && (n10 = object instanceof ConstraintLayout) != 0) {
            int n12;
            object = (ConstraintLayout)((Object)object);
            n10 = this.getVisibility();
            int n13 = 21;
            float f10 = n11 >= n13 ? this.getElevation() : 0.0f;
            for (int i10 = 0; i10 < (n12 = this.mCount); ++i10) {
                float f11;
                n12 = this.mIds[i10];
                View view = ((ConstraintLayout)((Object)object)).getViewById(n12);
                if (view == null) continue;
                int n14 = this.mApplyVisibilityOnAttach;
                if (n14 != 0) {
                    view.setVisibility(n10);
                }
                if ((n14 = this.mApplyElevationOnAttach) == 0 || (n14 = (f11 = f10 - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) <= 0 || n11 < n13) continue;
                float f12 = view.getTranslationZ() + f10;
                view.setTranslationZ(f12);
            }
        }
    }

    public void onMeasure(androidx.constraintlayout.solver.widgets.VirtualLayout virtualLayout, int n10, int n11) {
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        this.applyLayoutFeatures();
    }

    public void setVisibility(int n10) {
        super.setVisibility(n10);
        this.applyLayoutFeatures();
    }
}

