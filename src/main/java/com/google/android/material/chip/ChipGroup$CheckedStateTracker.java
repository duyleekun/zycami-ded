/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package com.google.android.material.chip;

import android.widget.CompoundButton;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.chip.ChipGroup$1;

public class ChipGroup$CheckedStateTracker
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ ChipGroup this$0;

    private ChipGroup$CheckedStateTracker(ChipGroup chipGroup) {
        this.this$0 = chipGroup;
    }

    public /* synthetic */ ChipGroup$CheckedStateTracker(ChipGroup chipGroup, ChipGroup$1 chipGroup$1) {
        this(chipGroup);
    }

    public void onCheckedChanged(CompoundButton object, boolean n10) {
        ChipGroup chipGroup = this.this$0;
        int n11 = ChipGroup.access$300(chipGroup);
        if (n11 != 0) {
            return;
        }
        int n12 = object.getId();
        n11 = -1;
        if (n10 != 0) {
            ChipGroup chipGroup2 = this.this$0;
            n10 = ChipGroup.access$400(chipGroup2);
            if (n10 != n11 && (n10 = ChipGroup.access$400(chipGroup2 = this.this$0)) != n12 && (n10 = (int)(ChipGroup.access$500(chipGroup2 = this.this$0) ? 1 : 0)) != 0) {
                chipGroup2 = this.this$0;
                n11 = ChipGroup.access$400(chipGroup2);
                ChipGroup.access$600(chipGroup2, n11, false);
            }
            chipGroup2 = this.this$0;
            ChipGroup.access$700(chipGroup2, n12);
        } else {
            ChipGroup chipGroup3 = this.this$0;
            n10 = ChipGroup.access$400(chipGroup3);
            if (n10 == n12) {
                object = this.this$0;
                ChipGroup.access$700((ChipGroup)((Object)object), n11);
            }
        }
    }
}

