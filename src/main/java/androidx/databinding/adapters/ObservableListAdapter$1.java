/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding.adapters;

import androidx.databinding.ObservableList;
import androidx.databinding.ObservableList$OnListChangedCallback;
import androidx.databinding.adapters.ObservableListAdapter;

public class ObservableListAdapter$1
extends ObservableList$OnListChangedCallback {
    public final /* synthetic */ ObservableListAdapter this$0;

    public ObservableListAdapter$1(ObservableListAdapter observableListAdapter) {
        this.this$0 = observableListAdapter;
    }

    public void onChanged(ObservableList observableList) {
        this.this$0.notifyDataSetChanged();
    }

    public void onItemRangeChanged(ObservableList observableList, int n10, int n11) {
        this.this$0.notifyDataSetChanged();
    }

    public void onItemRangeInserted(ObservableList observableList, int n10, int n11) {
        this.this$0.notifyDataSetChanged();
    }

    public void onItemRangeMoved(ObservableList observableList, int n10, int n11, int n12) {
        this.this$0.notifyDataSetChanged();
    }

    public void onItemRangeRemoved(ObservableList observableList, int n10, int n11) {
        this.this$0.notifyDataSetChanged();
    }
}

