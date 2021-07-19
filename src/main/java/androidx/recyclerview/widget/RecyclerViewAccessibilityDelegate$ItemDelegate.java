/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import java.util.Map;
import java.util.WeakHashMap;

public class RecyclerViewAccessibilityDelegate$ItemDelegate
extends AccessibilityDelegateCompat {
    private Map mOriginalItemDelegates;
    public final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;

    public RecyclerViewAccessibilityDelegate$ItemDelegate(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        WeakHashMap weakHashMap;
        this.mOriginalItemDelegates = weakHashMap = new WeakHashMap();
        this.mRecyclerViewDelegate = recyclerViewAccessibilityDelegate;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(view);
        if (accessibilityDelegateCompat != null) {
            return accessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }
        return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(view);
        if (accessibilityDelegateCompat != null) {
            return accessibilityDelegateCompat.getAccessibilityNodeProvider(view);
        }
        return super.getAccessibilityNodeProvider(view);
    }

    public AccessibilityDelegateCompat getAndRemoveOriginalDelegateForItem(View view) {
        return (AccessibilityDelegateCompat)this.mOriginalItemDelegates.remove(view);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(view);
        if (accessibilityDelegateCompat != null) {
            accessibilityDelegateCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
        } else {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Object object = this.mRecyclerViewDelegate;
        boolean bl2 = ((RecyclerViewAccessibilityDelegate)object).shouldIgnore();
        if (!bl2 && (object = this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager()) != null) {
            this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            object = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(view);
            if (object != null) {
                ((AccessibilityDelegateCompat)object).onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            }
        } else {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        }
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(view);
        if (accessibilityDelegateCompat != null) {
            accessibilityDelegateCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
        } else {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(viewGroup);
        if (accessibilityDelegateCompat != null) {
            return accessibilityDelegateCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
        return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int n10, Bundle bundle) {
        Object object = this.mRecyclerViewDelegate;
        boolean bl2 = ((RecyclerViewAccessibilityDelegate)object).shouldIgnore();
        if (!bl2 && (object = this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager()) != null) {
            object = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(view);
            boolean bl3 = true;
            if (object != null ? (bl2 = ((AccessibilityDelegateCompat)object).performAccessibilityAction(view, n10, bundle)) : (bl2 = super.performAccessibilityAction(view, n10, bundle))) {
                return bl3;
            }
            return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, n10, bundle);
        }
        return super.performAccessibilityAction(view, n10, bundle);
    }

    public void saveOriginalDelegate(View view) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = ViewCompat.getAccessibilityDelegate(view);
        if (accessibilityDelegateCompat != null && accessibilityDelegateCompat != this) {
            Map map = this.mOriginalItemDelegates;
            map.put(view, accessibilityDelegateCompat);
        }
    }

    public void sendAccessibilityEvent(View view, int n10) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(view);
        if (accessibilityDelegateCompat != null) {
            accessibilityDelegateCompat.sendAccessibilityEvent(view, n10);
        } else {
            super.sendAccessibilityEvent(view, n10);
        }
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(view);
        if (accessibilityDelegateCompat != null) {
            accessibilityDelegateCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        } else {
            super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }
}

