/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 */
package com.google.android.material.chip;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R$string;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import java.util.List;

public class Chip$ChipTouchHelper
extends ExploreByTouchHelper {
    public final /* synthetic */ Chip this$0;

    public Chip$ChipTouchHelper(Chip chip, Chip chip2) {
        this.this$0 = chip;
        super((View)chip2);
    }

    public int getVirtualViewAt(float f10, float f11) {
        int n10;
        Chip chip = this.this$0;
        boolean bl2 = Chip.access$100(chip);
        if (bl2 && (n10 = (int)((chip = Chip.access$200(this.this$0)).contains(f10, f11) ? 1 : 0)) != 0) {
            n10 = 0;
            f10 = 0.0f;
        } else {
            n10 = -1;
            f10 = 0.0f / 0.0f;
        }
        return n10;
    }

    public void getVisibleVirtualViews(List list) {
        Object object = this.this$0;
        boolean bl2 = Chip.access$100((Chip)object);
        if (bl2) {
            bl2 = false;
            object = 0;
            list.add(object);
        }
    }

    public boolean onPerformActionForVirtualView(int n10, int n11, Bundle bundle) {
        int n12 = 16;
        if (n11 == n12 && n10 == 0) {
            return this.this$0.performCloseIconClick();
        }
        return false;
    }

    public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean bl2;
        Object object = Chip.access$000(this.this$0);
        if (object != null && (bl2 = ((ChipDrawable)(object = Chip.access$000(this.this$0))).isCheckable())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        accessibilityNodeInfoCompat.setCheckable(bl2);
        object = Chip.class.getName();
        accessibilityNodeInfoCompat.setClassName((CharSequence)object);
        object = this.this$0.getText();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            accessibilityNodeInfoCompat.setText((CharSequence)object);
        } else {
            accessibilityNodeInfoCompat.setContentDescription((CharSequence)object);
        }
    }

    public void onPopulateNodeForVirtualView(int n10, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Object object = this.this$0;
        n10 = (int)(Chip.access$100((Chip)object) ? 1 : 0);
        Object object2 = "";
        if (n10 != 0) {
            object = this.this$0.getCloseIconContentDescription();
            if (object != null) {
                accessibilityNodeInfoCompat.setContentDescription((CharSequence)object);
            } else {
                object = this.this$0.getText();
                Context context = this.this$0.getContext();
                int n11 = R$string.mtrl_chip_close_icon_content_description;
                int n12 = 1;
                Object[] objectArray = new Object[n12];
                boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) {
                    object2 = object;
                }
                objectArray[0] = object2;
                object = context.getString(n11, objectArray).trim();
                accessibilityNodeInfoCompat.setContentDescription((CharSequence)object);
            }
            object = Chip.access$300(this.this$0);
            accessibilityNodeInfoCompat.setBoundsInParent((Rect)object);
            object = AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_CLICK;
            accessibilityNodeInfoCompat.addAction((AccessibilityNodeInfoCompat$AccessibilityActionCompat)object);
            object = this.this$0;
            n10 = (int)(object.isEnabled() ? 1 : 0);
            accessibilityNodeInfoCompat.setEnabled(n10 != 0);
        } else {
            accessibilityNodeInfoCompat.setContentDescription((CharSequence)object2);
            object = Chip.access$400();
            accessibilityNodeInfoCompat.setBoundsInParent((Rect)object);
        }
    }
}

