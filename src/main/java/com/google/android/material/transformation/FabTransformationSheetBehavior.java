/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$animator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import com.google.android.material.transformation.FabTransformationBehavior;
import com.google.android.material.transformation.FabTransformationBehavior$FabTransformationSpec;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.util.HashMap;
import java.util.Map;

public class FabTransformationSheetBehavior
extends FabTransformationBehavior {
    private Map importantForAccessibilityMap;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void updateImportantForAccessibility(View view, boolean bl2) {
        HashMap hashMap;
        int n10 = Build.VERSION.SDK_INT;
        Object object = view.getParent();
        int n11 = object instanceof CoordinatorLayout;
        if (n11 == 0) {
            return;
        }
        object = (CoordinatorLayout)object;
        n11 = object.getChildCount();
        int n12 = 16;
        if (n10 >= n12 && bl2) {
            this.importantForAccessibilityMap = hashMap = new HashMap(n11);
        }
        hashMap = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            View view2 = object.getChildAt(i10);
            Object object2 = view2.getLayoutParams();
            int n13 = object2 instanceof CoordinatorLayout$LayoutParams;
            if (n13 != 0 && (n13 = (object2 = ((CoordinatorLayout$LayoutParams)view2.getLayoutParams()).getBehavior()) instanceof FabTransformationScrimBehavior) != 0) {
                n13 = 1;
            } else {
                n13 = 0;
                object2 = null;
            }
            if (view2 == view || n13 != 0) continue;
            if (!bl2) {
                object2 = this.importantForAccessibilityMap;
                if (object2 == null || (n13 = (int)(object2.containsKey(view2) ? 1 : 0)) == 0) continue;
                object2 = (Integer)this.importantForAccessibilityMap.get(view2);
                n13 = (Integer)object2;
                ViewCompat.setImportantForAccessibility(view2, n13);
                continue;
            }
            if (n10 >= n12) {
                object2 = this.importantForAccessibilityMap;
                int n14 = view2.getImportantForAccessibility();
                Integer n15 = n14;
                object2.put(view2, n15);
            }
            n13 = 4;
            ViewCompat.setImportantForAccessibility(view2, n13);
        }
        if (!bl2) {
            view = null;
            this.importantForAccessibilityMap = null;
        }
    }

    /*
     * WARNING - void declaration
     */
    public FabTransformationBehavior$FabTransformationSpec onCreateMotionSpec(Context object, boolean bl2) {
        void var2_5;
        if (bl2) {
            int n10 = R$animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            int n11 = R$animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior$FabTransformationSpec fabTransformationBehavior$FabTransformationSpec = new FabTransformationBehavior$FabTransformationSpec();
        fabTransformationBehavior$FabTransformationSpec.timings = object = MotionSpec.createFromResource((Context)object, (int)var2_5);
        fabTransformationBehavior$FabTransformationSpec.positioning = object = new Positioning(17, 0.0f, 0.0f);
        return fabTransformationBehavior$FabTransformationSpec;
    }

    public boolean onExpandedStateChange(View view, View view2, boolean bl2, boolean bl3) {
        this.updateImportantForAccessibility(view2, bl2);
        return super.onExpandedStateChange(view, view2, bl2, bl3);
    }
}

