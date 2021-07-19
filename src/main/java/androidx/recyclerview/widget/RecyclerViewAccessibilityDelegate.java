/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate$ItemDelegate;

public class RecyclerViewAccessibilityDelegate
extends AccessibilityDelegateCompat {
    private final RecyclerViewAccessibilityDelegate$ItemDelegate mItemDelegate;
    public final RecyclerView mRecyclerView;

    public RecyclerViewAccessibilityDelegate(RecyclerView object) {
        boolean bl2;
        this.mRecyclerView = object;
        object = this.getItemDelegate();
        this.mItemDelegate = object != null && (bl2 = object instanceof RecyclerViewAccessibilityDelegate$ItemDelegate) ? (object = (RecyclerViewAccessibilityDelegate$ItemDelegate)object) : (object = new RecyclerViewAccessibilityDelegate$ItemDelegate(this));
    }

    public AccessibilityDelegateCompat getItemDelegate() {
        return this.mItemDelegate;
    }

    public void onInitializeAccessibilityEvent(View object, AccessibilityEvent accessibilityEvent) {
        RecyclerView$LayoutManager recyclerView$LayoutManager;
        super.onInitializeAccessibilityEvent((View)object, accessibilityEvent);
        boolean bl2 = object instanceof RecyclerView;
        if (bl2 && !(bl2 = this.shouldIgnore()) && (recyclerView$LayoutManager = ((RecyclerView)(object = (RecyclerView)object)).getLayoutManager()) != null) {
            object = ((RecyclerView)object).getLayoutManager();
            ((RecyclerView$LayoutManager)object).onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    public void onInitializeAccessibilityNodeInfo(View object, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo((View)object, accessibilityNodeInfoCompat);
        boolean bl2 = this.shouldIgnore();
        if (!bl2 && (object = this.mRecyclerView.getLayoutManager()) != null) {
            object = this.mRecyclerView.getLayoutManager();
            ((RecyclerView$LayoutManager)object).onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }
    }

    public boolean performAccessibilityAction(View object, int n10, Bundle bundle) {
        boolean bl2 = super.performAccessibilityAction((View)object, n10, bundle);
        if (bl2) {
            return true;
        }
        bl2 = this.shouldIgnore();
        if (!bl2 && (object = this.mRecyclerView.getLayoutManager()) != null) {
            return this.mRecyclerView.getLayoutManager().performAccessibilityAction(n10, bundle);
        }
        return false;
    }

    public boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}

