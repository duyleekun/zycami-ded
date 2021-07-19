/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package androidx.appcompat.widget;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

public class ActivityChooserView$3
extends View.AccessibilityDelegate {
    public final /* synthetic */ ActivityChooserView this$0;

    public ActivityChooserView$3(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCanOpenPopup(true);
    }
}

