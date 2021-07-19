/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.CallbackRegistry$NotifierCallback;
import androidx.databinding.ListChangeRegistry$ListChanges;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableList$OnListChangedCallback;

public final class ListChangeRegistry$1
extends CallbackRegistry$NotifierCallback {
    public void onNotifyCallback(ObservableList$OnListChangedCallback observableList$OnListChangedCallback, ObservableList observableList, int n10, ListChangeRegistry$ListChanges listChangeRegistry$ListChanges) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        observableList$OnListChangedCallback.onChanged(observableList);
                    } else {
                        n10 = listChangeRegistry$ListChanges.start;
                        int n12 = listChangeRegistry$ListChanges.count;
                        observableList$OnListChangedCallback.onItemRangeRemoved(observableList, n10, n12);
                    }
                } else {
                    n10 = listChangeRegistry$ListChanges.start;
                    n11 = listChangeRegistry$ListChanges.to;
                    int n13 = listChangeRegistry$ListChanges.count;
                    observableList$OnListChangedCallback.onItemRangeMoved(observableList, n10, n11, n13);
                }
            } else {
                n10 = listChangeRegistry$ListChanges.start;
                int n14 = listChangeRegistry$ListChanges.count;
                observableList$OnListChangedCallback.onItemRangeInserted(observableList, n10, n14);
            }
        } else {
            n10 = listChangeRegistry$ListChanges.start;
            int n15 = listChangeRegistry$ListChanges.count;
            observableList$OnListChangedCallback.onItemRangeChanged(observableList, n10, n15);
        }
    }
}

