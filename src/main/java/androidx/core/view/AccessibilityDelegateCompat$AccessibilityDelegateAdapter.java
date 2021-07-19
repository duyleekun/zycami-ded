/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeProvider
 */
package androidx.core.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;

public final class AccessibilityDelegateCompat$AccessibilityDelegateAdapter
extends View.AccessibilityDelegate {
    public final AccessibilityDelegateCompat mCompat;

    public AccessibilityDelegateCompat$AccessibilityDelegateAdapter(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        this.mCompat = accessibilityDelegateCompat;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider(View object) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.mCompat;
        object = (object = accessibilityDelegateCompat.getAccessibilityNodeProvider((View)object)) != null ? (AccessibilityNodeProvider)((AccessibilityNodeProviderCompat)object).getProvider() : null;
        return object;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View object, AccessibilityNodeInfo object2) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.wrap(object2);
        int n10 = ViewCompat.isScreenReaderFocusable((View)object);
        accessibilityNodeInfoCompat.setScreenReaderFocusable(n10 != 0);
        n10 = ViewCompat.isAccessibilityHeading((View)object);
        accessibilityNodeInfoCompat.setHeading(n10 != 0);
        Object object3 = ViewCompat.getAccessibilityPaneTitle((View)object);
        accessibilityNodeInfoCompat.setPaneTitle((CharSequence)object3);
        object3 = ViewCompat.getStateDescription((View)object);
        accessibilityNodeInfoCompat.setStateDescription((CharSequence)object3);
        object3 = this.mCompat;
        ((AccessibilityDelegateCompat)object3).onInitializeAccessibilityNodeInfo((View)object, accessibilityNodeInfoCompat);
        object2 = object2.getText();
        accessibilityNodeInfoCompat.addSpansToExtras((CharSequence)object2, (View)object);
        object = AccessibilityDelegateCompat.getActionList((View)object);
        object2 = null;
        for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
            object3 = (AccessibilityNodeInfoCompat$AccessibilityActionCompat)object.get(i10);
            accessibilityNodeInfoCompat.addAction((AccessibilityNodeInfoCompat$AccessibilityActionCompat)object3);
        }
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int n10, Bundle bundle) {
        return this.mCompat.performAccessibilityAction(view, n10, bundle);
    }

    public void sendAccessibilityEvent(View view, int n10) {
        this.mCompat.sendAccessibilityEvent(view, n10);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}

