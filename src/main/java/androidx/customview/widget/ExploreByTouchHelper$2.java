/*
 * Decompiled with CFR 0.151.
 */
package androidx.customview.widget;

import androidx.collection.SparseArrayCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.FocusStrategy$CollectionAdapter;

public class ExploreByTouchHelper$2
implements FocusStrategy$CollectionAdapter {
    public AccessibilityNodeInfoCompat get(SparseArrayCompat sparseArrayCompat, int n10) {
        return (AccessibilityNodeInfoCompat)sparseArrayCompat.valueAt(n10);
    }

    public int size(SparseArrayCompat sparseArrayCompat) {
        return sparseArrayCompat.size();
    }
}

