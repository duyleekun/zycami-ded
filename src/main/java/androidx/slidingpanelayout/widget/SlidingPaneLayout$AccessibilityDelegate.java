/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.slidingpanelayout.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

public class SlidingPaneLayout$AccessibilityDelegate
extends AccessibilityDelegateCompat {
    private final Rect mTmpRect;
    public final /* synthetic */ SlidingPaneLayout this$0;

    public SlidingPaneLayout$AccessibilityDelegate(SlidingPaneLayout slidingPaneLayout) {
        this.this$0 = slidingPaneLayout;
        this.mTmpRect = slidingPaneLayout;
    }

    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
        Object object = this.mTmpRect;
        accessibilityNodeInfoCompat2.getBoundsInParent((Rect)object);
        accessibilityNodeInfoCompat.setBoundsInParent((Rect)object);
        accessibilityNodeInfoCompat2.getBoundsInScreen((Rect)object);
        accessibilityNodeInfoCompat.setBoundsInScreen((Rect)object);
        int n10 = accessibilityNodeInfoCompat2.isVisibleToUser();
        accessibilityNodeInfoCompat.setVisibleToUser(n10 != 0);
        object = accessibilityNodeInfoCompat2.getPackageName();
        accessibilityNodeInfoCompat.setPackageName((CharSequence)object);
        object = accessibilityNodeInfoCompat2.getClassName();
        accessibilityNodeInfoCompat.setClassName((CharSequence)object);
        object = accessibilityNodeInfoCompat2.getContentDescription();
        accessibilityNodeInfoCompat.setContentDescription((CharSequence)object);
        n10 = accessibilityNodeInfoCompat2.isEnabled();
        accessibilityNodeInfoCompat.setEnabled(n10 != 0);
        n10 = accessibilityNodeInfoCompat2.isClickable();
        accessibilityNodeInfoCompat.setClickable(n10 != 0);
        n10 = accessibilityNodeInfoCompat2.isFocusable();
        accessibilityNodeInfoCompat.setFocusable(n10 != 0);
        n10 = accessibilityNodeInfoCompat2.isFocused();
        accessibilityNodeInfoCompat.setFocused(n10 != 0);
        n10 = accessibilityNodeInfoCompat2.isAccessibilityFocused();
        accessibilityNodeInfoCompat.setAccessibilityFocused(n10 != 0);
        n10 = accessibilityNodeInfoCompat2.isSelected();
        accessibilityNodeInfoCompat.setSelected(n10 != 0);
        n10 = accessibilityNodeInfoCompat2.isLongClickable();
        accessibilityNodeInfoCompat.setLongClickable(n10 != 0);
        n10 = accessibilityNodeInfoCompat2.getActions();
        accessibilityNodeInfoCompat.addAction(n10);
        int n11 = accessibilityNodeInfoCompat2.getMovementGranularities();
        accessibilityNodeInfoCompat.setMovementGranularities(n11);
    }

    public boolean filter(View view) {
        return this.this$0.isDimmed(view);
    }

    public void onInitializeAccessibilityEvent(View object, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent((View)object, accessibilityEvent);
        object = SlidingPaneLayout.class.getName();
        accessibilityEvent.setClassName((CharSequence)object);
    }

    public void onInitializeAccessibilityNodeInfo(View object, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Object object2 = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
        super.onInitializeAccessibilityNodeInfo((View)object, (AccessibilityNodeInfoCompat)object2);
        this.copyNodeInfoNoChildren(accessibilityNodeInfoCompat, (AccessibilityNodeInfoCompat)object2);
        ((AccessibilityNodeInfoCompat)object2).recycle();
        object2 = SlidingPaneLayout.class.getName();
        accessibilityNodeInfoCompat.setClassName((CharSequence)object2);
        accessibilityNodeInfoCompat.setSource((View)object);
        object = ViewCompat.getParentForAccessibility(object);
        int n10 = object instanceof View;
        if (n10 != 0) {
            accessibilityNodeInfoCompat.setParent((View)object);
        }
        object = this.this$0;
        int n11 = object.getChildCount();
        object2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            View view = this.this$0.getChildAt(n10);
            int n12 = this.filter(view);
            if (n12 != 0 || (n12 = view.getVisibility()) != 0) continue;
            n12 = 1;
            ViewCompat.setImportantForAccessibility(view, n12);
            accessibilityNodeInfoCompat.addChild(view);
        }
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        boolean bl2 = this.filter(view);
        if (!bl2) {
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
        return false;
    }
}

