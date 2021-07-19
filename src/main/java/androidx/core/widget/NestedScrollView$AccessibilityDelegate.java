/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityRecord
 *  android.widget.ScrollView
 */
package androidx.core.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.widget.ScrollView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.NestedScrollView;

public class NestedScrollView$AccessibilityDelegate
extends AccessibilityDelegateCompat {
    public void onInitializeAccessibilityEvent(View object, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent((View)object, accessibilityEvent);
        object = (NestedScrollView)object;
        String string2 = ScrollView.class.getName();
        accessibilityEvent.setClassName((CharSequence)string2);
        int n10 = ((NestedScrollView)object).getScrollRange();
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        accessibilityEvent.setScrollable(n10 != 0);
        n10 = object.getScrollX();
        accessibilityEvent.setScrollX(n10);
        n10 = object.getScrollY();
        accessibilityEvent.setScrollY(n10);
        n10 = object.getScrollX();
        AccessibilityRecordCompat.setMaxScrollX((AccessibilityRecord)accessibilityEvent, n10);
        int n11 = ((NestedScrollView)object).getScrollRange();
        AccessibilityRecordCompat.setMaxScrollY((AccessibilityRecord)accessibilityEvent, n11);
    }

    public void onInitializeAccessibilityNodeInfo(View object, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo((View)object, accessibilityNodeInfoCompat);
        object = (NestedScrollView)object;
        String string2 = ScrollView.class.getName();
        accessibilityNodeInfoCompat.setClassName(string2);
        int n10 = object.isEnabled();
        if (n10 != 0 && (n10 = ((NestedScrollView)object).getScrollRange()) > 0) {
            int n11;
            accessibilityNodeInfoCompat.setScrollable(true);
            int n12 = object.getScrollY();
            if (n12 > 0) {
                AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat = AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_BACKWARD;
                accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat$AccessibilityActionCompat);
                accessibilityNodeInfoCompat$AccessibilityActionCompat = AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_UP;
                accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat$AccessibilityActionCompat);
            }
            if ((n11 = object.getScrollY()) < n10) {
                object = AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_FORWARD;
                accessibilityNodeInfoCompat.addAction((AccessibilityNodeInfoCompat$AccessibilityActionCompat)object);
                object = AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_DOWN;
                accessibilityNodeInfoCompat.addAction((AccessibilityNodeInfoCompat$AccessibilityActionCompat)object);
            }
        }
    }

    public boolean performAccessibilityAction(View object, int n10, Bundle bundle) {
        int n11 = super.performAccessibilityAction((View)object, n10, bundle);
        boolean bl2 = true;
        if (n11 != 0) {
            return bl2;
        }
        n11 = (object = (NestedScrollView)object).isEnabled();
        if (n11 == 0) {
            return false;
        }
        n11 = 4096;
        if (n10 != n11) {
            n11 = 8192;
            if (n10 != n11 && n10 != (n11 = 16908344)) {
                n11 = 16908346;
                if (n10 != n11) {
                    return false;
                }
            } else {
                n10 = object.getHeight();
                n11 = object.getPaddingBottom();
                n10 -= n11;
                n11 = object.getPaddingTop();
                n10 -= n11;
                n10 = Math.max(object.getScrollY() - n10, 0);
                if (n10 != (n11 = object.getScrollY())) {
                    ((NestedScrollView)object).smoothScrollTo(0, n10, bl2);
                    return bl2;
                }
                return false;
            }
        }
        n10 = object.getHeight();
        n11 = object.getPaddingBottom();
        n10 -= n11;
        n11 = object.getPaddingTop();
        n10 -= n11;
        n11 = object.getScrollY() + n10;
        n10 = ((NestedScrollView)object).getScrollRange();
        if ((n10 = Math.min(n11, n10)) != (n11 = object.getScrollY())) {
            ((NestedScrollView)object).smoothScrollTo(0, n10, bl2);
            return bl2;
        }
        return false;
    }
}

