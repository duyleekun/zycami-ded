/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup$OnHierarchyChangeListener
 */
package com.google.android.material.chip;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.chip.ChipGroup$1;
import com.google.android.material.chip.ChipGroup$CheckedStateTracker;

public class ChipGroup$PassThroughHierarchyChangeListener
implements ViewGroup.OnHierarchyChangeListener {
    private ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
    public final /* synthetic */ ChipGroup this$0;

    private ChipGroup$PassThroughHierarchyChangeListener(ChipGroup chipGroup) {
        this.this$0 = chipGroup;
    }

    public /* synthetic */ ChipGroup$PassThroughHierarchyChangeListener(ChipGroup chipGroup, ChipGroup$1 chipGroup$1) {
        this(chipGroup);
    }

    public static /* synthetic */ ViewGroup.OnHierarchyChangeListener access$202(ChipGroup$PassThroughHierarchyChangeListener chipGroup$PassThroughHierarchyChangeListener, ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        chipGroup$PassThroughHierarchyChangeListener.onHierarchyChangeListener = onHierarchyChangeListener;
        return onHierarchyChangeListener;
    }

    public void onChildViewAdded(View view, View view2) {
        int n10;
        Object object = this.this$0;
        if (view == object && (n10 = view2 instanceof Chip) != 0) {
            int n11;
            n10 = view2.getId();
            if (n10 == (n11 = -1)) {
                n10 = Build.VERSION.SDK_INT;
                n11 = 17;
                n10 = n10 >= n11 ? View.generateViewId() : view2.hashCode();
                view2.setId(n10);
            }
            object = view2;
            object = (Chip)view2;
            ChipGroup$CheckedStateTracker chipGroup$CheckedStateTracker = ChipGroup.access$800(this.this$0);
            ((Chip)object).setOnCheckedChangeListenerInternal(chipGroup$CheckedStateTracker);
        }
        if ((object = this.onHierarchyChangeListener) != null) {
            object.onChildViewAdded(view, view2);
        }
    }

    public void onChildViewRemoved(View view, View view2) {
        boolean bl2;
        Object object = this.this$0;
        if (view == object && (bl2 = view2 instanceof Chip)) {
            object = view2;
            object = (Chip)view2;
            ((Chip)object).setOnCheckedChangeListenerInternal(null);
        }
        if ((object = this.onHierarchyChangeListener) != null) {
            object.onChildViewRemoved(view, view2);
        }
    }
}

